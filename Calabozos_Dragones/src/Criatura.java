
import java.util.ArrayList;
import java.util.List;

//Clase base para los personajes
class Criatura {
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
	 
	 public int getVida() {
		 return this.vida;
	 }
	 
	 public void setVida(int vida) {
		 this.vida = vida;
	 }
	 
	 public void morir() {
		 this.vida = 0;
	 }
}

//Clase base para los héroes
class Heroe extends Criatura {
	// Constructor
	public Heroe(String nombre) {
		super(nombre,200,100,100); // nombre = nombre, vida = 200 , energia = 100 , ataque = 100
	 }
	// getters y setters
}


class Tanque extends Criatura {
	//Constructor
	public Tanque(String nombre) {
		super(nombre,400,0,30); // nombre = nombre, vida = 400 , energia = 0 , ataque = 30
	}
}

class Luchador extends Criatura {
	//Constructor
	public Luchador(String nombre) {
		super(nombre,100,0,60); // nombre = nombre, vida = 100 , energia = 0 , ataque = 60
	}
}

class Profesor extends Criatura {
	//Constructor
	public Profesor(String nombre) {
		super(nombre, 2000, 500, 100);
	}
	
	
	//Ataque Del Ochoa
	public void habilidadEspecial(GrupoCriatura criaturas) {
		System.out.println("----Sucesiones Convergentes----");
		criaturas.recibir_dano(1000);
	}
}


/*
//Clase base para los enemigos
class Esbirros extends Criatura {
	// Constructor
	public Esbirros(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}
	//getters y setters
}
*/

class GrupoCriatura {
	private List<Criatura> lista_criatura = new ArrayList<>();
	
	public GrupoCriatura(List<Criatura>lista_criatura) {
		this.lista_criatura = lista_criatura;
	}
	
	public void mostrar_criatura() {
		for (Criatura criatura : lista_criatura) {
			System.out.println(criatura.getNombre() + " - ataque:" + criatura.getAtaque() + "  vida: " + criatura.getVida()) ;
		}
	}
	
	public int atacar_en_grupo() {
		//retorna el daño total de todos los personajes en grupo
		int ataque_total = 0;
		for (Criatura criatura : lista_criatura) {
			ataque_total = ataque_total + criatura.getAtaque();
		}
		return ataque_total;
	}
	
	public void recibir_dano(int ataque) {
		int dano = ataque;
		for (Criatura criatura : lista_criatura) {
			dano = dano - criatura.getVida();
			if (dano < 0) {
				int nueva_vida = dano * (-1);
				criatura.setVida(nueva_vida);
				break;
			}
			else {
				criatura.morir();
			}
		}
	}
	
	public void quitar_muertos() {
		for (int i = lista_criatura.size() - 1; i >= 0; i--) {
            Criatura criatura = lista_criatura.get(i);
            if (criatura.getVida() == 0) {
            	lista_criatura.remove(i); // Eliminar el objeto de la lista
            }
        }
	}
	
	public boolean esta_vacio() {
		if (lista_criatura.size() == 0) {
			return true;
		}
		return false;
	}
	
}


//Hacer que herede de GrupoCriaturas
class GrupoHeroes extends GrupoCriatura {
	
	public GrupoHeroes(List<Criatura>lista_heroes) {
		super(lista_heroes);
	}
	
}

//class GrupoEsbirros extends GrupoCriatura {
	//private List<Esbirros> lista_esbirros;
	
	//public GrupoEsbirros(List<Esbirros>lista_esbirros) {
		//this.lista_esbirros = lista_esbirros;
	//}
	
//}
