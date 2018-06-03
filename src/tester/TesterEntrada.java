package tester;

import java.util.ArrayList;
import java.util.List;

import dao.EntradaDAO;
import dao.SesionDAO;
import dto.Entrada;
import dto.Sesion;

public class TesterEntrada {

	public static void main(String[] args) {
		EntradaDAO entradaDao=new EntradaDAO();
		SesionDAO sesionDao=new SesionDAO();
		Sesion sesion =new Sesion(4);
		/*List<Entrada> entradas = new ArrayList<>(); 
		Entrada entrada=new Entrada(1,6);
		entradas.add(entrada);
		Entrada entrada1=new Entrada(sesion.getId(),2,6);
		entradas.add(entrada1);
		for (int i = 0; i < 5; i++) {
			Entrada entradaM=new Entrada(sesion.getId(),9,i+1);
			entradas.add(entrada);
		}
		for (Entrada entrada2 : entradas) {
			System.out.println(entrada2);
		}
		entradaDao.guardarEntrada(entradas);	
		System.out.println("La entrada esta:");
		System.out.println(entradaDao.comprobarEntrada(entrada1));
		*/ 
		List<Entrada> entradasSesion=sesionDao.recuperarEntradas(sesion.getId());
		for (Entrada entrada : entradasSesion) {
			System.out.println(entrada);
		}
		System.out.println("Entrada pedido");
		List<Entrada> entradas=new ArrayList<>();
		int a=0;
		for (int i = 0; i < 5; i++) {
			Entrada entrada=new Entrada(4, 2, i+1);
			entradas.add(entrada);
			for (Entrada entradaSe : entradasSesion) {
				if(entrada.getNumeroAsiento()==entradaSe.getNumeroAsiento()&&entrada.getNumeroFila()==entradaSe.getNumeroFila())
					a++;
			}
			
		}
		entradaDao.guardarEntrada(entradas);
		System.out.println(a);
		/*for (Entrada entrada : entradas) {
			System.out.println(entrada);
		}*/
		//System.out.println( entradasSesion.containsAll(entradas)) ;
			
		
	}
	

}
