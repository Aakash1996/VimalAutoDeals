import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class gcon {
		static String DB_URL = "jdbc:oracle:thin:@localhost:1521/XE";
		static String USER = "SYSTEM";
		static String PASS = "sa254+256";
		
		public Connection getDBConnection() {
			 
			Connection dbConnection = null;
	 
			try {
	 
				Class.forName("oracle.jdbc.OracleDriver");
	 
			} catch (ClassNotFoundException e) {
	 
				System.out.println(e.getMessage());
	 
			}
	 
			try {
	 
				dbConnection = DriverManager.getConnection(
						DB_URL, USER,PASS);
				return dbConnection;
	 
			} catch (SQLException e) {
	 
				System.out.println(e.getMessage());
	 
			}
	 
			return dbConnection;
	 
		}
	}


