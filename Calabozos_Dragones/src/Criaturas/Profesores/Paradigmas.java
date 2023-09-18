package Criaturas.Profesores;

import java.util.List;
import java.util.Random;

import Criaturas.Heroe;
import Criaturas.Profesor;

public class Paradigmas extends Profesor {
	//Constructor
	public Paradigmas(String nombre) {
		super(nombre);
	}
	//Habilidad especial
	public void HabilidadEspecial(List<Heroe>lista_heroes) {
        Random random = new Random();
        int indiceAleatorio = random.nextInt(lista_heroes.size());
        Heroe hero = lista_heroes.get(indiceAleatorio);
        int nuevoDano = (int)(hero.getAtaque() * 0.60);
        hero.setAtaque(nuevoDano);
	}
}