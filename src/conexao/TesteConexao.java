package conexao;

import java.sql.Connection;

public class TesteConexao {

	public static void main(String[] args) throws Exception{
		Connection con = new ConnectionFactory().getConnection(); 
		
		System.out.println(con);
		con.close();
	}

}
