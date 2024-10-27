package com.ProjectoJavaSpring.jpa.JAVASPRING.Services;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.stream.Stream;
import com.ProjectoJavaSpring.jpa.JAVASPRING.DTO.ClienteDTO;
import com.ProjectoJavaSpring.jpa.JAVASPRING.Mappers.ClienteMapper;
import com.ProjectoJavaSpring.jpa.JAVASPRING.Repository.ClienteRepository;
import com.ProjectoJavaSpring.jpa.JAVASPRING.Repository.MotosRepository;
import com.ProjectoJavaSpring.jpa.JAVASPRING.model.Cliente;
import com.ProjectoJavaSpring.jpa.JAVASPRING.model.Motos;

@Service
public class ClienteService {
@Autowired 
private ClienteRepository clienteRepository;
@Autowired
private MotosRepository motosRepository;

@Autowired
private final RestTemplate restTemplate;

@Autowired
    public ClienteService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public List<ClienteDTO>getDatosExternos() {
    String url = "https://jsonplaceholder.typicode.com/users/";
    ClienteDTO[] clientesExternos = restTemplate.getForObject(url, ClienteDTO[].class);
    if(clientesExternos == null){
        throw new RuntimeException("No se encontraron usuarios externos");
    }
    List<ClienteDTO> clientessConIngresos = Arrays.stream(clientesExternos).map(cliente -> {
        int ingresosMensuales = (int) (800 + Math.random() * 4200);
        cliente.setIngresosMensuales(ingresosMensuales);
        return cliente;
    }).collect(Collectors.toList());
    this.clienteRepository.saveAll(clientessConIngresos.stream().map(cliente -> ClienteMapper.toEntity(cliente)).collect(Collectors.toList()));
    return clientessConIngresos;
}
    public List<ClienteDTO> getAllClientes() {
    List<Cliente> clientes = clienteRepository.findAll();
    if(clientes == null){
        throw new RuntimeException("No se encontraron clientes");
    }
    return clientes.stream().map(cliente -> ClienteMapper.toDTO(cliente)).toList();
    }
    
    public ClienteDTO crearCliente(ClienteDTO cliente){
        if(cliente == null){
            throw new RuntimeException("El cliente no puede ser nulo");
        } else if(clienteRepository.existsByEmail(cliente.getEmail())){
            throw new RuntimeException("Ya existe un cliente con el email: " + cliente.getEmail());
        } else if(clienteRepository.existsByPhone(cliente.getPhone())){
            throw new RuntimeException("Ya existe un cliente con el teléfono: " + cliente.getPhone());
        }

        Cliente clienteEntity = ClienteMapper.toEntity(cliente);
        this.clienteRepository.save(clienteEntity);
        return cliente;
        
    }
    
    public ClienteDTO actualizarIngresos( Long id, Integer nuevosIngresosMensuales){
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if(clienteOptional.isPresent()){
            Cliente cliente = clienteOptional.get();
            cliente.setIngresosMensuales(nuevosIngresosMensuales);
            clienteRepository.save(cliente);
            return ClienteMapper.toDTO(cliente);

        }  else {
           
            throw new RuntimeException("Cliente no encontrado con ID: " + id);
        }
    }

    public void delete(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if(clienteOptional.isPresent()){
            Cliente cliente = clienteOptional.get();


             
        for (Motos moto : cliente.getMotos()) {
            moto.setCliente(null);  
            motosRepository.save(moto);  
        }

        clienteRepository.deleteById(id);
        }  else {
            throw new RuntimeException("Cliente no encontrado con ID: " + id);
        }
    }}
