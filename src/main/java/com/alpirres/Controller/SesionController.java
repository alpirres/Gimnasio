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
import com.alpirres.Utilities.HibernateUtilities_5;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author alfon
 */
public class SesionController {
    
    public SesionHibernate ses;
    static Conection c;
    
    public void Insertar(int circu, Timestamp fecha, Time horao){
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
    
    public void Actualizar(int id, int circu, Timestamp fecha, Time hora){
        c.abrir();
        
        Circuito circuito =(Circuito) c.session.get(Circuito.class, circu);
        Sesion a = (Sesion) c.session.get(Sesion.class, id);
        a.setCircuito(circuito);
        a.setFecha(fecha);
        a.setHora(hora);
        
        c.cerrar();
        
        ses.Update(a);
    }
    
    public void Borrar(int id)throws SQLException{
       ses.Delete(id);
    }
}
