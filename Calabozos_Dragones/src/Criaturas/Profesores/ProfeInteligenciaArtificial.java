package Criaturas.Profesores;

import java.util.ArrayList;
import java.util.List;

import Criaturas.Criatura;
import Criaturas.Esbirro;
import Criaturas.Heroe;
import Criaturas.Profesor;

public class ProfeInteligenciaArtificial extends Profesor {
	//Constructor
	public ProfeInteligenciaArtificial(String nombre) {
		super(nombre,true);
	}
	/**
	 * Crea un nuevo esbirro en su grupo y si no hay esbirros se suma la vida en 100 puntos
	 */
	public void HabilidadEspecial(List<Criatura> lista_criaturas) {
		if (lista_criaturas.size() >0 ) {
			Esbirro esbirro = new Esbirro("Harposito ");
			lista_criaturas.add(esbirro);
		}
		else {
			this.setVida(getVida() + 100);
		}
		
	}
}