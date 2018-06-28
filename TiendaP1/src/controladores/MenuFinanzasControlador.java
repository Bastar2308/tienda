/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import auxiliares.GuiTools;
import com.toedter.calendar.JDateChooser;
import dao.ClienteDAO;
import dao.ConsultasDAO;
import gui.JfMenuFinanzas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import pojo.Cliente;

/**
 *
 * @author MAESTROAD
 */
public class MenuFinanzasControlador implements ActionListener {

    JfMenuFinanzas vista;

    public MenuFinanzasControlador(JfMenuFinanzas vista) {
        this.vista = vista;
        addListeners();
        cargaConsultas();
    }

    private void addListeners() {
        vista.getJbRegresar().addActionListener(this);
        vista.getJbConsultar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getJbRegresar())) {
            GuiTools.getInstance().regresaMenu(vista);
        }else if (e.getSource().equals(vista.getJbConsultar())) {
            cargaConsultas();
        }
    }

    private void cargaConsultas() {
        switch (vista.getJcbConsultas().getSelectedIndex()) {
            case 0: vista.getJtResultados().setModel(ConsultasDAO.getInstance().consulta(ConsultasDAO.VENTAS_POR_CATEGORIA));break;
            case 1: vista.getJtResultados().setModel(ConsultasDAO.getInstance().consulta(ConsultasDAO.VENTAS_POR_MARCA));break;
            case 2: vista.getJtResultados().setModel(ConsultasDAO.getInstance().consulta(ConsultasDAO.VENTAS_POR_PRODUCTO));break;
            default:throw new AssertionError();
        }
    }
}
