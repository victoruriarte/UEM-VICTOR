package ut02_tiempo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	private final static String DB = "forecast.db";
	private final static String PATH = "./bbdd/";
	private final static String URL = "jdbc:sqlite:"+PATH+DB;
	
	private final static String DRIVER = "org.sqlite.JDBC";
	
	//protected para que las clases hijas puedan seguir utilizandolo
	protected Connection conn;
	
	//Conectamos a la base de datos
	public Database(){
		try {
			Class.forName(DRIVER);
			
			conn = DriverManager.getConnection(URL);
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el driver");
		} catch (SQLException e) {
			System.out.println("Error al conectarse");
		}
	}
	
	public Connection getConnection(){
		return conn;
	}
}
