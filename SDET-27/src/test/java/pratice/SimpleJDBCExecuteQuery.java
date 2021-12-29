package pratice;

 
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	import com.mysql.cj.jdbc.Driver;
	public class SimpleJDBCExecuteQuery{

	

		public static void main(String[] args) throws SQLException {
			/*steps 1: register the driver */
			 Driver driver = new Driver(); 
			 DriverManager.registerDriver(driver);
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","root");
			Statement state = con.createStatement();
			ResultSet result = state.executeQuery("select * from employeeinfo;");
			while(result.next())
			{
				System.out.println(result.getString(2)+" "+result.getString(3));
				
			}
			con.close();
			

		}

	}


