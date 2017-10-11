/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import auxiliares.GuiTools;
import gui.JfMenuCargaSaldo;
import gui.JfMenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author MAESTROAD
 */
public class MenuCargaSaldoControlador implements ActionListener{
    JfMenuCargaSaldo vista;

    public MenuCargaSaldoControlador(JfMenuCargaSaldo vista) {
        this.vista = vista;
        addListeners();
    }
    public void addListeners(){
        vista.getJbRegresar().addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getJbRegresar())) {
            GuiTools.getInstance().abre(vista, new JfMenuPrincipal());
        }
    }
    
}
