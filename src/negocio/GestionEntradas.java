package negocio;

import java.util.List;

import dao.EntradaDAO;
import dto.Entrada;
import dto.Sesion;

public class GestionEntradas {
	EntradaDAO entradaDao;

	public void guardarEntrada(List<Entrada> entradas, Sesion sesion) {
		entradaDao.guardarEntrada(entradas, sesion);
	}

	public boolean comprobarEntrada(Entrada entrada, Sesion sesion) {
		return entradaDao.comprobarEntrada(entrada, sesion);
	}
}
