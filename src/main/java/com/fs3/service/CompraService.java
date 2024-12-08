package com.fs3.service;

import java.util.List;

import com.fs3.dto.CompraDetalleDTO;
import com.fs3.model.Compra;

public interface CompraService {
    Compra crearCompra(Long usuarioId, List<CompraDetalleDTO> detallesDTO);
}
