import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Criaturas.Esbirro;
import Criaturas.Heroe;
import Criaturas.Profesor;
import Criaturas.Criatura;

import java.util.Random;
import java.util.HashMap;
import java.util.Iterator;

public class Arena {
	private String nombre;
	List<Heroe>lista_heroes = new ArrayList<Heroe>();
	List<Esbirro>lista_esbirros = new ArrayList<Esbirro>();
	Profesor profesor;
	private boolean completado = false;
	
	
	public Arena(String nuevoNombre,List<Heroe> lista_heroes,int cantidadEsbirros,Profesor profesor) {
		this.nombre = nuevoNombre;
		this.lista_heroes = lista_heroes;
		this.lista_esbirros = this.crear_esbirros(cantidadEsbirros);
		this.profesor = profesor;
	}
	
	//getters y setters
	public String getNombre() {
		return this.nombre;
	}
	
	public void verificarVidaCriaturas(List<? extends Criatura>lista_criatura) {
		Iterator<? extends Criatura> iterador = lista_criatura.iterator();
		
	    while (iterador.hasNext()) {
	        Criatura criatura = iterador.next();
	        if (criatura.getVida() == 0) {
	            iterador.remove();
	        }
	    }
	}
	//Metodo para Iniciar Enfrentamiento dentro de la Sala
	public boolean iniciar_enfrentamiento(List<Carta> listaDeCartas) {
		//Utilidades
		Scanner scanner = new Scanner(System.in); //Scanner del teclado
		Random random = new Random(); //variable Random
		int input_teclado;
		boolean combate_on = true;
		//Interfaz Grafica
		SalaGUI salaGUI = new SalaGUI(this);
		//
		
		System.out.println("Inicia El Combate");
		
		//Bucle de batalla Esbirros
		while (!this.completado) {
			//Muestra a los heroes y criaturas
			System.out.println("--------------------------------------------------------");
			gameController.estadisticasCriatura(lista_heroes);
			System.out.println("		-------vs--------		");
			gameController.estadisticasCriatura(lista_esbirros);
			System.out.println("--------------------------------------------------------");
			//Elegir Heroe
			System.out.println("##	Escoja Heroe con el que desee atacar	##");
			//Validador de entrada
	        input_teclado = gameController.entrada_teclado(scanner,1, lista_heroes.size());
	        Heroe heroe = gameController.obtenerHeroe(input_teclado,lista_heroes);
	        System.out.println("-------");
	        gameController.estadisticasCriatura(heroe);
	        System.out.println(heroe.getEstadisticasCriatura());
	        System.out.println("-------");
	        //Turno Heroes
			System.out.println("Eliga: 1-Ataque Basico , 2-Habilidad Especial , 3-Usar Carta");
			input_teclado = gameController.entrada_teclado(scanner, 1, 3);//Validador de entrada
			combateTurnoHeroe(scanner, input_teclado, heroe, lista_esbirros,listaDeCartas);//Logica Turno Heroe
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
		private static void combateTurnoHeroe(Scanner scanner,int input_teclado,Heroe heroe,List<Esbirro>lista_esbirros,List<Carta> listaDeCartas) {
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
		                esbirro = lista_esbirros.get(input_teclado - 1);
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
		                esbirro = lista_esbirros.get(input_teclado - 1);
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
				System.out.println("#############################");
	            System.out.println("---- Menu de Cartas ---");
	            System.out.println("#############################");
	            
	            System.out.println("|0|		Nombre		|		Descripcion		|");
	            int i = 1;
	            for (Carta carta : listaDeCartas) {
	            	// Realiza operaciones comunes para todas las Criaturas
	        		System.out.println("|"+i+"|	"+ carta.getNombre() +"		|"+carta.getDescripcion()+ " |");
	        		i++;
	        	};
	        	System.out.println("- Elija una Carta -");
	        	input_teclado = gameController.entrada_teclado(scanner, 1, listaDeCartas.size());
				break;
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
		private static void combateTurnoEnemigo(Random random,List<Esbirro> lista_esbirros,List<Heroe> lista_heroes,Profesor profesor) {
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
	            	profesor.HabilidadEspecial(lista_heroes);
	            	break;
	            case 3:
	                System.out.println("No hacer Nada");
	                break;
			}
		}
		
		//Turno Jefe
		private static void combateTurnoEnemigo(Random random,List<Heroe> lista_heroes,Profesor profesor) {
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
	            	profesor.HabilidadEspecial(lista_heroes);
	            	break;
	            case 3:
	                System.out.println("No hacer Nada");
	                break;
			}
		}
		
		//Metodo para crear Esbirros
		private List<Esbirro> crear_esbirros(int cantidad) {
			List<Esbirro> lista_esbirro = new ArrayList<Esbirro>();
			for (int i = 1; i <=cantidad; i++) {
				Esbirro esbirro = new Esbirro("Esbirro " + i);
				lista_esbirro.add(esbirro);
	        }
			return lista_esbirro;
		}
}