package com.ProjectoJavaSpring.jpa.JAVASPRING.Services;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjectoJavaSpring.jpa.JAVASPRING.Repository.ClienteRepository;
import com.ProjectoJavaSpring.jpa.JAVASPRING.Repository.MotosRepository;
import com.ProjectoJavaSpring.jpa.JAVASPRING.model.Cliente;
import com.ProjectoJavaSpring.jpa.JAVASPRING.model.Motos;

@Service
public class ClienteService {
@Autowired 
private ClienteRepository clienteRepository;


    public List<Cliente> getAllClientes(){
        return clienteRepository.findAll();
    }
    public void crearCliente(Cliente cliente){
        this.clienteRepository.save(cliente);
    }
    
    public void actualizarIngresos( Long id, Integer nuevosIngresosMensuales){
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if(clienteOptional.isPresent()){
            Cliente cliente = clienteOptional.get();
            cliente.setIngresosMensuales(nuevosIngresosMensuales);
            clienteRepository.save(cliente);
        }  else {
           
            throw new RuntimeException("Cliente no encontrado con ID: " + id);
        }
    }

    public void delete(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if(clienteOptional.isPresent()){
            clienteRepository.deleteById(id);
        }  else {
           
            throw new RuntimeException("Cliente no encontrado con ID: " + id);
        }
    }}
