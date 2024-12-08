package com.fs3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fs3.model.Producto;
import com.fs3.service.ProductoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200") 
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> getAllProductos(){
        return productoService.getAllProductos();
    }

    @GetMapping("/tipo/{categoria}")
    public List<Producto> getProductoByCategoria(@PathVariable String categoria) {
        return productoService.getProductosByCategoria(categoria);
    }


}
