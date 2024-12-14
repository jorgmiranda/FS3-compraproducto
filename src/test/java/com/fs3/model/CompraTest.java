package com.fs3.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CompraTest {

    @Test
    public void testConstructorVacio() {
        Compra compra = new Compra();
        assertNotNull(compra);
        assertNull(compra.getId());
        assertNull(compra.getUsuario());
        assertNull(compra.getFecha());
        assertNull(compra.getTotal());
        assertNull(compra.getDetalles());
    }

    @Test
    public void testConstructorConParametros() {
        Long id = 1L;
        Usuario usuario = new Usuario();
        LocalDateTime fecha = LocalDateTime.now();
        Double total = 10.99;
        List<CompraDetalle> detalles = new ArrayList<>();

        Compra compra = new Compra(id, usuario, fecha, total, detalles);
        assertNotNull(compra);
        assertEquals(id, compra.getId());
        assertEquals(usuario, compra.getUsuario());
        assertEquals(fecha, compra.getFecha());
        assertEquals(total, compra.getTotal());
        assertEquals(detalles, compra.getDetalles());
    }

    @Test
    public void testGettersYSetters() {
        Compra compra = new Compra();
        Long id = 1L;
        Usuario usuario = new Usuario();
        LocalDateTime fecha = LocalDateTime.now();
        Double total = 10.99;
        List<CompraDetalle> detalles = new ArrayList<>();

        compra.setId(id);
        compra.setUsuario(usuario);
        compra.setFecha(fecha);
        compra.setTotal(total);
        compra.setDetalles(detalles);

        assertEquals(id, compra.getId());
        assertEquals(usuario, compra.getUsuario());
        assertEquals(fecha, compra.getFecha());
        assertEquals(total, compra.getTotal());
        assertEquals(detalles, compra.getDetalles());
    }

    @Test
    public void testManyToOne() {
        Usuario usuario = new Usuario();

        Compra compra = new Compra();
        compra.setUsuario(usuario);

        assertEquals(usuario, compra.getUsuario());
    }

    @Test
    public void testOneToMany() {
        CompraDetalle detalle1 = new CompraDetalle();
        CompraDetalle detalle2 = new CompraDetalle();

        List<CompraDetalle> detalles = new ArrayList<>();
        detalles.add(detalle1);
        detalles.add(detalle2);

        Compra compra = new Compra();
        compra.setDetalles(detalles);

        assertEquals(detalles, compra.getDetalles());
    }
}