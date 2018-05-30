package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dto.Pelicula;


public class PeliculaDAO {
	Connection conexion;

	public PeliculaDAO() {
		try {
			conexion=DriverManager.getConnection("jdbc:mysql://localhost/CinesaEEp","root","root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Pelicula> recuperarTodasPeliculas(){
			ArrayList<Pelicula> peliculas=new ArrayList<>();
		try {
			Statement statement=conexion.createStatement();
			ResultSet resultado=statement.executeQuery("select * from peliculas");
			while(resultado.next()) {
				String titulo=resultado.getString("titulo");
				LocalDate fechaEstreno=resultado.getDate("fechaEstreno").toLocalDate();
				LocalDate fechaFE=resultado.getDate("fechaFE").toLocalDate();
				String sinopsis=resultado.getString("sinopsis");
				int duracion=resultado.getInt("duracion");
				Pelicula pelicula=new Pelicula(titulo, fechaEstreno, fechaFE, sinopsis, duracion);
				peliculas.add(pelicula);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return peliculas;
	}
	public boolean anadirPelicula(Pelicula p) {
		try {
			PreparedStatement statement=conexion.prepareStatement("insert into pelicula values (?,?,?,?,?)");
			statement.setString(1,p.getTitulo());
			statement.setDate(2,Date.valueOf(p.getFechaEstreno()));
			statement.setDate(3,Date.valueOf(p.getFechaFE()));
			statement.setString(4,p.getSinopsis());
			statement.setInt(5,p.getDuracion());
			int anadido=statement.executeUpdate();
			if(anadido>0)
				return true;
			else 
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean eliminarPelicula(String titulo) {
		try {
			PreparedStatement statement=conexion.prepareStatement("delete from peliculas where titulo=?");
			statement.setString(1,titulo);
			int borrado=statement.executeUpdate();
			if(borrado>0)
				return true;
			else
				return false;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	public boolean comprobarPelicula(String titulo) {
		try {
			
			PreparedStatement statement=conexion.prepareStatement("select * from peliculas where titulo=?");
			statement.setString(1, titulo);
			ResultSet resultado=statement.executeQuery();
			resultado.next();
			String tituloC=resultado.getString("titulo");
			if(tituloC!=null)
				return true;
			else 
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
	