package com.ProjectoJavaSpring.jpa.JAVASPRING.model;


import java.util.List;

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
    private int stock;
    private int precio;
    
    public Motos(String marca, String modelo, String matricula, int cilindraje, int precio, int stock) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.cilindraje = cilindraje;
        this.precio = precio;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Motos [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", matricula=" + matricula
                + ", cilindraje=" + cilindraje + ", precio=" + precio + ", stock=" + stock + "]";
    } 
    @ManyToOne(fetch = FetchType.EAGER)
    private Cliente cliente;
}
