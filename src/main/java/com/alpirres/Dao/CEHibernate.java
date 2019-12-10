/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpirres.Dao;

import static com.alpirres.Dao.CircuitoHibernate.c;
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
    
    public static boolean SearchId(int id){
        boolean esta=false;
        c.abrir();
        
        Query query = c.session.createQuery("from CircuEjercicio where id_circuito= :id");
        query.setParameter("id", id);
        
        if (query.list().size()>0){
            esta=true;
        }
        c.cerrar();
        
        return esta;
    }
    
    public static boolean SearchIdE(int id){
        boolean esta=false;
        c.abrir();
        
        Query query = c.session.createQuery("from CircuEjercicio where id_ejercicio= :id");
        query.setParameter("id", id);
        
        if (query.list().size()>0){
            esta=true;
        }
        c.cerrar();
        
        return esta;
    }
    
    public static void Update(int id, int id_circuito, int id_ejercicio){
        c.abrir();

        Query query = c.session.createQuery("update CircuEjercicio set id_circuito = :id_circuito , id_ejercicio= :id_ejercicio where id = :id");
        query.setParameter("id_circuito", id_circuito);
        query.setParameter("id_ejercicio", id_ejercicio);
        query.setParameter("id", id);
        int result = query.executeUpdate();
        
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
