
import java.util.ArrayList;
import java.util.List;

//Clase base para los personajes
class Criatura {
	private String nombre;
	private int vida = 100;
	private int energia;
	private int ataque = 10;

 // Constructor, getters y setters
	 public Criatura(String nombre) {
		 this.nombre = nombre;
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
 // Constructor, getters y setters
	public Heroe(String nombre) {
		 super(nombre);
	 }
}

//Clase base para los enemigos
class Esbirros extends Criatura {
 public Esbirros(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}
 // Constructor, getters y setters
}


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
class GrupoHeroes {
	private List<Heroe> lista_heroes;
	
	public GrupoHeroes(List<Heroe>lista_heroes) {
		this.lista_heroes = lista_heroes;
	}
	
	public void mostrar_heroes() {
		for (Heroe heroe : lista_heroes) {
			System.out.println(heroe.getNombre() + " - " + heroe.getAtaque());
		}
	}
	
	public int atacar_en_grupo() {
		//retorna el daño total de todos los personajes en grupo
		int ataque_total = 0;
		for (Heroe heroe : lista_heroes) {
			ataque_total = ataque_total + heroe.getAtaque();
		}
		return ataque_total;
	}
}

//class GrupoEsbirros extends GrupoCriatura {
	//private List<Esbirros> lista_esbirros;
	
	//public GrupoEsbirros(List<Esbirros>lista_esbirros) {
		//this.lista_esbirros = lista_esbirros;
	//}
	
//}
