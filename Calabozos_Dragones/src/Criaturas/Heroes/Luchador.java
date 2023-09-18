package Criaturas.Heroes;

import java.util.List;
import java.util.Scanner;
import Criaturas.Esbirro;
import Criaturas.Heroe;
import Criaturas.Profesor;

public class Luchador extends Heroe {
	//Constructor
	public Luchador(String nombre) {
		super(nombre); // nombre = nombre
		imageSrc = "Boss.png";
	}

	//Ataque Mele
	public int getAtaqueMele() {
		return this.getAtaque();
	}
	//Ataque Rango
	public int getAtaqueRango() {
		return (int) (this.getAtaque()/2);
	}	
	
	//Habilidad Especial Golpe con el doble de daño
	public void HabilidadEspecial(List<Esbirro>lista_esbirros) {
		System.out.println("Golpe Furioso");
		System.out.println("##Escoja al Esbirro al que desee atacar##");
		Scanner scanner = new Scanner(System.in); //Scanner del teclado
		int input_teclado = scanner.nextInt();
		Esbirro esbirro = lista_esbirros.get(input_teclado - 1);
		esbirro.recibirDano(getAtaque() * 2);
		if (esbirro.getVida() == 0) {
        	lista_esbirros.remove(esbirro);
        }
	}
	
	public void HabilidadEspecial(Profesor profesor) {
		System.out.println("Golpe Furioso");
		profesor.recibirDano(getAtaque() * 2);
	}
}