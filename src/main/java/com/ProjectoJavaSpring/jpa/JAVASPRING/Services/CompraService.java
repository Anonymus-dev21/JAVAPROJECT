package com.ProjectoJavaSpring.jpa.JAVASPRING.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import com.ProjectoJavaSpring.jpa.JAVASPRING.Repository.ClienteRepository;
import com.ProjectoJavaSpring.jpa.JAVASPRING.Repository.MotosRepository;
import com.ProjectoJavaSpring.jpa.JAVASPRING.model.Cliente;
import com.ProjectoJavaSpring.jpa.JAVASPRING.model.Motos;

@Service
public class CompraService {
@Autowired
private ClienteRepository clienteRepository;
@Autowired
private MotosRepository motosRepository;

public void  realizarCompra(Long clienteId, Integer motoId) {
        Optional<Motos> motoOptional = motosRepository.findById(motoId);
        if (!motoOptional.isPresent()) {
            throw new RuntimeException("Moto no encontrada con ID: " + motoId);
        }
        
        Motos moto = motoOptional.get();
        Cliente cliente;
        
        // Verifico si el cliente ya existe o creo uno nuevo
        Optional<Cliente> clienteOptional = clienteRepository.findById(clienteId);
        if (clienteOptional.isPresent()) {
            cliente = clienteOptional.get();
        } else {
          
            cliente = new Cliente("Cliente Nuevo", 5000);
            cliente = clienteRepository.save(cliente);  // Guarda el nuevo cliente
        }
        
        // Asociar la moto al cliente
        moto.setCliente(cliente);
        
        // Guardar la moto con la relación actualizada
        motosRepository.save(moto);
    }
}

