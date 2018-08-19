/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import auxiliares.GuiTools;
import auxiliares.MailTools;
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
import pojo.Cliente;

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
            public void keyReleased(KeyEvent e) {
                filtra();
            }
        });
        vista.getTfBuscar().addActionListener(this);
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
        } else if (e.getSource().equals(vista.getTfBuscar())) {
            vista.getJtClientes().changeSelection(0, 0, false, false);
            agregarSaldo();
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
        //Empieza desde 1 para no cargar publico oen general
        for (int i = 1; i < datos.getRowCount(); i ++) {
            original.addRow(new Object[]{datos.getValueAt(i, 0), datos.getValueAt(i, 1), datos.getValueAt(i, 2), datos.getValueAt(i, 9), datos.getValueAt(i, 4)});
        }
    }

    private void agregarSaldo() {
        if (vista.getJtClientes().getSelectedRow() != -1 && haySaldoSeleccionado() && JOptionPane.showConfirmDialog(null, "¿Agregar saldo?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            if (ClienteDAO.getInstance().agregaSaldo(
                    vista.getJtClientes().getValueAt(vista.getJtClientes().getSelectedRow(), 0).toString(),
                    String.valueOf(obtenValorSeleccionado()))) {
                JOptionPane.showMessageDialog(null, "Saldo agregado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                String id = vista.getJtClientes().getValueAt(vista.getJtClientes().getSelectedRow(), 0).toString();
                Cliente cliente = ClienteDAO.getInstance().buscaCliente(Integer.parseInt(id));
                MiHilo miHilo = new MiHilo(cliente.getCorreo(), String.valueOf(obtenValorSeleccionado()), String.valueOf(cliente.getSaldo()), cliente.getNombre());
                miHilo.start();
                vista.getJsOtra().setValue(0);
                vista.getRbOtra().setSelected(true);
                vista.getTfBuscar().setText(null);
                cargaTabla();
            } else {
                JOptionPane.showMessageDialog(null, "Error agregando saldo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Verifique el cliente y/o saldo a agregar", "Error", JOptionPane.ERROR_MESSAGE);
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
        if (vista.getRbOtra().isSelected() && ((int) vista.getJsOtra().getValue()) >= 0) {
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

    public boolean esCodigoEnClientes() {
        try {
            return vista.getTfBuscar().getText().substring(0, 5).equals("BSTR_");
        } catch (Exception e) {
            return false;
        }
    }
    
    public void enviaCorreo(String correo, String recarga, String saldo, String alumno){
        MailTools.getInstance().enviarCorreo(MailTools.getInstance().iniciarSesion("bastarpuntodeventa@hotmail.com", "puntodeventa23"), 
                correo, 
                "Recarga de saldo de "+alumno, 
                "Su recarga de $"+recarga+".00 ha sido realizada exitosamente para el alumno "+alumno+"\nSu saldo actual es de: $"+saldo+".");
        System.out.println("Enviado a: "+correo);
    }
    class MiHilo extends Thread{
        private String a;
        private String b;
        private String c;
        private String d;
        @Override
        public void run() {
            super.run(); //To change body of generated methods, choose Tools | Templates.
            enviaCorreo(a, b, c, d);
        }

        public MiHilo(String a, String b, String c, String d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
        
    }
}
