package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class CustRetriever {
	
	public int retrieveCust(String custContact) {
		
		int cust_id = 0;
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@bankdatabase.cz8yphudm026.us-east-2.rds.amazonaws.com:1521:orcl", "admin", "spicymeatball");
			
			
			PreparedStatement stm = con.prepareStatement("select cust_id from customers where contact = ?");
			stm.setString(1, custContact);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				cust_id = rs.getInt(1);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return cust_id;
	}
}
