package com.curso.spring.api.repositories;

import com.curso.spring.api.models.Detalle;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleRepository extends JpaRepository<Detalle, Integer>{
    
    
}