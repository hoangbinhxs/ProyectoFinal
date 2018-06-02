package Vista.utilidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Escaner {
	BufferedReader reader;
	
	public Escaner() {
		InputStreamReader input=new InputStreamReader(System.in);
		reader=new BufferedReader(input);
	}
	public String leerLinea() {
		String leerLinea="";
		try {
		leerLinea+=reader.readLine();
		
		}catch (IOException e) {
			e.printStackTrace();
		}
	 return leerLinea;
	}
	public LocalDateTime fechaHora() {
		System.out.println("Introduce la fecha");
		LocalDate fecha=fecha();
		System.out.println("Introduce la Hora");
		LocalTime hora=hora();
		LocalDateTime fechaHora=LocalDateTime.of(fecha,hora);
		return fechaHora;
	}
	public LocalDate fecha() {
		LocalDate fecha;
		while(true) {
			try {
				String date=reader.readLine();
				fecha=LocalDate.parse(date);
				return fecha;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public LocalTime hora() {
		LocalTime hora;
		while(true) {
			try {
				String time=reader.readLine();
				hora=LocalTime.parse(time);
				return hora;
			} catch (IOException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
	public int leerOpcion(String textoAMostrar, int limiteInferior, int limiteSuperior) {
		int numero=leerEntero();
		while(true) {
		if(numero<limiteInferior-1||numero>limiteSuperior+1) {
			System.out.println(textoAMostrar);
			numero=leerEntero();
		}else {
		return numero;
		}
		}
	}
	public int leerEntero() {
		int numero=0;
		
		while(true) {
		try {
		String num=reader.readLine();
		numero= Integer.parseInt(num);
		return numero;
		}catch (IOException e) {
			e.printStackTrace();
		}catch( NumberFormatException e) {
		System.out.println("Introduce un numero");	
		}
		}
		}
		
	public double leerDouble() {
		double numero=0;
		while(true) {
		try {
		String num=reader.readLine();
		numero= Double.parseDouble(num);
		return numero;
		}catch (IOException e) {
			e.printStackTrace();
		}catch( NumberFormatException e) {
			System.err.println("Introduce un numero");
		}
		}
		}
	
	public void cerrar() {
		try {
			reader.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
