/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpirres.Dao;

import com.alpirres.Modelo.UsuarioSesion;
import com.alpirres.Utilities.Conection;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author alfon
 */
public class USHibernate {
    public static Conection c;
     
    public static void Create(UsuarioSesion us){
        c.abrir();

        c.session.save(us);

        c.cerrar();
    }
    
    public static List<UsuarioSesion> Select(){
        c.abrir();

        Query query = c.session.createQuery("from UsuarioSesion");
        
        c.cerrar();
        return query.list();
    }
    
    public static void Update(UsuarioSesion us){
        c.abrir();

        c.session.update(us);
        
        c.cerrar();
    }
    
    public static void Delete(int id){
        c.abrir();

        Query query = c.session.createQuery("delete UsuarioSesion where id = :id");
        query.setParameter("id", id);
        int result = query.executeUpdate();
        
        c.cerrar();
    }
}
