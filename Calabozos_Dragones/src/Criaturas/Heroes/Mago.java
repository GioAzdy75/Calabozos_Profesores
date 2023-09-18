package Criaturas.Heroes;

import java.util.List;

import Criaturas.Criatura;
import Criaturas.Heroe;
import Criaturas.Profesor;

public class Mago extends Heroe {
	public Mago(String nombre) {
		super(nombre); // nombre = nombre
		imageSrc = "magofuego.png";
	}
	
	//Ataque Mele
	public int getAtaqueMele() {
		return this.getAtaque()/4;
	}
	//Ataque Rango
	public int getAtaqueRango() {
		return (int) (this.getAtaque());
	}
	
	//Habilidad Especial Congelar
	//Reduce el daño de todos los esbirros en un 30%
	//Solo funciona con esbirros
	public void HabilidadEspecial(List<? extends Criatura> lista_criaturas) {
		System.out.println("Ventisca Feroz");
		for (Criatura criatura : lista_criaturas) {
			double danoEsbirro = criatura.getAtaque() * 0.8;
			System.out.println(danoEsbirro);
			int nuevo_dano = (int) (danoEsbirro);
			criatura.setAtaque(nuevo_dano);
		}
	}
	
	public void HabilidadEspecial(Profesor profesor) {
		profesor.recibirDano((int)(getVida()* 0.15));
	}
}