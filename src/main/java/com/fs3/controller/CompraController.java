package com.fs3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fs3.dto.CompraDTO;
import com.fs3.model.Compra;
import com.fs3.service.CompraService;

@RestController
@RequestMapping("/compras")
public class CompraController {
    @Autowired
    private CompraService compraService;

    @PostMapping
    public ResponseEntity<Compra> crearCompra(@RequestBody CompraDTO compraDTO) {
        Compra nuevaCompra = compraService.crearCompra(compraDTO.getUsuarioId(), compraDTO.getDetalles());
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCompra);
    }
}
