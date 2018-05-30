package dto;

import java.time.LocalDateTime;
import java.util.List;

public class Sesion {
	private int id;
	private LocalDateTime fechaHora;
	private String titulo;
	private int idSala;
	private List<Entrada> entradas;
	
	public Sesion() {
		super();
	}
	public Sesion(int id) {
		super();
		this.id = id;
	}
	public Sesion(LocalDateTime fechaHora, String titulo, int idSala, List<Entrada> entradas) {
		super();
		this.fechaHora = fechaHora;
		this.titulo = titulo;
		this.idSala = idSala;
		this.entradas = entradas;
	}
	public Sesion(int id, LocalDateTime fechaHora, String titulo, int idSala, List<Entrada> entradas) {
		super();
		this.id = id;
		this.fechaHora = fechaHora;
		this.titulo = titulo;
		this.idSala = idSala;
		this.entradas = entradas;
	}
	@Override
	public String toString() {
		return "Sesion [id=" + id + ", fechaHora=" + fechaHora + ", titulo=" + titulo + ", idSala=" + idSala
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
	public List<Entrada> getEntradas() {
		return entradas;
	}
	public void setEntradas(List<Entrada> entradas) {
		this.entradas = entradas;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getIdSala() {
		return idSala;
	}
	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}
	
}
