package com.ProjectoJavaSpring.jpa.JAVASPRING.Mappers;

import org.springframework.stereotype.Component;

import com.ProjectoJavaSpring.jpa.JAVASPRING.DTO.ClienteDTO;
import com.ProjectoJavaSpring.jpa.JAVASPRING.model.Cliente;

@Component
public class ClienteMapper {
    public static ClienteDTO toDTO(Cliente cliente) {
        if(cliente == null) {    
           throw new RuntimeException("El cliente  no puede ser nulo");
        }
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setName(cliente.getName());
        clienteDTO.setIngresosMensuales(cliente.getIngresosMensuales());
        clienteDTO.setEmail(cliente.getEmail());
        clienteDTO.setPhone(cliente.getPhone());
        return clienteDTO;
    }
    public static  Cliente toEntity(ClienteDTO clienteDTO) {
        if(clienteDTO == null) {
            throw new RuntimeException("El cliente DTO no puede ser nulo");
        }
        Cliente cliente = new Cliente();
        cliente.setName(clienteDTO.getName());
        cliente.setIngresosMensuales(clienteDTO.getIngresosMensuales());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setPhone(clienteDTO.getPhone());
        return cliente;

    }
}
