/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliares;

import gui.JfMenuPrincipal;
import javax.swing.JFrame;

/**
 *
 * @author MAESTROAD
 */
public class GuiTools {

    private GuiTools() {
    }

    public static GuiTools getInstance() {
        return GuiToolesHolder.INSTANCE;
    }

    private static class GuiToolesHolder {

        private static final GuiTools INSTANCE = new GuiTools();
    }

    public void abre(JFrame viejo, JFrame nuevo) {

        viejo.dispose();
        nuevo.setVisible(true);
    }

    public void regresaMenu(JFrame viejo) {
        viejo.dispose();
        JfMenuPrincipal.getInstance().setVisible(true);
    }
}
