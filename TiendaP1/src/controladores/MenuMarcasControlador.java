/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import auxiliares.GuiTools;
import dao.MarcaDAO;
import gui.JfMenuMarcas;
import gui.JfProductosMenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author MAESTROAD
 */
public class MenuMarcasControlador implements ActionListener {

    JfMenuMarcas vista;
  

    public MenuMarcasControlador(JfMenuMarcas vista) {
        this.vista = vista;
        cargarListeners();
        cargarTabla();
    }

    public void cargarTabla() {
        vista.getJtDatos().setModel(MarcaDAO.getInstance().cargarTabla());
    }

    private void cargarListeners() {
        vista.getJbRegresar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getJbRegresar())) {
            GuiTools.getInstance().abre(vista, new JfProductosMenuPrincipal());
        }
    }
}
