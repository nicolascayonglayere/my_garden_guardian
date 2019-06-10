package fr.ncg.mygardenguardian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import fr.ncg.App;

@SpringBootApplication
public class MyGardenGuardianApp extends SpringBootServletInitializer {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		SpringApplication.run(App.class);
	}
}
