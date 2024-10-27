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

public void  realizarCompra(Long clienteId, Integer motoId, Integer ingresosMensuales, String name, String email, String phone) {
        Optional<Motos> motoOptional = motosRepository.findById(motoId);
        if (!motoOptional.isPresent()) {
            throw new RuntimeException("Moto no encontrada con ID: " + motoId);
        }
        
        Motos moto = motoOptional.get();
        Cliente cliente;
        if (moto.getCliente() != null) {
            throw new RuntimeException("La moto: " + moto.getMarca() + " " + moto.getModelo() + " " + " " + moto.getCilindraje() + " ya ha sido comprada");
        }
        // if(moto.getStock() <= 0) {
        //     throw new RuntimeException("No hay stock disponible para la moto con ID: " + motoId);
        // }
        
        // Verifico si el cliente ya existe o creo uno nuevo
        Optional<Cliente> clienteOptional = clienteRepository.findById(clienteId);
        
        if (clienteOptional.isPresent())  {
            cliente = clienteOptional.get();
            
        } else {
            if(ingresosMensuales == null || name == null  || email == null || phone == null) {
                throw new RuntimeException("Los datos del cliente son obligatorios: name, email, phone, ingresosMensuales");
            }
            cliente = new Cliente(name, ingresosMensuales, email, phone);
            cliente = clienteRepository.save(cliente);  // Guarda el nuevo cliente
        }
       
        if( cliente.getIngresosMensuales() < 1000){
            throw new RuntimeException("El cliente no tiene el presupuesto suficiente para cualificar como comprador de la moto: " + moto.getMarca() + " " + moto.getModelo() + " " + " " + moto.getCilindraje());
        }
        moto.setCliente(cliente);
        // moto.setStock(moto.getStock() - 1);
        cliente.agregarMoto(moto);
        motosRepository.save(moto);
    }
}

