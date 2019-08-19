package modelo;
import java.util.Date;

//15)Transforme o atributo Marca de um carro em uma classe Marca com nome, nrDeModelos, ano de lançamento e código identificador.
public class Marca {
	
	private int idMarca;
	private String nome;
	private int nrModelos; 
	private Date anoLancamento;
	
	public Marca() {}

	public Marca(int idMarca, String nome, int nrModelos, Date anoLancamento) {
		super();
		this.idMarca = idMarca;
		this.nome = nome;
		this.nrModelos = nrModelos;
		this.anoLancamento = anoLancamento;
	}

	public int getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNrModelos() {
		return nrModelos;
	}

	public void setNrModelos(int nrModelos) {
		this.nrModelos = nrModelos;
	}

	public Date getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(Date anoLancamento) {
		this.anoLancamento = anoLancamento;
	}
		
}
