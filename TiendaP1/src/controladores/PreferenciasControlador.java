/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import auxiliares.GuiTools;
import gui.JfMenuCargaSaldo;
import gui.JfMenuClientes;
import gui.JfMenuPrincipal;
import gui.JfProductosMenuPrincipal;
import gui.JfPuntoDeVenta;
import gui.JfPreferencias;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author MAESTROAD
 */
public class PreferenciasControlador implements ActionListener {

    JfPreferencias vista;

    public PreferenciasControlador(JfPreferencias vista) {
        this.vista = vista;
        cargarListeners();
        cargaDatos();
    }

    private void cargarListeners() {
        vista.getJbRegresar().addActionListener(this);
        vista.getJbGuardar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getJbRegresar())) {
            GuiTools.getInstance().abre(vista, JfMenuPrincipal.getInstance());
        } else if (e.getSource().equals(vista.getJbGuardar())) {
            guarda();
        }
    }

    private void guarda() {
        
    }

    private void cargaDatos() {
//        vista.getJlNegocio(pref);
    }
}
