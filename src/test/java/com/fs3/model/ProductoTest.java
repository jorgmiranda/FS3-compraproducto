package com.fs3.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProductoTest {

    @Test
    public void testConstructorVacio() {
        Producto producto = new Producto();
        assertNotNull(producto);
    }

    @Test
    public void testConstructorConParametros() {
        Long id = 1L;
        String nombre = "nombre";
        String descripcion = "descripcion";
        int precio = 10;
        String tipoProducto = "tipoProducto";
        String urlImg = "urlImg";

        Producto producto = new Producto(id, nombre, descripcion, precio, tipoProducto, urlImg);
        assertNotNull(producto);
        assertEquals(id, producto.getId());
        assertEquals(nombre, producto.getNombre());
        assertEquals(descripcion, producto.getDescripcion());
        assertEquals(precio, producto.getPrecio());
        assertEquals(tipoProducto, producto.getTipoProducto());
        assertEquals(urlImg, producto.getUrlImg());
    }

    @Test
    public void testGettersYSetters() {
        Producto producto = new Producto();
        Long id = 1L;
        String nombre = "nombre";
        String descripcion = "descripcion";
        int precio = 10;
        String tipoProducto = "tipoProducto";
        String urlImg = "urlImg";

        producto.setId(id);
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setPrecio(precio);
        producto.setTipoProducto(tipoProducto);
        producto.setUrlImg(urlImg);

        assertEquals(id, producto.getId());
        assertEquals(nombre, producto.getNombre());
        assertEquals(descripcion, producto.getDescripcion());
        assertEquals(precio, producto.getPrecio());
        assertEquals(tipoProducto, producto.getTipoProducto());
        assertEquals(urlImg, producto.getUrlImg());
    }
}