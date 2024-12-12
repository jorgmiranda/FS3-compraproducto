package com.fs3.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fs3.dto.CompraDTO;
import com.fs3.model.Compra;
import com.fs3.service.CompraService;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CompraControllerTest {

    @Mock
    private CompraService compraService;

    @InjectMocks
    private CompraController compraController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(compraController).build();
    }

    @Test
    public void testCrearCompra() throws Exception {
        CompraDTO compraDTO = new CompraDTO();
        compraDTO.setUsuarioId(1L);
        compraDTO.setDetalles(new ArrayList<>());

        Compra nuevaCompra = new Compra();
        nuevaCompra.setId(1L);

        when(compraService.crearCompra(compraDTO.getUsuarioId(), compraDTO.getDetalles())).thenReturn(nuevaCompra);

        mockMvc.perform(post("/compras")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(compraDTO)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testObtenerTodasLasCompras() throws Exception {
        List<Compra> compras = new ArrayList<>();
        compras.add(new Compra());
        compras.add(new Compra());

        when(compraService.obtenerTodasLasCompras()).thenReturn(compras);

        mockMvc.perform(get("/compras"))
                .andExpect(status().isOk());
    }

    @Test
    public void testObtenerComprasPorUsuario() throws Exception {
        List<Compra> compras = new ArrayList<>();
        compras.add(new Compra());
        compras.add(new Compra());

        when(compraService.obtenerComprasPorUsuario(1L)).thenReturn(compras);

        mockMvc.perform(get("/compras/usuario/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testObtenerComprasPorUsuarioNoContent() throws Exception {
        when(compraService.obtenerComprasPorUsuario(1L)).thenReturn(new ArrayList<>());

        mockMvc.perform(get("/compras/usuario/1"))
                .andExpect(status().isNoContent());
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}