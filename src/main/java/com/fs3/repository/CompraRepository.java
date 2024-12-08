package com.fs3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fs3.model.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long>{
    
}
