/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import auxiliares.GuiTools;
import dao.ClienteDAO;
import dao.ProductoDAO;
import gui.JfMenuPrincipal;
import gui.JfPuntoDeVenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Blob;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pojo.Cliente;

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
        cargaClientes();
    }

    private void addListeners() {
        vista.getJbRegresar().addActionListener(this);
        vista.getJbAgregar().addActionListener(this);
        vista.getJbEliminar().addActionListener(this);
        vista.getJbLimpiar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getJbRegresar())) {
            GuiTools.getInstance().regresaMenu(vista);
        } else if (e.getSource().equals(vista.getJbAgregar())) {
            agrega();
        } else if (e.getSource().equals(vista.getJbEliminar())) {
            eliminar();
        } else if (e.getSource().equals(vista.getJbLimpiar())) {
            limpiar();
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

    private void agrega() {
        if (vista.getJtProductos().getSelectedRow()!=-1) {
            int cantidad=-1;
            try {
                cantidad=Integer.parseInt((String) JOptionPane.showInputDialog(null, "¿Qué cantidad agregar?", "Cantidad", JOptionPane.QUESTION_MESSAGE, null, null, "1"));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor válido", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (cantidad>0) {
                boolean yaAgregado=false;
                int idDelProductoYaAgregado=-1;
                for (int i=0; i<vista.getJtProductosSeleccionados().getRowCount(); i++) {
                    if (vista.getJtProductos().getValueAt(vista.getJtProductos().getSelectedRow(), 0)
                            ==vista.getJtProductosSeleccionados().getValueAt(i, 0)) {
                        yaAgregado=true;
                        idDelProductoYaAgregado=(int) vista.getJtProductos().getValueAt(vista.getJtProductos().getSelectedRow(), 0);
                    }
                }
                if (yaAgregado) {
                    for (int i=0; i<vista.getJtProductosSeleccionados().getRowCount(); i++) {
                        if ((int) vista.getJtProductosSeleccionados().getValueAt(i, 0)==idDelProductoYaAgregado) {
                            DefaultTableModel modelo=(DefaultTableModel) vista.getJtProductosSeleccionados().getModel();
                            int cantidadAntigua=(int) vista.getJtProductosSeleccionados().getValueAt(i, 6);
                            modelo.setValueAt(cantidadAntigua+cantidad, i, 6);
                        }
                    }
                } else {
                    DefaultTableModel productosSeleccionados=(DefaultTableModel) vista.getJtProductosSeleccionados().getModel();
                    productosSeleccionados.addRow(
                            new Object[]{
                                vista.getJtProductos().getValueAt(vista.getJtProductos().getSelectedRow(), 0),
                                vista.getJtProductos().getValueAt(vista.getJtProductos().getSelectedRow(), 1),
                                vista.getJtProductos().getValueAt(vista.getJtProductos().getSelectedRow(), 2),
                                vista.getJtProductos().getValueAt(vista.getJtProductos().getSelectedRow(), 4),
                                vista.getJtProductos().getValueAt(vista.getJtProductos().getSelectedRow(), 5),
                                vista.getJtProductos().getValueAt(vista.getJtProductos().getSelectedRow(), 6),
                                cantidad
                            });

                }
            }

        }
    }

    private void eliminar() {
        if (vista.getJtProductosSeleccionados().getSelectedRow()!=-1) {
            ((DefaultTableModel) vista.getJtProductosSeleccionados().getModel()).removeRow(vista.getJtProductosSeleccionados().getSelectedRow());
        }
    }

    private void limpiar() {
        ((DefaultTableModel) vista.getJtProductosSeleccionados().getModel()).setRowCount(0);
    }

    private void cargaClientes() {
        DefaultTableModel datos=ClienteDAO.getInstance().cargarClientes();
        for (int i=0; i<datos.getRowCount(); i++) {
            Cliente cliente=new Cliente();

            cliente.setIdCliente((int) datos.getValueAt(i, 0));
            cliente.setNombre((String) datos.getValueAt(i, 1));
            cliente.setSaldo((double) datos.getValueAt(i, 2));
            cliente.setGrupo_idGrupo((int) datos.getValueAt(i, 3));
            cliente.setQr((String) datos.getValueAt(i, 4));
            cliente.setFoto((Blob) datos.getValueAt(i, 5));
            cliente.setTutor((String) datos.getValueAt(i, 6));
            cliente.setTelefono((String) datos.getValueAt(i, 7));
            cliente.setCorreo((String) datos.getValueAt(i, 8));
            cliente.setCompras_sin_credencial((int) datos.getValueAt(i, 9));
            cliente.setVigencia((Date) datos.getValueAt(i, 10));

            vista.getJcbNombres().addItem(cliente);
        }
    }
}
