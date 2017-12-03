/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import auxiliares.GuiTools;
import gui.JfMenuCargaSaldo;
import gui.JfMenuClientes;
import gui.JfMenuFinanzas;
import gui.JfMenuGeneradorCredenciales;
import gui.JfMenuPrincipal;
import gui.JfProductosMenuPrincipal;
import gui.JfPuntoDeVenta;
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
        vista.getJbMenuProductos().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getJbAyuda())) {
            //No hay ayuda aún
        } else if (e.getSource().equals(vista.getJbCargarSaldo())) {
            GuiTools.getInstance().abre(vista, JfMenuCargaSaldo.getInstance());
        } else if (e.getSource().equals(vista.getJbClientes())) {
            GuiTools.getInstance().abre(vista, JfMenuClientes.getInstance());
        } else if (e.getSource().equals(vista.getJbFinanzas())) {
            GuiTools.getInstance().abre(vista, JfMenuFinanzas.getInstance());
        } else if (e.getSource().equals(vista.getJbGeneradorDeCredenciales())) {
            GuiTools.getInstance().abre(vista, JfMenuGeneradorCredenciales.getInstance());
        } else if (e.getSource().equals(vista.getJbPuntoDeVentas())) {
            GuiTools.getInstance().abre(vista, JfPuntoDeVenta.getInstance());
        } else if (e.getSource().equals(vista.getJbMenuProductos())) {
            GuiTools.getInstance().abre(vista, JfProductosMenuPrincipal.getInstance());
        }
    }
}
