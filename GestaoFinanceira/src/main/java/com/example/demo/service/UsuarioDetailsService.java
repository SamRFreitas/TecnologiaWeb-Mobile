package com.example.demo.service;

import com.example.demo.models.Permissao;
import com.example.demo.models.Usuario;
import com.example.demo.repositories.UsuarioRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetailsService implements UserDetailsService{

    @Autowired
    private UsuarioRepository repo;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = repo.findByLogin(username);
        return new User(usuario.getLogin(), usuario.getSenha(), authorities(usuario.getPermissoes()));
    }
    
    private List<GrantedAuthority> authorities(List<Permissao> lista){
        List<GrantedAuthority> novaLista = new ArrayList<>();
        for(Permissao p : lista){
            novaLista.add(new SimpleGrantedAuthority("ROLE_"+p.getNome()));
        }
        return novaLista;
    }
    
}
