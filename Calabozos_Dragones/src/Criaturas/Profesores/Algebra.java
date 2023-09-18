package Criaturas.Profesores;

import java.util.List;

import Criaturas.Heroe;
import Criaturas.Profesor;

public class Algebra extends Profesor {
	//Constructor
	public Algebra(String nombre) {
		super(nombre);
	}
	
	//Habilidad especial
	//Reduce 15% energia y 5 % de vida
	public void HabilidadEspecial(List<Heroe>lista_heroes) {
		System.out.println("Matrices Multidimencional");
		for (Heroe heroe : lista_heroes) {
			double dano_jefe = heroe.getVida() * 0.05;
			double reducir_energia = heroe.getEnergia() * 0.85;
			heroe.recibirDano((int) dano_jefe);
			heroe.setEnergia((int) reducir_energia);
		}
	}
}