/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.ejb;

import com.br.lp3.entities.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author 31240550
 */
@Singleton
@LocalBean
@Startup
public class UsuarioSingleton  {
    private List<Usuario> usuarios;
    
    @PostConstruct
    private void initialize() {
        usuarios = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            Usuario u = new Usuario (i, "usuario" + i, "usuario" + i + "@gmail.com", "u" + i, "teste");
            usuarios.add(u);
        }
    }
    
    public Usuario readByID(int id) {
        Usuario u = null;
        for (Usuario usuario : usuarios) {
            if(usuario.getId() == id)
                u = usuario;
        }
        return u;
    }
    
    public List<Usuario> readByInterval(int a, int b) {
        List<Usuario> lista = new ArrayList<>();
        if (a >= 0 && a < usuarios.size() && b >= 0 && b < usuarios.size() && a < b) {
            for (int i = a; i < b; i++) {
                lista.add(usuarios.get(i));
            }
        }
        return lista;
    }
    
    public int getUsuarioAccount() {
        return usuarios.size();
    }
}
