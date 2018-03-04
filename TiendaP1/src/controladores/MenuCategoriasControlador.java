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
import javax.swing.table.DefaultTableModel;

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
        vista.getJbEliminarAceptar().addActionListener(this);
        vista.getJbEliminarCancelar().addActionListener(this);

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
            abreEliminar();
        } else if (e.getSource().equals(vista.getJbEliminarAceptar())) {
            elimina();
        } else if (e.getSource().equals(vista.getJbEliminarCancelar())) {
            vista.getJdEliminar().setVisible(false);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void abreEliminar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void elimina() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void agrega() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void edita() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void configuraJDialogs() {
        vista.getJdAgregar().setSize(vista.getJdAgregar().getPreferredSize().width,vista.getJdAgregar().getPreferredSize().height+30);
        vista.getJdEditar().setSize(vista.getJdEditar().getPreferredSize().width,vista.getJdEditar().getPreferredSize().height+30);
        vista.getJdEditar().setLocationRelativeTo(null);
        vista.getJdAgregar().setLocationRelativeTo(null);
    }
}
