package demo.servlet.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Locale;
import java.util.ResourceBundle;

public class ConnectionManager {
	
static Connection con = null;
	
	public static Connection getConnection() {
		try {
		Locale locale = new Locale("en", "US");

		ResourceBundle properties = ResourceBundle.getBundle("jdbc", locale);
		
		//required properties out of properties object
	    String driver = properties.getString("driver");
	    String url = properties.getString("url");
	    String username = properties.getString("username");
	    String password = properties.getString("password");
		//load the driver
		Class.forName(driver);
		//get the connection
		con = DriverManager.getConnection(url, username, password);
		
		}catch (Exception e) {
			System.out.println(e);
		}
		
		if(con != null)
			System.out.println("connection  established");
		
		return con;
	}
	
//	public static void main(String[] args) {
//		getConnection();
//	}

}
