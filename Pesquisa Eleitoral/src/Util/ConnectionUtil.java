package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	private static Connection con;
	
	public static Connection getConnection() {
		
		try {
			
			Class.forName("com.mysqljdbc.Driver");
			String url = "jbb:mysql://localhost:3306/Pesquisa_Eleitoral";
			con = DriverManager.getConnection(url,"root","Mb@rros1971");
			con.setAutoCommit(true);
			return con;
			
		} catch ( ClassNotFoundException e ) {
			
			e.printStackTrace();
			
		} catch (SQLException se ) {
			
			se.printStackTrace();
			
		}
		
		return null;
		
	}

	public static void closeConnection() {
		
		try {
			
			con.close();
		} catch (SQLException ex) {
			
			ex.printStackTrace();
		}
	}
}
