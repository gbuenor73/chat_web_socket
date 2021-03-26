package br.com.gbuenor.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "br.com.gbuenor.chat")
@EnableTransactionManagement
@EnableJpaRepositories
@EnableAutoConfiguration
@ComponentScan
public class DesafioChatApplication {

    public static void main(String[] args) {
        SpringApplication.run(DesafioChatApplication.class, args);
    }

}
