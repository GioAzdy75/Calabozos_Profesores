import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class gameController {

	private gameController() {
		
	}
	
	//Metodo para crear Esbirros
	public static List<Esbirro> crear_esbirros(int cantidad) {
		List<Esbirro> lista_esbirro = new ArrayList<Esbirro>();
		for (int i = 1; i <=cantidad; i++) {
			Esbirro esbirro = new Esbirro("Esbirro " + i);
			lista_esbirro.add(esbirro);
        }
		return lista_esbirro;
	}
	
	//Mostrar las estadisticas de los heroes o Esbirros (recibe listas)	
	public static void estadisticasCriatura(List<? extends Criatura> lista_criatura) {
		// Puedes trabajar con la lista de Criaturas, que incluye tanto Heroes como Esbirros
		System.out.println("|i|	Nombre	|	Vida	|	Dano	|");
		int i = 1;
		for (Criatura criatura : lista_criatura) {
		// Realiza operaciones comunes para todas las Criaturas
		    System.out.println("|"+(i++)+"|	"+criatura.getNombre() + "	|	" + criatura.getVida() + "	|	" + criatura.getAtaque() + "	|");
		    }
		}
	//Mostrar las estadisticas de los heroes o Esbirros (Heroe individual o Esbirro Individual)	
	public static void estadisticasCriatura(Criatura criatura) {
		System.out.println("|	Nombre	|	Vida	|	Dano	|");
	    System.out.println("|	"+criatura.getNombre() + "	|	" + criatura.getVida() + "	|	" + criatura.getAtaque() + "	|");
	}
	
	//Metodo para Obtener Heroe para atacar
	public static Heroe obtenerHeroe(int input_teclado,List<? extends Heroe>lista_heroes) {
		return lista_heroes.get(input_teclado - 1);
		}
	
	//Valida el entero que ingrasa desde: valor , hasta valor , siendo valor = a cualquier entero
	public static int entrada_teclado(Scanner scanner,int desde, int hasta) {
		int input_teclado;
		//Validador de entrada
        while (true) {
        	String entrada = scanner.next();
            try {
            	input_teclado = Integer.parseInt(entrada);
            	//input_teclado = scanner.nextInt();
            	if (input_teclado >= desde && input_teclado <= hasta) {
            		break;
            	}
            	else {
            		System.out.println("El índice está fuera de los límites de la lista. Inténtalo de nuevo.");
            	}
            } catch (NumberFormatException e) {
                System.out.println("Error Ingrese un numero Valido");
            }
        }
        return input_teclado;
	}
	
	//Combate Turno de Heroes
	public static void combateTurno(Scanner scanner,int input_teclado,Heroe heroe,List<Esbirro>lista_esbirros) {
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
		}
	}
	//Combate Contra el Profesor
	public static void combateTurno(Scanner scanner,int input_teclado,Heroe heroe,Profesor profesor) {
		switch (input_teclado) {
		case 1:
			// Hacer que escoja entre Ataque Mele = 1 o Rango = 2
			System.out.println("1- Ataque Mele , 2- Ataque Rango");
			input_teclado = scanner.nextInt();
			switch (input_teclado) {
				case 1:
					System.out.println("#############################");
	                System.out.println("Ataque Mele");
	                System.out.println("#############################");
	                profesor.recibirDano(heroe.getAtaqueMele());
	                System.out.println("#ataque con exito#");
	                if (profesor.getVida() == 0) {
	                	//Terminar SALA
	                	System.out.println("###Derrotaste la Sala########");
	                }
					break;
				case 2:
					System.out.println("#############################");
	                System.out.println("Ataque Rango");
	                System.out.println("#############################");
	                //Elegir al Esbirro a atacar
	                profesor.recibirDano(heroe.getAtaqueRango());
	                System.out.println("#ataque con exito#");
	                if (profesor.getVida() == 0) {
	                	//Terminar Sala
	                	System.out.println("###Derrotaste la Sala########");
	                }
					break;
			}
            break;
        case 2:
        	System.out.println("#############################");
            System.out.println("Ataque Especial");
            System.out.println("#############################");
            heroe.HabilidadEspecial(profesor);
            //Aplicar el daño
            break;
        case 3:
            System.out.println("No hacer Nada");
            break;
		}
	}
	
	
	//Turno Esbirros
	public static void combateTurnoEsbirro(Random random,List<Esbirro> lista_esbirros,List<Heroe> lista_heroes,Profesor profesor) {
		System.out.println("Rival decide hacer:");
		int numeroAleatorio = random.nextInt(3) + 1;
		switch (numeroAleatorio) {
			case 1:
				System.out.println("#############################");
                System.out.println("Ataque Mele");
                System.out.println("#############################");;
                //Logica Ataque Enemigo
                int dano = lista_esbirros.get(0).getAtaque();
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
	
	public static void combateTurnoEsbirro(Random random,List<Heroe> lista_heroes,Profesor profesor) {
		System.out.println("Rival decide hacer:");
		int numeroAleatorio = random.nextInt(3) + 1;
		switch (numeroAleatorio) {
			case 1:
				System.out.println("#############################");
                System.out.println("Ataque Mele");
                System.out.println("#############################");;
                //Logica Ataque Enemigo
                int dano = profesor.getAtaque();
                numeroAleatorio = random.nextInt(lista_heroes.size());
                lista_heroes.get(numeroAleatorio).recibirDano(dano);
                System.out.println("#ataque enemigo con exito#");
                if (lista_heroes.get(numeroAleatorio).getVida() == 0) {
                	lista_heroes.remove(lista_heroes.get(numeroAleatorio));
                }
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
}

