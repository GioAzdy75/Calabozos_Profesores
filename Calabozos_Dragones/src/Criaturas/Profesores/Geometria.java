package Criaturas.Profesores;

import java.util.List;

import Criaturas.Criatura;
import Criaturas.Heroe;
import Criaturas.Profesor;

public class Geometria extends Profesor {
	/**
	 * Constructor
	 * @param nombre : String
	 */
	public Geometria(String nombre) {
		super(nombre);
	}
	
	/**
	 * Reduce el dano y la vida en 10%
	 */
	public void HabilidadEspecial(List<? extends Criatura> lista_heroes) {
		System.out.println("Superficies Cuadraticas");
		for (Criatura heroe : lista_heroes) {
			double dano_jefe = heroe.getVida() * 0.10;
			double reducir_ataque = heroe.getAtaque() * 0.90;
			heroe.recibirDano((int) dano_jefe);
			heroe.setAtaque((int) reducir_ataque);
		}
	}
}