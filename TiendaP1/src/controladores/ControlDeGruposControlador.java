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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MAESTROAD
 */
public class ControlDeGruposControlador implements ActionListener {

    JfControlDeGrupos vista;

    public ControlDeGruposControlador(JfControlDeGrupos vista) {
        this.vista = vista;
        addListeners();
        cargarTabla();
    }

    private void addListeners() {
        vista.getJbRegresar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getJbRegresar())) {
            GuiTools.getInstance().abre(vista, JfMenuClientes.getInstance());
        }
    }

    public void cargarTabla() {
        DefaultTableModel datos = GrupoDAO.getInstance().cargarTabla();
        DefaultTableModel original = (DefaultTableModel) vista.getJtDatos().getModel();
        original.setRowCount(0);
        for (int i = 0; i < datos.getRowCount(); i++) {
            original.addRow(new Object[]{datos.getValueAt(i, 0), datos.getValueAt(i, 1), datos.getValueAt(i, 2), datos.getValueAt(i, 3)});
        }
    }
}
