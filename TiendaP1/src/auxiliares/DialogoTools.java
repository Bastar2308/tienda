/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliares;

import javax.swing.JOptionPane;

/**
 *
 * @author Profesor Bastar
 */
public class DialogoTools {

    private DialogoTools() {
    }

    public static DialogoTools getInstance() {
        return DialogoToolsHolder.INSTANCE;
    }

    private static class DialogoToolsHolder {

        private static final DialogoTools INSTANCE = new DialogoTools();
    }

    public void mensajeError(String texto) {
        JOptionPane.showMessageDialog(null, texto, "Error", JOptionPane.ERROR_MESSAGE);
    }

}
