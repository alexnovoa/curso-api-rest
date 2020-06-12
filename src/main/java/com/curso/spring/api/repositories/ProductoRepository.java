package com.curso.spring.api.repositories;

import com.curso.spring.api.models.Producto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
            
}