package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddUser {

	
	public void addCustomer(String name, String gender, int salary, String contact) {
		Connection con = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Register");
			
			 con = DriverManager.getConnection("jdbc:oracle:thin:@bankdatabase.cz8yphudm026.us-east-2.rds.amazonaws.com:1521:orcl", "admin", "spicymeatball");
			
			System.out.println("connection done");
			PreparedStatement pre = con.prepareStatement("insert into customers values(?,?,?,?,?,?,?,?)");
			
			
			pre.setInt(1, 1);
			pre.setString(2, name);
			pre.setString(3, gender);
			pre.setInt(4, salary);
			pre.setString(5, contact);
			pre.setNull(6, java.sql.Types.INTEGER);
			pre.setNull(7, java.sql.Types.INTEGER);
			pre.setNull(8, java.sql.Types.INTEGER);
			
			pre.executeUpdate();
			
			Statement stmt=con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from customers");
			
			while (rs.next()) {
				System.out.println(rs.getInt(1)+ " " + rs.getString(2) + " " + rs.getString(3));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
