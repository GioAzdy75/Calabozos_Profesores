
import java.util.List;
import java.util.Scanner;

//Clase base para los héroes
public class Heroe extends Criatura {
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
		imageSrc = "magofuego.png";
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
		imageSrc = "Boss.png";
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
		imageSrc = "arquero.png";
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