package Cartas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Clase de mazo de cartas
 */
public class Mazo {
	private List<Carta> listaCartas;
	
	/**
	 * Constructor del mazo
	 */
	public Mazo(){
		this.listaCartas = inicializarCartas();
	}
	
	/**
	 * Inicializa las cartas
	 * @return List<Carta> con las cartas inicializadas
	 */
	private static List<Carta> inicializarCartas() {
		List<Carta>lista_cartas = new ArrayList<Carta>();
		
		//nombre,descripcion,vida,ataque,energia,consumoMana
		Carta carta1 = new Carta("Bibliofrafia interesante", "Aumenta el ataque al básico del héroe en 30p y otorga 20p de energia adicional.", 0,30,20,10);
		Carta carta2 = new Carta("Exceso de cafeina", "Restaura 50p de energia pero reduce 30p de salud.", -30,0,70,15);
		Carta carta3 = new Carta("Examen Final", "Aumenta el ataque 60p y disminuye la energia 60p", 0,60,-60,15);
		Carta carta4 = new Carta("Recuperatorio", "Aumenta la vida 100p y consume 20p de energia", 100,0,20,15);
		Carta carta5 = new Carta("Presentacion Aburrida", "Aburres a los enemigos, disminuye su poder de ataque 50p.", 0,50,0,10);
		Carta carta6 = new Carta("Ir a Consulta", "Aumenta la vida 20p y dano disminuye energia en 20p", 20,20,-20,10);
		Carta carta7 = new Carta("Recreo", "Tomas un recreo.Aumenta la vida en 10p.", 50,0,0,10);
		Carta carta8 = new Carta("Maraton de estudio", "Aumenta la energia 30p permanentemente.", 0,0,60,20);
		Carta carta9 = new Carta("Entregar Tp en el ultimo minuto", "Disminuye la vida de la criatura 80p", 0,-80,0,20);
		Carta carta10 = new Carta("Cebar mate", "Aumenta la energia en 100p.", 0,0,100,20);
		Carta carta11 = new Carta("Fuertemente pateado", "Golpe critico que deja a la criatura muerta", -200,0,0,50);
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
		lista_cartas.add(carta11);
		return lista_cartas;
	}
	
	/**
	 * Devuelve 5 cartas del deck
	 * @return List<Carta> : con 5 cartas extraidas del deck
	 */
	public List<Carta> robarCartas() {
		
		Random random = new Random();
		//Creamos la mano de cartas
		List<Carta> manoCartas = new ArrayList<Carta>();
		//Agarra 5 cartas al azar
		manoCartas.add(listaCartas.get(random.nextInt(listaCartas.size())));
		manoCartas.add(listaCartas.get(random.nextInt(listaCartas.size())));
		manoCartas.add(listaCartas.get(random.nextInt(listaCartas.size())));
		manoCartas.add(listaCartas.get(random.nextInt(listaCartas.size())));
		manoCartas.add(listaCartas.get(random.nextInt(listaCartas.size())));
		
		return manoCartas;
	}
}
