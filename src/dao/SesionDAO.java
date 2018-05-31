package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dto.Entrada;
import dto.Pelicula;
import dto.Sala;
import dto.Sesion;

public class SesionDAO {
	Connection conexion;
	public SesionDAO() {
		try {
			conexion=DriverManager.getConnection("jdbc:mysql://localhost/CinesaEEp","root","root");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	public boolean eliminarSesion(int id) {
		try {
			PreparedStatement statement=conexion.prepareStatement("delete from sesiones where id=?");
			statement.setInt(1, id);
		
			if(statement.executeUpdate()>0) {
				System.out.println("Se ha eliminado la sesion correctamente");
				return true;
			}	
			else {
				return false;
			}
			
		} catch (SQLException e) {
			System.out.println("No se puede borrar la sesion");
			return false;
		}
	}
	public boolean anadirSesion(Sesion s) {
		try {
			if (comprobarSalaFechaHora(s.getSala(),s.getFechaHora())) {
				
			
			PreparedStatement statement=conexion.prepareStatement("insert into sesiones values (null,?,?,?)");
			statement.setTimestamp(1,Timestamp.valueOf(s.getFechaHora()));
			statement.setString(2,s.getPelicula().getTitulo());
			statement.setInt(3, s.getSala().getId());
				if(statement.executeUpdate()>0) {
					System.out.println("Se ha añadido correctamente la sesion");
					return true;
				}else {
					System.out.println("No se ha añadido correctamente la sesion");
					return false;
				}
			}else {
				System.out.println("La sala esta ocupado");
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public List<Sesion> recuperarSesionPorTitulo(String titulo){
		 ArrayList<Sesion> sesiones=new ArrayList<>();
		try {
			PreparedStatement statement = conexion.prepareStatement("select se.id,se.fechaHora,se.titulo,se.idSala,sa.filas,sa.asientos,p.fechaEstreno,p.sinopsis,p.fechaFE,p.duracion from sesiones se join salas sa on se.idSala=sa.id join peliculas p on p.titulo=se.titulo where se.titulo=? and se.fechaHora>'2018-05-20 16:20' order by fechaHora asc limit 5");
			statement.setString(1,titulo);
			ResultSet resultado=statement.executeQuery();
			while(resultado.next()) {
				int id=resultado.getInt("id");
				LocalDateTime fechaHora=resultado.getTimestamp("fechaHora").toLocalDateTime();
				String titulo1=resultado.getString("titulo");
				int idSala=resultado.getInt("idSala");
				int filas=resultado.getInt("filas");
				int asientos=resultado.getInt("asientos");
				Sala sala=new Sala(filas, asientos, idSala);
				LocalDate fechaEstreno=resultado.getDate("fechaEstreno").toLocalDate();
				String sinopsis=resultado.getString("sinopsis");
				LocalDate fechaFE =resultado.getDate("fechaFE").toLocalDate();
				int duracion=resultado.getInt("duracion");
				Pelicula pelicula=new Pelicula(titulo1, fechaEstreno, fechaFE, sinopsis, duracion);
				List<Entrada> entradas=recuperarEntradas(id);
				Sesion sesion=new Sesion(idSala, fechaHora, pelicula, sala, entradas);
				sesiones.add(sesion);
		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sesiones;
	}
	public List<Sesion> recuperarSesionPorFechaHora(LocalDateTime fechaHora){
			ArrayList<Sesion> sesiones=new ArrayList<>();
			try {
				PreparedStatement statement=conexion.prepareStatement("select se.id,se.fechaHora,se.titulo,se.idSala,sa.filas,sa.asientos,p.fechaEstreno,p.sinopsis,p.fechaFE,p.duracion from sesiones se join salas sa on se.idSala=sa.id join peliculas p on p.titulo=se.titulo where fechaHora>=? order by fechaHora asc limit 5");
				statement.setTimestamp(1,Timestamp.valueOf(fechaHora));
				ResultSet resultado=statement.executeQuery();
				while(resultado.next()){
					int id=resultado.getInt("id");
					LocalDateTime fechaHora1=resultado.getTimestamp("fechaHora").toLocalDateTime();
					String titulo1=resultado.getString("titulo");
					int idSala=resultado.getInt("idSala");
					int filas=resultado.getInt("filas");
					int asientos=resultado.getInt("asientos");
					Sala sala=new Sala(filas, asientos, idSala);
					LocalDate fechaEstreno=resultado.getDate("fechaEstreno").toLocalDate();
					String sinopsis=resultado.getString("sinopsis");
					LocalDate fechaFE =resultado.getDate("fechaFE").toLocalDate();
					int duracion=resultado.getInt("duracion");
					Pelicula pelicula=new Pelicula(titulo1, fechaEstreno, fechaFE, sinopsis, duracion);
					List<Entrada> entradas=recuperarEntradas(id);
					Sesion sesion=new Sesion(idSala, fechaHora1, pelicula, sala, entradas);
					sesiones.add(sesion);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return sesiones;
	}
	public List<Sesion> recuperarTodasSesiones(){
		ArrayList<Sesion> sesiones= new ArrayList<>();
		try {
			PreparedStatement statement=conexion.prepareStatement("select se.id,se.fechaHora,se.titulo,se.idSala,"
					+ " sa.filas,sa.asientos,p.fechaEstreno,p.sinopsis,p.fechaFE,p.duracion"
					+ " from sesiones se join salas sa on se.idSala=sa.id "
					+ "join peliculas p on p.titulo=se.titulo");
			ResultSet resultado=statement.executeQuery();
			while(resultado.next()) {
				int id=resultado.getInt("id");
				LocalDateTime fechaHora1=resultado.getTimestamp("fechaHora").toLocalDateTime();
				String titulo1=resultado.getString("titulo");
				int idSala=resultado.getInt("idSala");
				int filas=resultado.getInt("filas");
				int asientos=resultado.getInt("asientos");
				Sala sala=new Sala(filas, asientos, idSala);
				LocalDate fechaEstreno=resultado.getDate("fechaEstreno").toLocalDate();
				String sinopsis=resultado.getString("sinopsis");
				LocalDate fechaFE =resultado.getDate("fechaFE").toLocalDate();
				int duracion=resultado.getInt("duracion");
				Pelicula pelicula=new Pelicula(titulo1, fechaEstreno, fechaFE, sinopsis, duracion);
				List<Entrada> entradas=recuperarEntradas(id);
				Sesion sesion=new Sesion(idSala, fechaHora1, pelicula, sala, entradas);
				sesiones.add(sesion);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sesiones;
	}
	public List<Entrada> recuperarEntradas(int idSesion){
		ArrayList<Entrada> entradas=new ArrayList<>();
		try {
			PreparedStatement statement=conexion.prepareStatement("select * from entradas where idSesion=? ");
			statement.setInt(1,idSesion);
			ResultSet resultado=statement.executeQuery();
			while(resultado.next()) {
				int idTicket=resultado.getInt("idTicket");
				int numeroFila=resultado.getInt("numeroFila");
				int numeroAsiento=resultado.getInt("numeroAsiento");
				Entrada entrada=new Entrada(idTicket, numeroFila, numeroAsiento);
				entradas.add(entrada);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entradas;
		
	}
	public boolean comprobarSalaFechaHora(Sala sala,LocalDateTime fechaHora) {
		try {
			PreparedStatement statement=conexion.prepareStatement("select * from sesiones where idSala=? and fechaHora=? ");
			statement.setInt(1, sala.getId());
			statement.setTimestamp(2,Timestamp.valueOf(fechaHora));
			ResultSet resultado=statement.executeQuery();
			if (resultado.next()) {
				System.out.println("La sala esta ocupado");
				return false;
			}
			else { 
				System.out.println("La sala esta disponible");
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
