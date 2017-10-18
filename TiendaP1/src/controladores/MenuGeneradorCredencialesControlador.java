/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import auxiliares.GuiTools;
import gui.JfMenuGeneradorCredenciales;
import gui.JfMenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author MAESTROAD
 */
public class MenuGeneradorCredencialesControlador implements ActionListener{
    JfMenuGeneradorCredenciales vista;

    public MenuGeneradorCredencialesControlador(JfMenuGeneradorCredenciales vista) {
        this.vista = vista;
            addListeners();
    }

    private void addListeners() {
        vista.getJbRegresar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getJbRegresar())) {
            GuiTools.getInstance().regresaMenu(vista);
        }
    }
    
}
