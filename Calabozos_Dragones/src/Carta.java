import Criaturas.Criatura;

public class Carta {
	private String nombre;
	private String descripcion;
	
	public void efecto(Criatura heroe) {
	}
}

class CartaLuchador extends Carta{
	private String nombre = "Berserker";
	private String descripcion = "El 100% de tu energia se suma a la vida y daño de la Criatura, reduciendo esta misma a 0";
	
	
	public void CaraLuchador(){
	}
	
	public void efecto(Criatura heroe) {
		int vida = heroe.getVida();
		int dano = heroe.getAtaque();
		int energia = heroe.getEnergia();
		heroe.setVida(vida + energia);
		heroe.setAtaque(dano + energia);
		heroe.setEnergia(0);
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}
}

class CartaMago extends Carta{
	private String nombre = "Merlin el divino";
	private String descripcion = "Aumenta la energia 100%, reduce tu ataque en 50%";
	
	public void efecto(Criatura heroe) {
		int dano = heroe.getAtaque();
		int energia = heroe.getEnergia();
		heroe.setEnergia(energia + energia);
		heroe.setAtaque(dano/2);
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}
}

class CartaTanke extends Carta{
	private String nombre = "Tanquesito";
	private String descripcion = "Triplica tu vida, reduce tu ataque a 0";
	
	public void efecto(Criatura heroe) {
		int vida = heroe.getVida();
		
		heroe.setVida(vida + vida + vida);
		heroe.setAtaque(0);
	}
}

