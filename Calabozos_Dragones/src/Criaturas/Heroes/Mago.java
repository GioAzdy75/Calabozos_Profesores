package Criaturas.Heroes;

import java.util.List;
import Criaturas.Esbirro;
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
	public void HabilidadEspecial(List<Esbirro>lista_esbirros) {
		System.out.println("Ventisca Feroz");
		for (Esbirro esbirro : lista_esbirros) {
			double danoEsbirro = esbirro.getAtaque() * 0.8;
			System.out.println(danoEsbirro);
			int nuevo_dano = (int) (danoEsbirro);
			esbirro.setAtaque(nuevo_dano);
		}
	}
	
	public void HabilidadEspecial(Profesor profesor) {
		profesor.recibirDano((int)(getVida()* 0.15));
	}
}