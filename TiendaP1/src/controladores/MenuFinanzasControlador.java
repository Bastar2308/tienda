/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import auxiliares.GuiTools;
import gui.JfMenuFinanzas;
import gui.JfMenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author MAESTROAD
 */
public class MenuFinanzasControlador implements ActionListener {

    JfMenuFinanzas vista;

    public MenuFinanzasControlador(JfMenuFinanzas vista) {
        this.vista = vista;
        addListeners();
    }

    private void addListeners() {
        vista.getJbRegresar().addActionListener(this);
        vista.getJbConsultar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getJbRegresar())) {
            GuiTools.getInstance().regresaMenu(vista);
        } else if (e.getSource().equals(vista.getJbConsultar())) {
            consulta(vista.getJcbConsultas().getSelectedIndex());
        }
    }

    private void consulta(int selectedIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
