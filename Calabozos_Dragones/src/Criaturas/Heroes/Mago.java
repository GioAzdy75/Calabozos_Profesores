package Criaturas.Heroes;

import java.util.List;

import Criaturas.Criatura;
import Criaturas.Heroe;
import Criaturas.Profesor;

/**
 * Esta clase modela el tipo de Heroe Mago
 */
public class Mago extends Heroe {
	/**
	 * Constructor de la clase
	 * @param nombre nombre del mago
	 */
	public Mago(String nombre) {
		super(nombre); // nombre = nombre
		this.consumoHabilidadEspecial = 20;
	}
	
	public int getAtaqueMele() {
		return this.getAtaque()/4;
	}
	
	public int getAtaqueRango() {
		return (int) (this.getAtaque());
	}
	
	/**
	 * Reduce el daño de todos los esbirros en un 30%
	 */
	public void HabilidadEspecial(List<? extends Criatura> lista_criaturas) {
		this.setEnergia(this.getEnergia()-this.getConsumoHabilidadEspecial());
		System.out.println("Ventisca Feroz");
		for (Criatura criatura : lista_criaturas) {
			double danoEsbirro = criatura.getAtaque() * 0.8;
			System.out.println(danoEsbirro);
			int nuevo_dano = (int) (danoEsbirro);
			criatura.setAtaque(nuevo_dano);
		}
	}
	
	/**
	 * Reduce el 15% de la vida del Profesor
	 * @param profesor profesor al que se le aplica el efecto
	 */
	public void HabilidadEspecial(Profesor profesor) {
		profesor.recibirDano((int)(getVida()* 0.15));
	}
}