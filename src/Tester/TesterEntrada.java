package Tester;

import dao.EntradaDAO;
import dto.Entrada;
import dto.Sesion;

public class TesterEntrada {

	public static void main(String[] args) {
		EntradaDAO entradaDao=new EntradaDAO();
		Entrada entrada=new Entrada(10,5,1);
		Sesion sesion=new Sesion(1);
		entradaDao.guardarEntrada(entrada,sesion);

	}

}
