package Tester;

import dao.EntradaDAO;
import dto.Entrada;

public class TesterEntrada {

	public static void main(String[] args) {
		EntradaDAO entradaDao=new EntradaDAO();
		Entrada entrada=new Entrada(10,5,1);
		entradaDao.guardarEntrada(entrada);

	}

}
