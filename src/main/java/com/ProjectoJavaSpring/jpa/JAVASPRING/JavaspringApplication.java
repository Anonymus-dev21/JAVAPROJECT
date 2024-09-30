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
		List<Motos> motos =Arrays.asList(
			new Motos("Yamaha", "MT-07", "XYZ789", 700, 9000, 10),
			new Motos("Corven", "Triax", "ABC123", 150, 10000, 10));
        motosServices.crearMotos(motos);
		System.out.println("NOmbres funcionan?");
		
			for (Motos m : this.motosServices.getAllMotos()) {
				System.out.println(m);
			}

			System.out.println("MOTOS CILINDRADA 150:");
			for(Motos m : this.motosServices.findByCilindrada(150)) {
				System.out.println(m);
			}
		}
		

}
