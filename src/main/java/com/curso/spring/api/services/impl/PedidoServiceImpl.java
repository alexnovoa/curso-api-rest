package com.curso.spring.api.services.impl;

import java.util.List;
import javax.transaction.Transactional;
import com.curso.spring.api.models.Detalle;
import com.curso.spring.api.models.Pedido;
import com.curso.spring.api.repositories.DetalleRepository;
import com.curso.spring.api.repositories.PedidoRepository;
import com.curso.spring.api.services.PedidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private DetalleRepository detalleRepository;


    @Override
    @Transactional
    public Pedido save(Pedido pedido, List<Detalle> detalles) {       
        
        Pedido pedidoGuardado = pedidoRepository.save(pedido);


        for(Detalle tmp : detalles){

            tmp.setPedido(pedidoGuardado);

            detalleRepository.save(tmp);


        }

        return null;
    }    
    
}