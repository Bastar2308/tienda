/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import auxiliares.GuiTools;
import dao.ProductoDAO;
import gui.JfMenuPrincipal;
import gui.JfPuntoDeVenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MAESTROAD
 */
public class PuntoDeVentaControlador implements ActionListener {

    JfPuntoDeVenta vista;

    public PuntoDeVentaControlador(JfPuntoDeVenta vista) {
        this.vista=vista;
        addListeners();
        cargaTabla();
    }

    private void addListeners() {
        vista.getJbRegresar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getJbRegresar())) {
            GuiTools.getInstance().regresaMenu(vista);
        }
    }

    private void cargaTabla() {
        DefaultTableModel original=(DefaultTableModel) vista.getJtProductos().getModel();
        original.setRowCount(0);
        DefaultTableModel datos=ProductoDAO.getInstance().cargarTabla();
        for (int i=0; i<datos.getRowCount(); i++) {
            original.addRow(new Object[]{datos.getValueAt(i, 0), datos.getValueAt(i, 1), datos.getValueAt(i, 2), datos.getValueAt(i, 3), datos.getValueAt(i, 4), datos.getValueAt(i, 5), datos.getValueAt(i, 6), datos.getValueAt(i, 7)});
        }
    }

}
