package Criaturas.Heroes;

import java.util.List;

import Criaturas.Criatura;
import Criaturas.Heroe;
import Criaturas.Profesor;

public class Arquero extends Heroe {
	//Constructor
	public Arquero(String nombre) {
		super(nombre); // nombre = nombre
		imageSrc = "arquero.png";
	}
	
	//Ataque Mele
	public int getAtaqueMele() {
		return this.getAtaque()/2;
	}
	//Ataque Rango
	public int getAtaqueRango() {
		return (int) (this.getAtaque()*1.20);
	}
	
	//Habilidad Especial Golpe con el doble de daño
	public void HabilidadEspecial(List<? extends Criatura> lista_criaturas) {
	}
	
	public void HabilidadEspecial(Profesor profesor) {
	}
}