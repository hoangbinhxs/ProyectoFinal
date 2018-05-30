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
		return "Pelicula [titulo=" + titulo + ", fechaEstreno=" + fechaEstreno + ", fechaFE=" + fechaFE + ", sinopsis="
				+ sinopsis + ", duracion=" + duracion + "]";
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
