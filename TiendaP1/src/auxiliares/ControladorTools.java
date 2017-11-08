/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliares;

import dao.MarcaDAO;
import javax.swing.JTable;

/**
 *
 * @author Profesor Bastar
 */
public class ControladorTools {

    private ControladorTools() {
    }

    public static ControladorTools getInstance() {
        return ControladorToolsHolder.INSTANCE;
    }

    private static class ControladorToolsHolder {

        private static final ControladorTools INSTANCE = new ControladorTools();
    }

    public int idFilaSeleccionada(JTable tabla) {
        return Integer.parseInt(tabla.getValueAt(tabla.getSelectedRow(), 0).toString());
    }

    public boolean yaSeleccioneUnaFila(JTable tabla) {
        int fs = tabla.getSelectedRow();
        if (fs == -1) {
            DialogoTools.getInstance().mensajeError("Primero selecciona una fila");
            return false;
        } else {
            return true;
        }
    }
}
