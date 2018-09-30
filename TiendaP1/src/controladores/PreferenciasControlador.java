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
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author MAESTROAD
 */
public class PreferenciasControlador implements ActionListener {

    JfPreferencias vista;
    private boolean modifico;

    public PreferenciasControlador(JfPreferencias vista) {
        this.vista = vista;
        cargarListeners();
        cargaDatos();
        modifico = false;
    }

    private void cargarListeners() {
        KeyAdapter keyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                modifico = true;
            }
        };
        vista.getJlNegocio().addKeyListener(keyAdapter);
        vista.getJlEscuela().addKeyListener(keyAdapter);
        vista.getJlDireccion().addKeyListener(keyAdapter);
        vista.getJlTelefono().addKeyListener(keyAdapter);
        vista.getJlEncargado().addKeyListener(keyAdapter);

        vista.getJbRegresar().addActionListener(this);
        vista.getJbGuardar().addActionListener(this);
        vista.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                cargaDatos();
                modifico = false;
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getJbRegresar())) {
            intentaRegresar();
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

        JOptionPane.showMessageDialog(null, "Preferencias actualizadas", "Información", JOptionPane.INFORMATION_MESSAGE);
        regresa();
    }

    private void cargaDatos() {
        vista.getJlNegocio().setText(Prefs.get(Prefs.NEGOCIO));
        vista.getJlEscuela().setText(Prefs.get(Prefs.ESCUELA));
        vista.getJlEncargado().setText(Prefs.get(Prefs.ENCARGADO));
        vista.getJlTelefono().setText(Prefs.get(Prefs.TELEFONO));
        vista.getJlDireccion().setText(Prefs.get(Prefs.DIRECCION));
    }

    private void regresa() {
        GuiTools.getInstance().abre(vista, JfMenuPrincipal.getInstance());
    }

    private void intentaRegresar() {
        if (modifico) {
            System.out.println("MODIFICOOO");
            if (JOptionPane.showConfirmDialog(null, "¿Regresar sin guardar cambios?", "Información", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)
                    == JOptionPane.YES_OPTION) {
                regresa();
            }
        } else {
            regresa();
        }
    }
}
