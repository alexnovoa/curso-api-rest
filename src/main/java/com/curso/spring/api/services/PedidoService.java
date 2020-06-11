package com.curso.spring.api.services;

import java.util.List;

import com.curso.spring.api.models.Detalle;
import com.curso.spring.api.models.Pedido;

public interface PedidoService {

    public Pedido save(Pedido pedido, List<Detalle> detalles);    
    
}