package com.fs3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.fs3.model.Producto;
import com.fs3.repository.ProductoRepository;
import com.fs3.specifications.ProductoSpecifications;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> filtrarProductos(String nombre) {
        Specification<Producto> spec = Specification.where(null);

        if (nombre != null && !nombre.trim().isEmpty()) {

            spec = spec.and(ProductoSpecifications.nombreContains(nombre));
        }

        return productoRepository.findAll(spec);
    }

    @Override
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    @Override
    public List<Producto> getProductosByCategoria(String categoria) {
       return productoRepository.findByTipoProducto(categoria);
    }
    
}
