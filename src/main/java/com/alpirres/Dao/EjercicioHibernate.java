/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpirres.Dao;

import com.alpirres.Modelo.Ejercicio;
import com.alpirres.Utilities.Conection;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author alfon
 */
public class EjercicioHibernate {
    

    public static Conection c;
     
    public static void Create(Ejercicio e){
        c.abrir();

        c.session.save(e);

        c.cerrar();
    }
    
    public static List<Ejercicio> Select(){
        c.abrir();

        Query query = c.session.createQuery("from Ejercicio");
        
        c.cerrar();
        return query.list();
    }
    
    public static boolean SearchId(int id){
        boolean esta=false;
        c.abrir();
        
        Query query = c.session.createQuery("from Ejercicio where id= :id");
        query.setParameter("id", id);
        
        if (query.list().size()==1){
            esta=true;
        }
        c.cerrar();
        
        return esta;
    }
    
    public static void Update(Ejercicio e){
        c.abrir();

        c.session.update(e);
        
        c.cerrar();
    }
    
    public static void Delete(int e){
        c.abrir();

        Query query = c.session.createQuery("delete Ejercicio where id = :id");
        query.setParameter("id", e);
        int result = query.executeUpdate();
        
        c.cerrar();
    }
}
