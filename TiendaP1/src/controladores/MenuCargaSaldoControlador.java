/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import auxiliares.GuiTools;
import dao.ClienteDAO;
import gui.JfMenuCargaSaldo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.Enumeration;
import java.util.Iterator;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.apache.logging.log4j.core.config.builder.api.Component;

/**
 *
 * @author MAESTROAD
 */
public class MenuCargaSaldoControlador implements ActionListener {

    JfMenuCargaSaldo vista;

    public MenuCargaSaldoControlador(JfMenuCargaSaldo vista) {
        this.vista = vista;
        addListeners();
        cargaTabla();
        vista.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                cargaTabla();
            }
        });
    }

    public void addListeners() {
        vista.getJbAgregarSaldo().addActionListener(this);
        vista.getJbRegresar().addActionListener(this);
        vista.getTfBuscar().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                filtra();
            }

        });
        vista.getRb20().addActionListener(this);
        vista.getRb50().addActionListener(this);
        vista.getRb100().addActionListener(this);
        vista.getRb200().addActionListener(this);
        vista.getRb500().addActionListener(this);
        vista.getRb1000().addActionListener(this);
        vista.getRbOtra().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getJbRegresar())) {
            GuiTools.getInstance().regresaMenu(vista);
        } else if (e.getSource().equals(vista.getJbAgregarSaldo())) {
            agregarSaldo();
        } else if (e.getSource().equals(vista.getRb20())
                || e.getSource().equals(vista.getRb50())
                || e.getSource().equals(vista.getRb100())
                || e.getSource().equals(vista.getRb200())
                || e.getSource().equals(vista.getRb500())
                || e.getSource().equals(vista.getRb1000())) {
            vista.getJsOtra().setEnabled(false);
        } else if (e.getSource().equals(vista.getRbOtra())) {
            vista.getJsOtra().setEnabled(true);
        }
    }

    void filtra() {
        DefaultTableModel defaultTableModel = (DefaultTableModel) vista.getJtClientes().getModel();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<DefaultTableModel>(defaultTableModel);
        vista.getJtClientes().setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + vista.getTfBuscar().getText()));
    }

    private void cargaTabla() {
        DefaultTableModel original = (DefaultTableModel) vista.getJtClientes().getModel();
        original.setRowCount(0);
        DefaultTableModel datos = ClienteDAO.getInstance().cargarClientes();
        //Empieza desde 1 para no cargar public oen general
        for (int i = 1; i < datos.getRowCount(); i ++) {
            original.addRow(new Object[]{datos.getValueAt(i, 0), datos.getValueAt(i, 1), datos.getValueAt(i, 2), datos.getValueAt(i, 3), datos.getValueAt(i, 9)});
        }
    }

    private void agregarSaldo() {
        if (vista.getJtClientes().getSelectedRow() != -1 && haySaldoSeleccionado()) {
            if (ClienteDAO.getInstance().agregaSaldo(
                    vista.getJtClientes().getValueAt(vista.getJtClientes().getSelectedRow(), 0).toString(),
                    String.valueOf(obtenValorSeleccionado()))) {
                JOptionPane.showMessageDialog(null, "Saldo agregado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                vista.getJsOtra().setValue(0);
                cargaTabla();
            } else {
                JOptionPane.showMessageDialog(null, "Error agregando saldo", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    public Integer obtenValorSeleccionado() {
        if (vista.getRbOtra().isSelected()) {
            return (int) vista.getJsOtra().getValue();
        } else if (vista.getRb20().isSelected()) {
            return 20;
        } else if (vista.getRb50().isSelected()) {
            return 50;
        } else if (vista.getRb100().isSelected()) {
            return 100;
        } else if (vista.getRb200().isSelected()) {
            return 200;
        } else if (vista.getRb500().isSelected()) {
            return 500;
        } else if (vista.getRb1000().isSelected()) {
            return 1000;
        } else {
            return null;
        }
    }

    boolean haySaldoSeleccionado() {
        if (vista.getRbOtra().isSelected() && ((int) vista.getJsOtra().getValue()) > 0) {
            return true;
        } else if (vista.getRb20().isSelected()) {
            return true;
        } else if (vista.getRb50().isSelected()) {
            return true;
        } else if (vista.getRb100().isSelected()) {
            return true;
        } else if (vista.getRb200().isSelected()) {
            return true;
        } else if (vista.getRb500().isSelected()) {
            return true;
        } else if (vista.getRb1000().isSelected()) {
            return true;
        } else {
            return false;
        }
    }
}
