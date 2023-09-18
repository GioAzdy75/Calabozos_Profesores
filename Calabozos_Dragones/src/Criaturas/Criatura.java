package Criaturas;
//Clase base para los personajes
public abstract class Criatura {
	private String nombre;
	private int vida;
	private int energia;
	private int ataque;
	public String imageSrc;

 // Constructor, getters y setters
	 public Criatura(String nombre , int vida , int energia , int ataque) {
		 this.nombre = nombre;
		 this.vida = vida;
		 this.energia = energia;
		 this.ataque = ataque;
	 }
	 
	 public String getNombre() {
		 return this.nombre;
	 }
	 
	 public int getAtaque() {
		 return this.ataque;
	 }
	 
	 public void setAtaque(int attack) {
		 this.ataque = attack;
	 }
	 
	 public int getVida() {
		 return this.vida;
	 }
	 
	 public void setVida(int vida) {
		 this.vida = vida;
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
	 
	 public String getEstadisticasCriatura() {
		 return this.nombre + " - " +this.vida + " - " + this.ataque +" - " + this.energia;
	 }
	 
	 public int getEnergia() {
		 return this.energia;
	 }
	 
	 public void setEnergia(int nuevaEnergia) {
		 this.energia = nuevaEnergia;
	 }
}
