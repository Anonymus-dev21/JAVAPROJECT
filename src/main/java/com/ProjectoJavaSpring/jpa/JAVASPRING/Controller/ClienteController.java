package com.ProjectoJavaSpring.jpa.JAVASPRING.Controller;

import java.util.List;
import com.ProjectoJavaSpring.jpa.JAVASPRING.model.Cliente;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ProjectoJavaSpring.jpa.JAVASPRING.Services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/all")
    public List<Cliente> getAll(){
        return this.clienteService.getAllClientes();
    }
    @PostMapping("/createCliente")
public ResponseEntity<?> crearCliente(@RequestBody Cliente cliente) {
    this.clienteService.crearCliente(cliente);
    return ResponseEntity.ok().body("Cliente Creado: " + cliente);
}
    
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete( @RequestParam Long id){
        this.clienteService.delete(id);
        return ResponseEntity.ok().body("Cliente eliminado");
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateIngresos( @RequestParam Long id, Integer nuevosIngresosMensuales){   
        this.clienteService.actualizarIngresos(id, nuevosIngresosMensuales);
        return ResponseEntity.ok().body("Ingresos actualizados" );
    }

}
