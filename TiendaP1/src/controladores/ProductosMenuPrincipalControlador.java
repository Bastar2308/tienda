/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import auxiliares.GuiTools;
import dao.ProductoDAO;
import gui.JfMenuCategorias;
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
public class ProductosMenuPrincipalControlador implements ActionListener {

    JfProductosMenuPrincipal vista;

    public ProductosMenuPrincipalControlador(JfProductosMenuPrincipal vista) {
        this.vista = vista;
        addListeners();
        cargarTabla();
    }

    private  void cargarTabla() {

        try {
            DefaultTableModel datos = ProductoDAO.getInstance().cargarTabla();
            DefaultTableModel tm = (DefaultTableModel) vista.getJtDatos().getModel();
            tm.setRowCount(0);

            for (int filas = 0; filas < datos.getRowCount(); filas++) {
                tm.addRow(new Object[]{null, null, null, null});
                for (int columnas = 0; columnas < 3; columnas++) {
                    tm.setValueAt(datos.getValueAt(filas, columnas), filas, columnas + 1);
                    vista.getJtDatos().setModel(tm);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error cargando tabla: ui.abc.Categoria", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error cargando tabla ui.abc.Categoria: " + e);
        }
        
    }

    private void addListeners() {
        vista.getJbRegresar().addActionListener(this);
        vista.getJbControlDeMarcas().addActionListener(this);
        vista.getJbControlDeCategorias().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getJbRegresar())) {
            GuiTools.getInstance().regresaMenu(vista);
        } else if (e.getSource().equals(vista.getJbControlDeCategorias())) {
            GuiTools.getInstance().abre(vista, new JfMenuCategorias());
        } else if (e.getSource().equals(vista.getJbControlDeMarcas())) {
            GuiTools.getInstance().abre(vista, new JfMenuMarcas());
        }
    }

}
