/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.ejb;

import com.br.lp3.entities.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author 31240550
 */
@Stateless
@LocalBean
public class UsuarioBean {
    private UsuarioSingleton using;
    
    @GET
    @Path("/{id_usuario}")
    @Produces("application/json")
    public Usuario getUsuarioByID(@PathParam("id_usuario")int id) {
        
        
        return using.readByID(id);
    }
    
    @GET
    @Path("/{id1}/{id2}")
    @Produces("application/json")
    public List<Usuario> getUsuarioByInterval(@PathParam("id1") int a,@PathParam("id2") int b) {
        return using.readByInterval(a, b);
    }
    
    @GET
    @Path("/account")
    @Produces("application/json")
    public String getAccount() {
        return using.getUsuarioAccount() + "";
    }
}