/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import auxiliares.ControladorTools;
import auxiliares.DialogoTools;
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
        vista.getJbAgregarAceptar().addActionListener(this);
        vista.getJbAgregarCancelar().addActionListener(this);
        vista.getJbEditarAceptar().addActionListener(this);
        vista.getJbEditarCancelar().addActionListener(this);
        vista.getJbEliminarAceptar().addActionListener(this);
        vista.getJbEliminarCancelar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getJbRegresar())) {
            GuiTools.getInstance().abre(vista, JfProductosMenuPrincipal.getInstance());
        } else if (e.getSource().equals(vista.getJbAgregar())) {
            GuiTools.getInstance().abreDialogo(vista.getJdAgregar(), 652, 153);
        } else if (e.getSource().equals(vista.getJbEditar())) {
            GuiTools.getInstance().abreDialogo(vista.getJdEditar(), 652, 153);
        } else if (e.getSource().equals(vista.getJbEliminar())) {
            GuiTools.getInstance().abreDialogo(vista.getJdEliminar(), 350, 101);
        }else if (e.getSource().equals(vista.getJbAgregarCancelar())) {
            vista.getJdAgregar().dispose();
        }else if (e.getSource().equals(vista.getJbEditarCancelar())) {
            vista.getJdEditar().dispose();
        }else if (e.getSource().equals(vista.getJbEliminarCancelar())) {
            vista.getJdEliminar().dispose();
        }
    }

    private void eliminar() {
        int fs = vista.getJtDatos().getSelectedRow();
        if (fs == -1) {
            DialogoTools.getInstance().mensajeError("Primero selecciona una fila");
        } else {
            int id = ControladorTools.getInstance().idFilaSeleccionada(vista.getJtDatos());
            if (MarcaDAO.getInstance().eliminaMarca(id)) {
                DialogoTools.getInstance().mensajeInformacion("Éxito al eliminar");
                cargarTabla();
            } else {
                DialogoTools.getInstance().mensajeError("Error al eliminar");
            }
        }
    }
}
