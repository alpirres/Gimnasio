/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpirres.Controller;

import com.alpirres.Dao.FacturaHibernate;
import com.alpirres.Modelo.Factura;
import com.alpirres.Modelo.Usuario;
import com.alpirres.Utilities.Conection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author alfon
 */
public class FacturaController {
    
    static FacturaHibernate fac;
    static Conection c;
    
    public void Insertar(int usu, String dni, Date alta, int creditos, int precio){
        c.abrir();
        
        Usuario usuario =(Usuario) c.session.get(Usuario.class, usu);
        
        c.cerrar();
        
        Factura nuevo = new Factura(usuario, alta, creditos, precio);
        fac.Create(nuevo);
    }
    
    public List<Factura> Leer(){
        List<Factura> lista = new ArrayList<>();
        lista=fac.Select();
        return lista;
    }
    
    public void Actualizar(int id, int usu, String dni, Date alta, int creditos, int precio){
        c.abrir();
        
        Usuario usuario =(Usuario) c.session.get(Usuario.class, usu);
        Factura a = (Factura) c.session.get(Factura.class, id);
        a.setUsuario(usuario);
        a.setAlta(alta);
        a.setCreditos(creditos);
        a.setPrecio(precio);
        
        c.cerrar();
        fac.Update(a);
    }
    
    public void Borrar(int id)throws SQLException{
        fac.Delete(id);
    }
}
