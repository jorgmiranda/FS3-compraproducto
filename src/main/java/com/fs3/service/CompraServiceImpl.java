package com.fs3.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fs3.dto.CompraDetalleDTO;
import com.fs3.model.Compra;
import com.fs3.model.CompraDetalle;
import com.fs3.model.Producto;
import com.fs3.model.Usuario;
import com.fs3.repository.CompraRepository;
import com.fs3.repository.ProductoRepository;
import com.fs3.repository.UsuarioRepository;

@Service
public class CompraServiceImpl implements CompraService{
    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Compra crearCompra(Long usuarioId, List<CompraDetalleDTO> detallesDTO) {
        // Validar usuario
        Usuario usuario = usuarioRepository.findById(usuarioId)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Crear nueva compra
        Compra compra = new Compra();
        compra.setUsuario(usuario);
        compra.setFecha(LocalDateTime.now());

        // Procesar los detalles
        List<CompraDetalle> detalles = new ArrayList<>();
        double total = 0;
        System.out.println("Llega hasta este punto");
        for (CompraDetalleDTO detalleDTO : detallesDTO) {
            Producto producto = productoRepository.findById(detalleDTO.getProductoId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

            CompraDetalle detalle = new CompraDetalle();
            detalle.setCompra(compra);
            detalle.setProducto(producto);
            detalle.setCantidad(detalleDTO.getCantidad());
            detalle.setSubtotal((double)producto.getPrecio() * detalleDTO.getCantidad());

            detalles.add(detalle);
            total += detalle.getSubtotal();
        }

        compra.setDetalles(detalles);
        compra.setTotal(total);

        // Guardar compra y detalles
        return compraRepository.save(compra);
    }

    @Override
    public List<Compra> obtenerTodasLasCompras() {
        return compraRepository.findAll();
    }

    @Override
    public List<Compra> obtenerComprasPorUsuario(Long usuarioId) {
        return compraRepository.findByUsuarioId(usuarioId);
    }
    
}
