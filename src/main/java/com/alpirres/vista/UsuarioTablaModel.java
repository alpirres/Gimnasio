/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpirres.vista;

import com.alpirres.Controller.UsuarioController;
import com.alpirres.Modelo.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alfon
 */
public class UsuarioTablaModel extends AbstractTableModel {
    
    private UsuarioController usucontrol;
    private List<Usuario> datos = new ArrayList<>();

    public UsuarioTablaModel(UsuarioController usucontrol) {
        this.usucontrol = usucontrol;
        updateModel();
    }

    public void updateModel() {
        datos=usucontrol.Leer();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id";
            case 1:
                return "Nombre";
            case 2:
                return "Apellidos";
            case 3:
                return "Dni";
            case 4:
                return "Telefono";
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
                    return datos.get(rowIndex).getApellidos();
                case 3:
                    return datos.get(rowIndex).getDni();
                case 4:
                    return datos.get(rowIndex).getTelefono();
                default:
                    return "";
            }

        } else {
            return "";
        }
    }
}
