/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpirres.vista;

import com.alpirres.Controller.EMController;
import com.alpirres.Modelo.EjercicioMaterial;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alfon
 */
public class EMTablaModel extends AbstractTableModel {
    
    private EMController emcontrol;
    private List<EjercicioMaterial> datos = new ArrayList<>();

    public EMTablaModel(EMController emcontrol) {
        this.emcontrol = emcontrol;
        updateModel();
    }

    public void updateModel() {
        datos=emcontrol.Leer();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id";
            case 1:
                return "Id Ejercicio";
            case 2:
                return "Id Material";
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
                    return datos.get(rowIndex).getEjercicio().getId();
                case 2:
                    return datos.get(rowIndex).getMaterial().getId();
                default:
                    return "";
            }

        } else {
            return "";
        }
    }
}
