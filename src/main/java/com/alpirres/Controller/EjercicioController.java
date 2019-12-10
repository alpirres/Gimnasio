/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpirres.Controller;

import com.alpirres.Dao.EjercicioHibernate;
import com.alpirres.Modelo.Ejercicio;
import com.alpirres.Utilities.Conection;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alfon
 */
public class EjercicioController {
    
    public EjercicioHibernate ejer;
    static Conection c;
    
    public void Insertar(String nombre, Time duracion, int repeticiones, int series){
        Ejercicio nuevo = new Ejercicio(nombre, duracion, repeticiones, series);
        ejer.Create(nuevo);
    }
    
    public List<Ejercicio> Leer(){
        List<Ejercicio> lista = new ArrayList<>();
        lista=ejer.Select();
        return lista;
    }
    
    public void Borrar(int id){
        ejer.Delete(id);
    }
}
