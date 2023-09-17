
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Clase base para los personajes
abstract class Criatura {
	private String nombre;
	private int vida;
	private int energia;
	private int ataque;
	protected String imageSrc;

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

//Clase base para los esbirros
class Esbirro extends Criatura {
	// Constructor
	public Esbirro(String nombre) {
		super(nombre,200,0,50);
		imageSrc = "mago.png";
	}
	//getters y setters
}
