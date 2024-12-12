package com.fs3.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fs3.dto.CompraDetalleDTO;
import com.fs3.model.Compra;
import com.fs3.model.CompraDetalle;
import com.fs3.model.Producto;
import com.fs3.model.Usuario;
import com.fs3.repository.CompraRepository;
import com.fs3.repository.ProductoRepository;
import com.fs3.repository.UsuarioRepository;

@ExtendWith(MockitoExtension.class)
public class CompraServiceImplTest {

    @Mock
    private CompraRepository compraRepository;

    @Mock
    private ProductoRepository productoRepository;

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private CompraServiceImpl compraService;

    private Usuario usuario;
    private Producto producto;
    private CompraDetalleDTO detalleDTO;

    @BeforeEach
    void setUp() {
        usuario = new Usuario(1L, "Nombre Completo", "Nombre Usuario", "correo@example.com", "Direccion Despacho", "Fecha Nacimiento", false, "Contrasena", "Rol");
        producto = new Producto(1L, "Nombre Producto", "Descripcion Producto", 10, "Categoria Producto", "Url Imagen");
        detalleDTO = new CompraDetalleDTO(1L, 2);
    }

    @Test
    void testCrearCompra_UsuarioExistente() {
        when(usuarioRepository.findById(any(Long.class))).thenReturn(java.util.Optional.of(usuario));
        when(productoRepository.findById(any(Long.class))).thenReturn(java.util.Optional.of(producto));

        Compra compra = new Compra();
        compra.setUsuario(usuario);
        compra.setFecha(LocalDateTime.now());
        compra.setTotal(20.0);
        compra.setDetalles(List.of(new CompraDetalle()));

        when(compraRepository.save(any(Compra.class))).thenReturn(compra);

        Compra resultado = compraService.crearCompra(1L, List.of(detalleDTO));

        verify(compraRepository, times(1)).save(any(Compra.class));

        assertNotNull(resultado);
        assertEquals(usuario, resultado.getUsuario());
        assertEquals(LocalDateTime.now().getYear(), resultado.getFecha().getYear());
        assertEquals(LocalDateTime.now().getMonth(), resultado.getFecha().getMonth());
        assertEquals(LocalDateTime.now().getDayOfMonth(), resultado.getFecha().getDayOfMonth());
        assertEquals(20.0, resultado.getTotal());
        assertEquals(1, resultado.getDetalles().size());
    }

    @Test
    void testCrearCompra_UsuarioNoExistente() {
        when(usuarioRepository.findById(any(Long.class))).thenReturn(java.util.Optional.empty());

        assertThrows(RuntimeException.class, () -> compraService.crearCompra(1L, List.of(detalleDTO)));
    }

    @Test
    void testCrearCompra_ProductoNoExistente() {
        when(usuarioRepository.findById(any(Long.class))).thenReturn(java.util.Optional.of(usuario));
        when(productoRepository.findById(any(Long.class))).thenReturn(java.util.Optional.empty());

        assertThrows(RuntimeException.class, () -> compraService.crearCompra(1L, List.of(detalleDTO)));
    }

    @Test
    void testObtenerTodasLasCompras() {
        List<Compra> compras = new ArrayList<>();
        when(compraRepository.findAll()).thenReturn(compras);

        List<Compra> resultado = compraService.obtenerTodasLasCompras();

        assertNotNull(resultado);
        assertEquals(compras, resultado);
    }

    @Test
    void testObtenerComprasPorUsuario() {
        List<Compra> compras = new ArrayList<>();
        when(compraRepository.findByUsuarioId(any(Long.class))).thenReturn(compras);

        List<Compra> resultado = compraService.obtenerComprasPorUsuario(1L);

        assertNotNull(resultado);
        assertEquals(compras, resultado);
    }
}