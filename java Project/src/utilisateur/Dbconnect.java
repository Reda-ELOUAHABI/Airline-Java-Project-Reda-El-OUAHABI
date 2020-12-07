package utilisateur;
import java.sql.*;
import java.sql.DriverManager;

public class Dbconnect {
	public Connection con ;
	
	public Dbconnect() { try{  
		//step1 load the driver class  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		  
		//step2 create  the connection object  
	   con=DriverManager.getConnection(  
			   "jdbc:oracle:thin:@localhost:1521:xe","system","system");  
	   con.setAutoCommit(true);
	
		  
		}catch(Exception e) {
			System.err.println(e);
		
		   }
	}
	Connection getConn() {
		return con;
	}
		  
		  

}