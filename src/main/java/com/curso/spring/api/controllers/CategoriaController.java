package com.curso.spring.api.controllers;

import java.util.List;
import com.curso.spring.api.models.Categoria;
import com.curso.spring.api.repositories.CategoriaRepository;
import com.curso.spring.api.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private BCryptPasswordEncoder bcrypt;

    @GetMapping("/saludar/{nombre}")
    public String saludar(@PathVariable String nombre) {
        return "HOLA "+nombre;
    }


    @GetMapping("/categorias/{id}")   
    public ResponseEntity<Response<Categoria>> getCategoriaPorId(@PathVariable int id){
        Response<Categoria> response = new Response<>();  
        Categoria categoria = categoriaRepository.findById(id);     
        if(categoria==null){
            response.getErrores().add("No existe el elemento");           
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        response.setResultado(categoria);       
        return ResponseEntity.ok(response);
    }


    @GetMapping("/categorias")   
    public List<Categoria> getCategoria(){
        List<Categoria> categorias = categoriaRepository.findAll();        
        return categorias;
      
    }


    @PostMapping("/categorias")
    public Categoria postCategoria(@RequestBody Categoria categoria ){
        return categoriaRepository.save(categoria);   
    } 
    
}