import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DungeonGame {
	public static void main(String[] args) {
		//Utilidades que necesitamos
		Scanner scanner = new Scanner(System.in);
		//Titulo
		System.out.println("####Calabozos_Y_Dragones####");
		//Inicializamos los Heroes
		List<Heroe>lista_heroes = inicializarHeroes();
		List<List<Arena>> calabozo = crear_niveles(lista_heroes);//Revisar si quito este parametro
		
		
		for (List<Arena> lista_sala : calabozo) {
			int i = 0;
			for (Arena sala : lista_sala) {
				System.out.println("|"+ i +"|" +sala.getNombre());
				i++;
			}
			System.out.println("Eliga la Sala a ingresar");
			int input_teclado = gameController.entrada_teclado(scanner, 0, lista_sala.size()-1); //Valida el Input del Usuario
			System.out.println("Ingreso a la Sala " + input_teclado);
			boolean resultadoBatalla= lista_sala.get(input_teclado).iniciar_enfrentamiento();
			
			if (resultadoBatalla) {
				System.out.println("Enfrentamiento Terminado, listo para seguir");
			}
			else {
				System.out.println("## - Perdiste - ##");
				break;
			}
		}
		if (lista_heroes.size() > 0) {
			System.out.println("!!!FELICITACIONES!!! Te Graduaste!!");
		}
	}
	
	private static List<Heroe> inicializarHeroes() {
		List<Heroe>lista_heroes = new ArrayList<Heroe>();
		lista_heroes.add(new Luchador("Lc1"));
		lista_heroes.add(new Luchador("Lc2"));
		/*
		lista_heroes.add(new Luchador("Lc3"));
		lista_heroes.add(new Luchador("Lc4"));
		lista_heroes.add(new Mago("Mg1"));
		lista_heroes.add(new Mago("Mg2"));
		lista_heroes.add(new Arquero("ArQ1"));
		lista_heroes.add(new Arquero("ArQ2"));
		lista_heroes.add(new Arquero("ArQ3"));
		lista_heroes.add(new Arquero("ArQ4"));
		*/
		return lista_heroes;
		
	}
	
	private static List<List<Arena>> crear_niveles(List<Heroe>lista_heroes) {
		//Variables Iniciales
		Profesor profesor_a;
		Profesor profesor_b;
		Profesor profesor_c;
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
		profesor_a = new Analisis("Profesor Ochoa");
		profesor_b = new Algebra("Profesora Noemi");
		profesor_c = new Geometria("Profesor Videla");
		//Creamos las Arenas
		nivel_1.add(new Arena("Sala Analisis I",lista_heroes,5,profesor_a));
		nivel_1.add(new Arena("Sala Algebra",lista_heroes,3,profesor_b));
		nivel_1.add(new Arena("Sala Geometria",lista_heroes,1,profesor_c));
		
		//Nivel 2
		//Inicializamos los Jefes
		profesor_a = new Algoritmos("Profesor Jorch");
		profesor_b = new Paradigmas("Profesor Pablo");
		//Creamos las Arenas
		nivel_2.add(new Arena("Sala Algoritmos y Estructura de Datos",lista_heroes,5,profesor_a));
		nivel_2.add(new Arena("Sala Paradigmas de la Programacion",lista_heroes,2,profesor_b));
		
		//Nivel 3
		//Inicializamos los Jefes
		profesor_a = new InteligenciaArtificial("Profesor Harpo");
		//Creamos las Arenas
		nivel_3.add(new Arena("Sala Inteligencia Artificial",lista_heroes,5,profesor_a));
		
		//Nivel 4
		profesor_a = new Compiladores("Profesora Carolina");
		//Creamos las Arenas
		nivel_4.add(new Arena("Sala Compiladores",lista_heroes,5,profesor_a));
		
		//Nivel 5
		profesor_a = new Tesis("Profesora Marisa");
		profesor_b = new Laburo("Jefe Laburo");
		//Creamos las Arenas
		nivel_5.add(new Arena("Anfiteatro",lista_heroes,5,profesor_a));
		nivel_5.add(new Arena("Sector Trabajo",lista_heroes,2,profesor_b));
		
		
		calabozo.add(nivel_1);
		calabozo.add(nivel_2);
		calabozo.add(nivel_3);
		calabozo.add(nivel_4);
		calabozo.add(nivel_5);
		
		return calabozo;
		
	}
}
