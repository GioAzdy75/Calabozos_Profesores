package Criaturas.Profesores;

import java.util.List;

import Criaturas.Criatura;
import Criaturas.Profesor;

public class Algebra extends Profesor {
	/**
	 * Constructor de la clase
	 * @param nombre nombre del Profesor
	 */
	public Algebra(String nombre) {
		super(nombre);
	}
	
	//Habilidad especial
	//Reduce 15% energia y 5 % de vida
	public void HabilidadEspecial(List<? extends Criatura> lista_criaturas) {
		System.out.println("Matrices Multidimencional");
		for (Criatura criatura : lista_criaturas) {
			double dano_jefe = criatura.getVida() * 0.05;
			double reducir_energia = criatura.getEnergia() * 0.85;
			criatura.recibirDano((int) dano_jefe);
			criatura.setEnergia((int) reducir_energia);
		}
	}
}