package Criaturas.Profesores;

import java.util.List;

import Criaturas.Heroe;
import Criaturas.Profesor;

public class Analisis extends Profesor {
	//Constructor
	public Analisis(String nombre) {
		super(nombre);
		imageSrc = "Boss.png";
	}
	
	//Habilidad especial
	public void HabilidadEspecial(List<Heroe>lista_heroes) {
		System.out.println("Sucesiones Infinitas");
		for (Heroe heroe : lista_heroes) {
			double dano_jefe = heroe.getVida() * 0.10;
			double reducir_ataque = heroe.getAtaque() * 0.90;
			double reducir_energia = heroe.getEnergia() * 0.90;
			heroe.recibirDano((int) dano_jefe);
			heroe.setAtaque((int) reducir_ataque);
			heroe.setEnergia((int) reducir_energia);
		}
	}
}