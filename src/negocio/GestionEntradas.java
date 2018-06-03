package negocio;

import java.util.List;

import dao.EntradaDAO;
import dto.Entrada;

public class GestionEntradas {
	EntradaDAO entradaDao;
	public GestionEntradas() {
		entradaDao=new EntradaDAO();
	}
	public void guardarEntrada(List<Entrada> entradas) {
		entradaDao.guardarEntrada(entradas);
	}

	public boolean comprobarEntrada(Entrada entrada) {
		return entradaDao.comprobarEntrada(entrada);
	}
	public void cerrar() {
		entradaDao.cerrar();
	}
}
