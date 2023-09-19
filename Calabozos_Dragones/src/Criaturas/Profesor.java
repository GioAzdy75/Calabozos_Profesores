package Criaturas;

import java.util.List;

/**
 * Clase Base para los Profesores
 */
public abstract class Profesor extends Criatura implements IHabilidadEspecialMultipleObjetivo<Criatura> {
	/**
	 * Constructor de la clase
	 * @param nombre nombre de la criatura
	 */
	public Profesor(String nombre) {
		super(nombre, 300, 500, 100);
	}
	
}
