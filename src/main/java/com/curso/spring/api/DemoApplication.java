package com.curso.spring.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.curso.spring.api.models")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		/*Producto producto = new Producto();
		producto.setDescripcion("Lapices");
		producto.setPrecio(1.12);
		producto.setStock(23);
		System.out.println(producto);*/
		
	}

}
