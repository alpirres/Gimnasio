/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpirres.Dao;

import com.alpirres.Modelo.Sesion;
import com.alpirres.Utilities.Conection;
import com.alpirres.Utilities.HibernateUtilities_5;
import java.sql.Time;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 *
 * @author alfon
 */
public class SesionHibernate {
    public static Conection c;
    
    public static void Create(Sesion s){
        c.abrir();

        c.session.save(s);

        c.cerrar();
    }
    
    public static List<Sesion> Select(){
        c.abrir();

        Query query = c.session.createQuery("from Sesion");
        
        c.cerrar();
        return query.list();
    }
    
    public static boolean SearchId(int id){
        boolean esta=false;
        c.abrir();
        
        Query query = c.session.createQuery("from Sesion where id_circuito= :id");
        query.setParameter("id", id);
        
        if (query.list().size()>0){
            esta=true;
        }
        c.cerrar();
        
        return esta;
    }
    
    
    public static boolean SearchIds(int id){
        boolean esta=false;
        c.abrir();
        
        Query query = c.session.createQuery("from Sesion where id= :id");
        query.setParameter("id", id);
        
        if (query.list().size()>0){
            esta=true;
        }
        c.cerrar();
        
        return esta;
    }
    
    public static void Update(int id, int id_circuito, String fecha, Time hora){
        c.abrir();

        Query query = c.session.createQuery("update Sesion set id_circuito = :id_circuito , fecha= :fecha, hora= :hora where id = :id");
        query.setParameter("id_circuito", id_circuito);
        query.setParameter("fecha", fecha);
        query.setParameter("hora", hora);
        query.setParameter("id", id);
        int result = query.executeUpdate();
        
        c.cerrar();
    }
    
    public static void Delete(int s){
        c.abrir();

        Query query = c.session.createQuery("delete Sesion where id = :id");
        query.setParameter("id", s);
        int result = query.executeUpdate();

        c.cerrar();
    }
}
