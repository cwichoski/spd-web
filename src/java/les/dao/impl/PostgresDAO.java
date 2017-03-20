package les.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import les.dao.IConnection;
import les.dao.IDAO;

public abstract class PostgresDAO implements IDAO, IConnection{
	

	public Connection newConnection(){
		try {
			String driver = "org.postgresql.Driver";
			String url = "jdbc:postgresql://localhost:5432/fatec";
			String user = "postgres";
			String password = "admin";
			Class.forName( driver );
			Connection conn = DriverManager.getConnection( url, user, password);
			return conn;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro de SQL");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.getException();
			System.out.println("Erro de driver");
		}
		return null; 
	}

}
