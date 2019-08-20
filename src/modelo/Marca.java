package modelo;




//15)Transforme o atributo Marca de um carro em uma classe Marca com nome, nrDeModelos, ano de lançamento e código identificador.
public class Marca {
	
	private int idMarca;
	private String nome;
	private int nrModelos; 
	private int anoLancamento;	
	


	public Marca() {}

	public Marca(String nome, int nrModelos, int anoLancamento) {
		//super();
		
		this.nome = nome;
		this.nrModelos = nrModelos;
		this.anoLancamento = anoLancamento;
		
	}
	
	public Marca(int idMarca, String nome, int nrModelos, int anoLancamento) {
		//super();
		this.idMarca = idMarca;
		this.nome = nome;
		this.nrModelos = nrModelos;
		this.anoLancamento = anoLancamento;
		
	}

	@Override
	public String toString() {
		return "Marca [idMarca=" + idMarca + ", nome=" + nome + ", nrModelos=" + nrModelos + ", anoLancamento="
				+ anoLancamento + "]";
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

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}
	
	
	
	

	
		
}
