package com.alpirres.Modelo;
// Generated 03-dic-2019 8:56:38 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Circuito generated by hbm2java
 */
public class Circuito  implements java.io.Serializable {


     private Integer id;
     private String nombre;
     private Set circuEjercicios = new HashSet(0);
     private Set sesions = new HashSet(0);

    public Circuito() {
    }

	
    public Circuito(String nombre) {
        this.nombre = nombre;
    }
    public Circuito(String nombre, Set circuEjercicios, Set sesions) {
       this.nombre = nombre;
       this.circuEjercicios = circuEjercicios;
       this.sesions = sesions;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Set getCircuEjercicios() {
        return this.circuEjercicios;
    }
    
    public void setCircuEjercicios(Set circuEjercicios) {
        this.circuEjercicios = circuEjercicios;
    }
    public Set getSesions() {
        return this.sesions;
    }
    
    public void setSesions(Set sesions) {
        this.sesions = sesions;
    }




}


