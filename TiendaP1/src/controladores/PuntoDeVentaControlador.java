/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import auxiliares.GuiTools;
import dao.ClienteDAO;
import dao.Detalle_VentaDAO;
import dao.ProductoDAO;
import dao.VentaDAO;
import gui.JfMenuPrincipal;
import gui.JfPuntoDeVenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Blob;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pojo.Cliente;
import pojo.Detalle_Venta;
import pojo.Venta;

/**
 *
 * @author MAESTROAD
 */
public class PuntoDeVentaControlador implements ActionListener {

    JfPuntoDeVenta vista;

    public PuntoDeVentaControlador(JfPuntoDeVenta vista) {
        this.vista = vista;
        addListeners();
        cargaTabla();
        cargaClientes();
    }

    private void addListeners() {
        vista.getJbRegresar().addActionListener(this);
        vista.getJbAgregar().addActionListener(this);
        vista.getJbEliminar().addActionListener(this);
        vista.getJbLimpiar().addActionListener(this);
        vista.getJbConfirmaVenta().addActionListener(this);
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
        } else if (e.getSource().equals(vista.getJbConfirmaVenta())) {
            confirmaVenta();
        }
        actualizaTotales();
    }

    private void cargaTabla() {
        DefaultTableModel original = (DefaultTableModel) vista.getJtProductos().getModel();
        original.setRowCount(0);
        DefaultTableModel datos = ProductoDAO.getInstance().cargarTabla();
        for (int i = 0; i < datos.getRowCount(); i ++) {
            original.addRow(new Object[]{datos.getValueAt(i, 0), datos.getValueAt(i, 1), datos.getValueAt(i, 2), datos.getValueAt(i, 3), datos.getValueAt(i, 4), datos.getValueAt(i, 5), datos.getValueAt(i, 6)});
        }
    }

    private void agrega() {
        if (vista.getJtProductos().getSelectedRow() != -1) {
            int cantidad = -1;
            try {
                cantidad = Integer.parseInt((String) JOptionPane.showInputDialog(null, "¿Qué cantidad agregar?", "Cantidad", JOptionPane.QUESTION_MESSAGE, null, null, "1"));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor válido", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (cantidad > 0) {
                boolean yaAgregado = false;
                int idDelProductoYaAgregado = -1;
                for (int i = 0; i < vista.getJtProductosSeleccionados().getRowCount(); i ++) {
                    if (vista.getJtProductos().getValueAt(vista.getJtProductos().getSelectedRow(), 0)
                            == vista.getJtProductosSeleccionados().getValueAt(i, 0)) {
                        yaAgregado = true;
                        idDelProductoYaAgregado = (int) vista.getJtProductos().getValueAt(vista.getJtProductos().getSelectedRow(), 0);
                    }
                }
                if (yaAgregado) {
                    for (int i = 0; i < vista.getJtProductosSeleccionados().getRowCount(); i ++) {
                        if ((int) vista.getJtProductosSeleccionados().getValueAt(i, 0) == idDelProductoYaAgregado) {
                            DefaultTableModel modelo = (DefaultTableModel) vista.getJtProductosSeleccionados().getModel();
                            int cantidadAntigua = (int) vista.getJtProductosSeleccionados().getValueAt(i, 3);
                            modelo.setValueAt(cantidadAntigua + cantidad, i, 3);
                        }
                    }
                } else {
                    DefaultTableModel productosSeleccionados = (DefaultTableModel) vista.getJtProductosSeleccionados().getModel();
                    productosSeleccionados.addRow(
                            new Object[]{
                                vista.getJtProductos().getValueAt(vista.getJtProductos().getSelectedRow(), 0),
                                vista.getJtProductos().getValueAt(vista.getJtProductos().getSelectedRow(), 1),
                                vista.getJtProductos().getValueAt(vista.getJtProductos().getSelectedRow(), 2),
                                cantidad
                            });

                }
            }

        }
    }

    private void eliminar() {
        if (vista.getJtProductosSeleccionados().getSelectedRow() != -1) {
            ((DefaultTableModel) vista.getJtProductosSeleccionados().getModel()).removeRow(vista.getJtProductosSeleccionados().getSelectedRow());
        }
    }

    private void limpiar() {
        ((DefaultTableModel) vista.getJtProductosSeleccionados().getModel()).setRowCount(0);
    }

    private void cargaClientes() {
        DefaultTableModel datos = ClienteDAO.getInstance().cargarClientes();
        for (int i = 0; i < datos.getRowCount(); i ++) {
            Cliente cliente = new Cliente();

            cliente.setIdCliente((int) datos.getValueAt(i, 0));
            cliente.setNombre((String) datos.getValueAt(i, 1));
            cliente.setSaldo((double) datos.getValueAt(i, 2));
            cliente.setGrupo_idGrupo((int) datos.getValueAt(i, 3));
            cliente.setQr((String) datos.getValueAt(i, 4));
            cliente.setFoto((Blob) datos.getValueAt(i, 5));
            cliente.setTutor((String) datos.getValueAt(i, 6));
            cliente.setTelefono((String) datos.getValueAt(i, 7));
            cliente.setCorreo((String) datos.getValueAt(i, 8));
            cliente.setVigencia((Date) datos.getValueAt(i, 9));

            vista.getJcbNombres().addItem(cliente);
        }
    }

    private void actualizaTotales() {
        double total = 0;
        int cantidad = 0;
        for (int i = 0; i < vista.getJtProductosSeleccionados().getRowCount(); i ++) {
            total += Double.parseDouble(vista.getJtProductosSeleccionados().getValueAt(i, 2).toString())
                    * Double.parseDouble(vista.getJtProductosSeleccionados().getValueAt(i, 3).toString());
            cantidad += Double.parseDouble(vista.getJtProductosSeleccionados().getValueAt(i, 3).toString());
        }
        vista.getJlTotal().setText("" + total);
        vista.getJlProductos().setText("" + cantidad);
    }

    private void confirmaVenta() {
        if (vista.getJtProductosSeleccionados().getRowCount() > 0) {
            Venta venta = new Venta();

            venta.setCliente_idCliente(((Cliente) vista.getJcbNombres().getSelectedItem()).getIdCliente());
            venta.setNota(JOptionPane.showInputDialog(null, "Notas opcionales sobre la venta:", "Notas,", JOptionPane.QUESTION_MESSAGE));
            venta.setTotal(Double.parseDouble(vista.getJlTotal().getText()));
            int idVenta = VentaDAO.getInstance().insertaVenta(venta);

            for (int i = 0; i < vista.getJtProductosSeleccionados().getRowCount(); i ++) {
                Detalle_Venta detalle_Venta = new Detalle_Venta();

                detalle_Venta.setVenta_idVenta(idVenta);
                detalle_Venta.setCantidad(Double.parseDouble((vista.getJtProductosSeleccionados().getValueAt(i, 3).toString())));
                detalle_Venta.setSubtotal(Double.parseDouble((vista.getJtProductosSeleccionados().getValueAt(i, 2).toString()))
                        * Double.parseDouble((vista.getJtProductosSeleccionados().getValueAt(i, 3)).toString()));
                detalle_Venta.setProducto_idProducto((int) (vista.getJtProductosSeleccionados().getValueAt(i, 0)));

                Detalle_VentaDAO.getInstance().insertaDetalle_Venta(detalle_Venta);
            }
            JOptionPane.showMessageDialog(null, "Venta agregada correctmente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            ((DefaultTableModel) vista.getJtProductosSeleccionados().getModel()).setRowCount(0);
            vista.getJlTotal().setText("0.00");
            vista.getJlProductos().setText("0");
        }
    }
}
