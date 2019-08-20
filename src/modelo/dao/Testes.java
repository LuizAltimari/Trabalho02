package modelo.dao;

import java.text.SimpleDateFormat;

import modelo.Carro;
import modelo.Endereco;
import modelo.Marca;
import modelo.Proprietario;

public class Testes {

	public static void main(String[] args) {		
		ProprietarioDAO daoProp = new ProprietarioDAO();
		MarcaDAO daoMarc = new MarcaDAO();
		CarroDAO dao =  new CarroDAO();
		 Carro carro = new Carro("Luxo", "Preto", 2020, daoMarc.select(3), "68746846", daoProp.select("11111111111"), 400, 4, true, 8, true, 100, "11111111111", 3);
		
		//SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
//		if(dao.salvar(carro)) {
//			System.out.println("salvou!!");
//		}
//		else {
//			System.out.println("deu merda");
//		}
		
		System.out.println(dao.select("68746846").toString());
	}

}
