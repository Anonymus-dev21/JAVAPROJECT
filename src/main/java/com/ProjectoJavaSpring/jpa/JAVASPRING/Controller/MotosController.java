package com.ProjectoJavaSpring.jpa.JAVASPRING.Controller;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ProjectoJavaSpring.jpa.JAVASPRING.DTO.MotosDTO;
import com.ProjectoJavaSpring.jpa.JAVASPRING.Services.MotosServices;
import com.ProjectoJavaSpring.jpa.JAVASPRING.model.Motos;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/motos")
public class MotosController {
@Autowired
MotosServices motosServices;


    /**
     * @return a list of all motos stored in the database
     * 
     * @throws RuntimeException if any error occurs during the operation
     */
@GetMapping("/all")
 @Operation(summary = "Petición de todas las motos", description = "Devuelve una lista de todas las motos")
        @ApiResponse(responseCode = "200", description = "La lista de motos se obtuvo exitosamente")
        @ApiResponse(responseCode = "400", description = "Posiblemente no haya motos") 
public ResponseEntity<?> getAllMotos(){
    try{
        List<MotosDTO> motos = this.motosServices.getAllMotos();
        return ResponseEntity.ok().body(motos);
    } catch(RuntimeException e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
    }
}
@PostMapping("/newMoto")
@Operation(summary = "Crear una moto    ", description = "Debes pasarle el cuerpo de la moto que deseas crear con marca, modelo, cilindraje, matricula y precio")
@ApiResponse(responseCode = "200", description = "La moto se ha creado exitosamente")
@ApiResponse(responseCode = "400", description = "Error al crear la moto") 
public ResponseEntity<?> crearMotos(@RequestBody MotosDTO moto){
    try{
        this.motosServices.crearMotos(moto);
        return ResponseEntity.ok().body("moto creada " + moto);
    } catch(RuntimeException e){
        return ResponseEntity.status(500).body("Error: " + e.getMessage());
    }
}

@GetMapping("/cilindraje")
@Operation(summary = "Filtrar motos por cilindraje", description = "Ingresa una cilindrada de moto y la filtrara por el cilindraje que ingresaste")
@ApiResponse(responseCode = "200", description = "La lista de motos se obtuvo exitosamente")
@ApiResponse(responseCode = "400", description = "Posiblemente no haya motos de dicha cilindrada") 
public ResponseEntity<?> findByCilindraje(@RequestParam int cilindraje){
    try{
        List<MotosDTO> motosDeCilindraje = this.motosServices.findByCilindraje(cilindraje);
        return ResponseEntity.ok().body("Motos de cilindrada: " + motosDeCilindraje);
    } catch(RuntimeException e){
        return ResponseEntity.status(500).body("Error: " + e.getMessage());
    }
}
}
