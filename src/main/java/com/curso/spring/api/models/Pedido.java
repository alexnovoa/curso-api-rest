package com.curso.spring.api.models;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Pedido {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   @Temporal(TemporalType.DATE)
   private Date fechaPedido;

   private double subtotal;


      
    
}