import Criaturas.Criatura;

public class Carta {
	private String nombre;
	private String descripcion;
	
	public Carta(String nombre,String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	public void efecto(Criatura heroe) {
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}
}

class CartaLuchador extends Carta{
	public CartaLuchador() {
		super("Berserker","El 100% de tu energia se suma a la vida y daño de la Criatura, reduce energia a 0");
		// TODO Auto-generated constructor stub
	}
	
	public void efecto(Criatura heroe) {
		int vida = heroe.getVida();
		int dano = heroe.getAtaque();
		int energia = heroe.getEnergia();
		heroe.setVida(vida + energia);
		heroe.setAtaque(dano + energia);
		heroe.setEnergia(0);
	}
}

class CartaMago extends Carta{
	public CartaMago() {
		super("-Merlin-", "Aumenta la energia 100%, reduce tu ataque en 50%");
		// TODO Auto-generated constructor stub
	}
	public void efecto(Criatura heroe) {
		int dano = heroe.getAtaque();
		int energia = heroe.getEnergia();
		heroe.setEnergia(energia + energia);
		heroe.setAtaque(dano/2);
	}
}

class CartaTanke extends Carta{
	public CartaTanke() {
		super("Tanquesito", "Triplica tu vida, reduce tu ataque a 0");
		// TODO Auto-generated constructor stub
	}
	
	public void efecto(Criatura heroe) {
		int vida = heroe.getVida();
		
		heroe.setVida(vida + vida + vida);
		heroe.setAtaque(0);
	}
}

