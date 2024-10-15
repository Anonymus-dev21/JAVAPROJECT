package com.ProjectoJavaSpring.jpa.JAVASPRING.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ProjectoJavaSpring.jpa.JAVASPRING.Services.ClienteService;
import com.ProjectoJavaSpring.jpa.JAVASPRING.Services.CompraService;

@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/realizar")
    public ResponseEntity<?> realizarCompra(@RequestParam Long clienteId,
                                            @RequestParam Integer motoId) {
        try {
            clienteService.realizarCompra(clienteId, motoId);
            return ResponseEntity.ok().body("Compra realizada con éxito");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al realizar la compra: " + e.getMessage());
        }
    }
}
