package com.ProjectoJavaSpring.jpa.JAVASPRING.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.ProjectoJavaSpring.jpa.JAVASPRING.Repository.MotosRepository;
import com.ProjectoJavaSpring.jpa.JAVASPRING.model.Motos;

@Service
public class MotosServices {
@Autowired
private MotosRepository motosRepository;

public List<Motos> getAllMotos(){
    return motosRepository.findAll();
}

public List<Motos> findByCilindrada(int cilindrada) {
    return this.motosRepository.findByCilindrada(cilindrada);
}

public void crearMotos(List<Motos> motos) {
    for (Motos m : motos) {
        this.motosRepository.save(m);
    }
}}


