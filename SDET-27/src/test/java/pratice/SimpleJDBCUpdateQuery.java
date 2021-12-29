package pratice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SimpleJDBCUpdateQuery {

	public static void main(String[] args) throws SQLException {
     Driver driver = new Driver();
     DriverManager.registerDriver(driver);
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","root");
    Statement state = con.createStatement();
    int result = state.executeUpdate("insert into employeeinfo values(12,'Deepak','Mumbai')");
    if(result==1)
    {
    	System.out.println("database added sucessfully");
    }
    else
    {
    	System.out.println("error");
    }
    con.close();
    	
    	
    
     

	}
	

}
