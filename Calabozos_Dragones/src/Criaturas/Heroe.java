package Criaturas;
import java.util.List;


//Clase base para los héroes
public class Heroe extends Criatura implements IHabilidadEspecial<Criatura> {
	// Constructor
	public Heroe(String nombre) {
		super(nombre,200,100,100); // nombre = nombre, vida = 200 , energia = 100 , ataque = 100
	 }
	// getters y setters
	
	//Ataque Mele
	public int getAtaqueMele() {
		return this.getAtaque();
	}
	//Ataque Rango
	public int getAtaqueRango() {
		return this.getAtaque() / 2;
	}
	
	
	//Habilidad Especial
	@Override
    public void HabilidadEspecial(List<? extends Criatura> lista_criaturas) {
    }
    
    @Override
    public void HabilidadEspecial(Criatura criatura) {
    }

}