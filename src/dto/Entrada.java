package dto;

public class Entrada {
	private int idTicket;
	private int numeroFila;
	private int numeroAsiento;
	public Entrada() {
		super();
	}
	public Entrada(int numeroFila, int numeroAsiento) {
		super();
		this.numeroFila = numeroFila;
		this.numeroAsiento = numeroAsiento;
	}
	public Entrada(int idTicket, int numeroFila, int numeroAsiento) {
		super();
		this.idTicket = idTicket;
		this.numeroFila = numeroFila;
		this.numeroAsiento = numeroAsiento;
	}
	@Override
	public String toString() {
		return "Entrada [idTicket=" + idTicket + ", numeroFila=" + numeroFila + ", numeroAsiento=" + numeroAsiento
				+ "]";
	}
	public int getIdTicket() {
		return idTicket;
	}
	public void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}
	public int getNumeroFila() {
		return numeroFila;
	}
	public void setNumeroFila(int numeroFila) {
		this.numeroFila = numeroFila;
	}
	public int getNumeroAsiento() {
		return numeroAsiento;
	}
	public void setNumeroAsiento(int numeroAsiento) {
		this.numeroAsiento = numeroAsiento;
	}
}
