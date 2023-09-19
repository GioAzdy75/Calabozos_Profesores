package Criaturas;

/**
 * Clase Base para Implementar las demas Criaturas.
 */
public abstract class Criatura {
	private String nombre;
	private int vida;
	private int energia;
	private int ataque;
	/**
	 * Ruta de la imagen de la criatura
	 */

	/**
     * Constructor de la clase
     * @param nombre Recibe el nombre de la criatura
     * @param vida Recibe la vida de la criatura
     * @param energia Recibe el nombre de la criatura
     * @param ataque Recibe la vida de la criatura
     */
	 public Criatura(String nombre , int vida , int energia , int ataque) {
		 this.nombre = nombre;
		 this.vida = vida;
		 this.energia = energia;
		 this.ataque = ataque;
	 }
	 
	 /**
	  * Devuelve el nombre de la criatura
	  * @return String : nombre de la criatura
	  */
	 public String getNombre() {
		 return this.nombre;
	 }
	 
	 /**
	  * Devuelve el ataque de la criatura
	  * @return Int : ataque de la criatura
	  */
	 public int getAtaque() {
		 return this.ataque;
	 }
	 
	 /**
	  * Modifica el ataque de la criatura por uno nuevo
	  * @param attack Nuevo ataque de la criatura
	  */
	 public void setAtaque(int attack) {
		 this.ataque = attack;
	 }
	 
	 /**
	  * Devuelve la vida de la criatura
	  * @return Int : vida de la criatura
	  */
	 public int getVida() {
		 return this.vida;
	 }
	 
	 /**
	  * Modifica la vida de la criatura por uno nuevo
	  * @param vida Nueva vida de la criatura
	  */
	 public void setVida(int vida) {
		 this.vida = vida;
	 }
	 
	 /**
	  * Devuelve la energia
	  * @return Int : energia de la criatura
	  */
	 public int getEnergia() {
		 return this.energia;
	 }
	 
	 /**
	  * Modifica la energia por una nueva
	  * @param nuevaEnergia Nueva energia
	  */
	 public void setEnergia(int nuevaEnergia) {
		 this.energia = nuevaEnergia;
	 }
	 
	 public void recibirDano(int dano) {
		 this.vida -= dano;
		 if (this.vida <= 0){
			 this.vida = 0;
		 }
	 }
	 
	 public void morir() {
		 this.vida = 0;
	 }
	 
	 /**
	  * Devuelve en formato String todas las estadisticas de la Criatura
	  * @return String : estadisticas de la criatura
	  */
	 public String getEstadisticasCriatura() {
		 return this.nombre + " - " +this.vida + " - " + this.ataque +" - " + this.energia;
	 }
}
