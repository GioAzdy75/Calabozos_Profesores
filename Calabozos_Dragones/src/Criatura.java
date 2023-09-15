
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Clase base para los personajes
abstract class Criatura {
	private String nombre;
	private int vida;
	private int energia;
	private int ataque;

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
}

//Clase base para los héroes
class Heroe extends Criatura {
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
	public void HabilidadEspecial(List<Esbirro>lista_esbirros) {
		
	}
	
	public void HabilidadEspecial(Profesor profesor) {
		
	}
}

class Mago extends Heroe {
	public Mago(String nombre) {
		super(nombre); // nombre = nombre
	}
	
	//Ataque Mele
	public int getAtaqueMele() {
		return this.getAtaque()/4;
	}
	//Ataque Rango
	public int getAtaqueRango() {
		return (int) (this.getAtaque());
	}
	
	//Habilidad Especial Congelar
	//Reduce el daño de todos los esbirros en un 30%
	//Solo funciona con esbirros
	public void HabilidadEspecial(List<Esbirro>lista_esbirros) {
		System.out.println("Ventisca Feroz");
		for (Esbirro esbirro : lista_esbirros) {
			double danoEsbirro = esbirro.getAtaque() * 0.8;
			System.out.println(danoEsbirro);
			int nuevo_dano = (int) (danoEsbirro);
			esbirro.setAtaque(nuevo_dano);
		}
	}
	
	public void HabilidadEspecial(Profesor profesor) {
		profesor.recibirDano((int)(getVida()* 0.15));
	}
}

class Luchador extends Heroe {
	//Constructor
	public Luchador(String nombre) {
		super(nombre); // nombre = nombre
	}

	//Ataque Mele
	public int getAtaqueMele() {
		return this.getAtaque();
	}
	//Ataque Rango
	public int getAtaqueRango() {
		return (int) (this.getAtaque()/2);
	}	
	
	//Habilidad Especial Golpe con el doble de daño
	public void HabilidadEspecial(List<Esbirro>lista_esbirros) {
		System.out.println("Golpe Furioso");
		System.out.println("##Escoja al Esbirro al que desee atacar##");
		Scanner scanner = new Scanner(System.in); //Scanner del teclado
		int input_teclado = scanner.nextInt();
		Esbirro esbirro = lista_esbirros.get(input_teclado - 1);
		esbirro.recibirDano(getAtaque() * 2);
		if (esbirro.getVida() == 0) {
        	lista_esbirros.remove(esbirro);
        }
	}
	
	public void HabilidadEspecial(Profesor profesor) {
		System.out.println("Golpe Furioso");
		profesor.recibirDano(getAtaque() * 2);
	}
}

class Arquero extends Heroe {
	//Constructor
	public Arquero(String nombre) {
		super(nombre); // nombre = nombre
	}
	
	//Ataque Mele
	public int getAtaqueMele() {
		return this.getAtaque()/2;
	}
	//Ataque Rango
	public int getAtaqueRango() {
		return (int) (this.getAtaque()*1.20);
	}
	
	//Habilidad Especial Golpe con el doble de daño
	public void HabilidadEspecial(List<Esbirro>lista_esbirros) {
	}
	
	public void HabilidadEspecial(Profesor profesor) {
	}
}

class Kamikaze extends Heroe {
	public Kamikaze(String nombre) {
		super(nombre);
	}
	
	//Habilidad Especial , Se suicida y mata a un esbirro sin importar la vida 
	//o le quita 20% hp al boss
	public void HabilidadEspecial(List<Esbirro>lista_esbirros) {
		System.out.println("Kamikaze mode ON");
		System.out.println("##Escoja al Esbirro al que desee atacar##");
		Scanner scanner = new Scanner(System.in); //Scanner del teclado
		int input_teclado = scanner.nextInt();
		Esbirro esbirro = lista_esbirros.get(input_teclado - 1);
		esbirro.morir();
	}
	public void HabilidadEspecial(Profesor profesor) {
		//20% hp
		double dano = profesor.getVida() * 0.80;
		int dano_final = (int) (dano);
		profesor.recibirDano(dano_final);
	}
}

//Clase base para los esbirros
class Esbirro extends Criatura {
	// Constructor
	public Esbirro(String nombre) {
		super(nombre,200,0,50);
	}
	//getters y setters
}
