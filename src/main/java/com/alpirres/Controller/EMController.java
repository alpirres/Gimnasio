/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpirres.Controller;

import com.alpirres.Dao.EMHibernate;
import com.alpirres.Modelo.Ejercicio;
import com.alpirres.Modelo.EjercicioMaterial;
import com.alpirres.Modelo.Material;
import com.alpirres.Modelo.EjercicioMaterial;
import com.alpirres.Utilities.Conection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author alfon
 */
public class EMController {
    public EMHibernate em;
    static Conection c;
    
    public void Insertar(int ejer, int mat){
        c.abrir();
        
        Ejercicio ejercicio =(Ejercicio) c.session.get(Ejercicio.class, ejer);
        Material material = (Material) c.session.get(Material.class, mat);
        
        c.cerrar();
        
        EjercicioMaterial nuevo = new EjercicioMaterial(ejercicio,material);
        em.Create(nuevo);
    }
    
    public List<EjercicioMaterial> Leer(){
        List<EjercicioMaterial> lista = new ArrayList<>();
        lista=em.Select();
        return lista;
    }
    
    public void Borrar(int id){
        em.Delete(id);
    }
}
