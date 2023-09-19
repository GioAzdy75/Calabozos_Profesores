package Criaturas.Profesores;

import java.util.List;

import Criaturas.Criatura;
import Criaturas.Heroe;
import Criaturas.Profesor;

public class Compiladores extends Profesor {
	//Constructor
	public Compiladores(String nombre) {
		super(nombre);
	}
	//Habilidad especial
	public void HabilidadEspecial(List<? extends Criatura> lista_heroes) {
		
	}
}