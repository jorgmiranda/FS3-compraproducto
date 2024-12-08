package com.fs3.dto;

import java.util.List;

public class CompraDTO {
    private Long usuarioId;
    private List<CompraDetalleDTO> detalles;
    
    public Long getUsuarioId() {
        return usuarioId;
    }
    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
    public List<CompraDetalleDTO> getDetalles() {
        return detalles;
    }
    public void setDetalles(List<CompraDetalleDTO> detalles) {
        this.detalles = detalles;
    }

    
}
