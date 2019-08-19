package modelo;
import java.util.Date;


//1)Implemente uma classe Propriet�rio
public class Proprietario {
	// 2)Declare os seguintes atributos na classe:
	private String nome;
	private String cpf;
	private String rg;
	private Date dataDeNascimento;
	//10)Altere a classe Propriet�rio para que o atributo Endere�o vire uma classe;
	private Endereco endereco;
	
	
	//4)Os atributos nome, cpf e rg s�o obrigat�rios (crie um construtor com esses par�metros)
	
	public Proprietario(String nome, String cpf, String rg, Endereco endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.endereco = endereco;
	}
	
	//3)Fa�a o encapsulamento dos atributos da classe Propriet�rio
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
