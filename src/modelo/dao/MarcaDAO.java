package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.ConnectionFactory;
import modelo.Marca;

public class MarcaDAO {
	private Connection con;
	
	public MarcaDAO() {
		this.con = new ConnectionFactory().getConnection();
	}

	public boolean salvar(Marca marca) {
		try {
			String sql = "insert into marca (nome, nrModelos, anoLancamento) values (?,?,?)";
			PreparedStatement stmt = this.con.prepareStatement(sql); 
			stmt.setString(1, marca.getNome());
			stmt.setInt(2, marca.getNrModelos());
			stmt.setInt(3, marca.getAnoLancamento());
			stmt.executeUpdate();
			return true;
		}catch(SQLException e) {
			System.out.println("Execption: " + e.getMessage());
			return false;
		}finally {
			ConnectionFactory.closeConnection(con);
		}			
	}
	
	public ArrayList<Marca> selectAll (){
		ArrayList<Marca> marcas = new ArrayList<Marca>();
		try {
			String sql = "select * from marca";
			PreparedStatement stmt = this.con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				marcas.add(new Marca(rs.getInt("idMarca"),rs.getString("nome"), rs.getInt("nrModelos"), rs.getInt("anoLancamento")));
			}
			return marcas;
		}catch(SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			return null;
		}finally {
			ConnectionFactory.closeConnection(con);
		}
	}
	
	public Marca select(int idMarca) {
		Marca marca = null;
		ResultSet rs = null;
		try {
			String sql = "select * from marca where idMarca = " + idMarca;
			PreparedStatement stmt = this.con.prepareStatement(sql);
			
			rs = stmt.executeQuery(sql);
			//
			if(rs != null && rs.next()) {				
				marca = new Marca(rs.getInt("idMarca"), rs.getString("nome"), rs.getInt("nrModelos"), rs.getInt("anoLancamento"));
			}			
			return marca;
		}catch(SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			return null;
		}finally {
			ConnectionFactory.closeConnection(con);
		}
	}
	
	public boolean alterar(Marca marca) {
		try {
			String sql = "update marca set nome = ?, nrModelos = ?, anoLancamento = ? where idMarca = ?";
			PreparedStatement stmt = this.con.prepareStatement(sql); 
			stmt.setString(1, marca.getNome());
			stmt.setInt(2, marca.getNrModelos());
			stmt.setInt(3, marca.getAnoLancamento());
			stmt.setInt(4, marca.getIdMarca());
			stmt.executeUpdate();
			return true;
		}catch(SQLException e) {
			System.out.println("Execption: " + e.getMessage());
			return false;
		}finally {
			ConnectionFactory.closeConnection(con);
		}			
	}
		
	
	public boolean remover (int idMarca) {
		try {
			String sql = "delete from marca where idMarca = ?";
			PreparedStatement stmt = this.con.prepareStatement(sql); 			
			stmt.setInt(1, idMarca);
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
