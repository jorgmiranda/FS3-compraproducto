package com.fs3.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CompraDetalleDTOTest {

    @Test
    public void testConstructorVacio() {
        CompraDetalleDTO compraDetalleDTO = new CompraDetalleDTO();
        assertNotNull(compraDetalleDTO);
        assertNull(compraDetalleDTO.getProductoId());
        assertNull(compraDetalleDTO.getCantidad());
    }

    @Test
    public void testConstructorConParametros() {
        Long productoId = 1L;
        Integer cantidad = 2;

        CompraDetalleDTO compraDetalleDTO = new CompraDetalleDTO(productoId, cantidad);
        assertNotNull(compraDetalleDTO);
        assertEquals(productoId, compraDetalleDTO.getProductoId());
        assertEquals(cantidad, compraDetalleDTO.getCantidad());
    }

    @Test
    public void testGettersYSetters() {
        CompraDetalleDTO compraDetalleDTO = new CompraDetalleDTO();
        Long productoId = 1L;
        Integer cantidad = 2;

        compraDetalleDTO.setProductoId(productoId);
        compraDetalleDTO.setCantidad(cantidad);

        assertEquals(productoId, compraDetalleDTO.getProductoId());
        assertEquals(cantidad, compraDetalleDTO.getCantidad());
    }
}