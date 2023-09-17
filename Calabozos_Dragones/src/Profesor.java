import java.util.List;
import java.util.Random;


//Clase base para Profesores
class Profesor extends Criatura {
	//Constructor
	public Profesor(String nombre) {
		super(nombre, 300, 500, 100);
	}
	
	//Habilidad Especial
	public void HabilidadEspecial(List<Heroe>lista_heroes) {
		
	}
}

//Nivel 1
class Analisis extends Profesor {
	//Constructor
	public Analisis(String nombre) {
		super(nombre);
		imageSrc = "Boss.png";
	}
	
	//Habilidad especial
	public void HabilidadEspecial(List<Heroe>lista_heroes) {
		System.out.println("Sucesiones Infinitas");
		for (Heroe heroe : lista_heroes) {
			double dano_jefe = heroe.getVida() * 0.10;
			double reducir_ataque = heroe.getAtaque() * 0.90;
			double reducir_energia = heroe.getEnergia() * 0.90;
			heroe.recibirDano((int) dano_jefe);
			heroe.setAtaque((int) reducir_ataque);
			heroe.setEnergia((int) reducir_energia);
		}
	}
}

class Algebra extends Profesor {
	//Constructor
	public Algebra(String nombre) {
		super(nombre);
	}
	
	//Habilidad especial
	//Reduce 15% energia y 5 % de vida
	public void HabilidadEspecial(List<Heroe>lista_heroes) {
		System.out.println("Matrices Multidimencional");
		for (Heroe heroe : lista_heroes) {
			double dano_jefe = heroe.getVida() * 0.05;
			double reducir_energia = heroe.getEnergia() * 0.85;
			heroe.recibirDano((int) dano_jefe);
			heroe.setEnergia((int) reducir_energia);
		}
	}
}

class Geometria extends Profesor {
	//Constructor
	public Geometria(String nombre) {
		super(nombre);
	}
	
	//Habilidad especial
	public void HabilidadEspecial(List<Heroe>lista_heroes) {
		System.out.println("Superficies Cuadraticas");
		for (Heroe heroe : lista_heroes) {
			double dano_jefe = heroe.getVida() * 0.10;
			double reducir_ataque = heroe.getAtaque() * 0.90;
			heroe.recibirDano((int) dano_jefe);
			heroe.setAtaque((int) reducir_ataque);
		}
	}
}

//Nivel 2

class Algoritmos extends Profesor {
	//Constructor
	public Algoritmos(String nombre) {
		super(nombre);
	}
	//Habilidad especial
	public void HabilidadEspecial(List<Heroe>lista_heroes) {
        Random random = new Random();
        int indiceAleatorio = random.nextInt(lista_heroes.size());
        Heroe hero = lista_heroes.get(indiceAleatorio);
        int nuevaVida = (int)(hero.getVida() * 0.70);
        hero.setVida(nuevaVida);
	}
}

class Paradigmas extends Profesor {
	//Constructor
	public Paradigmas(String nombre) {
		super(nombre);
	}
	//Habilidad especial
	public void HabilidadEspecial(List<Heroe>lista_heroes) {
        Random random = new Random();
        int indiceAleatorio = random.nextInt(lista_heroes.size());
        Heroe hero = lista_heroes.get(indiceAleatorio);
        int nuevoDano = (int)(hero.getAtaque() * 0.60);
        hero.setAtaque(nuevoDano);
	}
}



//Nivel 3
class InteligenciaArtificial extends Profesor {
	//Constructor
	public InteligenciaArtificial(String nombre) {
		super(nombre);
	}
	//Habilidad especial
	public void HabilidadEspecial(List<Heroe>lista_heroes) {
		
	}
}

//Nivel 4
class Compiladores extends Profesor {
	//Constructor
	public Compiladores(String nombre) {
		super(nombre);
	}
	//Habilidad especial
	public void HabilidadEspecial(List<Heroe>lista_heroes) {
		
	}
}

//Nivel 5
class Tesis extends Profesor {
	//Constructor
	public Tesis(String nombre) {
		super(nombre);
	}
	//Habilidad especial
	public void HabilidadEspecial(List<Heroe>lista_heroes) {
		
	}
}

class Laburo extends Profesor {
	//Constructor
	public Laburo(String nombre) {
		super(nombre);
	}
	//Habilidad especial
	public void HabilidadEspecial(List<Heroe>lista_heroes) {
		
	}
}