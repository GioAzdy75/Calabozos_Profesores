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
		List<Heroe>lista_heroes = new ArrayList<Heroe>();
		for (int i = 1; i <=10; i++) {
			Heroe heroe = new Heroe("Heroe " + i);
			lista_heroes.add(heroe);
        }
		//Inicializamos los Jefes
		Profesor profesor_1 = new Profesor("Profesor Ochoa");
		Profesor profesor_2 = new Profesor("Profesor Harpo");
		//Creamos las Arenas
		Arena arena_1 = new Arena("Arena 1",lista_heroes,6,profesor_1);
		Arena arena_2 = new Arena("Arena 2",lista_heroes,4,profesor_2);
		
		//Elegimos la Arena
		System.out.println("Eliga la Sala 1 : 1 o Sala 2 : 2");
		int input_teclado = scanner.nextInt();
		switch (input_teclado) {
		case 1:
            System.out.println("Ingreso a la Sala 1");
            arena_1.iniciar_enfrentamiento();
            break;
        case 2:
            System.out.println("Ingreso a la Sala 2");
            arena_2.iniciar_enfrentamiento();
            break;
        default:
            System.out.println("Opción no válida.");
	}
	}
}
