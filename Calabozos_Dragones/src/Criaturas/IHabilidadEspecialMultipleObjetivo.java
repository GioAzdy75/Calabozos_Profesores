package Criaturas;

import java.util.List;

public interface IHabilidadEspecialMultipleObjetivo<T extends Criatura> {
	void HabilidadEspecial(List<? extends T> lista_criaturas);
}
