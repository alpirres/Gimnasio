/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpirres.Dao;

import com.alpirres.Modelo.EjercicioMaterial;
import com.alpirres.Utilities.Conection;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author alfon
 */
public class EMHibernate {
    public static Conection c;
     
    public static void Create(EjercicioMaterial em){
        c.abrir();

        c.session.save(em);

        c.cerrar();
    }
    
    public static List<EjercicioMaterial> Select(){
        c.abrir();

        Query query = c.session.createQuery("from EjercicioMaterial");
        
        c.cerrar();
        return query.list();
    }
    
    public static void Update(EjercicioMaterial em){
        c.abrir();

        c.session.update(em);
        
        c.cerrar();
    }
    
    public static void Delete(int em){
        c.abrir();

        Query query = c.session.createQuery("delete EjercicioMaterial where id = :id");
        query.setParameter("id", em);
        int result = query.executeUpdate();
        
        c.cerrar();
    }
}
