/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import auxiliares.GuiTools;
import dao.CategoriaDAO;
import gui.JfMenuCategorias;
import gui.JfProductosMenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pojo.Categoria;

/**
 *
 * @author MAESTROAD
 */
public class MenuCategoriasControlador implements ActionListener {

    JfMenuCategorias vista;

    public MenuCategoriasControlador(JfMenuCategorias vista) {
        this.vista = vista;
        addListeners();
        configuraJDialogs();
        cargarTabla();
    }

    public void cargarTabla() {
        DefaultTableModel datos = CategoriaDAO.getInstance().cargarTabla();
        DefaultTableModel original = (DefaultTableModel) vista.getJtDatos().getModel();
        original.setRowCount(0);
        for (int i = 0; i < datos.getRowCount(); i ++) {
            original.addRow(new Object[]{datos.getValueAt(i, 0), datos.getValueAt(i, 1)});
        }
    }

    public void addListeners() {
        vista.getJbRegresar().addActionListener(this);
        vista.getJbAgregar().addActionListener(this);
        vista.getJbEditar().addActionListener(this);
        vista.getJbEliminar().addActionListener(this);

        vista.getJbAgregarAceptar().addActionListener(this);
        vista.getJbAgregarCancelar().addActionListener(this);

        vista.getJbEditarCancelar().addActionListener(this);
        vista.getJbEditarAceptar().addActionListener(this);
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
            elimina();
        } else if (e.getSource().equals(vista.getJbAgregarAceptar())) {
            agrega();
        } else if (e.getSource().equals(vista.getJbAgregarCancelar())) {
            vista.getJdAgregar().setVisible(false);
        } else if (e.getSource().equals(vista.getJbEditarCancelar())) {
            vista.getJdEditar().setVisible(false);
        } else if (e.getSource().equals(vista.getJbEditarAceptar())) {
            edita();
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

    private void elimina() {
        if (vista.getJtDatos().getSelectedRow() != -1) {
            if (CategoriaDAO.getInstance().eliminaCategoria((int) vista.getJtDatos().getValueAt(vista.getJtDatos().getSelectedRow(), 0))) {
                JOptionPane.showMessageDialog(null, "Categoría eliminada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                cargarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "Error eliminando categoría", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private void agrega() {
        Categoria categoria = new Categoria();
        categoria.setNombre(vista.getTfAgregarNombre().getText());
        int exito = CategoriaDAO.getInstance().insertaCategoria(categoria);
        if (exito > 0) {
            JOptionPane.showMessageDialog(null, "Categoría agregada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            cargarTabla();
            vista.getJdAgregar().setVisible(false);
            vista.getTfAgregarNombre().setText(null);
        } else {
            JOptionPane.showMessageDialog(null, "Error agregando categorías", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void edita() {
        Categoria categoria = new Categoria();
        categoria.setIdCategoria((int) vista.getJtDatos().getValueAt(vista.getJtDatos().getSelectedRow(), 0));
        categoria.setNombre(vista.getTfEditarNombre().getText());
        if (CategoriaDAO.getInstance().modificaCategoria(categoria)) {
            JOptionPane.showMessageDialog(null, "Categoría modificada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            cargarTabla();
            vista.getJdEditar().setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Error modificando categoría", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void configuraJDialogs() {
        vista.getJdAgregar().setSize(vista.getJdAgregar().getPreferredSize().width, vista.getJdAgregar().getPreferredSize().height + 30);
        vista.getJdEditar().setSize(vista.getJdEditar().getPreferredSize().width, vista.getJdEditar().getPreferredSize().height + 30);
        vista.getJdEditar().setLocationRelativeTo(null);
        vista.getJdAgregar().setLocationRelativeTo(null);
    }
}
