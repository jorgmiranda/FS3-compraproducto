package com.fs3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fs3.dto.CompraDTO;
import com.fs3.model.Compra;
import com.fs3.service.CompraService;

@RestController
@CrossOrigin(origins = "http://ip172-18-0-31-ctee5d291nsg00ftqsog-80.direct.labs.play-with-docker.com") 
@RequestMapping("/compras")
public class CompraController {
    @Autowired
    private CompraService compraService;

    @PostMapping
    public ResponseEntity<Compra> crearCompra(@RequestBody CompraDTO compraDTO) {
        Compra nuevaCompra = compraService.crearCompra(compraDTO.getUsuarioId(), compraDTO.getDetalles());
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCompra);
    }

    @GetMapping
    public ResponseEntity<List<Compra>> obtenerTodasLasCompras() {
        List<Compra> compras = compraService.obtenerTodasLasCompras();
        return ResponseEntity.ok(compras);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Compra>> obtenerComprasPorUsuario(@PathVariable Long usuarioId) {
        List<Compra> compras = compraService.obtenerComprasPorUsuario(usuarioId);
        if (compras.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(compras);
    }
}
