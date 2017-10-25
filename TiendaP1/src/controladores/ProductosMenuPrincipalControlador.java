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
import gui.JfMenuPrincipal;
import gui.JfProductosMenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public void cargarTabla() {
        vista.getJtDatos().setModel(ProductoDAO.getInstance().cargarTabla());
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
