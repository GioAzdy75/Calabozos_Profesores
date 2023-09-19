package Criaturas.Profesores;

import java.util.List;
import java.util.Random;

import Criaturas.Criatura;
import Criaturas.Profesor;

public class Pasantias extends Profesor {
	/**
	 * Constructor
	 * @param nombre : String
	 */
	public Pasantias(String nombre) {
		super(nombre);
	}
	/**
	 * Te lanza la pala, destruye a un heroe
	 */
	public void HabilidadEspecial(List<? extends Criatura> lista_criaturas) {
		Random random = new Random();
		System.out.println("El Jefe te a largado una pala, tu heroe ");
		lista_criaturas.get(random.nextInt(lista_criaturas.size())).setVida(0);
	}
}