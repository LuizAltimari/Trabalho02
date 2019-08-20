package modelo.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.ConnectionFactory;
import modelo.Carro;


public class CarroDAO {
private Connection con;
	
	public CarroDAO() {
		this.con = new ConnectionFactory().getConnection();
	}

	public boolean salvar(Carro carro) {
		try {
			String sql = "insert into carro (modelo, cor, ano, idMarca, chassi, cpf, velocidadeMaxima, nrPorta, tetoSolar, nrMarchas, cambioAutomatico, volumeCombustivel) values (?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = this.con.prepareStatement(sql); 
			stmt.setString(1, carro.getModelo());			
			stmt.setString(2, carro.getCor());
			stmt.setInt(3, carro.getAno());
			stmt.setInt(4, carro.getIdMarca());
			stmt.setString(5, carro.getChassi());
			stmt.setString(6, carro.getCpf());
			stmt.setDouble(7, carro.getVelocidadeMaxima());
			stmt.setInt(8, carro.getNrPortas());
			stmt.setBoolean(9, carro.isTetoSolar());
			stmt.setInt(10, carro.getNrMarchas());
			stmt.setBoolean(11, carro.isCambioAutomatico());
			stmt.setDouble(12, carro.getVolumeCombustivel());
			stmt.executeUpdate();
			
			return true;
		}catch(SQLException e) {
			System.out.println("Execption: " + e.getMessage());
			return false;
		}finally {
			ConnectionFactory.closeConnection(con);
		}			
	}
	
	public ArrayList<Carro> selectAll (){
		ArrayList<Carro> carros = new ArrayList<Carro>();
		ProprietarioDAO propDao = new ProprietarioDAO();
		MarcaDAO marcDao = new MarcaDAO();
		try {
			String sql = "select * from carro";
			PreparedStatement stmt = this.con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Carro carro = new Carro(rs.getString("modelo"), 
										rs.getString("cor"), 
										rs.getInt("ano"), 
										marcDao.select(rs.getInt("idMarca")), 
										rs.getString("chassi"), 
										propDao.select(rs.getString("cpf")), 
										rs.getDouble("velocidadeMaxima"),
										rs.getInt("nrPorta"),
										rs.getBoolean("tetoSolar"),
										rs.getInt("nrMarchas"),
										rs.getBoolean("cambioAutomatico"),
										rs.getDouble("volumeCombustivel"),
										rs.getString("cpf"),
										rs.getInt("idMarca"));
				carros.add(carro);
			}
			return carros;
		}catch(SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			return null;
		}finally {
			ConnectionFactory.closeConnection(con);
		}
	}
	
	public Carro select(String chassi) {
		Carro carro = null;
		ResultSet rs = null;
		ProprietarioDAO propDao = new ProprietarioDAO();
		MarcaDAO marcDao = new MarcaDAO();
		try {
			String sql = "select * from carro where chassi = '" + chassi + "'";
			PreparedStatement stmt = this.con.prepareStatement(sql);
			
			rs = stmt.executeQuery(sql);
			//
			if(rs != null && rs.next()) {				
				carro = new Carro(rs.getString("modelo"), 
						rs.getString("cor"), 
						rs.getInt("ano"), 
						marcDao.select(rs.getInt("idMarca")), 
						rs.getString("chassi"), 
						propDao.select(rs.getString("cpf")), 
						rs.getDouble("velocidadeMaxima"),
						rs.getInt("nrPorta"),
						rs.getBoolean("tetoSolar"),
						rs.getInt("nrMarchas"),
						rs.getBoolean("cambioAutomatico"),
						rs.getDouble("volumeCombustivel"),
						rs.getString("cpf"),
						rs.getInt("idMarca"));
			}			
			return carro;
		}catch(SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			return null;
		}finally {
			ConnectionFactory.closeConnection(con);
		}
	}
	
	public boolean alterar(Carro carro) {
		try {
			String sql = "update carro set modelo = '"+carro.getModelo()+"', cor = '"+carro.getCor()+"', ano = "+carro.getAno()+", idMarca = "+carro.getIdMarca()+", chassi = '"+carro.getChassi()+"', cpf = '"+carro.getCpf()+"', velocidadeMaxima = "+carro.getVelocidadeMaxima()+", nrPorta = "+carro.getNrPortas()+", tetoSolar = "+carro.isTetoSolar()+", nrMarchas = "+carro.getNrMarchas()+", cambioAutomatico = "+carro.isCambioAutomatico()+", volumeCombustivel = "+ carro.getVolumeCombustivel();
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
		
	
	public boolean remover (String chassi) {
		try {
			String sql = "delete from carro where chassi = ?";
			PreparedStatement stmt = this.con.prepareStatement(sql); 			
			stmt.setString(1, chassi);
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
