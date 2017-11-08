/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controladores;

import auxiliares.GuiTools;
import dao.Comida_del_diaDAO;
import gui.JfComidaDelDia;
import gui.JfMenuPrincipal;
import gui.JfProductosMenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ComidaDelDiaControlador implements ActionListener{

    JfComidaDelDia vista;
    
    public ComidaDelDiaControlador(JfComidaDelDia vista) {
        this.vista = vista;
        
        addListeners();
        cargarTabla();
    }

    public void cargarTabla() {
        vista.getJtDatos().setModel(Comida_del_diaDAO.getInstance().cargarTabla());
    }

    public void addListeners() {
        vista.getJbRegresar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getJbRegresar())) {
            GuiTools.getInstance().regresaMenu(vista);
        }
    }

    
}
