package Criaturas;
import java.util.List;


/**
 * Clase Base para implementar los demas Heroes
 */
public abstract class Heroe extends Criatura implements IHabilidadEspecialMultipleObjetivo<Criatura>,IHabilidadEspecialIndividualObjetivo {
	protected int consumoHabilidadEspecial;
	/**
	 * Constructor de la clase
	 * @param nombre nombre de la criatura
	 */
	public Heroe(String nombre) {
		super(nombre,200,100,100); // nombre = nombre, vida = 200 , energia = 100 , ataque = 100
	 }
	
	/**
	 * Devuelve el ataque Mele de la Criatura
	 * @return int : ataque mele
	 */
	public int getAtaqueMele() {
		return this.getAtaque();
	}
	/**
	 * Devuelve el ataque Rango de la criatura
	 * @return int: Ataque rango
	 */
	public int getAtaqueRango() {
		return this.getAtaque() / 2;
	}

	/**
	 * @return the consumoHabilidadEspecial
	 */
	public int getConsumoHabilidadEspecial() {
		return consumoHabilidadEspecial;
	}
	
	/*
	//Habilidad Especial
	@Override
    public void HabilidadEspecial(List<? extends Criatura> lista_criaturas) {
    }
	@Override
    public void HabilidadEspecial(Profesor Profesor) {
    }
	*/
}