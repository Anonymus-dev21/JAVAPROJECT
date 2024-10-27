package com.ProjectoJavaSpring.jpa.JAVASPRING.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

import com.ProjectoJavaSpring.jpa.JAVASPRING.DTO.MotosDTO;
import com.ProjectoJavaSpring.jpa.JAVASPRING.Mappers.MotosMapper;
import com.ProjectoJavaSpring.jpa.JAVASPRING.Repository.MotosRepository;
import com.ProjectoJavaSpring.jpa.JAVASPRING.model.Motos;

@Service
public class MotosServices {
@Autowired
private MotosRepository motosRepository;

public List<MotosDTO> getAllMotos(){
    List<Motos> motos = this.motosRepository.findAll();
    if(motos.isEmpty()) {
        throw new RuntimeException("No hay motos");
    }
    return motos.stream().map(moto -> MotosMapper.toDTO(moto)).collect(Collectors.toList());
}

public List<MotosDTO> findByCilindraje(int cilindraje) {
   
    List<Motos> motos = motosRepository.findByCilindraje(cilindraje);
    if(motos.isEmpty()) {
        throw new RuntimeException("No hay motos");
    }
    return motos.stream().map(moto -> MotosMapper.toDTO(moto)).collect(Collectors.toList());
}
public void crearMotos(MotosDTO motos) {
    Motos motoEntity = MotosMapper.toEntity(motos);
    if(motosRepository.existsByMatricula(motoEntity.getMatricula())) {
        throw new RuntimeException("La moto con dicha matrícula ya existe");
    } else {
       
        this.motosRepository.save(motoEntity);
    }
}}


