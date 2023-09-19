package Criaturas.Profesores;

import java.util.List;
import java.util.Random;

import Criaturas.Criatura;
import Criaturas.Heroe;
import Criaturas.Profesor;

public class Algoritmos extends Profesor{
	//Constructor
	public Algoritmos(String nombre) {
		super(nombre);
	}
	/**
	 * Disminuye la vida de un heroe aleatorio en 30% y la vida de ese Heroe pasa en forma de daño al profesor
	 */
	public void HabilidadEspecial(List<? extends Criatura> lista_heroes) {
		System.out.println("Hash Optimizado");
        Random random = new Random();
        int indiceAleatorio = random.nextInt(lista_heroes.size());
        Criatura hero = lista_heroes.get(indiceAleatorio);
        int nuevaVida = (int)(hero.getVida() * 0.70);
        hero.setVida(nuevaVida);
        this.setAtaque(this.getAtaque() + nuevaVida);
	}
}