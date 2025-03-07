package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SQL_fetchdata {

	public static void main(String[] args) throws Throwable {

		// step1: register driver

	 Driver driverRef = new Driver();

	
		DriverManager.registerDriver (driverRef);

		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "mask1102");

	

		Statement state = conn.createStatement();

	 String Query = "select * from users";

	
		 ResultSet result = state.executeQuery(Query);

	

		 while (result.next()) {

	
	            System.out.println(
	                    result.getInt("id") + "\t" + 
	                    result.getString("name") + "\t" + 
	                    result.getInt("age"));

 
		 }
   conn.close();
	}

}
