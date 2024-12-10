package com.fs3.specifications;

import org.springframework.data.jpa.domain.Specification;

import com.fs3.model.Producto;

public class ProductoSpecifications {
    public static Specification<Producto> nombreContains(String nombre) {
        return (root, query, builder) -> 
            (nombre != null && !nombre.isEmpty()) ? builder.like(root.get("nombre"), "%" + nombre + "%") : null;
    }
}
