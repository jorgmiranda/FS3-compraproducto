package com.fs3.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class CompraDTOTest {

    @Test
    public void testGettersYSetters() {
        CompraDTO compraDTO = new CompraDTO();
        Long usuarioId = 1L;
        List<CompraDetalleDTO> detalles = new ArrayList<>();

        compraDTO.setUsuarioId(usuarioId);
        compraDTO.setDetalles(detalles);

        assertEquals(usuarioId, compraDTO.getUsuarioId());
        assertEquals(detalles, compraDTO.getDetalles());
    }

    @Test
    public void testSetDetallesConElementos() {
        CompraDTO compraDTO = new CompraDTO();
        List<CompraDetalleDTO> detalles = new ArrayList<>();
        detalles.add(new CompraDetalleDTO());
        detalles.add(new CompraDetalleDTO());

        compraDTO.setDetalles(detalles);

        assertEquals(detalles, compraDTO.getDetalles());
        assertEquals(2, compraDTO.getDetalles().size());
    }

    @Test
    public void testSetDetallesConNull() {
        CompraDTO compraDTO = new CompraDTO();

        compraDTO.setDetalles(null);

        assertNull(compraDTO.getDetalles());
    }
}