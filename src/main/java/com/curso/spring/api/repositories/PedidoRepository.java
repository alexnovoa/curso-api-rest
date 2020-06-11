package com.curso.spring.api.repositories;

import com.curso.spring.api.models.Pedido;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    
}