/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpirres.vista;

import com.alpirres.Controller.USController;
import com.alpirres.Modelo.UsuarioSesion;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alfon
 */
public class USTablaModel extends AbstractTableModel {
    
    private USController uscontrol;
    private List<UsuarioSesion> datos = new ArrayList<>();

    public USTablaModel(USController uscontrol) {
        this.uscontrol = uscontrol;
        updateModel();
    }

    public void updateModel() {
        datos=uscontrol.Leer();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id";
            case 1:
                return "Id Usuario";
            case 2:
                return "Id Sesion";
            default:
                return "[no]";
        }
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return datos.get(rowIndex).getId();
            case 1:
                return datos.get(rowIndex).getUsuario().getId();
            case 2:
                return datos.get(rowIndex).getSesion().getId();
            default:
                return "";
        }
    }
}
