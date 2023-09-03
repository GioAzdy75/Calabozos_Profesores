import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;


public class Arena {
	private String nombre;
	List<Heroe>lista_heroes = new ArrayList<Heroe>();
	List<Esbirro>lista_esbirros = new ArrayList<Esbirro>();
	private Profesor profesor;
	private Boolean completado;
	
	
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
	//Metodo para crear Esbirros
	public List<Esbirro> crear_esbirros(int cantidad) {
		List<Esbirro> lista_esbirro = new ArrayList<Esbirro>();
		for (int i = 1; i <=cantidad; i++) {
			Esbirro esbirro = new Esbirro("Esbirro " + i);
			lista_esbirro.add(esbirro);
        }
		return lista_esbirro;
	}
	//Mostrar las estadisticas de los heroes	
	public void estadisticasCriatura(List<? extends Criatura> lista_criatura) {
	    // Puedes trabajar con la lista de Criaturas, que incluye tanto Heroes como Esbirros
	    for (Criatura criatura : lista_criatura) {
	        // Realiza operaciones comunes para todas las Criaturas
	    	System.out.println(criatura.getNombre() + " vida- " + criatura.getVida() + " ataque- " + criatura.getAtaque());
	    }
	}
	//Metodo para atacar
	public Heroe obtenerHeroe(int input_teclado) {
		return lista_heroes.get(input_teclado - 1);
	}
	
	//Metodo para Iniciar Enfrentamiento dentro de la Sala
	public void iniciar_enfrentamiento() {
		//Muestra los Heroes y A las Criaturas
		System.out.println("Inicia El Combate");
		
		
		//Utilidades
		Scanner scanner = new Scanner(System.in); //Scanner del teclado
		Random random = new Random(); //variable Random
		int input_teclado;
		
		//Bucle de batalla
		while (true) {
			//Muestra a los heroes y criaturas
			System.out.println("------------------");
			this.estadisticasCriatura(lista_heroes);
			System.out.println("-------vs--------");
			this.estadisticasCriatura(lista_esbirros);
			System.out.println("------------------");
			
			//Muestra Heroes y estadisticas
			System.out.println("##Escoja Heroe con el que desee atacar##");
	        input_teclado = scanner.nextInt();
	        Heroe heroe = obtenerHeroe(input_teclado);
	        System.out.println("-------");
	        System.out.println(heroe.getEstadisticasCriatura());
	        System.out.println("-------");
			
			System.out.println("Eliga: 1-Ataque Basico , 2-Habilidad Especial , 3-No Hacer Nada ");
			//Recordatorio agregar validador por si no pasa int y algun valor esperado (1,2,3)
			input_teclado = scanner.nextInt();
			switch (input_teclado) {
				case 1:
					// Hacer que escoja entre Ataque Mele o Rango
					
					System.out.println("#############################");
	                System.out.println("Ataque Mele");
	                System.out.println("#############################");
	                //Elegir al Esbirro a atacar
	                System.out.println("##Escoja al Esbirro al que desee atacar##");
	                input_teclado = scanner.nextInt();
	                Esbirro esbirro = lista_esbirros.get(input_teclado - 1);
	                esbirro.recibirDano(heroe.getAtaque());
	                System.out.println("#ataque con exito#");
	                //Logica de quitarlo si se muere
	                if (esbirro.getVida() == 0) {
	                	lista_esbirros.remove(esbirro);
	                }
	                break;
	            case 2:
	            	System.out.println("#############################");
	                System.out.println("Ataque Especial");
	                System.out.println("#############################");
	                
	                //Elegir al Esbirro a atacar
	                
	                //Aplicar el daño
	                break;
	            case 3:
	                System.out.println("No hacer Nada");
	                break;
	            default:
	                System.out.println("Opción no válida.");
			}
			
			//Revisar Estadisticas de vida
			//System.out.println("-----Estadisticas de Enemigo------");
			//grupo_esbirros.quitar_muertos();
			//grupo_esbirros.mostrar_criatura();
			
			//if (grupo_esbirros.esta_vacio() | grupo_heroes.esta_vacio()){
				//break;
			//}
			
			System.out.println("Rival decide hacer:");
			int numeroAleatorio = random.nextInt(2) + 1;
			switch (numeroAleatorio) {
				case 1:
					System.out.println("#############################");
	                System.out.println("Ataque Mele");
	                System.out.println("#############################");
	                break;
	            case 2:
	            	System.out.println("Ataque Especial");
	            	//Pensar logica para traer las habilidades especiales
	            	break;
	            case 3:
	                System.out.println("No hacer Nada");
	                break;
			}
			
			
			/*
			//Revisar Estadisticas de vida
			System.out.println("-----Estadisticas de Heroes------");
			grupo_heroes.quitar_muertos();
			grupo_heroes.mostrar_criatura();
			
			if (grupo_esbirros.esta_vacio() | grupo_heroes.esta_vacio()){
				break;
			}
			*/
			
			
		}
		//Una vez terminado los esbirros se deben enfrentar al Profesor
		
		//Logica parecida a la de arriba solo que no elige esbirros ya que solo ataca al profe
		//Se podria elevar estadisticas del profe ya que esta solo
		
		//Batalla
		
		//Fin Batalla
		
		//Arena Terminada , se podria devolver (True or False)
		
	}
}