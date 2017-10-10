/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import gui.JfMenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author MAESTROAD
 */
public class MenuPrincipalControlador implements ActionListener {

    JfMenuPrincipal vista;

    public MenuPrincipalControlador(JfMenuPrincipal vista) {
        this.vista = vista;
        cargarListeners();
    }

    private void cargarListeners() {
        vista.getJbAyuda().addActionListener(this);
        vista.getJbCargarSaldo().addActionListener(this);
        vista.getJbClientes().addActionListener(this);
        vista.getJbFinanzas().addActionListener(this);
        vista.getJbGeneradorDeCredenciales().addActionListener(this);
        vista.getJbPuntoDeVentas().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getJbAyuda())) {

        } else if (e.getSource().equals(vista.getJbCargarSaldo())) {

        } else if (e.getSource().equals(vista.getJbClientes())) {

        } else if (e.getSource().equals(vista.getJbFinanzas())) {

        } else if (e.getSource().equals(vista.getJbGeneradorDeCredenciales())) {

        } else if (e.getSource().equals(vista.getJbPuntoDeVentas())) {

        }
    }
}
