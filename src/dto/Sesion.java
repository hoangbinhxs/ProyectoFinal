package dto;

import java.time.LocalDateTime;
import java.util.List;

public class Sesion {
	private int id;
	private LocalDateTime fechaHora;
	private Pelicula pelicula;
	private Sala sala;
	private List<Entrada> entradas;
	
	public Sesion() {
		super();
	}
	

	public Sesion(int id) {
		super();
		this.id = id;
	}


	public Sesion(LocalDateTime fechaHora, Pelicula pelicula, Sala sala) {
		super();
		this.fechaHora = fechaHora;
		this.pelicula = pelicula;
		this.sala = sala;
	}


	public Sesion(int id, LocalDateTime fechaHora, Pelicula pelicula, Sala sala, List<Entrada> entradas) {
		super();
		this.id = id;
		this.fechaHora = fechaHora;
		this.pelicula = pelicula;
		this.sala = sala;
		this.entradas = entradas;
	}


	@Override
	public String toString() {
		return "Sesion [id=" + id + ", fechaHora=" + fechaHora + ", pelicula=" + pelicula + ", sala=" + sala
				+ ", entradas=" + entradas + "]";
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public List<Entrada> getEntradas() {
		return entradas;
	}

	public void setEntradas(List<Entrada> entradas) {
		this.entradas = entradas;
	}
	

}
