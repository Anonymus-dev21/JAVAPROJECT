package com.ProjectoJavaSpring.jpa.JAVASPRING.model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table  (name = "motos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Motos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String marca;
    @Column(nullable = false)
    private String modelo;
    @Column(nullable = false, unique = true)
    private String matricula;
    private int cilindraje;
    
    private int precio;
    
    public Motos(String marca, String modelo, String matricula, int cilindraje, int precio ) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.cilindraje = cilindraje;
        this.precio = precio;
       
    }

    @Override
    public String toString() {
        return "Motos [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", matricula=" + matricula
                + ", cilindraje=" + cilindraje + ", precio=" + precio + "]";
    } 
    @ManyToOne(fetch = FetchType.EAGER)
     @JsonBackReference
    private Cliente cliente;
}
