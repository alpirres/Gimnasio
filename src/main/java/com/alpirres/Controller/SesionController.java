/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpirres.Controller;

import com.alpirres.Dao.SesionHibernate;
import com.alpirres.Modelo.Circuito;
import com.alpirres.Modelo.Sesion;
import com.alpirres.Utilities.Conection;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alfon
 */
public class SesionController {
    
    public SesionHibernate ses;
    static Conection c;
    
    public void Insertar(int circu, String fecha, Time horao){
        c.abrir();
        
        Circuito circuito =(Circuito) c.session.get(Circuito.class, circu);
        
        c.cerrar();
        
        Sesion nuevo = new Sesion(circuito, fecha, horao);
        ses.Create(nuevo);
    }
    
    public List<Sesion> Leer(){
        List<Sesion> lista = new ArrayList<>();
        lista=ses.Select();
        return lista;
    }
    
    
    public void Borrar(int id){
       ses.Delete(id);
    }
}
