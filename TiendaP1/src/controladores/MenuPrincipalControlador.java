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
import javax.swing.JOptionPane;

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
        vista.getJbSalir().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getJbAyuda())) {
            JOptionPane.showMessageDialog(null, "Módulo en construcción", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource().equals(vista.getJbCargarSaldo())) {
            GuiTools.getInstance().abre(vista, JfMenuCargaSaldo.getInstance());
        } else if (e.getSource().equals(vista.getJbClientes())) {
            JOptionPane.showMessageDialog(null, "Módulo en construcción", "Información", JOptionPane.INFORMATION_MESSAGE);
//            GuiTools.getInstance().abre(vista, JfMenuClientes.getInstance());
        } else if (e.getSource().equals(vista.getJbFinanzas())) {
            JOptionPane.showMessageDialog(null, "Módulo en construcción", "Información", JOptionPane.INFORMATION_MESSAGE);
//            GuiTools.getInstance().abre(vista, JfMenuFinanzas.getInstance());
        } else if (e.getSource().equals(vista.getJbGeneradorDeCredenciales())) {
            JOptionPane.showMessageDialog(null, "Módulo en contrucción", "Información", JOptionPane.INFORMATION_MESSAGE);
//            GuiTools.getInstance().abre(vista, JfMenuGeneradorCredenciales.getInstance());
        } else if (e.getSource().equals(vista.getJbPuntoDeVentas())) {
            GuiTools.getInstance().abre(vista, JfPuntoDeVenta.getInstance());
        } else if (e.getSource().equals(vista.getJbMenuProductos())) {
            JOptionPane.showMessageDialog(null, "Módulo en construcción", "Información", JOptionPane.INFORMATION_MESSAGE);
//            GuiTools.getInstance().abre(vista, JfProductosMenuPrincipal.getInstance());
        }else if (e.getSource().equals(vista.getJbSalir())) {
            JOptionPane.showMessageDialog(null, "Adios");
            System.exit(0);
        }
    }
}
