package modelo;



//5)Implemente uma classe Carro
public class Carro {
	//6)Declare os seguintes atributos na classe:
	private String modelo;
	private String cor;
	private int ano;
	//15)Transforme o atributo Marca de um carro em uma classe Marca com nome, nrDeModelos, ano de lan�amento e c�digo identificador.
	private Marca marca;
	private String chassi;
	private Proprietario proprietario;
	private double velocidadeMaxima; //em Km/h
	private double velocidadeAtual = 0; //em Km/h
	private int nrPortas;
	private boolean tetoSolar;
	private int nrMarchas;
	private int marchaAtual;
	private boolean cambioAutomatico;
	private double volumeCombustivel; //em litros
	private String cpf;
	private int idMarca;
	
	//12)Todo ve�culo tem um propriet�rio obrigatoriamente (implemente um construtor de ve�culo passando o propriet�rio como par�metro);
	public Carro(Proprietario proprietario) {
		this.proprietario = proprietario;
	}


	public Carro(String modelo, String cor, int ano, Marca marca, String chassi, Proprietario proprietario,
			double velocidadeMaxima, int nrPortas, boolean tetoSolar, int nrMarchas,
			boolean cambioAutomatico, double volumeCombustivel, String cpf, int idMarca) {
		
		this.modelo = modelo;
		this.cor = cor;
		this.ano = ano;
		this.marca = marca;
		this.chassi = chassi;
		this.proprietario = proprietario;
		this.velocidadeMaxima = velocidadeMaxima;		
		this.nrPortas = nrPortas;
		this.tetoSolar = tetoSolar;
		this.nrMarchas = nrMarchas;
		this.cambioAutomatico = cambioAutomatico;
		this.volumeCombustivel = volumeCombustivel;
		this.cpf = cpf;
		this.idMarca = idMarca;
	}


	
	//7)Fa�a o encapsulamento da classe Carro e seus atributos
	
	@Override
	public String toString() {
		return "Carro [modelo=" + modelo + ", cor=" + cor + ", ano=" + ano + ", marca=" + marca + ", chassi=" + chassi
				+ ", proprietario=" + proprietario + ", velocidadeMaxima=" + velocidadeMaxima + ", velocidadeAtual="
				+ velocidadeAtual + ", nrPortas=" + nrPortas + ", tetoSolar=" + tetoSolar + ", nrMarchas=" + nrMarchas
				+ ", marchaAtual=" + marchaAtual + ", cambioAutomatico=" + cambioAutomatico + ", volumeCombustivel="
				+ volumeCombustivel + ", cpf=" + cpf + ", idMarca=" + idMarca + "]";
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}	


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public int getIdMarca() {
		return idMarca;
	}


	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}


	public String getCor() {
		return cor;
	}


	public void setCor(String cor) {
		this.cor = cor;
	}


	public int getAno() {
		return ano;
	}


	public void setAno(int ano) {
		this.ano = ano;
	}


	public Marca getMarca() {
		return marca;
	}


	public void setMarca(Marca marca) {
		this.marca = marca;
	}


	public String getChassi() {
		return chassi;
	}


	public void setChassi(String chassi) {
		this.chassi = chassi;
	}


	public Proprietario getProprietario() {
		return proprietario;
	}


	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}


	public double getVelocidadeMaxima() {
		return velocidadeMaxima;
	}


	public void setVelocidadeMaxima(double velocidadeMaxima) {
		this.velocidadeMaxima = velocidadeMaxima;
	}


	public double getVelocidadeAtual() {
		return velocidadeAtual;
	}


	public void setVelocidadeAtual(double velocidadeAtual) {
		this.velocidadeAtual = velocidadeAtual;
	}


	public int getNrPortas() {
		return nrPortas;
	}


	public void setNrPortas(int nrPortas) {
		this.nrPortas = nrPortas;
	}


	public boolean isTetoSolar() {
		return tetoSolar;
	}


	public void setTetoSolar(boolean tetoSolar) {
		this.tetoSolar = tetoSolar;
	}


	public int getNrMarchas() {
		return nrMarchas;
	}


	public void setNrMarchas(int nrMarchas) {
		this.nrMarchas = nrMarchas;
	}

	public int getMarchaAtual() {
		return this.marchaAtual;
	}
	public boolean isCambioAutomatico() {
		return cambioAutomatico;
	}


	public void setCambioAutomatico(boolean cambioAutomatico) {
		this.cambioAutomatico = cambioAutomatico;
	}


	public double getVolumeCombustivel() {
		return volumeCombustivel;
	}


	public void setVolumeCombustivel(double volumeCombustivel) {
		this.volumeCombustivel = volumeCombustivel;
	}
	
	// 8)Implemente o m�todo acelera que aumenta a velocidade de 1 em 1 km/h
	
	public void aumentaVelocidade() {
		if(this.velocidadeAtual < this.velocidadeMaxima) {
			this.velocidadeAtual++;
		}
		else {
			//Criar exce��o de limite de velocidade
			System.out.println("Voc� j� atingiu a velocidade m�xima!");
		}
		
	}
	
	//9)Implemente o m�todo freia que para o carro � Velocidade = 0 km/h
	
	public void freia() {
		this.velocidadeAtual = 0;
	}

//	12)Implemete o m�todo troca marcha;
	public void trocaMarcha(int marcha) {
		if (marcha <= this.nrMarchas) {
			this.marchaAtual = marcha;
			System.out.println("Marcha atual: " + this.marchaAtual + "� Velocidade atual: " + this.velocidadeAtual + "km/h");
		}
		else {
			System.out.println("N�mero de marcha inv�lida!");
		}
	}
//	13)Implemente o m�todo reduz a marcha;
	
	public void reduzMarcha(int indice) {
		if(this.marchaAtual <= indice) {
			System.out.println("N�o � poss�vel reduzir tanto assim!");
		}
		else {
			this.marchaAtual -= indice;
		} 
	}

//	14)A marcha r� nao pode ser engatada se o a velocidade for superior a 0 KM/h;
	
	public void marchaRe() {
		if (this.velocidadeAtual > 0) {
			System.out.println("Reduza a velocidade a 0km/h para fazer a marcha r�.");
		}
		else {
			System.out.println("Fazendo a marcha r�.");
		}
	}
}
