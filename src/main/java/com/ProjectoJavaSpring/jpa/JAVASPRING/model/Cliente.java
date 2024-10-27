package com.ProjectoJavaSpring.jpa.JAVASPRING.model;




import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import java.util.ArrayList;
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
    private String name;  
    private Integer ingresosMensuales;
    private String email;
    private String phone;
    public Cliente(String name ,Integer ingresosMensuales, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.ingresosMensuales = ingresosMensuales;
    }

    public Cliente() {

    }
    
    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER,  cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonManagedReference
    private List<Motos> motos = new ArrayList<>();

    public void agregarMoto(Motos moto) {
        this.motos.add(moto);
        moto.setCliente(this);
    }
}
