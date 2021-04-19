package demo.servlet.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import demo.servlet.model.Login;
import demo.servlet.utility.ConnectionManager;

public class LoginDao {
	
	public boolean validateUser(Login login) {
		
		Connection con = ConnectionManager.getConnection();
		
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM logindetails ");
			while(rs.next())
			{
				if(rs.getString(1).equals(login.getUserId())&& rs.getString(2).equals(login.getPassword())) {
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return false;
		
	}

}
