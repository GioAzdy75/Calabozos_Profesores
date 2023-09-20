import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Criaturas.Profesor;
import Criaturas.Profesores.*;


/**
 * Clase Principal donde se ejecuta el Juego
 */
public class DungeonGame {
	/**
	 * Metodo Principal donde empieza la ejecucion del Juego
	 * @param args
	 */
	public static void main(String[] args) {
		//Utilidades que necesitamos
		Scanner scanner = new Scanner(System.in);//Scanner
		System.out.println("####Calabozos_Y_Dragones####");//Titulo
		
		//Inicializamos al Jugador
		Jugador jugador = new Jugador();
		
		//Inicializamos los niveles
		List<List<Sala>> calabozo = crear_niveles();
		
		for (List<Sala> lista_sala : calabozo) {
			int i = 0;
			for (Sala sala : lista_sala) {
				System.out.println("|"+ i +"|" +sala.getNombre());
				i++;
			}
			System.out.println("Eliga la Sala a ingresar");
			int input_teclado = gameController.entrada_teclado(scanner, 0, lista_sala.size()-1); //Valida el Input del Usuario
			System.out.println("Ingreso a la Sala " + input_teclado);
			boolean resultadoBatalla= lista_sala.get(input_teclado).iniciar_enfrentamiento(jugador);
			
			if (resultadoBatalla) {
				System.out.println("Enfrentamiento Terminado, listo para seguir");
			}
			else {
				System.out.println("## - Perdiste - ##");
				break;
			}
		}
		if (jugador.getLista_heroes().size() > 0) {
			System.out.println("!!!FELICITACIONES!!! Te Graduaste!!");
		}
	}
	
	
	/**
	 * Metodo para crear los niveles de la dungeon
	 * @return Lista de niveles y cada nivel tiene una sala
	 */
	private static List<List<Sala>> crear_niveles() {
		//Variables Iniciales
		Profesor profesor_a;
		Profesor profesor_b;
		Profesor profesor_c;
		//Calabozo
		List<List<Sala>> calabozo = new ArrayList<List<Sala>>();
		//Niveles
		List<Sala> nivel_1 = new ArrayList<Sala>();
		List<Sala> nivel_2 = new ArrayList<Sala>();
		List<Sala> nivel_3 = new ArrayList<Sala>();
		List<Sala> nivel_4 = new ArrayList<Sala>();
		List<Sala> nivel_5 = new ArrayList<Sala>();
		
		//Nivel 1
		//Inicializamos los Jefes
		profesor_a = new ProfeAnalisis("Profesor Ochoa");
		profesor_b = new ProfeAlgebra("Profesora Noemi");
		profesor_c = new ProfeGeometria("Profesor Videla");
		//Creamos las Arenas
		nivel_1.add(new Sala("Sala Analisis I",5,profesor_a,"Analisis"));
		nivel_1.add(new Sala("Sala Algebra",3,profesor_b,"Algebra"));
		nivel_1.add(new Sala("Sala Geometria",1,profesor_c,"Geometria"));
		
		//Nivel 2
		//Inicializamos los Jefes
		profesor_a = new ProfeAlgoritmos("Profesor Jorch");
		profesor_b = new ProfeParadigmas("Profesor Pablo");
		//Creamos las Arenas
		nivel_2.add(new Sala("Sala Algoritmos y Estructura de Datos",5,profesor_a,"Algoritmos"));
		nivel_2.add(new Sala("Sala Paradigmas de la Programacion",2,profesor_b,"Paradigmas"));
		
		//Nivel 3
		//Inicializamos los Jefes
		profesor_a = new ProfeInteligenciaArtificial("Profesor Harpo");
		profesor_b = new ProfeArquitectura("Profesor Osvaldo");
		//Creamos las Arenas
		nivel_3.add(new Sala("Sala Inteligencia Artificial",5,profesor_a,"InteligenciaArtificial"));
		nivel_3.add(new Sala("Sala Arquitectura",3,profesor_b,"Arquitectura"));
		//Nivel 4
		profesor_a = new ProfeCompiladores("Profesora Carolina");
		//Creamos las Arenas
		nivel_4.add(new Sala("Sala Compiladores",5,profesor_a,"Compiladores"));
		
		//Nivel 5
		profesor_a = new ProfeTesis("Profesora Marisa");
		profesor_b = new ProfePasantias("Jefe Laburo");
		//Creamos las Arenas
		nivel_5.add(new Sala("Anfiteatro",5,profesor_a,"Tesis"));
		nivel_5.add(new Sala("Sector Trabajo",2,profesor_b,"Pasantias"));
		
		
		calabozo.add(nivel_1);
		calabozo.add(nivel_2);
		calabozo.add(nivel_3);
		calabozo.add(nivel_4);
		calabozo.add(nivel_5);
		
		return calabozo;
		
	}
}
