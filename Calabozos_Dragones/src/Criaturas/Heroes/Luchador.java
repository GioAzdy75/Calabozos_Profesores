package Criaturas.Heroes;

import java.util.List;
import java.util.Scanner;
import Criaturas.Criatura;
import Criaturas.Heroe;
import Criaturas.Profesor;


/**
 * Esta clase modela el tipo de Heroe Luchador
 */
public class Luchador extends Heroe {
	/**
	 * Constructor
	 * @param nombre nombre del heroe
	 */
	public Luchador(String nombre) {
		super(nombre); // nombre = nombre
		this.consumoHabilidadEspecial = 15;
	}

	public int getAtaqueMele() {
		return this.getAtaque();
	}
	
	public int getAtaqueRango() {
		return (int) (this.getAtaque()/2);
	}	
	
	
	/**
	 * Golpe con el doble de daño hacia una lista de Criaturas
	 */
	public void HabilidadEspecial(List<Criatura> lista_criaturas) {
		this.setEnergia(this.getEnergia()-this.getConsumoHabilidadEspecial());
		
		System.out.println("Golpe Furioso");
		System.out.println("##Escoja al Esbirro al que desee atacar##");
		Scanner scanner = new Scanner(System.in); //Scanner del teclado
		int input_teclado = scanner.nextInt();
		Criatura esbirro = lista_criaturas.get(input_teclado - 1);
		esbirro.recibirDano(getAtaque() * 2);
		if (esbirro.getVida() == 0) {
			lista_criaturas.remove(esbirro);
        }
	}
	/**
	 * Golpe con el doble de daño hacia un Profesor
	 * @param profesor Profesor al que se le aplicara el daño
	 */
	public void HabilidadEspecial(Profesor profesor) {
		System.out.println("Golpe Furioso");
		profesor.recibirDano(getAtaque() * 2);
	}
}