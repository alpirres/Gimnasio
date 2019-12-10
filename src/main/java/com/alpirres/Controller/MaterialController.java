/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpirres.Controller;

import com.alpirres.Dao.MaterialHibernate;
import com.alpirres.Modelo.Material;
import com.alpirres.Utilities.Conection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author alfon
 */
public class MaterialController {
    
    public MaterialHibernate mat;
    static Conection c;
    
    public void Insertar(String nombre, int peso){
        Material nuevo = new Material(nombre, peso);
        mat.Create(nuevo);
    }
    
    public List<Material> Leer(){
        List<Material> lista = new ArrayList<>();
        lista=mat.Select();
        return lista;
    }
    
    
    public void Borrar(int id){
        mat.Delete(id);
    }
}
