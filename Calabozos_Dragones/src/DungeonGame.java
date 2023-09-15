import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DungeonGame {
	public static void main(String[] args) {
		//Utilidades que necesitamos
		Scanner scanner = new Scanner(System.in);
		//Titulo
		System.out.println("####Calabozos_Y_Dragones####");
		
		
		System.out.println("####Iniciando Interfaz Grafica####");
		//Inicializamos los Heroes
		List<Heroe>lista_heroes = new ArrayList<Heroe>();
		Luchador luchador = new Luchador("Lc1");
		Mago mago = new Mago("Mg1");
		Arquero arquero = new Arquero("ArQ1");
		Arquero arquero2 = new Arquero("ArQ2");
		Arquero arquero3 = new Arquero("ArQ3");
		Arquero arquero4 = new Arquero("ArQ4");
		lista_heroes.add(luchador);
		lista_heroes.add(mago);
		lista_heroes.add(arquero);
		lista_heroes.add(arquero2);
		lista_heroes.add(arquero3);
		lista_heroes.add(arquero4);
		
		
		
		List<List<Arena>> calabozo = crear_niveles(lista_heroes);
		
		
		//
		
		SalaGUI salita = new SalaGUI(calabozo.get(0).get(0));
		//
		
		/*
		for (List<Arena> lista_sala : calabozo) {
			int i = 0;
			for (Arena sala : lista_sala) {
				System.out.println("|"+ i +"|" +sala.getNombre());
				i++;
			}
			System.out.println("Eliga la Sala a ingresar");
			int input_teclado = scanner.nextInt();
			System.out.println("Ingreso a la Sala " + input_teclado);
			lista_sala.get(input_teclado).iniciar_enfrentamiento();
			System.out.println("Enfrentamiento Terminado, listo para seguir");
		}
		
		System.out.println("!!!FELICITACIONES!!! Te Graduaste!!");
		*/
	}
	
	private static List<List<Arena>> crear_niveles(List<Heroe>lista_heroes) {
		//Calabozo
		List<List<Arena>> calabozo = new ArrayList<List<Arena>>();
		//Niveles
		List<Arena> nivel_1 = new ArrayList<Arena>();
		List<Arena> nivel_2 = new ArrayList<Arena>();
		List<Arena> nivel_3 = new ArrayList<Arena>();
		List<Arena> nivel_4 = new ArrayList<Arena>();
		List<Arena> nivel_5 = new ArrayList<Arena>();
		//Nivel 1
		//Inicializamos los Jefes
		Profesor profesor_1 = new Ochoa("Profesor Ochoa");
		Profesor profesor_2 = new Profesor("Profesor Harpo");
		//Creamos las Arenas
		nivel_1.add(new Arena("Sala Ochoa",lista_heroes,5,profesor_1));
		//Nivel 2
		nivel_2.add(new Arena("Sala Harpo",lista_heroes,4,profesor_2));
		//Nivel 3
		
		//Nivel 4
		
		//Nivel 5
		
		calabozo.add(nivel_1);
		calabozo.add(nivel_2);
		return calabozo;
		
	}
}
