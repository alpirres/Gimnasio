/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpirres.Controller;

import com.alpirres.Dao.CircuitoHibernate;
import com.alpirres.Modelo.Circuito;
import com.alpirres.Utilities.Conection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author alfon
 */
public class CircuitoController {
    public CircuitoHibernate cir;
    static Conection c;
    
    public int Insertar(String nombre){
        int id=0;
        Circuito nuevo = new Circuito(nombre);
        id=cir.Create(nuevo);
        return id;
    }
    
    public List<Circuito> Leer(){
        List<Circuito> lista = new ArrayList<>();
        lista=cir.Select();
        return lista;
    }
    
    
    
    public void Borrar(int id){
        cir.Delete(id);
    }
}
