/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import auxiliares.GuiTools;
import dao.GrupoDAO;
import gui.JfControlDeGrupos;
import gui.JfMenuClientes;
import gui.JfMenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author MAESTROAD
 */
public class ControlDeGruposControlador implements ActionListener {

    JfControlDeGrupos vista;
    GrupoDAO dao;

    public ControlDeGruposControlador(JfControlDeGrupos vista) {
        this.vista = vista;
        dao=new GrupoDAO();
        addListeners();
        cargarTabla();
    }

    private void addListeners() {
        vista.getJbRegresar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getJbRegresar())) {
            GuiTools.getInstance().abre(vista, new JfMenuClientes());
        }
    }

    public void cargarTabla() {
        vista.getJtDatos().setModel(dao.cargarTabla());
    }
}
