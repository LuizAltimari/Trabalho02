package modelo;
import java.util.Date;


//1)Implemente uma classe Proprietário
public class Proprietario {
	// 2)Declare os seguintes atributos na classe:
	private String nome;
	private String cpf;
	private String rg;
	private Date dataDeNascimento;
	//10)Altere a classe Proprietário para que o atributo Endereço vire uma classe;
	private String cep;


	private Endereco endereco;	
	
	
	//4)Os atributos nome, cpf e rg são obrigatórios (crie um construtor com esses parâmetros)
	


	public Proprietario(String nome, String cpf, String rg,String cep, Endereco endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.endereco = endereco;
		this.cep = cep;
	}
	
	
	
	//3)Faça o encapsulamento dos atributos da classe Proprietário
	
	@Override
	public String toString() {
		return "Proprietario [nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", dataDeNascimento=" + dataDeNascimento
				+ ", cep=" + cep + ", endereco=" + endereco + "]";
	}



	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	
}
