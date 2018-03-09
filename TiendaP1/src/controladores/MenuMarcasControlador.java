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
import pojo.Marca;

/**
 *
 * @author MAESTROAD
 */
public class MenuMarcasControlador implements ActionListener {

    JfMenuMarcas vista;

    public MenuMarcasControlador(JfMenuMarcas vista) {
        this.vista = vista;
        cargarListeners();
        configuraJDialogs();
        cargarTabla();
    }

    public void cargarTabla() {
        DefaultTableModel datos = MarcaDAO.getInstance().cargarTabla();
        DefaultTableModel original = (DefaultTableModel) vista.getJtDatos().getModel();
        original.setRowCount(0);
        for (int i = 0; i < datos.getRowCount(); i ++) {
            original.addRow(new Object[]{datos.getValueAt(i, 0), datos.getValueAt(i, 1)});
        }
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getJbRegresar())) {
            GuiTools.getInstance().abre(vista, JfProductosMenuPrincipal.getInstance());
        } else if (e.getSource().equals(vista.getJbAgregar())) {
            abreAgregar();
        } else if (e.getSource().equals(vista.getJbEditar())) {
            abreEditar();
        } else if (e.getSource().equals(vista.getJbEliminar())) {
            eliminar();
        } else if (e.getSource().equals(vista.getJbAgregarCancelar())) {
            vista.getJdAgregar().setVisible(false);
        } else if (e.getSource().equals(vista.getJbAgregarAceptar())) {
            agregar();
        } else if (e.getSource().equals(vista.getJbEditarCancelar())) {
            vista.getJdEditar().setVisible(false);
        } else if (e.getSource().equals(vista.getJbEditarAceptar())) {
            editar();
        }
    }

    private void eliminar() {
        if (vista.getJtDatos().getSelectedRow() != -1) {
            if (MarcaDAO.getInstance().eliminaMarca((int) vista.getJtDatos().getValueAt(vista.getJtDatos().getSelectedRow(), 0))) {
                JOptionPane.showMessageDialog(null, "Marca eliminada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                cargarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "Error eliminando marca", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private void editar() {
        Marca marca = new Marca();
        marca.setIdMarca((int) vista.getJtDatos().getValueAt(vista.getJtDatos().getSelectedRow(), 0));
        marca.setNombre(vista.getTfEditarNombre().getText());
        if (MarcaDAO.getInstance().modificaMarca(marca)) {
            JOptionPane.showMessageDialog(null, "Marca modificada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            cargarTabla();
            vista.getJdEditar().setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Error modificando marca", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void agregar() {
        Marca marca = new Marca();
        marca.setNombre(vista.getTfAgregarNombre().getText());
        int exito = MarcaDAO.getInstance().insertaMarca(marca);
        if (exito > 0) {
            JOptionPane.showMessageDialog(null, "Marca agregada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            cargarTabla();
            vista.getJdAgregar().setVisible(false);
            vista.getTfAgregarNombre().setText(null);
        } else {
            JOptionPane.showMessageDialog(null, "Error agregando marca", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void abreAgregar() {
        vista.getJdAgregar().setVisible(true);
    }

    private void abreEditar() {
        if (vista.getJtDatos().getSelectedRow() != -1) {
            vista.getTfEditarNombre().setText((String) vista.getJtDatos().getValueAt(vista.getJtDatos().getSelectedRow(), 1));
            vista.getJdEditar().setVisible(true);
        }
    }

    private void configuraJDialogs() {
        vista.getJdAgregar().setSize(vista.getJdAgregar().getPreferredSize().width, vista.getJdAgregar().getPreferredSize().height + 30);
        vista.getJdEditar().setSize(vista.getJdEditar().getPreferredSize().width, vista.getJdEditar().getPreferredSize().height + 30);
        vista.getJdEditar().setLocationRelativeTo(null);
        vista.getJdAgregar().setLocationRelativeTo(null);
    }
}
