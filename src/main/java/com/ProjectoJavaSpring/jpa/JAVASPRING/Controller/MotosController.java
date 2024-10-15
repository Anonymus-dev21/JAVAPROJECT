package com.ProjectoJavaSpring.jpa.JAVASPRING.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProjectoJavaSpring.jpa.JAVASPRING.Services.MotosServices;
import com.ProjectoJavaSpring.jpa.JAVASPRING.model.Motos;

@RestController
@RequestMapping("/motos")
public class MotosController {
@Autowired
MotosServices motosServices;

@RequestMapping("/all")
public List<Motos> getAllMotos(){
    return this.motosServices.getAllMotos();
}
@RequestMapping("/newMoto")
public ResponseEntity<?> crearMotos(@RequestBody Motos moto){
    this.motosServices.crearMotos(moto);
    return ResponseEntity.ok().body("moto creada " + moto);
}
}
