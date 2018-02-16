/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import auxiliares.GuiTools;
import dao.ClienteDAO;
import gui.JfControlDeGrupos;
import gui.JfMenuClientes;
import gui.JfMenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author MAESTROAD
 */
public class MenuClientesControlador implements ActionListener {

    JfMenuClientes vista;

    public MenuClientesControlador(JfMenuClientes vista) {
        this.vista = vista;

        addListeners();
        cargarTabla();
    }

    public void cargarTabla() {
        vista.getJtDatos().setModel(ClienteDAO.getInstance().cargarTabla());
    }

    private void addListeners() {
        vista.getJbRegresar().addActionListener(this);
        vista.getJbControlDeGrupos().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getJbRegresar())) {
            GuiTools.getInstance().regresaMenu(vista);
        } else if (e.getSource().equals(vista.getJbControlDeGrupos())) {
            GuiTools.getInstance().abre(vista, JfControlDeGrupos.getInstance());
        }
    }
}
