/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpirres.vista;

import com.alpirres.Controller.SesionController;
import com.alpirres.Modelo.Sesion;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alfon
 */
public class SesionTablaModel extends AbstractTableModel {
    
    private SesionController scontrol;
    private List<Sesion> datos = new ArrayList<>();

    public SesionTablaModel(SesionController usucontrol) {
        this.scontrol = usucontrol;
        updateModel();
    }

    public void updateModel() {
        datos=scontrol.Leer();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id";
            case 1:
                return "Fecha";
            case 2:
                return "Hora";
            case 3:
                return "Id Circuito";
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
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return datos.get(rowIndex).getId();
            case 1:
                return datos.get(rowIndex).getFecha();
            case 2:
                return datos.get(rowIndex).getHora();
            case 3:
                return datos.get(rowIndex).getCircuito().getId();
            default:
                return "";
        }
    }
}
