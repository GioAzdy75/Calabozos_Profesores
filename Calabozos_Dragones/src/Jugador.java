import java.util.ArrayList;
import java.util.List;

import Cartas.Mazo;
import Criaturas.Heroe;
import Criaturas.Heroes.Arquero;
import Criaturas.Heroes.Luchador;
import Criaturas.Heroes.Mago;

public class Jugador {
	private List<Heroe> lista_heroes;
	private Mazo mazo;
	private int energia;
	/**
	 * Constructor de la clase
	 */
	public Jugador(){
		this.lista_heroes = inicializarHeroes();
		this.mazo = new Mazo();
	}
	
	/**
	 * Devuelve la lista_heroes
	 * @return List<Heroes> lista_heroes
	 */
	public List<Heroe> getLista_heroes() {
		return lista_heroes;
	}
	
	/**
	 * Devuelve el mazo del jugador
	 * @return Mazo : retorna el mazo del jugador
	 */
	public Mazo getMazo() {
		return this.mazo;
	}

	/**
	 * Metodo para inicializar los Heroes 
	 * @return lista de tipo Heroe
	 */
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

	/**
	 * @return the energia
	 */
	public int getEnergia() {
		return energia;
	}

	/**
	 * @param energia the energia to set
	 */
	public void setEnergia(int energia) {
		this.energia = energia;
	}
}


