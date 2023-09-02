import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClasePrincipal {

	public static void main(String[] args) {
		
		//
		
		System.out.println("####Calabozos_Y_Dragones####");
		
		//Utilidades que necesitamos
		Scanner scanner = new Scanner(System.in);
		
		//Lista de Criaturas
		List<Criatura>lista_aliados = new ArrayList<Criatura>();
		List<Criatura>lista_enemigos = new ArrayList<Criatura>();
		
		
		//Creamos 3 tanques
		for (int i = 0; i <= 3; i++) {
			Tanque tanque = new Tanque("Tanque " + i);
			lista_aliados.add(tanque);
        }
		//Creamos 5 luchadores
		for (int i = 0; i <= 5; i++) {
			Luchador luchador = new Luchador("Luchador " + i);
			lista_aliados.add(luchador);
        }
		//Creamos 2 Heroes
		Heroe hero_1 = new Heroe("Hero_1");
		Heroe hero_2 = new Heroe("Hero_2");
		lista_aliados.add(hero_1);
		lista_aliados.add(hero_2);
		
		//Creamos Enemigos
		for (int i = 0; i <= 9; i++) {
			if (i<4) {
				Tanque tanque = new Tanque("Enemigo-Tanque " + i);
				lista_enemigos.add(tanque);
			}
			else {
				Luchador luchador = new Luchador("Enemigo-Luchador " + i);
				lista_enemigos.add(luchador);
			}	
        }
		Profesor profe_1 = new Profesor("Ochoa");
		lista_enemigos.add(profe_1);
	

		//Crear Arena
		GrupoHeroes grupo_heroes = new GrupoHeroes(lista_aliados);
		GrupoCriatura grupo_esbirros = new GrupoCriatura(lista_enemigos);
		
		Arena arena_1 = new Arena("primer_arena",grupo_heroes,grupo_esbirros);
		
		arena_1.iniciar_enfrentamiento();
	}

}
