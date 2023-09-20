package Criaturas.Profesores;

import java.util.List;

import Criaturas.Criatura;
import Criaturas.Heroe;
import Criaturas.Profesor;

public class ProfeCompiladores extends Profesor {
	//Constructor
	public ProfeCompiladores(String nombre) {
		super(nombre,false);
	}
	/**
	 * Mejora las estadisticas de sus esbirros en 50% o las suyas si no hay esbirros
	 */
	public void HabilidadEspecial(List<Criatura> lista_criaturas) {
		
		if (lista_criaturas.size() >0) {
			double newDano;
			double newVida;
			for (Criatura criatura : lista_criaturas) {
				newDano = criatura.getVida() + criatura.getAtaque() * 0.5;
				newVida = criatura.getVida() + criatura.getVida() * 0.5;
				criatura.setAtaque((int) newDano);
				criatura.setVida((int) newVida);
			}
		}
		else {
			this.setAtaque((int)(this.getAtaque() + this.getAtaque() * 0.5));
		}
	}
}