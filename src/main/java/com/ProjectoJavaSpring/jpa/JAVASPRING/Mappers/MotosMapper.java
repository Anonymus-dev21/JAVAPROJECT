package com.ProjectoJavaSpring.jpa.JAVASPRING.Mappers;

import org.springframework.stereotype.Component;

import com.ProjectoJavaSpring.jpa.JAVASPRING.DTO.MotosDTO;
import com.ProjectoJavaSpring.jpa.JAVASPRING.model.Motos;

@Component

public class MotosMapper {
public static Motos toEntity(MotosDTO motosDTO) {
    if(motosDTO == null) {
        throw new RuntimeException("La moto DTO no puede ser nulo");
    }
    Motos motos = new Motos();
    motos.setMarca(motosDTO.getMarca());
    motos.setMatricula(motosDTO.getMatricula());
    motos.setModelo(motosDTO.getModelo());
    // motos.setStock(motosDTO.getStock());
    motos.setPrecio(motosDTO.getPrecio());
    motos.setCilindraje(motosDTO.getCilindraje());
    return motos;
}

public static MotosDTO toDTO(Motos motos) {
    if(motos == null) {
        throw new RuntimeException("La moto no puede ser nulo");
    }
    MotosDTO motosDTO = new MotosDTO();
    motosDTO.setMarca(motos.getMarca());
    motosDTO.setMatricula(motos.getMatricula());
    motosDTO.setModelo(motos.getModelo());
    // motosDTO.setStock(motos.getStock());
    motosDTO.setPrecio(motos.getPrecio());
    motosDTO.setCilindraje(motos.getCilindraje());
    return motosDTO;
}}
