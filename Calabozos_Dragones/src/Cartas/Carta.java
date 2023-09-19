package Cartas;

import Criaturas.Criatura;

public class Carta {
	private String nombre;
	private String descripcion;
	private int modificadorVida;
	private int modificadorEnergia;
	private int modificadorAtaque;
	private int consumoEnergia;

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
		criatura.setEnergia(criatura.getEnergia() + modificadorEnergia);
		criatura.setVida(criatura.getVida() + modificadorVida);
	}
	
	/**
	 * Retorna el nombre de la carta
	 * @return String : nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Retorna la discripcion de la carta 
	 * @return String : discripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	
	/**
	 * Retorna el consumo de energia de la carta en un int
	 * @return
	 */
	public int getConsumoEnergia() {
		return consumoEnergia;
	}
}
