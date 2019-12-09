/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpirres.vista;

import com.alpirres.Controller.MaterialController;
import com.alpirres.Modelo.Material;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alfon
 */
public class MaterialTablaModel extends AbstractTableModel {
    
    private MaterialController mcontrol;
    private List<Material> datos = new ArrayList<>();

    public MaterialTablaModel(MaterialController usucontrol) {
        this.mcontrol = usucontrol;
        updateModel();
    }

    public void updateModel() {
        datos=mcontrol.Leer();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id";
            case 1:
                return "Nombre";
            case 2:
                return "Peso";
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
                    return datos.get(rowIndex).getNombre();
                case 2:
                    return datos.get(rowIndex).getPeso();
                default:
                    return "";
            }

        } else {
            return "";
        }
    }
}
