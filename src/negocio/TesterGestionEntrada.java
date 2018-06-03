package negocio;

import java.util.ArrayList;
import java.util.List;

import dto.Entrada;

public class TesterGestionEntrada {

	public static void main(String[] args) {
		GestionEntradas gestionEntrada=new GestionEntradas();
		List<Entrada> entradas=new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			Entrada entrada=new Entrada(1, 5, i+1);
			entradas.add(entrada);
		}
		gestionEntrada.guardarEntrada(entradas);
	}

}
