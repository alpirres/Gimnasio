/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpirres.Dao;

import com.alpirres.Modelo.Sesion;
import com.alpirres.Utilities.Conection;
import com.alpirres.Utilities.HibernateUtilities_5;
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
    
    public static void Update(Sesion s){
        c.abrir();

        c.session.update(s);
        
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
