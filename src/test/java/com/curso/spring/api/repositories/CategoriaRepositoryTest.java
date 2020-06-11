package com.curso.spring.api.repositories;

import com.curso.spring.api.models.Categoria;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CategoriaRepositoryTest {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Test
    public void save(){
        Categoria categoria = new Categoria();
        categoria.setId(9);
        categoria.setDescripcion("VERDURAS");  
        categoria = categoriaRepository.save(categoria);
        Categoria categoriaExistente = categoriaRepository.findById(9).get();
        Assert.assertEquals(categoria, categoriaExistente);   
        
    }

    @Test
    public void getByDescripcion(){
        Categoria categoria  = categoriaRepository.findByDescripcion("ALIMENTOS");
        Assert.assertEquals(categoria.getId(), 5);   
    }
    

    @Test
    public void getByDescripcionJpql(){
        Categoria categoria  = categoriaRepository.getByDescripcion("ALIMENTOS");
        Assert.assertEquals(categoria.getId(), 5);   
    }
}