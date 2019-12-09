/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpirres.Controller;

import com.alpirres.Dao.CEHibernate;
import com.alpirres.Modelo.CircuEjercicio;
import com.alpirres.Modelo.Circuito;
import com.alpirres.Modelo.Ejercicio;
import com.alpirres.Utilities.Conection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author alfon
 */
public class CEController {
    
    static CEHibernate ce;
    static Conection c;
    
    public void Insertar(int circu, int ejer){
        c.abrir();
        
        Circuito circuito =(Circuito) c.session.get(Circuito.class, circu);
        Ejercicio ejercicio =(Ejercicio) c.session.get(Ejercicio.class, ejer);
        
        c.cerrar();
        
        CircuEjercicio nuevo = new CircuEjercicio(circuito, ejercicio);
        ce.Create(nuevo);
    }
    
    public List<CircuEjercicio> Leer(){
        List<CircuEjercicio> lista = new ArrayList<>();
        lista=ce.Select();
        return lista;
    }
    
    public void Actualizar(int id, int circu, int ejer){
        c.abrir();
        
        Circuito circuito =(Circuito) c.session.get(Circuito.class, circu);
        Ejercicio ejercicio =(Ejercicio) c.session.get(Ejercicio.class, ejer);
        
        CircuEjercicio a = (CircuEjercicio) c.session.get(CircuEjercicio.class, id);
        a.setCircuito(circuito);
        a.setEjercicio(ejercicio);
        
        c.cerrar();
        
        ce.Update(a);
    }
    
    public void Borrar(int id){
        ce.Delete(id);
    }
}
