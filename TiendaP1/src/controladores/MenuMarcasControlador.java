/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import auxiliares.GuiTools;
import dao.MarcaDAO;
import dao.ProductoDAO;
import gui.JfMenuMarcas;
import gui.JfProductosMenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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

    private void cargarTabla() {
        vista.getJtDatos().setModel(MarcaDAO.getInstance().cargarTabla());
    }

    private void cargarListeners() {
        vista.getJbRegresar().addActionListener(this);
        vista.getJbAgregar().addActionListener(this);
        vista.getJbEditar().addActionListener(this);
        vista.getJbEliminar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getJbRegresar())) {
            GuiTools.getInstance().abre(vista, JfProductosMenuPrincipal.getInstance());
        } else if (e.getSource().equals(vista.getJbAgregar())) {
            GuiTools.getInstance().abreDialogo(vista.getJdAgregar(), 652, 153);
        } else if (e.getSource().equals(vista.getJbEditar())) {
            GuiTools.getInstance().abreDialogo(vista.getJdEditar(), 652, 153);
        }
    }
}
