package Criaturas;

import java.util.List;

//Clase base para Profesores
public class Profesor extends Criatura {
	//Constructor
	public Profesor(String nombre) {
		super(nombre, 300, 500, 100);
	}
	
	//Habilidad Especial
	public void HabilidadEspecial(List<Heroe>lista_heroes) {
		
	}
}
