import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Criaturas.Heroes.Arquero;
import Criaturas.Heroes.Luchador;
import Criaturas.Heroes.Mago;
import Criaturas.Heroe;
import Criaturas.Profesor;
import Criaturas.Profesores.*;


public class DungeonGame {
	public static void main(String[] args) {
		//Utilidades que necesitamos
		Scanner scanner = new Scanner(System.in);
		//Titulo
		System.out.println("####Calabozos_Y_Dragones####");
		//Inicializamos los Heroes
		List<Heroe>lista_heroes = inicializarHeroes();
		List<List<Arena>> calabozo = crear_niveles(lista_heroes);//Revisar si quito este parametro
		//Inicializamos las cartas
		List<Carta>mazo_cartas = inicializarCartas();
		List<Carta>mano_cartas = new ArrayList<Carta>(); //cartas del jugador
		
		
		for (List<Arena> lista_sala : calabozo) {
			int i = 0;
			for (Arena sala : lista_sala) {
				System.out.println("|"+ i +"|" +sala.getNombre());
				i++;
			}
			System.out.println("Eliga la Sala a ingresar");
			int input_teclado = gameController.entrada_teclado(scanner, 0, lista_sala.size()-1); //Valida el Input del Usuario
			System.out.println("Ingreso a la Sala " + input_teclado);
			boolean resultadoBatalla= lista_sala.get(input_teclado).iniciar_enfrentamiento(mazo_cartas,mano_cartas);
			
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
	
	//Método que inicializa a los héroes
	//Retorna una lista con los héroes
	private static List<Heroe> inicializarHeroes() {
		List<Heroe>lista_heroes = new ArrayList<Heroe>();
		lista_heroes.add(new Luchador("Lc1"));
		lista_heroes.add(new Luchador("Lc2"));
		
		lista_heroes.add(new Luchador("Lc3"));
		lista_heroes.add(new Luchador("Lc4"));
		lista_heroes.add(new Mago("Mg1"));
		lista_heroes.add(new Mago("Mg2"));
		lista_heroes.add(new Arquero("ArQ1"));
		lista_heroes.add(new Arquero("ArQ2"));
		lista_heroes.add(new Arquero("ArQ3"));
		lista_heroes.add(new Arquero("ArQ4"));
		
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

	private static List<Carta>inicializarCartas() {
		List<Carta>lista_cartas = new ArrayList<Carta>();

		//Carta 1
		Carta carta1 = new Carta("Bibliofrafia interesante", "Aumenta el ataque básico del héroe en 10p y otorga 20p de energia adicional.", 0,20,10,20);
		//Carta 2
		Carta carta2 = new Carta("Exceso de cafeina", "Restaura 50p de energia pero reduce 30p de salud.", -30,0,50,0);
		Carta carta3 = new Carta("Examen Final", "Aumenta el ataque 60p y disminuye la energia 60p", 0,60,-60,0);
		Carta carta4 = new Carta("Recuperatorio", "Aumenta la vida 100p y consume 20p de energia", 100,0,0,20);
		Carta carta5 = new Carta("Presentacion Aburrida", "Aburres a los enemigos, disminuye su poder de ataque 50p.", 0,50,0,10);
		Carta carta6 = new Carta("Ir a Consulta", "Aumenta la vida 20p y disminuye energia en 5p", 20,20,-20,0);
		Carta carta7 = new Carta("Recreo", "Tomas un recreo.Aumenta la vida en 10p.", 10,0,0,0);
		Carta carta8 = new Carta("Maraton de estudio", "Aumenta la energia 30p permanentemente.", 0,0,30,0);
		Carta carta9 = new Carta("Entregar Tp en el ultimo minuto", "Disminuye la vida del enemigo 80p", 0,-80,0,30);
		Carta carta10 = new Carta("Cebar mate", "Aumenta la energia en 100p.", 0,0,100,0);

		lista_cartas.add(carta1);
		lista_cartas.add(carta2);
		lista_cartas.add(carta3);
		lista_cartas.add(carta4);
		lista_cartas.add(carta5);
		lista_cartas.add(carta6);
		lista_cartas.add(carta7);
		lista_cartas.add(carta8);
		lista_cartas.add(carta9);
		lista_cartas.add(carta10);
		
		return lista_cartas;
	}
}
