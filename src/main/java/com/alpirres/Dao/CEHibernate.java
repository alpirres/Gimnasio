/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpirres.Dao;

import com.alpirres.Modelo.CircuEjercicio;
import com.alpirres.Utilities.Conection;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author alfon
 */
public class CEHibernate {
    public static Conection c;
     
    public static void Create(CircuEjercicio ce){
        c.abrir();

        c.session.save(ce);

        c.cerrar();
    }
    
    public static List<CircuEjercicio> Select(){
        c.abrir();

        Query query = c.session.createQuery("from CircuEjercicio");
        
        c.cerrar();
        return query.list();
    }
    
    public static void Update(CircuEjercicio ce){
        c.abrir();

        c.session.update(ce);
        
        c.cerrar();
    }
    
    public static void Delete(int ce){
        c.abrir();

        Query query = c.session.createQuery("delete CircuEjercicio where id = :id");
        query.setParameter("id", ce);
        int result = query.executeUpdate();
        
        c.cerrar();
    }
}
