package com.fs3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fs3.model.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long>{
    List<Compra> findByUsuarioId(Long usuarioId);
}
