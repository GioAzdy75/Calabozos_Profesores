import java.util.List;

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
class Ochoa extends Profesor {
	//Constructor
	public Ochoa(String nombre) {
		super(nombre);
	}
	
	//Habilidad especial
	public void HabilidadEspecial(List<Heroe>lista_heroes) {
		for (Heroe heroe : lista_heroes) {
			double dano_jefe = heroe.getVida() * 0.15;
			double reducir_ataque = heroe.getAtaque() * 0.85;
			heroe.recibirDano((int) dano_jefe);
			heroe.setAtaque((int) reducir_ataque);
		}
	}
}

class Algebra extends Profesor {
	//Constructor
	public Algebra(String nombre) {
		super(nombre);
	}
	
	//Habilidad especial
	public void HabilidadEspecial(List<Heroe>lista_heroes) {
		System.out.println("Matrices Multidimencional");
		for (Heroe heroe : lista_heroes) {
			double dano_jefe = heroe.getVida() * 0.15;
			double reducir_ataque = heroe.getAtaque() * 0.85;
			heroe.recibirDano((int) dano_jefe);
			heroe.setAtaque((int) reducir_ataque);
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
			double dano_jefe = heroe.getVida() * 0.15;
			double reducir_ataque = heroe.getAtaque() * 0.85;
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
		for (Heroe heroe : lista_heroes) {
			double dano_jefe = heroe.getVida() * 0.15;
			double reducir_ataque = heroe.getAtaque() * 0.85;
			heroe.recibirDano((int) dano_jefe);
			heroe.setAtaque((int) reducir_ataque);
		}
	}
}

class Harpo extends Profesor {
	//Constructor
	public Harpo(String nombre) {
		super(nombre);
	}
	//Habilidad especial
	public void HabilidadEspecial(List<Heroe>lista_heroes) {
		for (Heroe heroe : lista_heroes) {
			double dano_jefe = heroe.getVida() * 0.15;
			double reducir_ataque = heroe.getAtaque() * 0.85;
			heroe.recibirDano((int) dano_jefe);
			heroe.setAtaque((int) reducir_ataque);
		}
	}
}

//Nivel 3
class Inteligencia extends Profesor {
	//Constructor
	public Inteligencia(String nombre) {
		super(nombre);
	}
	//Habilidad especial
	public void HabilidadEspecial(List<Heroe>lista_heroes) {
		for (Heroe heroe : lista_heroes) {
			double dano_jefe = heroe.getVida() * 0.15;
			double reducir_ataque = heroe.getAtaque() * 0.85;
			heroe.recibirDano((int) dano_jefe);
			heroe.setAtaque((int) reducir_ataque);
		}
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
		for (Heroe heroe : lista_heroes) {
			double dano_jefe = heroe.getVida() * 0.15;
			double reducir_ataque = heroe.getAtaque() * 0.85;
			heroe.recibirDano((int) dano_jefe);
			heroe.setAtaque((int) reducir_ataque);
		}
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
		for (Heroe heroe : lista_heroes) {
			double dano_jefe = heroe.getVida() * 0.15;
			double reducir_ataque = heroe.getAtaque() * 0.85;
			heroe.recibirDano((int) dano_jefe);
			heroe.setAtaque((int) reducir_ataque);
		}
	}
}

class Laburo extends Profesor {
	//Constructor
	public Laburo(String nombre) {
		super(nombre);
	}
	//Habilidad especial
	public void HabilidadEspecial(List<Heroe>lista_heroes) {
		for (Heroe heroe : lista_heroes) {
			double dano_jefe = heroe.getVida() * 0.15;
			double reducir_ataque = heroe.getAtaque() * 0.85;
			heroe.recibirDano((int) dano_jefe);
			heroe.setAtaque((int) reducir_ataque);
		}
	}
}