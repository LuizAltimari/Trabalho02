package modelo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.ConnectionFactory;

import modelo.Proprietario;

public class ProprietarioDAO {
	private Connection con;
	
	public ProprietarioDAO() {
		this.con = new ConnectionFactory().getConnection();
	}

	public boolean salvar(Proprietario proprietario) {
		try {
			String sql = "insert into proprietario (cpf, nome, rg, dataDeNascimento, cep) values (?,?,?,?,?)";
			PreparedStatement stmt = this.con.prepareStatement(sql); 
			stmt.setString(1, proprietario.getCpf());
			stmt.setString(2, proprietario.getNome());
			stmt.setString(3, proprietario.getRg());
			stmt.setDate(4, (Date) proprietario.getDataDeNascimento());
			stmt.setString(5, proprietario.getCep());
			
			stmt.executeUpdate();
			return true;
		}catch(SQLException e) {
			System.out.println("Execption: " + e.getMessage());
			return false;
		}finally {
			ConnectionFactory.closeConnection(con);
		}			
	}
	
	public ArrayList<Proprietario> selectAll (){
		ArrayList<Proprietario> proprietarios = new ArrayList<Proprietario>();
		EnderecoDAO endDao = new EnderecoDAO();
		try {
			String sql = "select * from proprietario";
			PreparedStatement stmt = this.con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Proprietario prop = new Proprietario(rs.getString("nome"), rs.getString("cpf"), rs.getString("rg"), rs.getString("cep") , endDao.select(rs.getString("cep")));
				proprietarios.add(prop);
			}
			return proprietarios;
		}catch(SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			return null;
		}finally {
			ConnectionFactory.closeConnection(con);
		}
	}
	
	public Proprietario select(String cpf) {
		Proprietario proprietario = null;
		ResultSet rs = null;
		EnderecoDAO endDao = new EnderecoDAO();
		try {
			String sql = "select * from proprietario where cpf = '" + cpf + "'";
			PreparedStatement stmt = this.con.prepareStatement(sql);
			
			rs = stmt.executeQuery(sql);
			//
			if(rs != null && rs.next()) {				
				proprietario = new Proprietario(rs.getString("nome"), rs.getString("cpf"), rs.getString("rg"), rs.getString("cep") , endDao.select(rs.getString("cep")));
			}			
			return proprietario;
		}catch(SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			return null;
		}finally {
			ConnectionFactory.closeConnection(con);
		}
	}
	
	public boolean alterar(Proprietario proprietario) {
		try {
			String sql = "update proprietario set  cpf = '"+proprietario.getCpf()+"', nome = '"+proprietario.getNome()+"', rg = '"+proprietario.getRg()+"', dataDeNascimento = '"+proprietario.getDataDeNascimento()+"', cep = '"+proprietario.getDataDeNascimento()+"'";
			PreparedStatement stmt = this.con.prepareStatement(sql); 					
			stmt.executeUpdate();
			return true;
		}catch(SQLException e) {
			System.out.println("Execption: " + e.getMessage());
			return false;
		}finally {
			ConnectionFactory.closeConnection(con);
		}			
	}
		
	
	public boolean remover (String cpf) {
		try {
			String sql = "delete from proprietario where cpf = ?";
			PreparedStatement stmt = this.con.prepareStatement(sql); 			
			stmt.setString(1, cpf);
			stmt.executeUpdate();
			return true;
		}catch(SQLException e) {
			System.out.println("Execption: " + e.getMessage());
			return false;
		}finally {
			ConnectionFactory.closeConnection(con);
		}			
	}
}
