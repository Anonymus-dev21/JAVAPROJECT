package com.ProjectoJavaSpring.jpa.JAVASPRING.Controller;

import java.util.List;
import com.ProjectoJavaSpring.jpa.JAVASPRING.model.Cliente;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ProjectoJavaSpring.jpa.JAVASPRING.DTO.ClienteDTO;
import com.ProjectoJavaSpring.jpa.JAVASPRING.Services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    /**
     * @return a list of all the clientes stored in the database
     * 
     * @throws RuntimeException if any error occurs during the operation
     */
    @GetMapping("/all")
    @Operation(summary = "Petición de todos los clientes", description = "Devuelve una lista de todos los clientes")
        @ApiResponse(responseCode = "200", description = "La lista de Clientes se obtuvo exitosamente")
        @ApiResponse(responseCode = "400", description = "Posiblemente no haya Clientes") 
    public ResponseEntity<?> getAll(){
        try{
            List<ClienteDTO> clientes = this.clienteService.getAllClientes();
            return ResponseEntity.ok().body(clientes);
        } catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
        
    }

    @GetMapping("/externa")
    @Operation(summary = "Petición de nuevos clientes a una API externa", description = "Hace una petición a una API externa, tomando en cuenta las propiedades necesarias del cliente y los almacena en la base de datos como nuevos clientes. Ignora las propiedades innecesarias de la API externa y le genera automaticamente un ingreso mensual a cada uno.")
        @ApiResponse(responseCode = "200", description = "La lista de clientes se obtuvo exitosamente")
        @ApiResponse(responseCode = "400", description = "Error al concectarse con la API externa")
    public ResponseEntity<?> getDatosExternos(){
        Object url = this.clienteService.getDatosExternos();
        return ResponseEntity.ok().body(url);
    }
    @PostMapping("/createCliente")
    @Operation(summary = "Crear Cliente", description = "Ingresa el cuerpo de un cliente (nombre, email, telefono y ingresosMensuales) y lo crea en la base de datos")
        @ApiResponse(responseCode = "200", description = "Cliente creado exitosamente")
        @ApiResponse(responseCode = "400", description = " Error al crear el cliente")
public ResponseEntity<?> crearCliente(@RequestBody ClienteDTO cliente) {
    try{

        this.clienteService.crearCliente(cliente);
        return ResponseEntity.ok().body("Cliente Creado: " + cliente);
    } catch(RuntimeException e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
    }
}
    
    @DeleteMapping("/delete")
    @Operation(summary = "Eliminar un cliente", description = "Ingresa el id del cliente que deseas eliminar y lo elimina de la base de datos")
        @ApiResponse(responseCode = "200", description = "Cliente eliminado exitosamente")
        @ApiResponse(responseCode = "400", description = "Posiblemente no exista un cliente con dicho ID")
    public ResponseEntity<?> delete( @RequestParam Long id){
        try{
            this.clienteService.delete(id);
            return ResponseEntity.ok().body("Cliente eliminado");
        } catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }
    @PutMapping("/update")
    @Operation(summary = "Actualizar ingresos mensuales de un cliente", description = "Ingresa id del cliente y el nuevo monto de ingresos mensuales y actualizara sus ingresos")
        @ApiResponse(responseCode = "200", description = "Ingresos actualizados correctamente")
        @ApiResponse(responseCode = "400", description = "Posiblemente no exista un cliente con dicho ID para actualizar sus ingresos")
    public ResponseEntity<?> updateIngresos( @RequestParam Long id, Integer nuevosIngresosMensuales){  
        try{
            this.clienteService.actualizarIngresos(id, nuevosIngresosMensuales);
            return ResponseEntity.ok().body("Ingresos actualizados" );
        } catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

}
