package Criaturas.Heroes;

import java.util.List;
import java.util.Random;

import Criaturas.Criatura;
import Criaturas.Heroe;
import Criaturas.Profesor;

/**
 * Esta clase modela el tipo de Heroe arquero
 */
public class Arquero extends Heroe {
	/**
	 * Constructor de la clase
	 * @param nombre nombre del arquero
	 */
	public Arquero(String nombre) {
		super(nombre);
		this.consumoHabilidadEspecial = 10;
	}
	
	public int getAtaqueMele() {
		return this.getAtaque()/2;
	}
	
	public int getAtaqueRango() {
		return (int) (this.getAtaque()*1.20);
	}
	
	/**
	 * Tira tres flechas a la vez y daña a enemigos al azar , cada flecha tiene la mitad de daño del rango del Arquero
	 */
	public void HabilidadEspecial(List<Criatura> lista_criaturas) {
		this.setEnergia(this.getEnergia()-this.getConsumoHabilidadEspecial());
		
		System.out.println("Ataque Triple Flecha");
		
		int dano = this.getAtaqueRango() / 2;
		Random random = new Random();
		lista_criaturas.get(random.nextInt(lista_criaturas.size())).recibirDano(dano);
		lista_criaturas.get(random.nextInt(lista_criaturas.size())).recibirDano(dano);
		lista_criaturas.get(random.nextInt(lista_criaturas.size())).recibirDano(dano);
	}
	
	/**
	 * Tira tres flechas al boss , cada flecha tiene la mitad de daño del rango del Arquero
	 */
	public void HabilidadEspecial(Profesor profesor) {
		System.out.println("Ataque Triple Flecha");
		int dano = this.getAtaqueRango() / 2;
		dano = dano * 3;
		profesor.recibirDano(dano);
	}
}