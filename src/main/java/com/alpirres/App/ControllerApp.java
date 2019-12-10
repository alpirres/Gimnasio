/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpirres.App;

import com.alpirres.Controller.*;
import com.alpirres.vista.VistaGeneral;
import java.sql.Time;
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
    
    
    /**
     * funcion que inici¡ializa la vista
     */
    public void start(){
        VistaGeneral vista= new VistaGeneral(this);
        vista.setVisible(true);
    }
    
    /**
     * funcion que comprueba si se puede eliminar un circuito mediante su id
     * @param id
     * @return boolean correcto
     */
    public boolean deleteCir(int id){
        boolean correcto=false;
        if(ce.ce.SearchId(id)){
            correcto=true;
        }if(s.ses.SearchId(id)){
            correcto=true;
        }
        return correcto;
    }
    
    /**
     * fincion que comprueba si se puede eliminar un ejercicio mediante su id
     * @param id
     * @return boolean correcto
     */
    public boolean deleteEjer(int id){
        boolean correcto=false;
        if(ce.ce.SearchIdE(id)){
            correcto=true;
        }if(em.em.SearchIdE(id)){
            correcto=true;
        }
        return correcto;
        
    }
    
    /**
     * 
     * @param id
     * @return boolean correcto
     */
    public boolean deleteMat(int id){
        boolean correcto=em.em.SearchIdM(id);
        return correcto;
    }
    
    /**
     * funcion que comprueba si se puede elimina un usuario mediante su id
     * @param id
     * @return boolean correcto
     */
    public boolean deleteUsu(int id){
        boolean correcto=us.us.SearchIdU(id);
        return correcto;
    }
    
    /**
     * funcion que comprueba si se puede eliminar una sesion mediante su id
     * @param id
     * @return boolean correcto
     */
    public boolean deleteSes(int id){
        boolean correcto=us.us.SearchIdS(id);
        return correcto;
    }
    
    /**
     * funcion que compreba los campos introducidos para que sean correctos y lo introduce en la base de datos
     * @param dni
     * @param nombre
     * @param apellidos
     * @param telefono
     * @return int num
     */
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
    
    /**
     * funcion que comprueba los campos de un usuario para ver si es posible actualizarlo
     * @param id
     * @param dni
     * @param nombre
     * @param apellidos
     * @param telefono
     * @return int num
     */
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
    
    /**
     * funcion que compreba los campos introducidos para que sean correctos y lo introduce en la base de datos
     * @param name
     * @param peso
     * @return 
     */
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
    
    /**
     * funcion que comprueba los campos de un material para ver si es posible actualizar en la bse de datos
     * @param id
     * @param name
     * @param peso
     * @return 
     */
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
    
    /**
     * funcion que compreba los campos introducidos para que sean correctos y lo introduce en la base de datos
     * @param name
     * @param duracion
     * @param repeticiones
     * @param series
     * @return 
     */
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
    
    /**
     * funcion que comprueba los campos del circuito y del ejercicio para ver si es posible actualizar la base de datos
     * @param id
     * @param circu
     * @param ejer
     * @return 
     */
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
    
    /**
     * funcion que comprueba los campos del ejercicio y del material para ver si es posible actualizar la base de datos
     * @param id
     * @param ejer
     * @param mat
     * @return 
     */
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
    
    /**
     * funcion que compreba los campos introducidos para que sean correctos y lo introduce en la base de datos
     * @param ejer
     * @param mat
     * @return 
     */
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
    
    /**
     * funcion que comprueba los campos del usuario y de la sesion para ver si es posible actualizar la base de datos
     * @param id
     * @param usu
     * @param ses
     * @return 
     */
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
    
    /**
     * funcion que compreba los campos introducidos para que sean correctos y lo introduce en la base de datos
     * @param usu
     * @param ses
     * @return 
     */
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
    
    /**
     * funcion que comprueba los campos del ejercicio para ver si es posible actualizar la base de datos
     * @param id
     * @param name
     * @param duracion
     * @param repeticiones
     * @param series
     * @return 
     */
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
    
    /**
     * funcion que compreba los campos introducidos para que sean correctos y lo introduce en la base de datos
     * @param text
     * @param comboEje
     * @return 
     */
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
    
    /**
     * funcion que comprueba los campos del circuito para ver si es posible actualizar la base de datos
     * @param id
     * @param text
     * @return 
     */
    public int actCircu(int id,String text) {
        int num=1;
        if(validarTexto(text)){
            c.cir.Update(id,text);
        }else{
            num=2;
        }
        return num;
    }
    
    /**
     * funcion que compreba los campos introducidos para que sean correctos y lo introduce en la base de datos
     * @param fecha
     * @param hora
     * @param circu
     * @return 
     */
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
    
    /**
     * funcion que comprueba los campos de la sesion para ver si es posible actualizar la base de datos
     * @param id
     * @param fecha
     * @param hora
     * @param circu
     * @return 
     */
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
    
    /**
     * funcion que compreba los campos introducidos para que sean correctos y lo introduce en la base de datos
     * @param item
     * @return 
     */
    public boolean comprobarCombo(String item) {
        boolean correcto=false; 
        if(!item.equals("")){
            correcto=e.ejer.SearchId(Integer.parseInt(item));
        }
        return correcto;
    }
    
    /**
     * funcion que compreba los campos introducidos para que sean correctos y lo introduce en la base de datos
     * @param item
     * @return 
     */
    public boolean comprobarCircus(String item) {
        boolean correcto=false; 
        if(!item.equals("")){
            correcto=c.cir.SearchId(Integer.parseInt(item));
        }
        return correcto;
    }
    
    /**
     * funcion que compreba los campos introducidos para que sean correctos y lo introduce en la base de datos
     * @param item
     * @return 
     */
    public boolean comprobarMatri(String item) {
        boolean correcto=false; 
        if(!item.equals("")){
            correcto=m.mat.SearchId(Integer.parseInt(item));
        }
        return correcto;
    }
    
    /**
     * funcion que compreba los campos introducidos para que sean correctos y lo introduce en la base de datos
     * @param item
     * @return 
     */
    public boolean comprobarUsua(String item) {
        boolean correcto=false; 
        if(!item.equals("")){
            correcto=u.usu.SearchId(Integer.parseInt(item));
        }
        return correcto;
    }
    
    /**
     * funcion que compreba los campos introducidos para que sean correctos y lo introduce en la base de datos
     * @param item
     * @return 
     */
    public boolean comprobarSesi(String item) {
        boolean correcto=false; 
        if(!item.equals("")){
            correcto=s.ses.SearchIds(Integer.parseInt(item));
        }
        return correcto;
    }
    
    /**
     * funcion que valida un dni
     * @param dni
     * @return 
     */
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
     
    
    /**
     * funcion que valida un telefon
     * @param telefono
     * @return 
     */
    public boolean validarTlf(String telefono){
        boolean correcto=false;
        String patern1="^(6|7|8|9)([0-9]){8}$";
        if(Pattern.matches(patern1,telefono)){
            correcto=true;
        }
        return correcto;
    }
    
    
    /**
     * funcion que valida un texto
     * @param texto
     * @return 
     */
    public boolean validarTexto(String texto){
        boolean correcto=false;
        String patern1="^[A-Za-z]+$";
        if(Pattern.matches(patern1,texto)){
            correcto=true;
        }
        return correcto;
    }

    
    /**
     * funcion que valida un numero entre 1 y 500
     * @param peso
     * @return 
     */
    private boolean validarPeso(String peso) {
        boolean correcto=false;
        String patern1="^[1-4]?(\\d{1,2})$";
        if(Pattern.matches(patern1,peso)){
            correcto=true;
        }
        return correcto;
    }
    
    /**
     * funcion que valida la hora
     * @param duracion
     * @return 
     */
    private boolean validaHora(String duracion) {
        boolean correcto=false;
        String patern1="^([0-1]?\\d|2[0-3])(?::([0-5]?\\d))(?::([0-5]?\\d))$";
        if(Pattern.matches(patern1,duracion)){
            correcto=true;
        }
        return correcto;
    }
    
    /**
     * funcion que valida la fecha
     * @param texto
     * @return 
     */
    public static boolean validarFecha(String texto){
        boolean correcto=false;
        String patern1="^([0-2][0-9]|3[0-1])(\\/)(0[1-9]|1[0-2])\\2(\\d{4})$";
        if(Pattern.matches(patern1,texto)){
            correcto=true;
        }
        return correcto;
    }

    /**
     * funcion que comprueba que exista un circuito y que no este repetido en las sesiones
     * @param circu
     * @return 
     */
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
