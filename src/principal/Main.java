package principal;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.Carro;
import modelo.Endereco;
import modelo.Marca;
import modelo.Proprietario;
import modelo.dao.CarroDAO;
import modelo.dao.EnderecoDAO;
import modelo.dao.MarcaDAO;
import modelo.dao.ProprietarioDAO;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n####################### BEM VINDO AO SISTEMA DE GERENCIAMENTO DE CARROS! #######################\n");
		String opcao = "s";
		do {
			System.out.println("O que deseja fazer?");
			System.out.println("[1] Cadastrar um propriet�rio \n " +
								"[2] Selecionar todos os propriet�rios \n" +
								"[3] Selecionar um propriet�rio espec�fico \n" +
								"[4] Atualizar um propriet�rio \n" +
								"[5] Remover um propriet�rio \n" +
								"[6] Cadastrar um carro" +
								"[7] Selecionar todos os carros \n" +
								"[8] Selecionar um carro espec�fico \n" +
								"[9] Atualizar um carro \n" +
								"[10] Remover um carro \n" +
								"[11] Casdastrar um endere�o \n" +
								"[12] Selecionar todos os endere�os \n" +
								"[13] Selecionar um endere�o espec�fico \n" +
								"[14] Atualizar um endere�o \n" +
								"[15] Remover um endere�o \n" +
								"[16] Cadastrar uma marca \n" +
								"[17] Selecionar todas as marcas \n" +
								"[18] Selecionar uma marca espec�fica \n" +
								"[19] Atualizar uma marca \n" +
								"[20] Remover uma marca \n" +
								"[0] Sair \n");
			System.out.print("Sua op��o: ");
			int op = sc.nextInt();
			switch(op) {
				case 1:
					cadastrarProprietario(sc);
					break;
				case 2:
					selecionarTodosProprietarios();
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					cadastrarCarro(sc);
					break;
				case 7:
					selecionarTodosProprietarios();
					break;
				case 8:
					break;
				case 9:
					break;
				case 10:
					break;
				case 11:
					cadastrarEndereco(sc);
					break;
				case 12:
					selecionarTodosEnderecos();
					break;
				case 13:
					break;
				case 14:
					break;
				case 15:
					break;
				case 16:
					cadastrarMarca(sc);
					break;
				case 17:
					selecionarTodasMarcas();
					break;
				case 18:
					break;
				case 19:
					break;
				case 20:
					break;
				default:
				
			}
			System.out.print("\n Deseja continuar (s/n): ");
			opcao = sc.nextLine();			
		} while(opcao.equals("s"));
		System.out.println("\n####################### OBRIGADO POR UTILIZAR O SISTEMA. VOLTE SEMPRE! #######################\n");
	}
	
	
	
	public static void cadastrarCarro(Scanner sc) {
		System.out.println("########### CADASTRANDO UM CARRO ########### \n\n");		
		String modelo, cor, chassi, cpf = "";
		int ano, nrPortas, nrMarchas, idMarca = 0;
		double velocidadeMaxima, volumeCombustivel = 0; 
		boolean tetoSolar, cambioAutomatico;
		Proprietario prop = null;
		Marca marc = null;
		CarroDAO dao = new CarroDAO();
		System.out.print("Insira o modelo: ");
		modelo = sc.nextLine();
		sc.nextLine();
		System.out.print("Insira o CPF do propriet�rio: ");
		cpf = sc.nextLine();
		sc.nextLine();
		System.out.print("Insira a cor: ");
		cor = sc.nextLine();
		sc.nextLine();
		System.out.print("Insira o chassi: ");
		chassi = sc.nextLine();
		sc.nextLine();
		System.out.print("Insira o ano do carro: ");
		ano = sc.nextInt();
		System.out.print("Insira o n�mero de portas: ");
		nrPortas = sc.nextInt();
		System.out.print("Insira o n�mero de marchas: ");
		nrMarchas = sc.nextInt();
		System.out.print("Insira a identifica��o da marca: ");
		idMarca = sc.nextInt();
		System.out.print("Insira a velocidade m�xima: ");
		velocidadeMaxima = sc.nextDouble();
		System.out.print("Insira volume do tanque de combust�vel: ");
		volumeCombustivel = sc.nextDouble();
		System.out.print("O carro possui teto solar? (true/false) ");
		tetoSolar = sc.nextBoolean();
		System.out.print("O carro possui c�mbio autom�tico? (true/false) ");
		cambioAutomatico = sc.nextBoolean();
				
		System.out.println("Deseja cadastrar um novo proriet�rio (com o CPF informado acima) ou utilizar um j� cadastrado (com o CPF informado acima)?");
		System.out.println("[1] Cadastrar \n"+
							"[2] J� cadastrado\n");
		int op = 0;
		do {
			System.out.print("Sua reposta: ");
			op = sc.nextInt();
			switch(op) {
				case 1:
					cadastrarProprietario(sc);
					prop = selecionarProprietario(cpf);
					break;
				case 2:
					prop = selecionarProprietario(cpf);
					break;
				default:
					System.out.println("Insira uma resposta v�lida.");			
			}
		} while ((op != 1) && (op != 2));		
		
		
		System.out.println("Deseja cadastrar uma nova marca (com a identifica��o de marca informada acima) ou utilizar um j� cadastrado (com a identifica��o de marca informada acima)?");
		System.out.println("[1] Cadastrar \n"+
							"[2] J� cadastrado\n");
		int op2 = 0;
		do {
			System.out.print("Sua reposta: ");
			op2 = sc.nextInt();
			switch(op2) {
				case 1:
					cadastrarMarca(sc);
					marc = selecionarMarca(idMarca);
					break;
				case 2:
					marc = selecionarMarca(idMarca);
					break;
				default:
					System.out.println("Insira uma resposta v�lida.");			
			}
		} while ((op2 != 1) && (op2 != 2));
		
		Carro c = new Carro(modelo, cor, ano, marc, chassi, prop, velocidadeMaxima, nrPortas, tetoSolar, nrMarchas, cambioAutomatico, volumeCombustivel, cpf, idMarca);
		if(dao.salvar(c)) {
			System.out.println("CARRO CADASTRADO COM SUCESSO \n\n");
		}else {
			System.out.println("ERRO AO CADASTRAR O CARRO \n\n");
		}
	}
	
	public static void atualizarCarro(Carro c, Scanner sc) {
		System.out.println("########### CADASTRANDO UM CARRO ########### \n\n");		
		String modelo, cor, chassi, cpf = "";
		int ano, nrPortas, nrMarchas, idMarca = 0;
		double velocidadeMaxima, volumeCombustivel = 0; 
		boolean tetoSolar, cambioAutomatico;
		Proprietario prop = null;
		Marca marc = null;
		CarroDAO dao = new CarroDAO();
		System.out.print("Insira o modelo: ");
		modelo = sc.nextLine();
		sc.nextLine();
		System.out.print("Insira o CPF do propriet�rio: ");
		cpf = sc.nextLine();
		sc.nextLine();
		System.out.print("Insira a cor: ");
		cor = sc.nextLine();
		sc.nextLine();
		System.out.print("Insira o chassi: ");
		chassi = sc.nextLine();
		sc.nextLine();
		System.out.print("Insira o ano do carro: ");
		ano = sc.nextInt();
		System.out.print("Insira o n�mero de portas: ");
		nrPortas = sc.nextInt();
		System.out.print("Insira o n�mero de marchas: ");
		nrMarchas = sc.nextInt();
		System.out.print("Insira a identifica��o da marca: ");
		idMarca = sc.nextInt();
		System.out.print("Insira a velocidade m�xima: ");
		velocidadeMaxima = sc.nextDouble();
		System.out.print("Insira volume do tanque de combust�vel: ");
		volumeCombustivel = sc.nextDouble();
		System.out.print("O carro possui teto solar? (true/false) ");
		tetoSolar = sc.nextBoolean();
		System.out.print("O carro possui c�mbio autom�tico? (true/false) ");
		cambioAutomatico = sc.nextBoolean();
				
		System.out.println("Deseja cadastrar um novo proriet�rio (com o CPF informado acima) ou utilizar um j� cadastrado (com o CPF informado acima)?");
		System.out.println("[1] Cadastrar \n"+
							"[2] J� cadastrado\n");
		int op = 0;
		do {
			System.out.print("Sua reposta: ");
			op = sc.nextInt();
			switch(op) {
				case 1:
					cadastrarProprietario(sc);
					prop = selecionarProprietario(cpf);
					break;
				case 2:
					prop = selecionarProprietario(cpf);
					break;
				default:
					System.out.println("Insira uma resposta v�lida.");			
			}
		} while ((op != 1) && (op != 2));		
		
		
		System.out.println("Deseja cadastrar uma nova marca (com a identifica��o de marca informada acima) ou utilizar um j� cadastrado (com a identifica��o de marca informada acima)?");
		System.out.println("[1] Cadastrar \n"+
							"[2] J� cadastrado\n");
		int op2 = 0;
		do {
			System.out.print("Sua reposta: ");
			op2 = sc.nextInt();
			switch(op2) {
				case 1:
					cadastrarMarca(sc);
					marc = selecionarMarca(idMarca);
					break;
				case 2:
					marc = selecionarMarca(idMarca);
					break;
				default:
					System.out.println("Insira uma resposta v�lida.");			
			}
		} while ((op2 != 1) && (op2 != 2));
		
		 c = new Carro(modelo, cor, ano, marc, chassi, prop, velocidadeMaxima, nrPortas, tetoSolar, nrMarchas, cambioAutomatico, volumeCombustivel, cpf, idMarca);
		if(dao.alterar(c)) {
			System.out.println("CARRO ATUALIZADO COM SUCESSO \n\n");
		}else {
			System.out.println("ERRO AO ATUALIZAR O CARRO \n\n");
		}
	}
	
	
	public static ArrayList<Carro> selecionarTodosCarros(){
		CarroDAO dao = new CarroDAO();
		ArrayList<Carro> carros  = dao.selectAll();
		return carros;
	}
	
	public static Carro selecionarCarro(String chassi) {
		CarroDAO dao = new CarroDAO();
		Carro carro = dao.select(chassi);
		return carro;
	}
	
	
	public static void removerCarro(String chassi) {
		CarroDAO dao = new CarroDAO();
		if(dao.remover(chassi)) {
			System.out.println("CARRO REMOVIDO COM SUCESSO");
		}
		else {
			System.out.println("ERRO AO REMOVER CARRO");
		}
	}
	
	
	public static void cadastrarEndereco(Scanner sc) {
		System.out.println("########### CADASTRANDO UM ENDERE�O ########### \n\n");
		
		Endereco endereco = new Endereco();
		EnderecoDAO dao = new EnderecoDAO();
		
		
		System.out.print("Insira a rua: ");
		endereco.setRua(sc.nextLine());
		sc.nextLine();
		System.out.print("Insira o bairro: ");
		endereco.setBairro(sc.nextLine());
		sc.nextLine();
		System.out.print("Insira o CEP: ");
		endereco.setCep(sc.nextLine());
		sc.nextLine();
		System.out.print("Insira a cidade: ");
		endereco.setCidade(sc.nextLine());
		sc.nextLine();
		System.out.print("Insira o complemento: ");
		endereco.setRua(sc.nextLine());
		sc.nextLine();
		
		if(dao.salvar(endereco)) {
			System.out.println("ENDERE�O CADASTRADO COM SUCESSO \n\n");
		}else {
			System.out.println("ERRO AO CADASTRAR O ENDERE�O \n\n");
		}
	}
	
	public static void atualizarEndereco(Endereco endereco, Scanner sc) {
		System.out.println("########### ATUALIZANDO UMA MARCA DE CARRO ########### \n\n");
		
		
		EnderecoDAO dao = new EnderecoDAO();
		
		
		System.out.print("Insira a nova rua: ");
		endereco.setRua(sc.nextLine());
		sc.nextLine();
		System.out.print("Insira o novo bairro: ");
		endereco.setBairro(sc.nextLine());
		sc.nextLine();
		System.out.print("Insira o novo CEP: ");
		endereco.setCep(sc.nextLine());
		sc.nextLine();
		System.out.print("Insira a nova cidade: ");
		endereco.setCidade(sc.nextLine());
		sc.nextLine();
		System.out.print("Insira o novo complemento: ");
		endereco.setRua(sc.nextLine());
		sc.nextLine();
		
		if(dao.salvar(endereco)) {
			System.out.println("ENDERE�O ATUALIZADO COM SUCESSO \n\n");
		}else {
			System.out.println("ERRO AO ATUALIZAR O ENDERE�O \n\n");
		}
	}
	
	public static ArrayList<Endereco> selecionarTodosEnderecos(){
		EnderecoDAO dao = new EnderecoDAO();
		ArrayList<Endereco> enderecos = dao.selectAll();
		return enderecos;
	}
	
	public static Endereco selecionarEndereco(String cep) {
		EnderecoDAO dao = new EnderecoDAO();
		Endereco endereco = dao.select(cep);
		return endereco;
	}

	
	public static void removerEndereco(String cep) {
		EnderecoDAO dao = new EnderecoDAO();
		if(dao.remover(cep)) {
			System.out.println("ENDERE�O REMOVIDO COM SUCESSO");
		}
		else {
			System.out.println("ERRO AO REMOVER ENDERE�O");
		}
	}
	
	
	public static void cadastrarProprietario(Scanner sc) {
		System.out.println("########### CADASTRANDO UM PROPRIET�RIO ########### \n\n");		
		String nome, cpf, rg, cep = "";
		Endereco end = null;
		ProprietarioDAO dao = new ProprietarioDAO();
		System.out.print("Insira o nome: ");
		nome = sc.nextLine();
		sc.nextLine();
		System.out.print("Insira o CPF: ");
		cpf = sc.nextLine();
		sc.nextLine();
		System.out.print("Insira o RG: ");
		rg = sc.nextLine();
		sc.nextLine();
		System.out.print("Insira o CEP: ");
		cep = sc.nextLine();
		sc.nextLine();
		
		System.out.println("Deseja cadastrar um novo endere�o (com o CEP informado acima) ou utilizar um j� cadastrado (com o CEP informado acima)?)");
		System.out.println("[1] Cadastrar \n"+
							"[2] J� cadastrado\n");
		int op = 0;
		do {
			System.out.print("Sua reposta: ");
			op = sc.nextInt();
			switch(op) {
				case 1:
					cadastrarEndereco(sc);
					end = selecionarEndereco(cep);
					break;
				case 2:
					end = selecionarEndereco(cep);
					break;
				default:
					System.out.println("Insira uma resposta v�lida.");			
			}
		} while ((op != 1) && (op != 2));		
		
		
		Proprietario prop = new Proprietario(nome, cpf, rg, cep, end);
		if(dao.salvar(prop)) {
			System.out.println("PROPRIET�RIO CADASTRADO COM SUCESSO \n\n");
		}else {
			System.out.println("ERRO AO CADASTRAR O PROPRIET�RIO \n\n");
		}
	}
	
	public static void atualizarProprietario(Proprietario prop, Scanner sc) {
		System.out.println("########### ATUALIZANDO UM PROPRIET�RIO ########### \n\n");		
		String nome, cpf, rg, cep = "";
		Endereco end = null;
		ProprietarioDAO dao = new ProprietarioDAO();
		System.out.print("Insira o novo nome: ");
		nome = sc.nextLine();
		sc.nextLine();
		System.out.print("Insira o novo CPF: ");
		cpf = sc.nextLine();
		sc.nextLine();
		System.out.print("Insira o novo RG: ");
		rg = sc.nextLine();
		sc.nextLine();
		System.out.print("Insira o novo CEP: ");
		cep = sc.nextLine();
		sc.nextLine();
		
		System.out.println("Deseja cadastrar um novo endere�o (com o CEP informado acima) ou utilizar um j� cadastrado (com o CEP informado acima)?)");
		System.out.println("[1] Cadastrar \n"+
							"[2] J� cadastrado\n");
		int op = 0;
		do {
			System.out.print("Sua reposta: ");
			op = sc.nextInt();
			switch(op) {
				case 1:
					cadastrarEndereco(sc);
					end = selecionarEndereco(cep);
					break;
				case 2:
					end = selecionarEndereco(cep);
					break;
				default:
					System.out.println("Insira uma resposta v�lida.");			
			}
		} while ((op != 1) && (op != 2));		
		
		
		prop = new Proprietario(nome, cpf, rg, cep, end);
		if(dao.alterar(prop)) {
			System.out.println("PROPRIET�RIO ATUALIZADO COM SUCESSO \n\n");
		}else {
			System.out.println("ERRO AO ATUALIZAR O PROPRIET�RIO \n\n");
		}
	}
	
	public static ArrayList<Proprietario> selecionarTodosProprietarios(){
		ProprietarioDAO dao = new ProprietarioDAO();
		ArrayList<Proprietario> props = dao.selectAll();
		return props;
	}
	
	public static Proprietario selecionarProprietario(String cpf) {
		ProprietarioDAO dao = new ProprietarioDAO();
		Proprietario prop = dao.select(cpf);
		return prop;
	}
	
	
	public static void removerProprietario(String cpf) {
		ProprietarioDAO dao = new ProprietarioDAO();
		if(dao.remover(cpf)) {
			System.out.println("PROPRIET�RIO REMOVIDO COM SUCESSO");
		}
		else {
			System.out.println("ERRO AO REMOVER PROPRIET�RIO");
		}
	}
	
	
	public static void cadastrarMarca(Scanner sc) {
		System.out.println("########### CADASTRANDO UMA MARCA DE CARRO ########### \n\n");
		Marca marca = new Marca();
		MarcaDAO dao = new MarcaDAO();
		System.out.print("Insira o nome da marca: ");
		marca.setNome(sc.nextLine());
		sc.nextLine();
		System.out.print("Insira o numero de modelos da marca: ");
		marca.setNrModelos(sc.nextInt());
		System.out.print("Insira o ano de lan�amento da marca: ");
		marca.setAnoLancamento(sc.nextInt());
		
		if(dao.salvar(marca)) {
			System.out.println("MARCA CADASTRADA COM SUCESSO \n\n");
		}else {
			System.out.println("ERRO AO CADASTRAR A MARCA \n\n");
		}
	}
	
	public static void atualizarMarca(Marca marca, Scanner sc) {
		System.out.println("########### ATUALIZANDO UMA MARCA DE CARRO ########### \n\n");
		
		System.out.print("Insira o novo nome da marca: ");
		marca.setNome(sc.nextLine());
		sc.nextLine();
		System.out.print("Insira o novo numero de modelos da marca: ");
		marca.setNrModelos(sc.nextInt());
		System.out.print("Insira o novo ano de lan�amento da marca: ");
		marca.setAnoLancamento(sc.nextInt());
		
		MarcaDAO dao = new MarcaDAO();
		if(dao.alterar(marca)) {
			System.out.println("MARCA ALTERADA COM SUCESSO \n\n");
		}else {
			System.out.println("ERRO AO ALTERAR A MARCA \n\n");
		}
	}
	
	public static ArrayList<Marca> selecionarTodasMarcas(){
		MarcaDAO dao = new MarcaDAO();
		ArrayList<Marca> marcas = dao.selectAll();
		return marcas;
	}
	
	public static Marca selecionarMarca(int idMarca) {
		MarcaDAO dao = new MarcaDAO();
		Marca marca = dao.select(idMarca);
		return marca;
	}

	public static void removerMarca(int idMarca) {
		MarcaDAO dao = new MarcaDAO();
		if(dao.remover(idMarca)) {
			System.out.println("MARCA REMOVIDA COM SUCESSO");
		}
		else {
			System.out.println("ERRO AO REMOVER MARCA");
		}
	}
}
