package com.ProjectoJavaSpring.jpa.JAVASPRING.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ProjectoJavaSpring.jpa.JAVASPRING.Services.ClienteService;
import com.ProjectoJavaSpring.jpa.JAVASPRING.Services.CompraService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private CompraService compraService;

           @PostMapping("/realizar")
        @Operation(summary = "Realizar una compra", description = "Realiza una compra de una moto para un cliente, si el id del cliente que ingresaste no existe, se creara uno nuevo siempre y cuando completes los parametros (name, email, phone, ingresosMensuales), luego ingresas el id de la moto que deseas comprar. Si esta existe y no la compro nadie anteriormente, se creara una nueva compra")
        @ApiResponse(responseCode = "200", description = "La compra se realizo exitosamente")
        @ApiResponse(responseCode = "400", description = "Error al realizar la compra") 
        public String realizarCompra(@RequestParam Long clienteId, 
                                     @RequestParam Integer motoId, Integer ingresosMensuales, String name, String email, String phone) {
            try {
                compraService.realizarCompra(clienteId, motoId, ingresosMensuales, name, phone, email);
                return "Compra realizada exitosamente";
            } catch (RuntimeException e) {
                return "Error en la compra: " + e.getMessage();
            }
        }
    }

