package Criaturas.Profesores;

import java.util.List;
import java.util.Random;

import Criaturas.Criatura;
import Criaturas.Heroe;
import Criaturas.Profesor;

public class ProfeParadigmas extends Profesor {
	/**
	 * Constructor
	 * @param nombre : String
	 */
	public ProfeParadigmas(String nombre) {
		super(nombre,false);
	}
	/**
	 * Aumenta sus estadisticas en 60%
	 */
	public void HabilidadEspecial(List<Criatura> lista_heroes) {
		System.out.println("- NAIN - ");
		System.out.println("- Profes Aumenta sus estadisticas - ");
        this.setAtaque((int)(this.getAtaque() * 0.6));
        this.setVida((int)(this.getVida() * 0.6));
	}
}