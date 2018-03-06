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
import gui.JfPuntoDeVenta;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
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
        vista.getJtClientes().setRowSelectionInterval(0, 0);
        seleccionaCliente(0);
    }

    private void addListeners() {
        vista.getJbRegresar().addActionListener(this);
        vista.getJbAgregar().addActionListener(this);
        vista.getJbEliminar().addActionListener(this);
        vista.getJbLimpiar().addActionListener(this);
        vista.getJbConfirmaVenta().addActionListener(this);
        vista.getJbSeleccionaCliente().addActionListener(this);
        vista.getTfFiltrarClientes().addKeyListener(
                new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                filtraClientes();
            }
        }
        );
        vista.getTfFiltrarProductos().addKeyListener(
                new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                filtraProductos();
            }
        }
        );
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
        } else if (e.getSource().equals(vista.getJbSeleccionaCliente())) {
            if (vista.getJtClientes().getSelectedRow() != -1) {
                seleccionaCliente(vista.getJtClientes().getSelectedRow());
            }
        }
        actualizaTotales();
    }

    private void cargaTabla() {
        DefaultTableModel original = (DefaultTableModel) vista.getJtProductos().getModel();
        original.setRowCount(0);
        DefaultTableModel datos = ProductoDAO.getInstance().cargarTabla();
        for (int i = 0; i < datos.getRowCount(); i ++) {
            original.addRow(new Object[]{datos.getValueAt(i, 0), datos.getValueAt(i, 1), datos.getValueAt(i, 2), datos.getValueAt(i, 3), datos.getValueAt(i, 4)});
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
        DefaultTableModel datos = ClienteDAO.getInstance().cargarTablaPuntoDeVenta();
        DefaultTableModel original = (DefaultTableModel) vista.getJtClientes().getModel();
        original.setRowCount(0);
        for (int i = 0; i < datos.getRowCount(); i ++) {
            original.addRow(new Object[]{datos.getValueAt(i, 0), datos.getValueAt(i, 1), datos.getValueAt(i, 2), datos.getValueAt(i, 3)});
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
        vista.getJlTotal().setText(total + "0");
        vista.getJlProductos().setText("" + cantidad);
    }

    private void confirmaVenta() {
        if (vista.getJtProductosSeleccionados().getRowCount() > 0) {
            Venta venta = new Venta();

            venta.setCliente_idCliente((Integer.parseInt(vista.getJlId().getText())));
//                venta.setNota(JOptionPane.showInputDialog(null, "Notas opcionales sobre la venta:", "Notas,", JOptionPane.QUESTION_MESSAGE));
            venta.setNota("");
            venta.setTotal(Double.parseDouble(vista.getJlTotal().getText()));
            //Verificar quien compra y restar saldo
            boolean procedeVenta = false;
            if ("1".equals(vista.getJlId().getText())) {
                int cantidadRecibida = Integer.parseInt(JOptionPane.showInputDialog(null, "Total: " + vista.getJlTotal().getText() + "\nDigite cantidad para pagar", "Insertar importe", JOptionPane.QUESTION_MESSAGE));
                if (cantidadRecibida == Double.parseDouble(vista.getJlTotal().getText())) {
                    JOptionPane.showMessageDialog(null, "Se paga con cantidad exacta", "Pago correceto", JOptionPane.INFORMATION_MESSAGE);
                    procedeVenta = true;
                } else if (cantidadRecibida > Double.parseDouble(vista.getJlTotal().getText())) {
                    JOptionPane.showMessageDialog(null, "Cambio: " + (cantidadRecibida - Double.parseDouble(vista.getJlTotal().getText())), "Cambio a devolver", JOptionPane.INFORMATION_MESSAGE);
                    procedeVenta = true;
                }
            } else {
                ClienteDAO.getInstance().restaSaldo(vista.getJlId().getText(), vista.getJlTotal().getText());
            }
            //Inserta venta y detalles de venta
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

            //Resetear GUI
            cargaClientes();
            vista.getJtClientes().setRowSelectionInterval(0, 0);
            seleccionaCliente(1);
            vista.getTfFiltrarClientes().setText(null);
            vista.getTfFiltrarProductos().setText(null);
            filtraClientes();
            filtraProductos();
            ((DefaultTableModel) vista.getJtProductosSeleccionados().getModel()).setRowCount(0);
            vista.getJlTotal().setText("0.00");
            vista.getJlProductos().setText("0");

            JOptionPane.showMessageDialog(null, "Venta agregada correctmente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Agrega artículos al pedido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void seleccionaCliente(int id) {
        Blob imagen = ClienteDAO.getInstance().buscaCliente(
                (int) vista.getJtClientes().getValueAt(vista.getJtClientes().getSelectedRow(), 0)
        ).getFoto();

        try {
            InputStream is = imagen.getBinaryStream(1, imagen.length());
            BufferedImage imag = ImageIO.read(is);
            Image image = imag;
            ImageIcon icon = new ImageIcon(image);
            vista.getJlFoto().setIcon(icon);
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error cargando imagen de cliente: " + e, "Error", JOptionPane.ERROR_MESSAGE);
            vista.getJlFoto().setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icons8_User_64px_1.png")));
        }

        vista.getJlId().setText(vista.getJtClientes().getValueAt(vista.getJtClientes().getSelectedRow(), 0).toString());
        vista.getJlNombre().setText(vista.getJtClientes().getValueAt(vista.getJtClientes().getSelectedRow(), 1).toString());
        vista.getJlSaldo().setText(vista.getJtClientes().getValueAt(vista.getJtClientes().getSelectedRow(), 2).toString());
        vista.getJlGrupo().setText(vista.getJtClientes().getValueAt(vista.getJtClientes().getSelectedRow(), 3).toString());
    }

    void filtraClientes() {
        DefaultTableModel defaultTableModel = (DefaultTableModel) vista.getJtClientes().getModel();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<DefaultTableModel>(defaultTableModel);
        vista.getJtClientes().setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + vista.getTfFiltrarClientes().getText()));
    }

    void filtraProductos() {
        DefaultTableModel defaultTableModel = (DefaultTableModel) vista.getJtProductos().getModel();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<DefaultTableModel>(defaultTableModel);
        vista.getJtProductos().setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + vista.getTfFiltrarProductos().getText()));
    }
}
