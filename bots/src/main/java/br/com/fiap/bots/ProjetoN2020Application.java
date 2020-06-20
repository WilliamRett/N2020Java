package br.com.fiap.bots;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "br.com.fiap.bots.repository")
@SpringBootApplication
public class ProjetoN2020Application {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoN2020Application.class, args);
	}
	

}
