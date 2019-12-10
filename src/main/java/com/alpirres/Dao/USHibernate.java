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
    
    public static boolean SearchIdU(int id){
        boolean esta=false;
        c.abrir();
        
        Query query = c.session.createQuery("from UsuarioSesion where id_usuario= :id");
        query.setParameter("id", id);
        
        if (query.list().size()>0){
            esta=true;
        }
        c.cerrar();
        
        return esta;
    }
    public static boolean SearchIdS(int id){
        boolean esta=false;
        c.abrir();
        
        Query query = c.session.createQuery("from UsuarioSesion where id_sesion= :id");
        query.setParameter("id", id);
        
        if (query.list().size()>0){
            esta=true;
        }
        c.cerrar();
        
        return esta;
    }
    
    public static void Update(int id, int id_sesion, int id_usuario){
        c.abrir();

        Query query = c.session.createQuery("update UsuarioSesion set id_sesion= :id_sesion, id_usuario = :id_usuario  where id = :id");
        query.setParameter("id_sesion", id_sesion);
        query.setParameter("id_usuario", id_usuario);
        query.setParameter("id", id);
        int result = query.executeUpdate();
        System.out.println(result+"adkfjhasrhfgry");
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
