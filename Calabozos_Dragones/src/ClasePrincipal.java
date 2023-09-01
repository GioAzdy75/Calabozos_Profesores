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
		List<Heroe>lista_heroes = new ArrayList<Heroe>();
		List<Criatura>lista_esbirros = new ArrayList<Criatura>();
		
		for (int i = 0; i <= 3; i++) {
            //System.out.println("Valor de i: " + i);
            //Creamos Criaturas
            Heroe heroe = new Heroe("cabezon " + i);
            Esbirros esbirro = new Esbirros("esbirrito "+ i);
            //llenamos la lista
            lista_heroes.add(heroe);
            lista_esbirros.add(esbirro);
        }
		
	

		//Crear Arena
		GrupoHeroes grupo_heroes = new GrupoHeroes(lista_heroes);
		GrupoCriatura grupo_esbirros = new GrupoCriatura(lista_esbirros);
		
		Arena arena_1 = new Arena("primer_arena",grupo_heroes,grupo_esbirros);
		
		
		
		
		//Pruebas
		
		//System.out.println(grupo_heroes.atacar_en_grupo());
		//grupo_esbirros.mostrar_criatura();
		//System.out.println(grupo_esbirros.atacar_en_grupo());
		//grupo_esbirros.recibir_dano(100);
		//grupo_esbirros.mostrar_criatura();
		
		arena_1.iniciar_enfrentamiento();
	}

}
