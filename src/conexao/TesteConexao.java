package conexao;


public class TesteConexao {

	public static void main(String[] args) throws Exception{
		ConnectionFactory con = new ConnectionFactory(); 
		
		System.out.println(con.getConnection());
	}

}
