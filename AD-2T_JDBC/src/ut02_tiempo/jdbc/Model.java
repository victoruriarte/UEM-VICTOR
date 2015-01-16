package ut02_tiempo.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Model extends Database {

	public Model() {
		super();
		createTableTiempo();
	}

	final static String CREATE_TABLE_TIEMPO = "" + "CREATE TABLE TIEMPO"
			+ "(_id INTEGER PRIMARY KEY AUTO_INCREMENT"
			+ " fecha TEXT NOT NULL" 
			+ " min REAL NOT NULL"
			+ " max REAL NOT NULL" 
			+ " humedad REAL NOT NULL"
			+ " presion REAL NOT NULL)";

	public void createTableTiempo() {
		Statement st = null;
		try {
			st = conn.createStatement();

			st.executeUpdate(CREATE_TABLE_TIEMPO);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			if (st != null)
				try {
					st.close();
				} catch (SQLException e) {

				}
		}
	}

	public void insertPredicion(String fecha, float min, float max,
			float humedad, float presion) {
		Statement st = null;
		
		String sql = "INSERT INTO TIEMPO "
				+ "(fecha, min, max, humedad, presion) "
				+ "VALUES ('"+fecha+"',"
							+min+","+
							+max+","+
							+humedad+","+
							+presion+")";
		try {
			st = conn.createStatement();

			
			st.executeUpdate(sql);
			
			System.out.println(sql);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			if (st != null)
				try {
					st.close();
				} catch (SQLException e) {

				}
		}
	}

	public void imprimirPrediciones() {
		Statement st = null;
		ResultSet rs = null;
		try {
			rs = st.executeQuery("select * from tiempo");
			
			while(rs.next())
		      {
		        // read the result set
		        System.out.println("id = " + rs.getString("name"));
		        System.out.println("fecha = " + rs.getString("id"));
		        System.out.println("min = " + rs.getFloat("min"));
		        System.out.println("min = " + rs.getFloat("max"));
		        System.out.println("min = " + rs.getFloat("humedad"));
		        System.out.println("min = " + rs.getFloat("presion"));
		      }
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				
			}
		}
		
		 
	}

}
