/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpirres.vista;

import com.alpirres.Controller.EjercicioController;
import com.alpirres.Modelo.Ejercicio;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alfon
 */
public class EjercicioTablaModel extends AbstractTableModel {
    
    private EjercicioController econtrol;
    private List<Ejercicio> datos = new ArrayList<>();

    public EjercicioTablaModel(EjercicioController econtrol) {
        this.econtrol = econtrol;
        updateModel();
    }

    public void updateModel() {
        datos=econtrol.Leer();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id";
            case 1:
                return "Nombre";
            case 2:
                return "Duracion";
            case 3:
                return "Repeticiones";
            case 4:
                return "Series";
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
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (datos != null) {
            switch (columnIndex) {
                case 0:
                    return datos.get(rowIndex).getId();
                case 1:
                    return datos.get(rowIndex).getNombre();
                case 2:
                    return datos.get(rowIndex).getDuracion();
                case 3:
                    return datos.get(rowIndex).getRepeticiones();
                case 4:
                    return datos.get(rowIndex).getSeries();
                default:
                    return "";
            }

        } else {
            return "";
        }
    }
}
