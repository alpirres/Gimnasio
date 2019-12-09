/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpirres.vista;

import com.alpirres.Controller.CircuitoController;
import com.alpirres.Modelo.Circuito;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alfon
 */
public class CircuitoTableModel extends AbstractTableModel {
    
    private CircuitoController ccontrol;
    private List<Circuito> datos = new ArrayList<>();

    public CircuitoTableModel(CircuitoController ccontrol) {
        this.ccontrol = ccontrol;
        updateModel();
    }

    public void updateModel() {
        datos=ccontrol.Leer();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id";
            case 1:
                return "Nombre";
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
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (datos != null) {
            switch (columnIndex) {
                case 0:
                    return datos.get(rowIndex).getId();
                case 1:
                    return datos.get(rowIndex).getNombre();
                default:
                    return "";
            }

        } else {
            return "";
        }
    }
}
