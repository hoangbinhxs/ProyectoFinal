package dto;

public class Entrada {
	private int idSesion;
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
	public Entrada(int idSesion, int numeroFila, int numeroAsiento) {
		super();
		this.idSesion = idSesion;
		this.numeroFila = numeroFila;
		this.numeroAsiento = numeroAsiento;
	}
	@Override
	public String toString() {
		String cadena= "----------------------------------------------------\n";
		cadena+=textoFormateado("IdTicket: "+getNumeroFila()+""+getNumeroAsiento()+""+getIdSesion(),50);
		cadena+=textoFormateado("Fila: "+getNumeroFila(),50);
		cadena+=textoFormateado("Asiento: "+getNumeroAsiento(),50);
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
	public int getIdSesion() {
		return idSesion;
	}
	public void setIdSesion(int idTicket) {
		this.idSesion = idTicket;
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
