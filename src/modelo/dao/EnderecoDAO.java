package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.ConnectionFactory;
import modelo.Endereco;

public class EnderecoDAO {
	private Connection con;
	
	public EnderecoDAO() {
		this.con = new ConnectionFactory().getConnection();
	}

	public boolean salvar(Endereco endereco) {
		try {
			String sql = "insert into endereco (cep, rua, bairro, cidade, estado, complemento) values (?,?,?,?,?,?)";
			PreparedStatement stmt = this.con.prepareStatement(sql); 
			stmt.setString(1, endereco.getCep());
			stmt.setString(3, endereco.getBairro());
			stmt.setString(4, endereco.getCidade());
			stmt.setString(6, endereco.getComplemento());
			stmt.setString(5, endereco.getEstado());
			stmt.setString(2, endereco.getRua());
			stmt.executeUpdate();
			return true;
		}catch(SQLException e) {
			System.out.println("Execption: " + e.getMessage());
			return false;
		}finally {
			ConnectionFactory.closeConnection(con);
		}			
	}
	
	public ArrayList<Endereco> selectAll (){
		ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
		try {
			String sql = "select * from endereco";
			PreparedStatement stmt = this.con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Endereco end = new Endereco(rs.getString("rua"), rs.getString("bairro"), rs.getString("cidade"), rs.getString("estado"), rs.getString("cep"), rs.getString("complemento"));
				enderecos.add(end);
			}
			return enderecos;
		}catch(SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			return null;
		}finally {
			ConnectionFactory.closeConnection(con);
		}
	}
	
	public Endereco select(String cep) {
		Endereco endereco = null;
		ResultSet rs = null;
		try {
			String sql = "select * from endereco where cep = '" + cep + "'";
			PreparedStatement stmt = this.con.prepareStatement(sql);
			
			rs = stmt.executeQuery(sql);
			//
			if(rs != null && rs.next()) {				
				endereco = new Endereco(rs.getString("rua"), rs.getString("bairro"), rs.getString("cidade"), rs.getString("estado"), rs.getString("cep"), rs.getString("complemento"));
			}			
			return endereco;
		}catch(SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			return null;
		}finally {
			ConnectionFactory.closeConnection(con);
		}
	}
	
	public boolean alterar(Endereco endereco) {
		try {
			String sql = "update endereco set cep = '" + endereco.getCep() +"', rua = '"+endereco.getRua() +"', bairro = '"+ endereco.getBairro()+"', cidade = '"+endereco.getCidade()+"', estado = '"+endereco.getEstado()+"', complemento = '" +endereco.getComplemento() + "'";
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
		
	
	public boolean remover (String cep) {
		try {
			String sql = "delete from endereco where cep = ?";
			PreparedStatement stmt = this.con.prepareStatement(sql); 			
			stmt.setString(1, cep);
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
