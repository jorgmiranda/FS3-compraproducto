package com.fs3.service;

import java.util.List;

import com.fs3.model.Producto;

public interface ProductoService {
    List<Producto> filtrarProductos(String nombre);
    List<Producto> getAllProductos();
    List<Producto> getProductosByCategoria(String categoria);
}
