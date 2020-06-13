package com.curso.spring.api.security;

import java.util.ArrayList;
import com.curso.spring.api.models.Usuario;
import com.curso.spring.api.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsuario(username);
        if(usuario==null){
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return new User(usuario.getUsuario(), usuario.getClave(), new ArrayList<>()  );
    }    

    
    
}