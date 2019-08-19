package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public Connection getConnection(){
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/Trabalho02?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "12345");
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
