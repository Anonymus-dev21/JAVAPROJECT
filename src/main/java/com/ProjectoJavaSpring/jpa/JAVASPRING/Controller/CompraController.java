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
    private CompraService compraService;

           @PostMapping("/realizar")
        public String realizarCompra(@RequestParam Long clienteId, 
                                     @RequestParam Integer motoId) {
            try {
                compraService.realizarCompra(clienteId, motoId);
                return "Compra realizada exitosamente";
            } catch (RuntimeException e) {
                return "Error en la compra: " + e.getMessage();
            }
        }
    }

