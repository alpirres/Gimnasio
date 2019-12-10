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
    public EjercicioController e = new EjercicioController();
    public EMController em= new EMController();
    public CircuitoController c= new CircuitoController();
    public CEController ce = new CEController();
    
    public void start(){
        VistaGeneral vista= new VistaGeneral(this);
        vista.setVisible(true);
    }
    
    public boolean deleteCir(int id){
        boolean correcto=false;
        if(ce.ce.SearchId(id)){
            correcto=true;
        }if(s.ses.SearchId(id)){
            correcto=true;
        }
        return correcto;
    }
    
    public boolean deleteEjer(int id){
        boolean correcto=false;
        if(ce.ce.SearchIdE(id)){
            correcto=true;
        }if(em.em.SearchIdE(id)){
            correcto=true;
        }
        return correcto;
    }
    
    public boolean deleteMat(int id){
        boolean correcto=em.em.SearchIdM(id);
        return correcto;
    }
    
    public boolean deleteUsu(int id){
        boolean correcto=us.us.SearchIdU(id);
        return correcto;
    }
    
    public boolean deleteSes(int id){
        boolean correcto=us.us.SearchIdS(id);
        return correcto;
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
    
    public int actUsu(int id,String dni, String nombre, String apellidos, String telefono){
        int num=1;
        if(validardni(dni)&& validarTlf(telefono)){
            u.usu.Update(id,dni, nombre, apellidos, Integer.parseInt(telefono));
        }else if(!validardni(dni)){
            num=2;
            if(!validarTlf(telefono)){
                num=4;
            }
        }else if(!validarTlf(telefono)){
            num=3;
            
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
    
    public int actMat(int id, String name, String peso) {
        int num=1;
        if(validarTexto(name)&& validarPeso(peso)){
           m.mat.Update(id,name,Integer.parseInt(peso));
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
    
    public int actCE(int id, String circu, String ejer){
        int num=1;
        if(comprobarCombo(ejer)&&comprobarCircus(circu)){
            ce.ce.Update(id, Integer.parseInt(circu), Integer.parseInt(ejer));
        }else if(!comprobarCircus(circu)){
            num=2;
            if(!comprobarCombo(ejer)){
                num=4;
            }
        }else if(!comprobarCombo(ejer)){
            num=3;
        }
        return num;
    }
    
    
    public int actEM(int id, String ejer, String mat){
        int num=1;
        if(comprobarCombo(ejer)&&comprobarMatri(mat)){
            em.em.Update(id, Integer.parseInt(ejer), Integer.parseInt(mat));
        }else if(!comprobarCombo(ejer)){
            num=2;
            if(!comprobarMatri(mat)){
                num=4;
            }
        }else if(!comprobarMatri(mat)){
            num=3;
        }
        return num;
    }
    
    
    public int crearEM( String ejer, String mat){
        int num=1;
        if(comprobarCombo(ejer)&&comprobarMatri(mat)){
            em.Insertar(Integer.parseInt(ejer), Integer.parseInt(mat));
        }else if(!comprobarCombo(ejer)){
            num=2;
            if(!comprobarMatri(mat)){
                num=4;
            }
        }else if(!comprobarMatri(mat)){
            num=3;
        }
        return num;
    }
    
    
    public int actUS(int id, String usu, String ses){
        int num=1;
        if(comprobarUsua(usu)&&comprobarSesi(ses)){
            us.us.Update(id, Integer.parseInt(ses),Integer.parseInt(usu));
        }else if(!comprobarUsua(usu)){
            num=2;
            if(!comprobarSesi(ses)){
                num=4;
            }
        }else if(!comprobarSesi(ses)){
            num=3;
        }
        return num;
    }
    
    public int crearUS(String usu, String ses){
        int num=1;
        if(comprobarUsua(usu)&&comprobarSesi(ses)){
            us.Insertar(Integer.parseInt(ses), Integer.parseInt(usu));
        }else if(!comprobarUsua(usu)){
            num=2;
            if(!comprobarSesi(ses)){
                num=4;
            }
        }else if(!comprobarSesi(ses)){
            num=3;
        }
        return num;
    }
    
    public int actEje(int id,String name,String duracion, String repeticiones, String series ){
        int num=1;
        if(validarTexto(name)&&validaHora(duracion)){
            e.ejer.Update(id,name, Time.valueOf(duracion), Integer.parseInt(repeticiones), Integer.parseInt(series));
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
    public int actCircu(int id,String text) {
        int num=1;
        if(validarTexto(text)){
            c.cir.Update(id,text);
        }else{
            num=2;
        }
        return num;
    }
    
    public int comprobarSes(String fecha, String hora, String circu) {
        int num=1;
        if(validarFecha(fecha)&&validaHora(hora)&&validarCirci(circu)){
            s.Insertar(Integer.parseInt(circu),fecha,Time.valueOf(hora));
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
    public int actSes(int id,String fecha, String hora, String circu) {
        int num=1;
        if(validarFecha(fecha)&&validaHora(hora)&&validarCirci(circu)){
            s.ses.Update(id,Integer.parseInt(circu),fecha,Time.valueOf(hora));
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
    
    
    public boolean comprobarCircus(String item) {
        boolean correcto=false; 
        if(!item.equals("")){
            correcto=c.cir.SearchId(Integer.parseInt(item));
        }
        return correcto;
    }
    
    
    public boolean comprobarMatri(String item) {
        boolean correcto=false; 
        if(!item.equals("")){
            correcto=m.mat.SearchId(Integer.parseInt(item));
        }
        return correcto;
    }
    
    public boolean comprobarUsua(String item) {
        boolean correcto=false; 
        if(!item.equals("")){
            correcto=u.usu.SearchId(Integer.parseInt(item));
        }
        return correcto;
    }
    
    
    public boolean comprobarSesi(String item) {
        boolean correcto=false; 
        if(!item.equals("")){
            correcto=s.ses.SearchIds(Integer.parseInt(item));
        }
        return correcto;
    }
    
    
    
     public boolean validardni(String dni) {
 
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
     
    public boolean validarTlf(String telefono){
        boolean correcto=false;
        String patern1="^(6|7|8|9)([0-9]){8}$";
        if(Pattern.matches(patern1,telefono)){
            correcto=true;
        }
        return correcto;
    }
    
    public boolean validarTexto(String texto){
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
        String patern1="^([0-2][0-9]|3[0-1])(\\/)(0[1-9]|1[0-2])\\2(\\d{4})$";
        if(Pattern.matches(patern1,texto)){
            correcto=true;
        }
        return correcto;
    }

    private boolean validarCirci(String circu) {
        boolean correcto=false;
        if(!circu.equals("")){
            if(c.cir.SearchId(Integer.parseInt(circu))&&!s.ses.SearchId(Integer.parseInt(circu))){
                correcto=true;
            }
        }
        return correcto;
    }
}
