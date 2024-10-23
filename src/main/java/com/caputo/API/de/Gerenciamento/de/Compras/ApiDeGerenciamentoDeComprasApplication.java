package com.caputo.API.de.Gerenciamento.de.Compras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@EntityScan(basePackages = "com.caputo.API.de.Gerenciamento.de.Compras.model.entities")
@SpringBootApplication
public class ApiDeGerenciamentoDeComprasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiDeGerenciamentoDeComprasApplication.class, args);
	}

}
