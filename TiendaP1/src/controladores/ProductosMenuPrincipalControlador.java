/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import auxiliares.GuiTools;
import dao.CategoriaDAO;
import dao.MarcaDAO;
import dao.ProductoDAO;
import gui.JfMenuCategorias;
import gui.JfProductosMenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pojo.Categoria;
import pojo.Marca;
import pojo.Producto;

/**
 *
 * @author MAESTROAD
 */
public class ProductosMenuPrincipalControlador implements ActionListener {

    JfProductosMenuPrincipal vista;

    public ProductosMenuPrincipalControlador(JfProductosMenuPrincipal vista) {
        this.vista = vista;
        configuraDialogos();
        addListeners();
        cargarTabla();
    }

    private void cargarTabla() {

        try {
            DefaultTableModel datos = ProductoDAO.getInstance().cargarTabla();
            DefaultTableModel tm = (DefaultTableModel) vista.getJtDatos().getModel();
            tm.setRowCount(0);

            for (int filas = 0; filas < datos.getRowCount(); filas ++) {
                tm.addRow(new Object[]{null, null, null, null, null, null, null, null});
                for (int columnas = 0; columnas < datos.getColumnCount(); columnas ++) {
                    tm.setValueAt(datos.getValueAt(filas, columnas), filas, columnas);
                    vista.getJtDatos().setModel(tm);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error cargando tabla: Producto", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error cargando tabla: Producto: " + e);
        }

    }

    private void addListeners() {
        vista.getJbRegresar().addActionListener(this);
        vista.getJbControlDeMarcas().addActionListener(this);
        vista.getJbControlDeCategorias().addActionListener(this);
        vista.getJbEliminar().addActionListener(this);

        vista.getJbAgregar().addActionListener(this);
        vista.getJbAgregarAceptar().addActionListener(this);
        vista.getJbAgregarCancelar().addActionListener(this);
        vista.getJchCodigoPersonalizado().addActionListener(this);

        vista.getJbEditar().addActionListener(this);
        vista.getJbEditarAceptar().addActionListener(this);
        vista.getJbEditarCancelar().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getJbRegresar())) {
            GuiTools.getInstance().regresaMenu(vista);
        } else if (e.getSource().equals(vista.getJbAgregar())) {
            abreAgregaProducto();
        } else if (e.getSource().equals(vista.getJbEditar())) {
            abreEditaProducto();
        } else if (e.getSource().equals(vista.getJbEliminar())) {
            eliminaProducto();
        } else if (e.getSource().equals(vista.getJbControlDeCategorias())) {
            abreControlDeCategorias();
        } else if (e.getSource().equals(vista.getJbControlDeMarcas())) {
            abreControlDeMarcas();
        } else if (e.getSource().equals(vista.getJbAgregarAceptar())) {
            agregaProducto();
        } else if (e.getSource().equals(vista.getJbAgregarCancelar())) {
            vista.getJdAgregar().setVisible(false);
        } else if (e.getSource().equals(vista.getJbEditarAceptar())) {
            editaProducto();
        } else if (e.getSource().equals(vista.getJbEditarCancelar())) {
            vista.getJdEditar().setVisible(false);
        } else if (e.getSource().equals(vista.getJchCodigoPersonalizado())) {
            if (vista.getTfAgregarCodigo().isEnabled()) {
                vista.getTfAgregarCodigo().setEnabled(false);
            } else {
                vista.getTfAgregarCodigo().setEnabled(true);
            }
        } else if (e.getSource().equals(vista.getJbEliminar())) {
            eliminaProducto();
        }
    }

    private void abreAgregaProducto() {
        vista.getJcbAgregarCategoria().setModel(CategoriaDAO.getInstance().cargarCombo());
        vista.getJcbAgregarMarca().setModel(MarcaDAO.getInstance().cargarCombo());
        vista.getJdAgregar().setVisible(true);
    }

    private void abreEditaProducto() {
        if (vista.getJtDatos().getSelectedRow() != -1) {

            vista.getTfEditarNombre().setText((String) vista.getJtDatos().getValueAt(vista.getJtDatos().getSelectedRow(), 1));
            vista.getJsEditarPrecio().setValue((double) vista.getJtDatos().getValueAt(vista.getJtDatos().getSelectedRow(), 2));
            vista.getJtaEditarDetalles().setText((String) vista.getJtDatos().getValueAt(vista.getJtDatos().getSelectedRow(), 3));

            //Hay que poner todos los registros en combos
            vista.getJcbEditarCategoria().setModel(CategoriaDAO.getInstance().cargarCombo());
            vista.getJcbEditarMarca().setModel(MarcaDAO.getInstance().cargarCombo());

            vista.getJcbEditarCategoria().setSelectedIndex(
                    encuentraCategoriaEnCombo(
                            (String) vista.getJtDatos().getValueAt(vista.getJtDatos().getSelectedRow(), 4),
                            vista.getJcbEditarCategoria()
                    ).getIdCategoria() - 1);
            vista.getJcbEditarMarca().setSelectedIndex(
                    encuentraMarcaEnCombo(
                            (String) vista.getJtDatos().getValueAt(vista.getJtDatos().getSelectedRow(), 5),
                            vista.getJcbEditarMarca()
                    ).getIdMarca() - 1);

            vista.getTfEditarCodigo().setText((String) vista.getJtDatos().getValueAt(vista.getJtDatos().getSelectedRow(), 6));
            vista.getJdEditar().setVisible(true);
        }
    }

    private void eliminaProducto() {
        if (vista.getJtDatos().getSelectedRow() != -1) {
            if (JOptionPane.showConfirmDialog(null, "Solo puede eliminar un producto no vendido", "¿Continuar?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                if (ProductoDAO.getInstance().eliminaProducto((int) vista.getJtDatos().getValueAt(vista.getJtDatos().getSelectedRow(), 0))) {
                    JOptionPane.showMessageDialog(null, "Producto eliminado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    cargarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha podido eliminar el producto", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void abreControlDeCategorias() {
        GuiTools.getInstance().abre(vista, JfMenuCategorias.getInstance());
    }

    private void abreControlDeMarcas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void agregaProducto() {
        if (JOptionPane.showConfirmDialog(null, "¿Desea agregar el producto?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            Producto producto = new Producto();
            producto.setNombre(vista.getTfAgregarNombre().getText());
            producto.setPrecio((double) vista.getJsAgregarPrecio().getValue());
            producto.setDetalles(vista.getJtaAgregarDetalles().getText());
            producto.setCategoria_idCategoria(((Categoria) vista.getJcbAgregarCategoria().getSelectedItem()).getIdCategoria());
            producto.setMarca_idMarca(((Marca) vista.getJcbAgregarMarca().getSelectedItem()).getIdMarca());
            producto.setCodigo(vista.getTfAgregarCodigo().getText());
//TODO generar cdigo

            int idProducto = ProductoDAO.getInstance().insertaProducto(producto);

            if (vista.getJchCodigoPersonalizado().isSelected() == false) {
                ProductoDAO.getInstance().actualizaCodigoDeProducto(("BSTR_" + idProducto), idProducto);
            }

            if (idProducto > 0) {
                JOptionPane.showMessageDialog(null, "Producto agregado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                vista.getTfAgregarNombre().setText(null);
                vista.getJsAgregarPrecio().setValue(0);
                vista.getJtaAgregarDetalles().setText(null);
                vista.getJcbAgregarCategoria().setSelectedIndex(0);
                vista.getJcbAgregarMarca().setSelectedIndex(0);
                vista.getTfAgregarCodigo().setText(null);
                vista.getJdAgregar().setVisible(false);
                cargarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "Error agregando producto", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void editaProducto() {
        if (JOptionPane.showConfirmDialog(null, "¿Desea editar el producto?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            Producto producto = new Producto();
            producto.setIdProducto((int) vista.getJtDatos().getValueAt(vista.getJtDatos().getSelectedRow(), 0));
            producto.setNombre(vista.getTfEditarNombre().getText());
            producto.setPrecio((double) vista.getJsEditarPrecio().getValue());
            producto.setDetalles(vista.getJtaEditarDetalles().getText());
            producto.setCategoria_idCategoria(((Categoria) vista.getJcbEditarCategoria().getSelectedItem()).getIdCategoria());
            producto.setMarca_idMarca(((Marca) vista.getJcbEditarMarca().getSelectedItem()).getIdMarca());
            producto.setCodigo(vista.getTfEditarCodigo().getText());

            if (ProductoDAO.getInstance().modificaProducto(producto)) {
                JOptionPane.showMessageDialog(null, "Producto modificado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                vista.getTfEditarNombre().setText(null);
                vista.getJsEditarPrecio().setValue(0);
                vista.getJtaEditarDetalles().setText(null);
                vista.getJcbEditarCategoria().setSelectedIndex(0);
                vista.getJcbEditarMarca().setSelectedIndex(0);
                vista.getTfEditarCodigo().setText(null);
                vista.getJdEditar().setVisible(false);
                cargarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "Error modificando producto", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void configuraDialogos() {
        vista.getJdAgregar().setSize(vista.getJdAgregar().getPreferredSize());
        vista.getJdAgregar().setLocationRelativeTo(null);
        vista.getJdEditar().setSize(vista.getJdEditar().getPreferredSize());
        vista.getJdEditar().setLocationRelativeTo(null);
    }

    Categoria encuentraCategoriaEnCombo(String nombreABuscar, JComboBox<Categoria> elementos) {
        for (int i = 0; i < elementos.getItemCount(); i ++) {
            if (elementos.getItemAt(i).getNombre().equals(nombreABuscar)) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(elementos.getItemAt(i).getIdCategoria());
                categoria.setNombre(elementos.getItemAt(i).getNombre());
                return categoria;
            }
        }
        return null;
    }

    Marca encuentraMarcaEnCombo(String nombreABuscar, JComboBox<Marca> elementos) {
        for (int i = 0; i < elementos.getItemCount(); i ++) {
            if (elementos.getItemAt(i).getNombre().equals(nombreABuscar)) {
                Marca marca = new Marca();
                marca.setIdMarca(elementos.getItemAt(i).getIdMarca());
                marca.setNombre(elementos.getItemAt(i).getNombre());
                return marca;
            }
        }
        return null;
    }
}
