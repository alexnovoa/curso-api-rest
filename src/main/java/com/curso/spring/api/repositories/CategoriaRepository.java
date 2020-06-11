package com.curso.spring.api.repositories;
import com.curso.spring.api.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
    
    Categoria findByDescripcion(String descripcion);


    @Query("SELECT c FROM Categoria c WHERE descripcion = ?1")
    Categoria getByDescripcion(String descripcion);

}