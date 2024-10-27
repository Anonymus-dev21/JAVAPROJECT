package com.ProjectoJavaSpring.jpa.JAVASPRING.DTO;

import lombok.Data;

@Data
public class ClienteDTO {
    private String name;  
    private Integer ingresosMensuales;
    private String email;
    private String   phone;
    
}
