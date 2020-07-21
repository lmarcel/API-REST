package br.com.lmarcel.ustorechallenge.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lmarcel.ustorechallenge.domain.Produto;
import br.com.lmarcel.ustorechallenge.repositories.ProdutoRepository;


@Service
public class DBService {
	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	
	public void instantiateTestDatabase() throws ParseException {
		
		Produto p1 = new Produto(null, "Computador", 2500.00,"Informática");
		Produto p2 = new Produto(null, "Impressora", 800.00, "Informática");
		Produto p3 = new Produto(null, "Teclado", 80.0, "Informática");
		Produto p4 = new Produto(null, "Mesa de escritório", 300.00, "Escritório");
		Produto p5 = new Produto(null, "Toalha", 50.00, "Cama mesa e banho");
		Produto p6 = new Produto(null, "Colchão", 400.00, "Cama mesa e banho");
		Produto p7 = new Produto(null, "TV 42 polegadas", 1200.00, "Eletrônicos");
		Produto p8 = new Produto(null, "Bicicleta", 1800.00, "Esporte e Lazer");
		Produto p9 = new Produto(null, "Cortinas", 100.00, "Decoração");
		Produto p10 = new Produto(null, "Creme para pele", 80.00, "Perfumaria");
		Produto p11 = new Produto(null, "Shampoo", 90.00, "Perfumaria");
	
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3, p4, p5, p6, p7, p8, p9, p10, p11));
	}




}
