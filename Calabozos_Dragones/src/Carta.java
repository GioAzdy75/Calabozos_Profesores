import Criaturas.Criatura;

public class Carta {
	private String nombre;
	private String descripcion;
	private int modificadorVida;
	private int modificadorEnergia;
	private int modificadorAtaque;
	private int consumoEnergia;
	//private int rareza;
	
	public Carta(String nombre,String descripcion,int modificadorVida, int modificadorAtaque, int modificadorEnergia, int consumoEnergia) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.modificadorVida = modificadorVida;
		this.modificadorEnergia = modificadorEnergia;
		this.modificadorAtaque = modificadorAtaque;
		this.consumoEnergia = consumoEnergia;
		
	}
	
	public void efecto(Criatura criatura) {
		criatura.setAtaque(criatura.getAtaque() + modificadorAtaque);
		criatura.setEnergia(criatura.getEnergia() + modificadorEnergia - consumoEnergia);
		criatura.setVida(criatura.getVida() + modificadorVida);
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

}



