package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
    public class GestaoFinanceiraApplication {
        //É ESSE AQUI MESMO!
	public static void main(String[] args) {
		SpringApplication.run(GestaoFinanceiraApplication.class, args);
                System.out.println(new BCryptPasswordEncoder().encode("123456"));
	}

}
