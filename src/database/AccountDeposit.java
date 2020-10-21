package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDeposit {
	
	public void depositMoney(String accountType, int amount, int cust_id) {
		Connection con = null;
		int balance = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Register");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@bankdatabase.cz8yphudm026.us-east-2.rds.amazonaws.com:1521:orcl", "admin", "spicymeatball");
			System.out.println("connection done");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select balance from " + accountType + " where cust_id = " + cust_id);
			while(rs.next()) {
				balance = rs.getInt(1) + amount;
			}
			
			PreparedStatement pre = con.prepareStatement("update " + accountType + " set balance = " + balance + " where cust_id = " + cust_id);
			pre.executeUpdate();
			
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
	}
	
	public static void main(String[] args) {
		AccountDeposit ad = new AccountDeposit();
		ad.depositMoney("salary_account", 10000,1);
	}
}
