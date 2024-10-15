package com.ProjectoJavaSpring.jpa.JAVASPRING.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table  (name = "clientes")
@Data

public class Cliente {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(nullable = false, unique = true)
    private Long id;
    private String nombre;  
    private Integer ingresosMensuales;
    public Cliente(String nombre, Integer ingresosMensuales) {
        this.nombre = nombre;
        this.ingresosMensuales = ingresosMensuales;
    }

    public Cliente() {

    }
    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Motos> motos;
}
