package com.alpirres.Modelo;
// Generated 03-dic-2019 8:56:38 by Hibernate Tools 4.3.1



/**
 * EjercicioMaterial generated by hbm2java
 */
public class EjercicioMaterial  implements java.io.Serializable {


     private Integer id;
     private Ejercicio ejercicio;
     private Material material;

    public EjercicioMaterial() {
    }

    public EjercicioMaterial(Ejercicio ejercicio, Material material) {
       this.ejercicio = ejercicio;
       this.material = material;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Ejercicio getEjercicio() {
        return this.ejercicio;
    }
    
    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }
    public Material getMaterial() {
        return this.material;
    }
    
    public void setMaterial(Material material) {
        this.material = material;
    }




}

