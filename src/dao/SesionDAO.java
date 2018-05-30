package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dto.Entrada;
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
			if(!recuperarEntradas(id).isEmpty()) {
				System.out.println("No se puede eliminar la sesion");
				return false;
			}
			else {
				PreparedStatement statement=conexion.prepareStatement("delete from sesiones where id=?");
				statement.setInt(1, id);
				if(statement.executeUpdate()>0) {
					System.out.println("se ha eliminado la sesion");
					return true;
				}else {
					return false;
					}
			}
			
		} catch (SQLException e) {
			System.out.println("No se puede borrar la sesion");
			e.printStackTrace();
			return false;
		}
	}
	public boolean anadirSesion(Sesion s) {
		try {
			PreparedStatement statement=conexion.prepareStatement("insert into sesiones values (null,?,?,?)");
			statement.setTimestamp(1,Timestamp.valueOf(s.getFechaHora()));
			statement.setString(2,s.getTitulo());
			statement.setInt(3, s.getIdSala());
			if(statement.executeUpdate()>0) {
				System.out.println("Se ha añadido correctamente la sesion");
				return true;
			}
			else { 
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
			PreparedStatement statement = conexion.prepareStatement("select * from sesiones where titulo like order by fechaHora asc limit 5 ");
			statement.setString(1,titulo);
			ResultSet resultado=statement.executeQuery();
			while(resultado.next()) {
				int id=resultado.getInt("id");
				LocalDateTime fechaHora=resultado.getTimestamp("fechaHora").toLocalDateTime();
				String titulo1=resultado.getString("titulo");
				List<Entrada> entradas=recuperarEntradas(id);
				int idSala=resultado.getInt("idSala");
				Sesion sesion=new Sesion(fechaHora, titulo1, idSala, entradas);
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
				PreparedStatement statement=conexion.prepareStatement("select * from sesiones where fechaHora>=? order by fechaHora asc limit 5 ");
				statement.setTimestamp(1,Timestamp.valueOf(fechaHora));
				ResultSet resultado=statement.executeQuery();
				while(resultado.next()){
					int id=resultado.getInt("id");
					LocalDateTime fechaHora1=resultado.getTimestamp("fechaHora").toLocalDateTime();
					String titulo=resultado.getString("titulo");
					List<Entrada> entradas=recuperarEntradas(id);
					int idSala=resultado.getInt("idSala");
					Sesion sesion=new Sesion(id, fechaHora1, titulo, idSala, entradas);
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
			PreparedStatement statement=conexion.prepareStatement("select * from sesiones");
			ResultSet resultado=statement.executeQuery();
			while(resultado.next()) {
				int id=resultado.getInt("id");
				LocalDateTime fechaHora1=resultado.getTimestamp("fechaHora").toLocalDateTime();
				String titulo=resultado.getString("titulo");
				List<Entrada> entradas=recuperarEntradas(id);
				int idSala=resultado.getInt("idSala");
				Sesion sesion=new Sesion(id, fechaHora1, titulo, idSala, entradas);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entradas;
		
	}

}
