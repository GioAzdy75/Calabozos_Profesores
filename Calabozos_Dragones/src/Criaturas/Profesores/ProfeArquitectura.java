package Criaturas.Profesores;

import java.util.List;

import Criaturas.Criatura;
import Criaturas.Profesor;

public class ProfeArquitectura extends Profesor{
	public ProfeArquitectura(String nombre) {
		super(nombre,false);
	}
	
	public void HabilidadEspecial(List<Criatura> lista_criaturas) {
		System.out.println("4bits");
		for (Criatura criatura : lista_criaturas) {
			double dano_jefe = criatura.getVida() * 0.25;
			double reducir_energia = criatura.getEnergia() * 0.65;
			criatura.recibirDano((int) dano_jefe);
			criatura.setEnergia((int) reducir_energia);
		}
	}
}


