package br.com.erudio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author Edilson
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class Startup {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Startup.class, args);
		
		/*
		 * BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(16);
		 * String senha = "admin123"; 
		 * String senhaCriptografada =
		 * bCryptPasswordEncoder.encode(senha); System.out.println(senhaCriptografada);
		 */
	}
}
