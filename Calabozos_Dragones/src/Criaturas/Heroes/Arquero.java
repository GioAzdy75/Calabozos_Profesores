package Criaturas.Heroes;

import java.util.List;

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
	
	public void HabilidadEspecial(List<? extends Criatura> lista_criaturas) {
		this.setEnergia(this.getEnergia()-this.getConsumoHabilidadEspecial());
	}
	
	public void HabilidadEspecial(Profesor profesor) {
	}
}