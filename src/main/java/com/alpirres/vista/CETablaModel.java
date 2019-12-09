/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpirres.vista;

import com.alpirres.Controller.CEController;
import com.alpirres.Modelo.CircuEjercicio;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alfon
 */
public class CETablaModel extends AbstractTableModel {
    
    private CEController cecontrol;
    private List<CircuEjercicio> datos = new ArrayList<>();

    public CETablaModel(CEController cecontrol) {
        this.cecontrol = cecontrol;
        updateModel();
    }

    public void updateModel() {
        datos=cecontrol.Leer();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id";
            case 1:
                return "Id Circuito";
            case 2:
                return "Id Ejercicio";
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
        if (datos != null) {
            switch (columnIndex) {
                case 0:
                    return datos.get(rowIndex).getId();
                case 1:
                    return datos.get(rowIndex).getCircuito().getId();
                case 2:
                    return datos.get(rowIndex).getEjercicio().getId();
                default:
                    return "";
            }

        } else {
            return "";
        }
    }
}
