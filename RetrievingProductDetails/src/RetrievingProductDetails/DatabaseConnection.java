package RetrievingProductDetails;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DatabaseConnection { 
    protected static Connection initializeDatabase() 
        throws SQLException, ClassNotFoundException 
    { 
    	String dbDriver = "com.mysql.jdbc.Driver"; 
        String dbURL = "jdbc:mysql://localhost:3306/"; 
        // Database name to access 
        String dbName = "phase2db"; 
        String dbUsername = "root"; 
        String dbPassword = "root"; 
        
	    Class.forName(dbDriver); 
	    Connection conn = (Connection) DriverManager.getConnection(dbURL + dbName + "?autoReconnect=true&useSSL=false&" + "user=" + dbUsername + "&password=" + dbPassword);
        return conn; 
    } 
} 