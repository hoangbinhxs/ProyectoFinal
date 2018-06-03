package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dto.Entrada;

public class EntradaDAO {
	Connection conexion;
	public EntradaDAO() {
		try {
			conexion=DriverManager.getConnection("jdbc:mysql://localhost/CinesaEEp","root","root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void guardarEntrada(List<Entrada> entradas) {
		
		try {
			PreparedStatement statement=conexion.prepareStatement("insert into entradas values (?,?,?)");
			
			for (Entrada entrada : entradas) {
	
				statement.setInt(1, entrada.getNumeroFila());
				statement.setInt(2, entrada.getNumeroAsiento());
				statement.setInt(3,entrada.getIdSesion());
				statement.executeUpdate();
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("No se ha podido guardar las entradas");
			
		}
		
	}
	public boolean comprobarEntrada(Entrada entrada) {
		try {
			PreparedStatement statemen=conexion.prepareStatement("select * from entradas where numeroFila=? and numeroAsiento=? and idSesion=?");
			statemen.setInt(1,entrada.getNumeroFila());
			statemen.setInt(2, entrada.getNumeroAsiento());
			statemen.setInt(3,entrada.getIdSesion());
			ResultSet resultado=statemen.executeQuery();
			if (resultado.next()) {
				System.out.println("La entrada esta comprado");
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
	public void cerrar() {
		try {
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("No se puede cerrar la conexion");
		}
	}
}
