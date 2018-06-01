package dto;

public class Sala {
	private int filas;
	private int asientos;
	private int id;
	public Sala() {
		super();
	}
	
	public Sala(int id) {
		super();
		this.id = id;
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
		String cadena= "--------------------------------\n";
		cadena+=textoFormateado("|Id de Sesion: "+id+"|",30);
		cadena+=textoFormateado("|Fila: "+filas+"|",30);
		cadena+=textoFormateado("|Asiento: "+asientos+"|",30);
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
