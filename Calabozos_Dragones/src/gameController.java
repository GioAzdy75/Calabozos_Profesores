import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Criaturas.Heroe;
import Criaturas.Criatura;

public class gameController {

	private gameController() {
		
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
	
	//Metodo para Obtener Heroe a partir de una Lista
	public static Heroe obtenerHeroe(int input_teclado,List<Criatura>lista_heroes) {
		return (Heroe) lista_heroes.get(input_teclado - 1);
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
}

