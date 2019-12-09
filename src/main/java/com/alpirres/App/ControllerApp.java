/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpirres.App;

import com.alpirres.Controller.*;
import com.alpirres.vista.VistaGeneral;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.regex.Pattern;
import javax.swing.JComboBox;

/**
 *
 * @author alfon
 */
public class ControllerApp {
    public UsuarioController u=new UsuarioController();
    public USController us= new USController();
    public SesionController s= new SesionController();
    public MaterialController m = new MaterialController();
    public FacturaController f= new FacturaController();
    public EjercicioController e = new EjercicioController();
    public EMController em= new EMController();
    public CircuitoController c= new CircuitoController();
    public CEController ce = new CEController();
    
    public void start(){
        VistaGeneral vista= new VistaGeneral(this);
        vista.setVisible(true);
    }
    
    public int comprobarUsu(String dni, String nombre, String apellidos, String telefono){
        int num=1;
        if(validardni(dni)&& validarTlf(telefono)&& !u.usu.SearchDni(dni)){
            u.Insertar(dni, nombre, apellidos, Integer.parseInt(telefono));
        }else if(!validardni(dni)){
            num=2;
            if(!validarTlf(telefono)){
                num=4;
            }
        }else if(!validarTlf(telefono)){
            num=3;
            
        }
        else if(u.usu.SearchDni(dni)){
                num=5;
            }
        return num;
    }
    
    public int comprobarMat(String name, String peso) {
        int num=1;
        if(validarTexto(name)&& validarPeso(peso)){
           m.Insertar(name,Integer.parseInt(peso));
        }else if(!validarTexto(name)){
            num=2;
            if(!validarPeso(peso)){
                num=4;
            }
        }else if(!validarPeso(peso)){
            num=3;
        }
        return num;
    }
    
    public int comprobarEje(String name,String duracion, String repeticiones, String series ){
        int num=1;
        if(validarTexto(name)&&validaHora(duracion)){
            e.Insertar(name, Time.valueOf(duracion), Integer.parseInt(repeticiones), Integer.parseInt(series));
        }else if(!validarTexto(name)){
            num=2;
            if(!validaHora(duracion)){
                num=4;
            }
        }else if(!validaHora(duracion)){
            num=3;
        }
        return num;
    }
    
    public int comprobarCircu(String text, JComboBox<String> comboEje) {
        int num=1;
        if(validarTexto(text)){
            int id = c.Insertar(text);
            if(comboEje.getItemCount()!=0){
                for (int i=1; i<comboEje.getItemCount();i++) {
                    ce.Insertar(id, Integer.parseInt(comboEje.getItemAt(i)));
                }
            }
        }else{
            num=2;
        }
        return num;
    }
    
    public int comprobarSes(String fecha, String hora, String circu) {
        int num=1;
        if(validarFecha(fecha)&&validaHora(hora)&&validarCirci(circu)){
            s.Insertar(Integer.parseInt(circu),Timestamp.valueOf(fecha),Time.valueOf(hora));
        }else if(!validarFecha(fecha)){
            num=2;
            if(!validaHora(hora)){
                num=3;
                if(!validarCirci(circu)){
                    num=4;
                }
            }else if(!validarCirci(circu)){
                num=5;
            }
        }else if(!validaHora(hora)){
            num=6;
            if(!validarCirci(circu)){
                num=7;
            }
        }else if (!validarCirci(circu)){
            num=8;
        }
        
        return num;
    }
    
    public boolean comprobarCombo(String item) {
        boolean correcto=false; 
        if(!item.equals("")){
            correcto=e.ejer.SearchId(Integer.parseInt(item));
        }
        return correcto;
    }
    
     public static boolean validardni(String dni) {
 
        boolean esValido = false;
        int i = 0;
        int caracterASCII = 0;
        char letra = ' ';
        int miDNI = 0;
        int resto = 0;
        char[] asignacionLetra = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X','B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
 
 
        if(dni.length() == 9 && Character.isLetter(dni.charAt(8))) {
 
            do {
                caracterASCII = dni.codePointAt(i);
                esValido = (caracterASCII > 47 && caracterASCII < 58);
                i++;
            } 
            while(i < dni.length() - 1 && esValido);     
        }
 
        if(esValido) {
            letra = Character.toUpperCase(dni.charAt(8));
            miDNI = Integer.parseInt(dni.substring(0,8));
            resto = miDNI % 23;
            esValido = (letra == asignacionLetra[resto]);
        }
 
        return esValido;
    }
     
    public static boolean validarTlf(String telefono){
        boolean correcto=false;
        String patern1="^(6|7|8|9)([0-9]){8}$";
        if(Pattern.matches(patern1,telefono)){
            correcto=true;
        }
        return correcto;
    }
    
    public static boolean validarTexto(String texto){
        boolean correcto=false;
        String patern1="^[A-Za-z]+$";
        if(Pattern.matches(patern1,texto)){
            correcto=true;
        }
        return correcto;
    }

    private boolean validarPeso(String peso) {
        boolean correcto=false;
        String patern1="^[1-4]?(\\d{1,2})$";
        if(Pattern.matches(patern1,peso)){
            correcto=true;
        }
        return correcto;
    }

    private boolean validaHora(String duracion) {
        boolean correcto=false;
        String patern1="^([0-1]?\\d|2[0-3])(?::([0-5]?\\d))(?::([0-5]?\\d))$";
        if(Pattern.matches(patern1,duracion)){
            correcto=true;
        }
        return correcto;
    }
    
    public static boolean validarFecha(String texto){
        boolean correcto=false;
        String patern1="^([0-2][0-9]|3[0-1])(\\-)(0[1-9]|1[0-2])\\2(\\d{4})$";
        if(Pattern.matches(patern1,texto)){
            correcto=true;
        }
        return correcto;
    }

    private boolean validarCirci(String circu) {
        boolean correcto=false;
        if(!circu.equals("")){
            correcto=c.cir.SearchId(Integer.parseInt(circu));
        }
        return correcto;
    }
}
