/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpirres.Utilities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author alfon
 */
public class Conection {
    public static Session session;
    public static SessionFactory sf = HibernateUtilities_5.getSessionFactory();
    
    public static void abrir(){
        session = sf.openSession();
        session.beginTransaction();
    }
    
    public static void cerrar(){
        session.getTransaction().commit();
    }
}
