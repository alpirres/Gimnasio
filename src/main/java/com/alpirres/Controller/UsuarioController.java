/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpirres.Controller;

import com.alpirres.Dao.UsuarioHibernate;
import com.alpirres.Modelo.Usuario;
import com.alpirres.Utilities.Conection;
import com.alpirres.Utilities.HibernateUtilities_5;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 *
 * @author alfon
 */
public class UsuarioController {
    static Conection c;
    public UsuarioHibernate usu;
    
    public void Insertar(String dni, String nombre, String apellidos, int telefono){
        Usuario nuevo = new Usuario( dni,  nombre,  apellidos,  telefono);
        usu.Create(nuevo);
    }
    
    public List<Usuario> Leer(){
        List<Usuario> lista = new ArrayList<>();
        lista=usu.Select();
        return lista;
    }
    
    public void Actualizar(int id, String dni, String nombre, String apellidos, int telefono){
        c.abrir();

        Usuario a = (Usuario) c.session.get(Usuario.class, id);
        a.setDni(dni);
        a.setNombre(nombre);
        a.setApellidos(apellidos);
        a.setTelefono(telefono);
        
        c.cerrar();
        
        usu.Update(a);
    }
    
    public void Borrar(int id) throws SQLException{
        usu.Delete(id);
    }
    
}
