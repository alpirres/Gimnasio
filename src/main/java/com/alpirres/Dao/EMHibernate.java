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
    
    
    public static boolean SearchIdE(int id){
        boolean esta=false;
        c.abrir();
        
        Query query = c.session.createQuery("from EjercicioMaterial where id_ejercicio= :id");
        query.setParameter("id", id);
        
        if (query.list().size()>0){
            esta=true;
        }
        c.cerrar();
        
        return esta;
    }
    public static boolean SearchIdM(int id){
        boolean esta=false;
        c.abrir();
        
        Query query = c.session.createQuery("from EjercicioMaterial where id_material= :id");
        query.setParameter("id", id);
        
        if (query.list().size()>0){
            esta=true;
        }
        c.cerrar();
        
        return esta;
    }
    
    public static void Update(int id, int id_ejercicio, int id_material){
        c.abrir();

       Query query = c.session.createQuery("update EjercicioMaterial set id_ejercicio = :id_ejercicio , id_material= :id_material where id = :id");
        query.setParameter("id_ejercicio", id_ejercicio);
        query.setParameter("id_material", id_material);
        query.setParameter("id", id);
        int result = query.executeUpdate();
        
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
