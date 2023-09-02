import java.util.List;
import java.util.Scanner;
import java.util.Random;


public class Arena {
	private String nombre;
	private GrupoHeroes grupo_heroes;
	private GrupoCriatura grupo_esbirros;
	private Boolean completado;
	
	
	public Arena(String nuevoNombre,GrupoHeroes grupo_heroes,GrupoCriatura grupo_esbirros) {
		this.nombre = nuevoNombre;
		this.grupo_heroes = grupo_heroes;
		this.grupo_esbirros = grupo_esbirros;
	}
	
	
	public String getNombre() {
		return this.nombre;
	}
	
	
	
	public void iniciar_enfrentamiento() {
		//Muestra los Heroes y A las Criaturas
		System.out.println("Inicia El Combate");
		System.out.println("------------------");
		grupo_heroes.mostrar_criatura();
		System.out.println("-------vs--------");
		grupo_esbirros.mostrar_criatura();
		System.out.println("------------------");
		
		//Scanner del teclado
		Scanner scanner = new Scanner(System.in);
		
		Random random = new Random();
		
		//Bucle de batalla
		while (true) {
			System.out.println("Eliga: 1-Ataque Basico , 2-Habilidad Especial , 3-No Hacer Nada ");
			
			//Recordatorio agregar validador por si no pasa int y algun valor esperado (1,2,3)
			int input_teclado = scanner.nextInt();
			
			switch (input_teclado) {
				case 1:
	                System.out.println("Ataque Basico");
	                int dano_total = grupo_heroes.atacar_en_grupo();
	                grupo_esbirros.recibir_dano(dano_total);
	                break;
	            case 2:
	                System.out.println("Ataque Especial");
	                break;
	            case 3:
	                System.out.println("No hacer Nada");
	                break;
	            default:
	                System.out.println("Opción no válida.");
			}
			
			//Revisar Estadisticas de vida
			System.out.println("-----Estadisticas de Enemigo------");
			grupo_esbirros.quitar_muertos();
			grupo_esbirros.mostrar_criatura();
			
			if (grupo_esbirros.esta_vacio() | grupo_heroes.esta_vacio()){
				break;
			}
			
			System.out.println("Rival decide hacer:");
			int numeroAleatorio = random.nextInt(3) + 1;
			switch (numeroAleatorio) {
				case 1:
	                System.out.println("Ataque Mele");
	                int dano_total = grupo_esbirros.atacar_en_grupo();
	                grupo_heroes.recibir_dano(dano_total);
	                break;
	            case 2:
	                System.out.println("Ataque Rango");
	                break;
	                
	            case 3:
	            	System.out.println("Ataque Especial");
	            	//Pensar logica para traer las habilidades especiales
	            case 4:
	                System.out.println("No hacer Nada");
	                break;
	            default:
	                System.out.println("Opción no válida.");
			}
			
			
			
			//Revisar Estadisticas de vida
			System.out.println("-----Estadisticas de Heroes------");
			grupo_heroes.quitar_muertos();
			grupo_heroes.mostrar_criatura();
			
			if (grupo_esbirros.esta_vacio() | grupo_heroes.esta_vacio()){
				break;
			}
			if (input_teclado == 4) {
				break;
			}
			
			
		}
	}
}