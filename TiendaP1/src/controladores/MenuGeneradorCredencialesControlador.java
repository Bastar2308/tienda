/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import auxiliares.GuiTools;
import dao.ClienteDAO;
import gui.JfGeneradorCredencial;
import gui.JfMenuGeneradorCredenciales;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author MAESTROAD
 */
public class MenuGeneradorCredencialesControlador implements ActionListener, MouseListener{

    JfMenuGeneradorCredenciales vista;

    public MenuGeneradorCredencialesControlador(JfMenuGeneradorCredenciales vista) {
        this.vista = vista;
        addListeners();
        cargaClientes();
        addMouseListener();
    }

    private void addListeners() {
        vista.getJbRegresar().addActionListener(this);
        vista.getTfBuscar().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                filtra();
            }

        });
        vista.getJbGenerar().addActionListener(this);
    }
    
    private void addMouseListener() {
        vista.getJtClientes().addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getJbRegresar())) {
            GuiTools.getInstance().regresaMenu(vista);
        } else if (e.getSource().equals(vista.getJbGenerar())) {
            GuiTools.getInstance().abre(vista, JfGeneradorCredencial.getInstance(vista.getId()));
        }
    }

    private void cargaClientes() {
        DefaultTableModel datos = ClienteDAO.getInstance().cargarTablaPuntoDeVenta();
        DefaultTableModel original = (DefaultTableModel) vista.getJtClientes().getModel();
        original.setRowCount(0);
        for (int i = 0; i < datos.getRowCount(); i ++) {
            original.addRow(new Object[]{datos.getValueAt(i, 0), datos.getValueAt(i, 1), datos.getValueAt(i, 2), datos.getValueAt(i, 3)});
        }
    }

    void filtra() {
        DefaultTableModel defaultTableModel = (DefaultTableModel) vista.getJtClientes().getModel();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<>(defaultTableModel);
        vista.getJtClientes().setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + vista.getTfBuscar().getText()));
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if (me.getSource().equals(vista.getJtClientes())) {
            vista.setId(Integer.parseInt(vista.getJtClientes().getValueAt(vista.getJtClientes().getSelectedRow(), 0).toString()));
            System.out.println(vista.getId());
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
}
