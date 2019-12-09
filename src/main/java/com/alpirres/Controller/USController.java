/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpirres.Controller;

import com.alpirres.Dao.USHibernate;
import com.alpirres.Modelo.Circuito;
import com.alpirres.Modelo.Sesion;
import com.alpirres.Modelo.Usuario;
import com.alpirres.Modelo.UsuarioSesion;
import com.alpirres.Utilities.Conection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author alfon
 */
public class USController {
    
    static USHibernate us;
    static Conection c;
    
    public void Insertar(int ses, int usu){
        c.abrir();
        
        Usuario usuario =(Usuario) c.session.get(Usuario.class, usu);
        Sesion sesion =(Sesion) c.session.get(Sesion.class, ses);
        
        c.cerrar();
        
        UsuarioSesion nuevo = new UsuarioSesion(sesion, usuario);
        
        us.Create(nuevo);
    }
    
    public List<UsuarioSesion> Leer(){
        List<UsuarioSesion> lista = new ArrayList<>();
        lista=
                us.Select();
        return lista;
    }
    
    public void Actualizar(int id, int ses, int usu){
        c.abrir();
        
        Usuario usuario =(Usuario) c.session.get(Usuario.class, usu);
        Sesion sesion =(Sesion) c.session.get(Sesion.class, ses);
        
        UsuarioSesion a = (UsuarioSesion) c.session.get(UsuarioSesion.class, id);
        a.setSesion(sesion);
        a.setUsuario(usuario);
        
        c.cerrar();
        
        
        us.Update(a);
    }
    
    public void Borrar(int id){
        us.Delete(id);
    }
}
