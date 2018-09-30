/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import auxiliares.GuiTools;
import auxiliares.Prefs;
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
        Prefs.put(Prefs.NEGOCIO, vista.getJlNegocio().getText());
        Prefs.put(Prefs.ESCUELA, vista.getJlEscuela().getText());
        Prefs.put(Prefs.ENCARGADO, vista.getJlEncargado().getText());
        Prefs.put(Prefs.TELEFONO, vista.getJlTelefono().getText());
        Prefs.put(Prefs.DIRECCION, vista.getJlDireccion().getText());
    }

    private void cargaDatos() {
        vista.getJlNegocio().setText(Prefs.get(Prefs.NEGOCIO));
        vista.getJlEscuela().setText(Prefs.get(Prefs.ESCUELA));
        vista.getJlEncargado().setText(Prefs.get(Prefs.ENCARGADO));
        vista.getJlTelefono().setText(Prefs.get(Prefs.TELEFONO));
        vista.getJlDireccion().setText(Prefs.get(Prefs.DIRECCION));
    }
}
