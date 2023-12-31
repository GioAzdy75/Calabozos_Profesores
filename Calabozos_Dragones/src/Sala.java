import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

import Cartas.Carta;
import Cartas.Mazo;
import Criaturas.Esbirro;
import Criaturas.Heroe;
import Criaturas.Profesor;
import Criaturas.Criatura;

import java.util.Random;
import java.util.Iterator;

public class Sala {
	private String nombre;
	List<Criatura>lista_esbirros = new ArrayList<Criatura>();
	Profesor profesor;
	private boolean completado = false;
	private String tipoSala;
	
	
	public Sala(String nuevoNombre,int cantidadEsbirros,Profesor profesor,String tipoSala) {
		this.nombre = nuevoNombre;
		this.lista_esbirros = this.crear_esbirros(cantidadEsbirros);
		this.profesor = profesor;
		this.tipoSala = tipoSala;
	}
	
	/**
	 * Devuelve el nombre de la Sala
	 * @return String : nombre de la sala
	 */
	public String getNombre() {
		return this.nombre;
	}
	
	/**
	 * Verifica la salud de las criaturas, si alguna criatura esta muerta (vida == 0) entonces lo quita de la lista
	 * @param lista_criatura Lista de cualquier criatura
	 */
	public void verificarVidaCriaturas(List<? extends Criatura>lista_criatura) {
		Iterator<? extends Criatura> iterador = lista_criatura.iterator();
		
	    while (iterador.hasNext()) {
	        Criatura criatura = iterador.next();
	        if (criatura.getVida() == 0) {
	            iterador.remove();
	        }
	    }
	}
	
	/**
	 * Imprime las criaturas
	 * @param lista_heroes una List<Heroe>
	 * @param lista_esbirros una List<Esbirro>
	 */
	private void imprimir_criaturas(List<Heroe> lista_heroes, List<Esbirro> lista_esbirros) {
		//Muestra a los heroes y criaturas
		System.out.println("--------------------------------------------------------");
		gameController.estadisticasCriatura(lista_heroes);
		System.out.println("		-------vs--------		");
		gameController.estadisticasCriatura(lista_esbirros);
		System.out.println("--------------------------------------------------------");
	}
	
	private void imprimir_cartas(List<Carta> lista_cartas) {
		System.out.println("--------------	Cartas	-------------------");
		System.out.println("|	Nombre			|		Descripcion		|	Costo Mana	|");
		int count = 1;
		for (Carta carta : lista_cartas) {
			System.out.println("|"+count+"|"+carta.getNombre()+ "		|" + carta.getDescripcion()+ "	|"+carta.getCostoMana()+"|");//Mejorar visualizacion en consola
			count ++;
		}
		System.out.println("|6|	No	Usar Ninguna Carta");
		System.out.println("--------------------------------------------------------");
	}
	
