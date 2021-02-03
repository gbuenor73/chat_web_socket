package br.com.tupinamba.desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "br.com.tupinamba.desafio")
@EnableTransactionManagement
@EnableJpaRepositories
public class DesafioChatApplication {

    public static void main(String[] args) {
        SpringApplication.run(DesafioChatApplication.class, args);
    }

}
