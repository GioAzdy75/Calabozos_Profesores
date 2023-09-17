import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
		this.lista_esbirros = gameController.crear_esbirros(cantidadEsbirros);
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
	public boolean iniciar_enfrentamiento() {
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
			System.out.println("Eliga: 1-Ataque Basico , 2-Habilidad Especial , 3-No Hacer Nada ");
			input_teclado = gameController.entrada_teclado(scanner, 1, 3);//Validador de entrada
			gameController.combateTurno(scanner, input_teclado, heroe, lista_esbirros);//Logica Turno Heroe
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
			gameController.combateTurnoEsbirro(random, lista_esbirros, lista_heroes, profesor);
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
			gameController.combateTurno(scanner, input_teclado, heroe, profesor);
			
			//Comprobar vida Heroes
			verificarVidaCriaturas(lista_heroes);
			
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
			gameController.combateTurnoEsbirro(random, lista_heroes, profesor);
			//Comprobar vida Heroes
			verificarVidaCriaturas(lista_heroes);
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
		return false;	}
}