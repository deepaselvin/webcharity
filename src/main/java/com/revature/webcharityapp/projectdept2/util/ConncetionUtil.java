package com.revature.webcharityapp.projectdept2.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConncetionUtil {

	  private static final ConncetionUtil INSTANCE = new ConncetionUtil();
	    
	    private ConncetionUtil() {
	        //private Constructor
	    }
	    
	    public static ConncetionUtil getInstance() {
	        return INSTANCE;
	    }
	    
	    /*    public static Connection getconnection() {

	        Connection con = null;

	        //try with resources, it will the close the reader.close automatically.
	        try(InputStream inputStream  = INSTANCE.getClass()
	                .getClassLoader().getResourceAsStream("application.properties")) {
	            
	            Properties prop = new Properties();
	            // load a properties file
	            prop.load(inputStream);

	            String driverClassName = prop.getProperty("driverClassName");
	            String url = prop.getProperty("url");
	            String username = prop.getProperty("username");
	            String password = prop.getProperty("password");

	            Class.forName(driverClassName);
	            con = DriverManager.getConnection(url, username, password);
	            System.out.println("Loading Credentials from Property Files:" + con);
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	            throw new RuntimeException("Unable to load the driver class");
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new RuntimeException("Unable to get DB Connection");
	        } catch (IOException ex) {
	            ex.printStackTrace();
	            throw new RuntimeException("Unable to read property files");
	        }

	        return con;
	    }
*/
	
	
	public static Connection getconnection() {

		String driverClassName = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://trainingdb.ck1ayq0lncmp.ap-south-1.rds.amazonaws.com:3306/pradeepa_db";
		String username = "pradeepa";
		String password = "pradeepa";
		Connection con = null;

		try {
			Class.forName(driverClassName);
			con = DriverManager.getConnection(url, username, password);
			// System.out.println(con);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}
