/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpirres.Dao;

import com.alpirres.Modelo.Circuito;
import com.alpirres.Utilities.Conection;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author alfon
 */
public class CircuitoHibernate {
    public static Conection c;
     
    public static int Create(Circuito cir){
        int id=0;
        c.abrir();

        c.session.save(cir);
        id=cir.getId();

        c.cerrar();
        
        return id;
    }
    
    public static List<Circuito> Select(){
        c.abrir();

        Query query = c.session.createQuery("from Circuito");
        
        c.cerrar();
        return query.list();
    }
    
    public static boolean SearchId(int id){
        boolean esta=false;
        c.abrir();
        
        Query query = c.session.createQuery("from Circuito where id= :id");
        query.setParameter("id", id);
        
        if (query.list().size()==1){
            esta=true;
        }
        c.cerrar();
        
        return esta;
    }
    
    
    public static void Update(int id, String nombre){
        c.abrir();

        Query query = c.session.createQuery("update Circuito set nombre= :nombre where id = :id");
        query.setParameter("nombre", nombre);
        query.setParameter("id", id);
        int result = query.executeUpdate();
        
        c.cerrar();
    }
    
    public static void Delete(int cir){
        c.abrir();

        Query query = c.session.createQuery("delete Circuito where id = :id");
        query.setParameter("id", cir);
        int result = query.executeUpdate();
        
        c.cerrar();
    }
}
