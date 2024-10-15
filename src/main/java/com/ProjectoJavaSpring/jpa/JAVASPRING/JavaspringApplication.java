package com.ProjectoJavaSpring.jpa.JAVASPRING;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ProjectoJavaSpring.jpa.JAVASPRING.Services.MotosServices;
import com.ProjectoJavaSpring.jpa.JAVASPRING.model.Motos;

@SpringBootApplication
public class JavaspringApplication implements CommandLineRunner{

	@Autowired
	private MotosServices motosServices;
	
	public static void main(String[] args) {
		SpringApplication.run(JavaspringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.motosServices.crearMotos(new Motos("Yamaha", "YBR", "123456", 125, 3000, 10));
		this.motosServices.crearMotos(new Motos("Yamaha", "Mt09", "123AB6", 890, 12500, 10));
		this.motosServices.crearMotos(new Motos("Corven", "Triax", "12BAC56", 150, 2200, 10));

System.out.println("MOTOS: " + this.motosServices.getAllMotos());
			System.out.println("MOTOS CILINDRADA 150:");
			for(Motos m : this.motosServices.findByCilindraje(150)) {
				System.out.println(m);
			}
		}
		

}
