package dto;

public class Sala {
	private int filas;
	private int asientos;
	private int id;
	public Sala() {
		super();
	}
	public Sala(int filas, int asientos) {
		super();
		this.filas = filas;
		this.asientos = asientos;
	}
	public Sala(int filas, int asientos, int id) {
		super();
		this.filas = filas;
		this.asientos = asientos;
		this.id = id;
	}
	@Override
	public String toString() {
		return "Sala [filas=" + filas + ", asientos=" + asientos + ", id=" + id + "]";
	}
	public int getFilas() {
		return filas;
	}
	public void setFilas(int filas) {
		this.filas = filas;
	}
	public int getAsientos() {
		return asientos;
	}
	public void setAsientos(int asientos) {
		this.asientos = asientos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
