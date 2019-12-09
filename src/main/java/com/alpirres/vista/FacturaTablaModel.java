/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpirres.vista;

import com.alpirres.Controller.FacturaController;
import com.alpirres.Modelo.Factura;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alfon
 */
public class FacturaTablaModel extends AbstractTableModel {
    
    private FacturaController fcontrol;
    private List<Factura> datos = new ArrayList<>();

    public FacturaTablaModel(FacturaController fcontrol) {
        this.fcontrol = fcontrol;
        updateModel();
    }

    public void updateModel() {
        datos=fcontrol.Leer();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id";
            case 1:
                return "Fecha de Alta";
            case 2:
                return "Creditos";
            case 3:
                return "Precio";
            case 4:
                return "Id Usuario";
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
                    return datos.get(rowIndex).getAlta();
                case 2:
                    return datos.get(rowIndex).getCreditos();
                case 3:
                    return datos.get(rowIndex).getPrecio();
                case 4:
                    return datos.get(rowIndex).getUsuario().getId();
                default:
                    return "";
            }

        } else {
            return "";
        }
    }
}
