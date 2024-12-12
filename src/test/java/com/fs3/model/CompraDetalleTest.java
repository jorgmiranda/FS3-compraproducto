package com.fs3.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CompraDetalleTest {

    @Test
    public void testConstructorVacio() {
        CompraDetalle compraDetalle = new CompraDetalle();
        assertNotNull(compraDetalle);
        assertNull(compraDetalle.getId());
        assertNull(compraDetalle.getCompra());
        assertNull(compraDetalle.getProducto());
        assertNull(compraDetalle.getCantidad());
        assertNull(compraDetalle.getSubtotal());
    }

    @Test
    public void testConstructorConParametros() {
        Long id = 1L;
        Compra compra = new Compra();
        Producto producto = new Producto();
        Integer cantidad = 2;
        Double subtotal = 10.99;

        CompraDetalle compraDetalle = new CompraDetalle(id, compra, producto, cantidad, subtotal);
        assertNotNull(compraDetalle);
        assertEquals(id, compraDetalle.getId());
        assertEquals(compra, compraDetalle.getCompra());
        assertEquals(producto, compraDetalle.getProducto());
        assertEquals(cantidad, compraDetalle.getCantidad());
        assertEquals(subtotal, compraDetalle.getSubtotal());
    }

    @Test
    public void testGettersYSetters() {
        CompraDetalle compraDetalle = new CompraDetalle();
        Long id = 1L;
        Compra compra = new Compra();
        Producto producto = new Producto();
        Integer cantidad = 2;
        Double subtotal = 10.99;

        compraDetalle.setId(id);
        compraDetalle.setCompra(compra);
        compraDetalle.setProducto(producto);
        compraDetalle.setCantidad(cantidad);
        compraDetalle.setSubtotal(subtotal);

        assertEquals(id, compraDetalle.getId());
        assertEquals(compra, compraDetalle.getCompra());
        assertEquals(producto, compraDetalle.getProducto());
        assertEquals(cantidad, compraDetalle.getCantidad());
        assertEquals(subtotal, compraDetalle.getSubtotal());
    }

    @Test
    public void testManyToOne() {
        Compra compra = new Compra();
        Producto producto = new Producto();

        CompraDetalle compraDetalle = new CompraDetalle();
        compraDetalle.setCompra(compra);
        compraDetalle.setProducto(producto);

        assertEquals(compra, compraDetalle.getCompra());
        assertEquals(producto, compraDetalle.getProducto());
    }
}