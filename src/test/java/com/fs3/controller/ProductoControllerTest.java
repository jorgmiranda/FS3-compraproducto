package com.fs3.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fs3.model.Producto;
import com.fs3.service.ProductoService;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ProductoControllerTest {

    @Mock
    private ProductoService productoService;

    @InjectMocks
    private ProductoController productoController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(productoController).build();
    }

    @Test
    public void testGetAllProductos() throws Exception {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto());
        productos.add(new Producto());

        when(productoService.getAllProductos()).thenReturn(productos);

        mockMvc.perform(get("/productos"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetProductosByCategoria() throws Exception {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto());
        productos.add(new Producto());

        when(productoService.getProductosByCategoria("categoria")).thenReturn(productos);

        mockMvc.perform(get("/productos/tipo/categoria"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetProductosByNombre() throws Exception {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto());
        productos.add(new Producto());

        when(productoService.filtrarProductos("nombre")).thenReturn(productos);

        mockMvc.perform(get("/productos/nombre/nombre"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllProductosEmpty() throws Exception {
        when(productoService.getAllProductos()).thenReturn(new ArrayList<>());

        mockMvc.perform(get("/productos"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetProductosByCategoriaEmpty() throws Exception {
        when(productoService.getProductosByCategoria("categoria")).thenReturn(new ArrayList<>());

        mockMvc.perform(get("/productos/tipo/categoria"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetProductosByNombreEmpty() throws Exception {
        when(productoService.filtrarProductos("nombre")).thenReturn(new ArrayList<>());

        mockMvc.perform(get("/productos/nombre/nombre"))
                .andExpect(status().isOk());
    }
}