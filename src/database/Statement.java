package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Statement {
	
//	public void retrieveStatement(int cust_id) {
//		Connection con = null;
//		
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			System.out.println("Driver Register");
//			
//			con = DriverManager.getConnection("jdbc:oracle:thin:@bankdatabase.cz8yphudm026.us-east-2.rds.amazonaws.com:1521:orcl", "admin", "spicymeatball");
//			System.out.println("connection done");
//
//			Statement stmt = con.createStatement();
//			ResultSet rs = stmt.executeQuery("select * from transactions where cust_id = " + cust_id);
//			while(rs.next()) {
//				acctId = rs.getInt(1);
//			}
//			
//			
//			
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		finally {
//			try {
//				con.close();
//			} catch (SQLException e) {
//				
//				e.printStackTrace();
//			}
//		}
//	}
}
