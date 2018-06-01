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


	public Sesion(Sala s, Pelicula p, LocalDateTime hora, int duracion) {
		this.sala=s;
		this.pelicula=p;
		this.fechaHora=hora;
	}



	@Override
	public String toString() {
		String cadena= "--------------------------------\n";
		cadena+=textoFormateado("|Id de Sesion: "+id+"|",30);
		cadena+=textoFormateado("|Fecha y Hora: "+fechaHora+"|",30);
		cadena+=textoFormateado("|Pelicula emitida: "+pelicula+"|",30);
		cadena+=textoFormateado("|Sala: "+ sala+"|",30);
		cadena+=textoFormateado("|Entrada: "+entradas+"|", 30);
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
