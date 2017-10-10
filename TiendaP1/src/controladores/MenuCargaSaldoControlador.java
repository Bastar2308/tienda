/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import gui.JfMenuCargaSaldo;
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
