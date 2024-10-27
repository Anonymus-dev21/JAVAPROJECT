package com.ProjectoJavaSpring.jpa.JAVASPRING;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.ProjectoJavaSpring.jpa.JAVASPRING.DTO.MotosDTO;
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
		// Crear las motos con MotoDTO
		MotosDTO moto1 = new MotosDTO("Yamaha", "YBR", "123456", 125, 3000);
		MotosDTO moto2 = new MotosDTO("Yamaha", "Mt09", "123AB6", 890, 12500);
		MotosDTO moto3 = new MotosDTO("Corven", "Triax", "12BAC56", 150, 2200);
	
		// Llamar al servicio para guardar cada moto
		this.motosServices.crearMotos(moto1);
		this.motosServices.crearMotos(moto2);
		this.motosServices.crearMotos(moto3);
		List<MotosDTO> motosCilindraje150 = this.motosServices.findByCilindraje(125
		);
		
		if (motosCilindraje150.isEmpty()) {
			System.out.println("No se encontraron motos de dicha cilindrada");
		} else {
			for(MotosDTO m : motosCilindraje150) {
				System.out.println(m);
			}
		}}
		

}
