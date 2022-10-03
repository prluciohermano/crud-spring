package com.prluciohermano.crudspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.prluciohermano.crudspring.model.Produto;
import com.prluciohermano.crudspring.repository.ProdutoRepository;

@SpringBootApplication
public class GarageControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(GarageControlApplication.class, args);
	}

	@Bean
	CommandLineRunner initDtaBase(ProdutoRepository produtoRepository) {
		return args -> {
			produtoRepository.deleteAll();

			Produto p = new Produto();
			p.setDescricao("NovoFox Pepper");
			p.setAnoModelo("2022");
			p.setCorProduto("Vermelho");
			p.setPrecoEntrada(45865.25);
			p.setCategoria("Hatch");

			produtoRepository.save(p);

			Produto p2 = new Produto();
			p2.setDescricao("Fuscão 1600cc");
			p2.setAnoModelo("1980");
			p2.setCorProduto("Preto");
			p2.setPrecoEntrada(25000.25);
			p2.setCategoria("Hatch");

			produtoRepository.save(p2);
		};
	}
	
}
