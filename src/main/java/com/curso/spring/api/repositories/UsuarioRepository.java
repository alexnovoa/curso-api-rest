package com.curso.spring.api.repositories;

import com.curso.spring.api.models.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByUsuario(String usuario);
    
}