	/**
	 * Metodo para iniciar el enfrentamiento con la sala , Devuelve true or false si es que completa la sala
	 * @param listaDeCartas 
	 * @return boolean : completado 
	 */
	public boolean iniciar_enfrentamiento(Jugador jugador) {
		//Variables
		List<Criatura>lista_heroes = jugador.getLista_heroes();
		Mazo mazo = jugador.getMazo();
		//Utilidades
		Scanner scanner = new Scanner(System.in); //Scanner del teclado
		Random random = new Random(); //variable Random
		int input_teclado;
		//Extraer 5 cartas del deck
		System.out.println("-Robamos 5 cartas del Deck-");
		List<Carta> mano = mazo.robarCartas();
		//Imprimimos los heroes y la criatura
		//imprimir_criaturas(lista_heroes,lista_esbirros);
		//Imprimimos las Cartas
		//imprimir_cartas(mano);
		
		//Jugador decide si usar cartas
		
		
		
		//Interfaz Grafica
		SalaGUI salaGUI = new SalaGUI(this,lista_heroes,mano);
		//
		System.out.println("-	Inicia El Enfrentamiento	-");
		
		//Bucle de batalla Heroe vs Esbirros
		while (!this.completado) {
			//Muestra a los heroes y criaturas
			System.out.println("--------------------------------------------------------");
			gameController.estadisticasCriatura(lista_heroes);
			System.out.println("		-------vs--------		");
			gameController.estadisticasCriatura(lista_esbirros);
			System.out.println("--------------------------------------------------------");
			//Muestra las cartas
			imprimir_cartas(mano);
			//Imprimimos el Mana del Jugador
			System.out.println(" Mana del Jugador: "+ jugador.getMana());
			//
			System.out.println("-	Fase Cartas	-");
			//Jugador decide si usar cartas
			System.out.println("Elija:  1-Usar alguna carta 	2- Ninguna");
			input_teclado = gameController.entrada_teclado(scanner,1, 2);
			if (input_teclado == 1) {
				System.out.println("- Elija la carta que quiera Usar -");
				input_teclado = gameController.entrada_teclado(scanner, 1, 6);
				if (input_teclado <=5) {
					//Verificamos que tenga mana el jugador para aplicar el efecto
					while (jugador.getMana() < mano.get(input_teclado - 1).getCostoMana()) {
						System.out.println("Elija otra carta, mana insuficiente");
						input_teclado = gameController.entrada_teclado(scanner, 1, 6);
						if (input_teclado == 6) {
							break;
						}
					}
				}
				if (input_teclado <=5) {
					Carta carta = mano.get(input_teclado - 1);
					//Aplicamos los costos de la carta al jugador
					jugador.setMana(jugador.getMana() - carta.getCostoMana());
					//borramos la carta de la mano
					mano.remove(carta);
					//Aplicamos los efectos de las cartas
					System.out.println("Elija : 1-Aplicar a aliado  ,  2-Aplicar a Enemigo");
					input_teclado = gameController.entrada_teclado(scanner, 1, 2);
					switch (input_teclado) {
						case 1:
							System.out.println("Elija al Heroe que desea aplicar");
							input_teclado = gameController.entrada_teclado(scanner, 1, lista_heroes.size());
							carta.efecto(lista_heroes.get(input_teclado-1));
							break;
						case 2:
							System.out.println("Elija al Esbirro que desea aplicar");
							input_teclado = gameController.entrada_teclado(scanner, 1, lista_esbirros.size());
							carta.efecto(lista_esbirros.get(input_teclado-1));
							break;
					}
				}
				
				
				
				//Revisar Estadisticas de vida
				verificarVidaCriaturas(lista_esbirros);//Borra a los muertos
				verificarVidaCriaturas(lista_heroes);//Borra a los muertos
				if (lista_esbirros.isEmpty()){
					System.out.println("-Esbirros Derrotados-");
					break;
				}
				if (lista_heroes.isEmpty()) {
					break;
				}
				
				
				
				//Actualizamos La Interfaz Grafica
				salaGUI.actualizarGUI();
			}
			//Elegir Heroe
			System.out.println("-	Fase Combate	-");
			System.out.println("##	Escoja Heroe con el que desee atacar	##");
			//Validador de entrada
	        input_teclado = gameController.entrada_teclado(scanner,1, lista_heroes.size());
	        Heroe heroe = gameController.obtenerHeroe(input_teclado,lista_heroes);
	        System.out.println("-------");
	        gameController.estadisticasCriatura(heroe);
	        System.out.println(heroe.getEstadisticasCriatura());
	        System.out.println("-------");
	        //Turno Heroes
			System.out.println("Eliga: 1-Ataque Basico , 2-Habilidad Especial , 3-No hacer nada");
			input_teclado = gameController.entrada_teclado(scanner, 1, 3);//Validador de entrada
			//Revisar si tiene Energia para habilidad Especial si es q la usa
			while (heroe.getEnergia() < heroe.getConsumoHabilidadEspecial()) {
				System.out.println("No tienes suficiente energia");
				input_teclado = gameController.entrada_teclado(scanner, 1, 3);//Validador de entrada
				if (input_teclado != 2) {
					break;
				}
			}
			
			combateTurnoHeroe(scanner, input_teclado, heroe, lista_esbirros);//Logica Turno Heroe
			verificarVidaCriaturas(lista_esbirros);//Borra a los muertos
			
			//Revisar Estadisticas de vida
			if (lista_esbirros.isEmpty()){
				System.out.println("-Esbirros Derrotados-");
				break;
			}
			if (lista_heroes.isEmpty()) {
				break;
			}
			//Actualizamos La Interfaz Grafica
			salaGUI.actualizarGUI();
			//Turno Esbirros
			combateTurnoEnemigo(random, lista_esbirros, lista_heroes, profesor);
			//Revisamos la vida de Heroes
			verificarVidaCriaturas(lista_heroes);
			//Revisar Estadisticas de vida
			if (lista_esbirros.isEmpty()){
				break;
			}
			if (lista_heroes.isEmpty()) {
				break;
			}
			//Actualizamos La Interfaz Grafica
			salaGUI.actualizarGUI();
			//Borra La consola
			try {
	            if (System.getProperty("os.name").contains("Windows")) {
	                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	            } else {
	                new ProcessBuilder("clear").inheritIO().start().waitFor();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		}
		
		if(lista_heroes.size() == 0) {
			return false;
		}
		
		//Actualizamos La Interfaz Grafica
		salaGUI.actualizarGUI();
		//Una vez terminado los esbirros se deben enfrentar al Profesor
		System.out.println("Jefe Final");
		while (!this.completado) {
			//Muestra a los heroes y criaturas
			System.out.println("--------------------------------------------------------");
			gameController.estadisticasCriatura(lista_heroes);
			System.out.println("		-------vs--------		");
			gameController.estadisticasCriatura(profesor);
			System.out.println("--------------------------------------------------------");
			//Elegir
			System.out.println("##	Escoja Heroe con el que desee atacar	##");
			//Validador de entrada
	        input_teclado = gameController.entrada_teclado(scanner, 1, lista_heroes.size());
	        Heroe heroe = gameController.obtenerHeroe(input_teclado,lista_heroes);
	        System.out.println("-------");
	        gameController.estadisticasCriatura(heroe);
	        System.out.println("-------");
	        
			//Turno Heroes
			System.out.println("Eliga: 1-Ataque Basico , 2-Habilidad Especial , 3-No Hacer Nada ");
			//Validador de entrada
			input_teclado = gameController.entrada_teclado(scanner, 1, 3);
			combateTurnoHeroe(scanner, input_teclado, heroe, profesor);
			
			//Comprobar vida Heroes
			verificarVidaCriaturas(lista_heroes);
			
			//Actualizamos La Interfaz Grafica
			salaGUI.actualizarGUI();
			
			//Revisar Estadisticas de vida
			if (lista_heroes.isEmpty()) {
				return false;
			}
			if (profesor.getVida() == 0) {
				this.completado = true;
				salaGUI.cerrarVentana();
				return true;
			}
			//Turno Profesor
			combateTurnoEnemigo(random, lista_heroes, profesor);
			//Comprobar vida Heroes
			verificarVidaCriaturas(lista_heroes);
			
			//Actualizamos La Interfaz Grafica
			salaGUI.actualizarGUI();
			
			//Revisar Estadisticas de vida
			if (lista_heroes.isEmpty()) {
				return false;
			}
			if (profesor.getVida() == 0) {
				this.completado = true;
				salaGUI.cerrarVentana();
				return true;
			}
		}
		return false;
	}
	
	//Metodos Para Combate
	//Combate Turno de Heroes
		private static void combateTurnoHeroe(Scanner scanner,int input_teclado,Heroe heroe,List<Criatura>lista_esbirros) {
			//Variables
			Esbirro esbirro;
			switch (input_teclado) {
			case 1:
				// Hacer que escoja entre Ataque Mele = 1 o Rango = 2
				System.out.println("1- Ataque Mele , 2- Ataque Rango");
				input_teclado = gameController.entrada_teclado(scanner, 1, 2);
				switch (input_teclado) {
					case 1:
						System.out.println("#############################");
		                System.out.println("Ataque Mele");
		                System.out.println("#############################");
		                //Elegir al Esbirro a atacar
		                System.out.println("##Escoja al Esbirro al que desee atacar##");
		                input_teclado = gameController.entrada_teclado(scanner, 1, lista_esbirros.size());
		                esbirro = (Esbirro) lista_esbirros.get(input_teclado - 1);
		                esbirro.recibirDano(heroe.getAtaqueMele());
		                System.out.println("#ataque con exito#");
						break;
					case 2:
						System.out.println("#############################");
		                System.out.println("Ataque Rango");
		                System.out.println("#############################");
		                //Elegir al Esbirro a atacar
		                System.out.println("##Escoja al Esbirro al que desee atacar##");
		                input_teclado = gameController.entrada_teclado(scanner, 1, lista_esbirros.size());
		                esbirro = (Esbirro) lista_esbirros.get(input_teclado - 1);
		                esbirro.recibirDano(heroe.getAtaqueRango());
		                System.out.println("#ataque con exito#");
						break;
				}
	            break;
	        case 2:
	        	System.out.println("#############################");
	            System.out.println("Ataque Especial");
	            System.out.println("#############################");
	            
	            heroe.HabilidadEspecial(lista_esbirros);
	            break;
	        case 3:
	        	System.out.println("- No hacer Nada -");
			}
		}
		//Combate Contra el Profesor
		private static void combateTurnoHeroe(Scanner scanner,int input_teclado,Heroe heroe,Profesor profesor) {
			switch (input_teclado) {
			case 1:
				// Hacer que escoja entre Ataque Mele = 1 o Rango = 2
				System.out.println("1- Ataque Mele , 2- Ataque Rango");
				input_teclado = gameController.entrada_teclado(scanner, 1, 2);
				switch (input_teclado) {
					case 1:
						System.out.println("#############################");
		                System.out.println("Ataque Mele");
		                System.out.println("#############################");
		                profesor.recibirDano(heroe.getAtaqueMele());
		                System.out.println("#ataque con exito#");
						break;
					case 2:
						System.out.println("#############################");
		                System.out.println("Ataque Rango");
		                System.out.println("#############################");
		                profesor.recibirDano(heroe.getAtaqueRango());
		                System.out.println("#ataque con exito#");
						break;
				}
	            break;
	        case 2:
	        	System.out.println("#############################");
	            System.out.println("Ataque Especial");
	            System.out.println("#############################");
	            heroe.HabilidadEspecial(profesor);
	            break;
	        case 3:
	            System.out.println("- No hacer Nada -");
	            break;
			}
		}
		
		
		//Turno Esbirros
		private static void combateTurnoEnemigo(Random random,List<Criatura> lista_esbirros,List<Criatura> lista_heroes,Profesor profesor) {
			System.out.println("Rival decide hacer:");
			int numeroAleatorio = random.nextInt(3) + 1;
			switch (numeroAleatorio) {
				case 1:
					System.out.println("#############################");
	                System.out.println("Ataque Mele");
	                System.out.println("#############################");
	                //Logica Ataque Enemigo
	                //Esbirro Aleatorio
	                numeroAleatorio = random.nextInt(lista_esbirros.size());
	                int dano = lista_esbirros.get(0).getAtaque();
	                //Heroe Aleatorio
	                numeroAleatorio = random.nextInt(lista_heroes.size());
	                lista_heroes.get(numeroAleatorio).recibirDano(dano);
	                System.out.println("#ataque enemigo con exito#");
	                break;
	            case 2:
	            	System.out.println("Ataque Especial del Jefe");
	            	//Pensar logica para traer las habilidades especiales
	            	//Colaborativo
	            	if (profesor.getColaborativo()) {
	            		profesor.HabilidadEspecial(lista_esbirros);
	            	}
	            	else {
	            		profesor.HabilidadEspecial(lista_heroes);
	            	}
	            	
	            	break;
	            case 3:
	                System.out.println("No hacer Nada");
	                break;
			}
		}
		
		//Turno Jefe
		private static void combateTurnoEnemigo(Random random,List<Criatura> lista_heroes,Profesor profesor) {
			System.out.println("Rival decide hacer:");
			int numeroAleatorio = random.nextInt(3) + 1;
			switch (numeroAleatorio) {
				case 1:
					System.out.println("#############################");
	                System.out.println("Ataque Mele");
	                System.out.println("#############################");;
	                //Logica Ataque Enemigo
	                int dano = profesor.getAtaque();
	                //Heroe Aleatorio
	                numeroAleatorio = random.nextInt(lista_heroes.size());
	                lista_heroes.get(numeroAleatorio).recibirDano(dano);
	                System.out.println("#ataque enemigo con exito#");     
	                break;
	            case 2:
	            	System.out.println("Ataque Especial del Jefe");
	            	//
	            	if (profesor.getColaborativo()) {
	            		List<Criatura> lista_vacia = new ArrayList<Criatura>();
	            		profesor.HabilidadEspecial(lista_vacia);
	            	}
	            	else {
	            		profesor.HabilidadEspecial(lista_heroes);
	            	}
	            	break;
	            case 3:
	                System.out.println("No hacer Nada");
	                break;
			}
		}
		
		//Metodo para crear Esbirros
		private List<Criatura> crear_esbirros(int cantidad) {
			List<Criatura> lista_esbirro = new ArrayList<Criatura>();
			for (int i = 1; i <=cantidad; i++) {
				Esbirro esbirro = new Esbirro("Esbirro " + i);
				lista_esbirro.add(esbirro);
	        }
			return lista_esbirro;
		}
		
		public String getTipoSala() {
			return this.tipoSala;
		}
}