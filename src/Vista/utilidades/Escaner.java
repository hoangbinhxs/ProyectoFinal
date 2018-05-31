package Vista.utilidades;
import java.io.*;

public class Escaner {
	
	BufferedReader reader;
	
	public Escaner() {
		InputStreamReader streamer=new InputStreamReader(System.in);
		reader= new BufferedReader(streamer);
	}
	
	public String leerLinea() {
		String linea=null;
		try {
			linea=reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  linea;
	}
	
	public int leerOpcion(String textoAMostrar, int limiteInferior, int limiteSuperior) {
		int numero=limiteInferior-1;
		while(numero<limiteInferior||numero>limiteSuperior) {
		numero=LeerEntero();
		if(numero<limiteInferior||numero>limiteSuperior) {
			System.err.println(textoAMostrar);
		}
		}
		return numero;
	}
	
	public int LeerEntero() {
		String palabra;
		int numero=0;
		while(true) {
		try {
			palabra=reader.readLine();
			numero=Integer.parseInt(palabra);
			return numero;
		} catch (IOException e) {
			System.err.println("Introduzca un valor numerico entero");
		}
		}
		
	}
	
	public double LeerDoble() {
		String palabra;
		double numero=0;
		while(true) {
		try {
			palabra=reader.readLine();
			numero=Double.parseDouble(palabra);
			return numero;
		} catch (IOException e) {
			System.err.println("Introduzca un valor numerico");
		}
		}
	}
	
	public void cerrar() {
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}