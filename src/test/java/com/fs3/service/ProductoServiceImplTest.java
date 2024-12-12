package com.fs3.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.domain.Specification;

import com.fs3.model.Producto;
import com.fs3.repository.ProductoRepository;

@ExtendWith(MockitoExtension.class)
public class ProductoServiceImplTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoServiceImpl productoService;

    private List<Producto> productos;

    @BeforeEach
    void setUp() {
        productos = new ArrayList<>();
        productos.add(new Producto(1L, "Producto 1", "Descripción 1", 10, "Categoria 1", "urlImagen1"));
        productos.add(new Producto(2L, "Producto 2", "Descripción 2", 20, "Categoria 2", "urlImagen2"));
        productos.add(new Producto(3L, "Producto 3", "Descripción 3", 30, "Categoria 1", "urlImagen3"));
    }

    @Test
    void testFiltrarProductos_NombreNoNulo() {
        when(productoRepository.findAll(any(Specification.class))).thenReturn(productos);

        List<Producto> resultado = productoService.filtrarProductos("Producto");

        assertNotNull(resultado);
        assertEquals(3, resultado.size());
        verify(productoRepository, times(1)).findAll(any(Specification.class));
    }

    @Test
    void testFiltrarProductos_NombreNulo() {
        when(productoRepository.findAll(any(Specification.class))).thenReturn(productos);

        List<Producto> resultado = productoService.filtrarProductos(null);

        assertNotNull(resultado);
        assertEquals(3, resultado.size());
        verify(productoRepository, times(1)).findAll(any(Specification.class));
    }

    @Test
    void testFiltrarProductos_NombreVacio() {
        when(productoRepository.findAll(any(Specification.class))).thenReturn(productos);

        List<Producto> resultado = productoService.filtrarProductos("");

        assertNotNull(resultado);
        assertEquals(3, resultado.size());
        verify(productoRepository, times(1)).findAll(any(Specification.class));
    }

    @Test
    void testGetAllProductos() {
        when(productoRepository.findAll()).thenReturn(productos);

        List<Producto> resultado = productoService.getAllProductos();

        assertNotNull(resultado);
        assertEquals(3, resultado.size());
        verify(productoRepository, times(1)).findAll();
    }

    @Test
    void testGetProductosByCategoria() {
        when(productoRepository.findByTipoProducto("Categoria 1")).thenReturn(productos);

        List<Producto> resultado = productoService.getProductosByCategoria("Categoria 1");

        assertNotNull(resultado);
        assertEquals(3, resultado.size());
        verify(productoRepository, times(1)).findByTipoProducto("Categoria 1");
    }
}