package Criaturas;

import java.util.List;

public interface IHabilidadEspecial<T extends Criatura> {
	void HabilidadEspecial(List<? extends T> lista_criaturas);
    void HabilidadEspecial(Criatura criatura);
}
