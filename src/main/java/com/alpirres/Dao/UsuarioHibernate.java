/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpirres.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.alpirres.Utilities.HibernateUtilities_5;
import com.alpirres.Modelo.Usuario;
import com.alpirres.Utilities.Conection;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.query.Query;
/**
 *
 * @author alfon
 */
public class UsuarioHibernate {
    
    static Conection c;
     
    public static void Create(Usuario u){
        c.abrir();

        c.session.save(u);

        c.cerrar();
    }
    
    public static List<Usuario> Select(){
        c.abrir();

        List<Usuario> result = (List<Usuario>)c.session.createQuery("from Usuario").list();
        
        c.cerrar();
        return result;
    }
    
    public static boolean SearchDni(String dni){
        boolean esta=false;
        c.abrir();
        
        Query query = c.session.createQuery("from Usuario where dni= :dni");
        query.setParameter("dni", dni);
        
        if (query.list().size()==1){
            esta=true;
        }
        c.cerrar();
        
        return esta;
    } 
    
    public static void Update(Usuario u){
        c.abrir();

        c.session.update(u);
        
        c.cerrar();
    }
    
    public static void Delete(int id){
        c.abrir();
        
        Query query = c.session.createQuery("delete Usuario where id = :id");
        query.setParameter("id", id);
        int result = query.executeUpdate();

        c.cerrar();
    }
}
