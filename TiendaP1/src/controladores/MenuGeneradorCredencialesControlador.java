/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import auxiliares.GuiTools;
import dao.ClienteDAO;
import gui.JfMenuGeneradorCredenciales;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author MAESTROAD
 */
public class MenuGeneradorCredencialesControlador implements ActionListener {

    JfMenuGeneradorCredenciales vista;

    public MenuGeneradorCredencialesControlador(JfMenuGeneradorCredenciales vista) {
        this.vista = vista;
        addListeners();
        cargaClientes();
    }

    private void addListeners() {
        vista.getJbRegresar().addActionListener(this);
        vista.getTfBuscar().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                filtra();
            }

        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getJbRegresar())) {
            GuiTools.getInstance().regresaMenu(vista);
        }
    }

    private void cargaClientes() {
        DefaultTableModel datos = ClienteDAO.getInstance().cargarTablaPuntoDeVenta();
        DefaultTableModel original = (DefaultTableModel) vista.getJtClientes().getModel();
        original.setRowCount(0);
        for (int i = 1; i < datos.getRowCount(); i ++) {
            original.addRow(new Object[]{datos.getValueAt(i, 0), datos.getValueAt(i, 1), datos.getValueAt(i, 2), datos.getValueAt(i, 3)});
        }
    }

    void filtra() {
        DefaultTableModel defaultTableModel = (DefaultTableModel) vista.getJtClientes().getModel();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<>(defaultTableModel);
        vista.getJtClientes().setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + vista.getTfBuscar().getText()));
    }
}
