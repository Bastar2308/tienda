/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;
//cambio min

import auxiliares.GuiTools;
import dao.ClienteDAO;
import dao.Detalle_VentaDAO;
import dao.ProductoDAO;
import dao.VentaDAO;
import gui.JfPuntoDeVenta;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.Blob;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
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
        seleccionaCliente();
        vista.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                cargaTabla();
                cargaClientes();
            }
        });

        vista.getJtProductos().getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        vista.getJtProductos().getActionMap().put("enter", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                agrega();
                actualizaTotales();
            }
        });

    }

    private void addListeners() {
        vista.getJbRegresar().addActionListener(this);
        vista.getJbAgregar().addActionListener(this);
        vista.getJbEliminar().addActionListener(this);
        vista.getJbLimpiar().addActionListener(this);
        vista.getJbConfirmaVenta().addActionListener(this);
        vista.getJbSeleccionaCliente().addActionListener(this);
        vista.getTfFiltrarProductos().addActionListener(this);
        vista.getTfFiltrarClientes().addActionListener(this);
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
                actualizaTotales();
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
        } else if (e.getSource().equals(vista.getTfFiltrarProductos())) {
            if (esCodigoEnProductos()) {
                vista.getJtProductos().changeSelection(0, 0, false, false);
                agrega();
            }
        }else if (e.getSource().equals(vista.getTfFiltrarClientes())) {
                vista.getJtClientes().changeSelection(0, 0, false, false);
                seleccionaCliente();
                vista.getTfFiltrarClientes().setText(null);
        } else if (e.getSource().equals(vista.getJbConfirmaVenta())) {
            confirmaVenta();
        } else if (e.getSource().equals(vista.getJbSeleccionaCliente())) {
            if (vista.getJtClientes().getSelectedRow() != -1) {
                seleccionaCliente();
            }
        }
        actualizaTotales();
    }

    private void cargaTabla() {
        DefaultTableModel original = (DefaultTableModel) vista.getJtProductos().getModel();
        original.setRowCount(0);
        DefaultTableModel datos = ProductoDAO.getInstance().cargarTabla();
        for (int i = 0; i < datos.getRowCount(); i ++) {
            original.addRow(new Object[]{datos.getValueAt(i, 0), datos.getValueAt(i, 1), datos.getValueAt(i, 2), datos.getValueAt(i, 3), datos.getValueAt(i, 6 /*aqui va la wea*/)});
        }
    }

    private void agrega() {
        if (vista.getJtProductos().getSelectedRow() != -1) {
            String idProductoElegido = vista.getJtProductos().getValueAt(vista.getJtProductos().getSelectedRow(), 0).toString();
            String nombreProductoElegido = vista.getJtProductos().getValueAt(vista.getJtProductos().getSelectedRow(), 1).toString();
            String precioProductoElegido = vista.getJtProductos().getValueAt(vista.getJtProductos().getSelectedRow(), 2).toString();
            int cantidad = -1;
            try {
                cantidad = Integer.parseInt((String) JOptionPane.showInputDialog(null, "¿Qué cantidad agregar?", "Cantidad", JOptionPane.QUESTION_MESSAGE, null, null, "1"));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor válido", "Cancelado", JOptionPane.ERROR_MESSAGE);
            }
            if (cantidad > 0) {
                boolean yaAgregado = false;
                int idDelProductoYaAgregado = -1;
                for (int i = 0; i < vista.getJtProductosSeleccionados().getRowCount(); i ++) {
                    if (idProductoElegido.equals(vista.getJtProductosSeleccionados().getValueAt(i, 0).toString())) {
                        yaAgregado = true;
                        idDelProductoYaAgregado = Integer.parseInt(idProductoElegido);
                    }
                }
                if (yaAgregado) {
                    for (int i = 0; i < vista.getJtProductosSeleccionados().getRowCount(); i ++) {
                        if (Integer.parseInt(vista.getJtProductosSeleccionados().getValueAt(i, 0).toString()) == idDelProductoYaAgregado) {
                            DefaultTableModel modelo = (DefaultTableModel) vista.getJtProductosSeleccionados().getModel();
                            int cantidadAntigua = Integer.parseInt(vista.getJtProductosSeleccionados().getValueAt(i, 3).toString());
                            modelo.setValueAt(cantidadAntigua + cantidad, i, 3);
                        }
                    }
                } else {
                    DefaultTableModel productosSeleccionados = (DefaultTableModel) vista.getJtProductosSeleccionados().getModel();
                    productosSeleccionados.addRow(
                            new Object[]{
                                idProductoElegido, nombreProductoElegido, Double.parseDouble(precioProductoElegido), cantidad
                            });

                }
            }
            vista.getTfFiltrarProductos().setText(null);
            filtraProductos();
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
            original.addRow(new Object[]{datos.getValueAt(i, 0), datos.getValueAt(i, 1), datos.getValueAt(i, 2), datos.getValueAt(i, 3), datos.getValueAt(i, 5)});
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
                String res = JOptionPane.showInputDialog(null, "Total: " + vista.getJlTotal().getText() + "\nDigite cantidad para pagar", "Insertar importe", JOptionPane.QUESTION_MESSAGE);
                Integer cantidadRecibida = 0;
                try {
                    cantidadRecibida = Integer.parseInt(res);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Cantidad incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                }

                if (cantidadRecibida == Double.parseDouble(vista.getJlTotal().getText())) {
                    JOptionPane.showMessageDialog(null, "Se paga con cantidad exacta", "Pago correceto", JOptionPane.INFORMATION_MESSAGE);
                    procedeVenta = true;
                } else if (cantidadRecibida > Double.parseDouble(vista.getJlTotal().getText())) {
                    JOptionPane.showMessageDialog(null, "Cambio: " + (cantidadRecibida - Double.parseDouble(vista.getJlTotal().getText())), "Cambio a devolver", JOptionPane.INFORMATION_MESSAGE);
                    procedeVenta = true;
                }
            } else {
                ClienteDAO.getInstance().restaSaldo(vista.getJlId().getText(), vista.getJlTotal().getText());
                procedeVenta = true;
            }
            //Inserta venta y detalles de venta
            if (procedeVenta) {
                agregaRegistroVenta(venta);
                reseteaGUI();
                JOptionPane.showMessageDialog(null, "Venta agregada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Agrega artículos al pedido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void seleccionaCliente() {
        Blob imagen = ClienteDAO.getInstance().buscaCliente(
                Integer.parseInt(vista.getJtClientes().getValueAt(vista.getJtClientes().getSelectedRow(), 0).toString())
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

    public boolean esCodigoEnProductos() {
        try {
            boolean empiezaConBstr = vista.getTfFiltrarProductos().getText().substring(0, 5).equals("BSTR_");
            int id = Integer.parseInt(vista.getTfFiltrarProductos().getText().substring(5, vista.getTfFiltrarProductos().getText().length()));
            return empiezaConBstr && id > 0;
        } catch (Exception e) {
            return false;
        }
    }

    private void reseteaGUI() {
        //Resetear GUI
        cargaClientes();
        vista.getJtClientes().setRowSelectionInterval(0, 0);
        seleccionaCliente();
        vista.getTfFiltrarClientes().setText(null);
        vista.getTfFiltrarProductos().setText(null);
        filtraClientes();
        filtraProductos();
        ((DefaultTableModel) vista.getJtProductosSeleccionados().getModel()).setRowCount(0);
        vista.getJlTotal().setText("0.00");
        vista.getJlProductos().setText("0");
    }

    private void agregaRegistroVenta(Venta venta) {
        int idVenta = VentaDAO.getInstance().insertaVenta(venta);
        for (int i = 0; i < vista.getJtProductosSeleccionados().getRowCount(); i ++) {
            Detalle_Venta detalle_Venta = new Detalle_Venta();

            detalle_Venta.setVenta_idVenta(idVenta);
            detalle_Venta.setCantidad(Double.parseDouble((vista.getJtProductosSeleccionados().getValueAt(i, 3).toString())));
            detalle_Venta.setSubtotal(Double.parseDouble((vista.getJtProductosSeleccionados().getValueAt(i, 2).toString()))
                    * Double.parseDouble((vista.getJtProductosSeleccionados().getValueAt(i, 3)).toString()));
            detalle_Venta.setProducto_idProducto(Integer.parseInt(vista.getJtProductosSeleccionados().getValueAt(i, 0).toString()));

            Detalle_VentaDAO.getInstance().insertaDetalle_Venta(detalle_Venta);
        }
    }
}
