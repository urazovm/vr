package ru.vashrekrut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.vashrekrut.config.cors.CorsConfig;
import ru.vashrekrut.config.database.JpaConfig;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		Thread.currentThread().setName("[Main thread]");
		SpringApplication.run(new Class<?>[] {MainApplication.class, JpaConfig.class, CorsConfig.class}, args);
	}
}
