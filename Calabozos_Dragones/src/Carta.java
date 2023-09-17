
public class Carta {
	private String nombre;
	private String descripcion;
	
	
	public void efecto(Criatura heroe) {
		int ataque = heroe.getAtaque();
		int vida = heroe.getVida();
		int energia = heroe.getEnergia();
		
		heroe.setAtaque(ataque*2);
		heroe.setEnergia(energia/2);
	}
}

class CartaVida {
	private String nombre;
	private String descripcion;
	
	public void efecto(Criatura heroe) {
		int vida = heroe.getVida();
		int energia = heroe.getEnergia();
		
		heroe.setVida(vida + energia);
		heroe.setEnergia(0);
	}
}

