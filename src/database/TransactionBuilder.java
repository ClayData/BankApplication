package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionBuilder {
	
	public void addTransaction(int amount, int cust_id, String acct_type, int acct_id) {
		int id = 0;
		int savacct = java.sql.Types.INTEGER;
		int salacct = java.sql.Types.INTEGER;
		int curacct = java.sql.Types.INTEGER;
		Connection con = null;
		switch(acct_type) {
		case "salary_account":
			salacct = acct_id;
			break;
		case "savings_account":
			savacct = acct_id;
			break;
		case "current_account":
			curacct = acct_id;
			break;
		
		}
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@bankdatabase.cz8yphudm026.us-east-2.rds.amazonaws.com:1521:orcl", "admin", "spicymeatball");
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select max(transact_id) from transactions");
			while(rs.next()) {
				id = rs.getInt(1) + 1;
			}
			
			PreparedStatement pre = con.prepareStatement("insert into transactions values(?,?,?,?,?,?)");
			pre.setInt(1, id);
			pre.setInt(2, amount);
			pre.setInt(3, cust_id);
			pre.setInt(4, salacct);
			pre.setInt(5, curacct);
			pre.setInt(6, savacct);
			
			
		}  catch (ClassNotFoundException e) {
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
	
	public void getTransactions() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Register");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@bankdatabase.cz8yphudm026.us-east-2.rds.amazonaws.com:1521:orcl", "admin", "spicymeatball");
			System.out.println("connection done");
		}  catch (ClassNotFoundException e) {
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
}
