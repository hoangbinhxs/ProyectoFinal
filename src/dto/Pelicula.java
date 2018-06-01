package dto;

import java.time.LocalDate;

public class Pelicula {
	private String titulo;
	private LocalDate fechaEstreno;
	private LocalDate fechaFE;
	private String sinopsis;
	private int duracion;
	public Pelicula() {
		super();
	}
	
	public Pelicula(String titulo) {
		super();
		this.titulo = titulo;
	}

	public Pelicula(String titulo, LocalDate fechaEstreno, LocalDate fechaFE, String sinopsis, int duracion) {
		super();
		this.titulo = titulo;
		this.fechaEstreno = fechaEstreno;
		this.fechaFE = fechaFE;
		this.sinopsis = sinopsis;
		this.duracion = duracion;
	}
	@Override
	public String toString() {
		String cadena= "--------------------------------\n";
		cadena+=textoFormateado("|Titulo: "+titulo+"|",30);
		cadena+=textoFormateado("|Fecha de estreno: "+fechaEstreno+"|",30);
		cadena+=textoFormateado("|Fin de emision: "+fechaFE+"|",30);
		cadena+=textoFormateado("|Sinopsis: "+ sinopsis+"|",30);
		cadena+=textoFormateado("|Duracion: "+duracion+"|", 30);
		cadena+="--------------------------------";
		return cadena;		
	}
	public String textoFormateado(String texto, int longitud) {
		String cadena= "|"+texto;
		for(int i=0;i<longitud-texto.length();i++) {
			cadena+=" ";
		}
		cadena+="|\n";
		return cadena;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public LocalDate getFechaEstreno() {
		return fechaEstreno;
	}
	public void setFechaEstreno(LocalDate fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}
	public LocalDate getFechaFE() {
		return fechaFE;
	}
	public void setFechaFE(LocalDate fechaFE) {
		this.fechaFE = fechaFE;
	}
	public String getSinopsis() {
		return sinopsis;
	}
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
		
}
