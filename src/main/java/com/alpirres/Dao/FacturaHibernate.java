/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpirres.Dao;

import com.alpirres.Modelo.Factura;
import com.alpirres.Utilities.Conection;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author alfon
 */
public class FacturaHibernate {
    public static Conection c;
     
    public static void Create(Factura f){
        c.abrir();

        c.session.save(f);

        c.cerrar();
    }
    
    public static List<Factura> Select(){
        c.abrir();

        Query query = c.session.createQuery("from Factura");
        
        c.cerrar();
        return query.list();
    }
    
    public static void Update(Factura f){
        c.abrir();

        c.session.update(f);
        
        c.cerrar();
    }
    
    public static void Delete(int f){
        c.abrir();

        Query query = c.session.createQuery("delete Factura where id = :id");
        query.setParameter("id", f);
        int result = query.executeUpdate();
        
        c.cerrar();
    }
}
