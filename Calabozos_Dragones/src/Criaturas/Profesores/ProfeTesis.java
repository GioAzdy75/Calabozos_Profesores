package Criaturas.Profesores;

import java.util.List;

import Criaturas.Criatura;
import Criaturas.Heroe;
import Criaturas.Profesor;

public class ProfeTesis extends Profesor {
	/**
	 * Constructor
	 * @param nombre String
	 */
	public ProfeTesis(String nombre) {
		super(nombre,false);
	}
	/**
	 * reduce el daño de todos en 50% y se lo suma al Profesor
	 */
	public void HabilidadEspecial(List<Criatura> lista_criaturas) {
		int vidaDrenada = 0;
		for (Criatura criatura : lista_criaturas) {
			int dano = (int)(criatura.getVida() * 0.5);
			vidaDrenada += dano;
			criatura.setVida(criatura.getVida() - dano);
		}
		this.setAtaque(this.getAtaque() + vidaDrenada);
	}
}