package com.ProjectoJavaSpring.jpa.JAVASPRING.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor

@Data
public class MotosDTO {
    private String marca;
    private String modelo;
    private String matricula;
    private int cilindraje;
    private int precio;
    
    
}
