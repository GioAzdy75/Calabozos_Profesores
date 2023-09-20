package Criaturas;

/**
 * Clase Base para los Profesores
 */
public abstract class Profesor extends Criatura implements IHabilidadEspecialMultipleObjetivo<Criatura> {
	
	private boolean colaborativo;
	/**
	 * Constructor de la clase
	 * @param nombre nombre de la criatura
	 */
	public Profesor(String nombre,boolean colaborativo) {
		super(nombre, 350, 500, 100);
		this.colaborativo = colaborativo;
	}
	/**
	 * @return the colaborativo
	 */
	public boolean getColaborativo() {
		return colaborativo;
	}
	
}
