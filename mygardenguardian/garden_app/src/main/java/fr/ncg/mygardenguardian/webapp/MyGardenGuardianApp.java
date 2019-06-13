package fr.ncg.mygardenguardian.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "fr.ncg.mygardenguardian")
@ComponentScan(basePackages = "fr.ncg.mygardenguardian")
@EntityScan(basePackages = "fr.ncg.mygardenguardian")
public class MyGardenGuardianApp {// extends SpringBootServletInitializer {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		SpringApplication.run(MyGardenGuardianApp.class);
	}
}
