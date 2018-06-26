/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import auxiliares.GuiTools;
import com.toedter.calendar.JDateChooser;
import dao.ConsultasDAO;
import gui.JfMenuFinanzas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.JOptionPane;

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
            case 3: 
                 JDateChooser desde = new JDateChooser();
                 JDateChooser hasta = new JDateChooser();
                 JOptionPane.showConfirmDialog(null, new Object[]{"Desde:",desde,"Hasta:",hasta}, "Rango", JOptionPane.PLAIN_MESSAGE);
                vista.getJtResultados().setModel(ConsultasDAO.getInstance().consultaComprasEnRango(new Date(desde.getDate().getTime()) ,new Date(hasta.getDate().getTime()) ));break;
            default:throw new AssertionError();
        }
    }
}
