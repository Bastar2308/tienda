/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import gui.JfGeneradorCredencial;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Fernando
 */
public class GeneradorCrendencialControlador implements ActionListener{
    JfGeneradorCredencial vista;

    public GeneradorCrendencialControlador(JfGeneradorCredencial vista) {
        this.vista = vista;
        cargarListeners();
    }

    private void cargarListeners() {
        vista.getJbTomar().addActionListener(this);
        vista.getJbRepetir().addActionListener(this);
        vista.getJbGuardar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getJbTomar())) {
            vista.getWcPanel().stop();
        } else if (e.getSource().equals(vista.getJbRepetir())) {
            
        } else if (e.getSource().equals(vista.getJbGuardar())) {
            
        } 
    }
}
