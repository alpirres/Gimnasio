/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpirres.Dao;


import com.alpirres.Modelo.Material;
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
public class MaterialHibernate {
    public static Conection c;
     
    public static void Create(Material m){
        c.abrir();

        c.session.save(m);

        c.cerrar();
    }
    
    public static List<Material> Select(){
        c.abrir();

        Query query = c.session.createQuery("from Material");
        
        c.cerrar();
        return query.list();
    }
    
    public static boolean SearchId(int id){
        boolean esta=false;
        c.abrir();
        
        Query query = c.session.createQuery("from Material where id= :id");
        query.setParameter("id", id);
        
        if (query.list().size()==1){
            esta=true;
        }
        c.cerrar();
        
        return esta;
    } 
    
    public static void Update(int id, String nombre, int peso){
        c.abrir();

        Query query = c.session.createQuery("update Material set  nombre= :nombre , peso= :peso where id = :id");
        query.setParameter("nombre", nombre);
        query.setParameter("peso", peso);
        query.setParameter("id", id);
        int result = query.executeUpdate();
        
        c.cerrar();
    }
    
    public static void Delete(int m){
        c.abrir();

        Query query = c.session.createQuery("delete Material where id = :id");
        query.setParameter("id", m);
        int result = query.executeUpdate();
        
        c.cerrar();
    }
}
