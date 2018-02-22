/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiif;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author ALUMNO
 */
public interface JfProductosMenuPrincipalIf extends FrameRegresable {

    public abstract JButton getJbControlDeCategorias();

    public abstract void setJbControlDeCategorias(JButton x);

    public abstract JButton getJbControlDeMarcas();

    public abstract void setJbControlDeMarcas(JButton x);

    public abstract JButton getJbAgregar();

    public abstract void setJbAgregar(JButton x);

    public abstract JButton getJbEditar();

    public abstract void setJbEditar(JButton x);

    public abstract JButton getJbEliminar();

    public abstract void setJbEliminar(JButton x);

    public abstract JDialog getJdAgregar();

    public abstract void setJdAgregar(JDialog x);

    public abstract JDialog getJdEditar();

    public abstract void setJdEditar(JDialog x);

    public abstract JTextField getTfAgregarNombre();

    public abstract void setTfAgregarNombre(JTextField x);

    public abstract JSpinner getJsAgregarPrecio();

    public abstract void setJsAgregarPrecio(JSpinner x);

    public abstract JTextArea getJtaAgregarDetalles();

    public abstract void setJtaAgregarDetalles(JTextArea x);

    public abstract JComboBox<pojo.Categoria> getJcbAgregarCategoria();

    public abstract void setJcbAgregarCategoria(JComboBox<pojo.Categoria> x);

    public abstract JComboBox<pojo.Marca> getJcbAgregarMarca();

    public abstract void setJcbAgregarMarca(JComboBox<pojo.Marca> x);

    public abstract JTextField getTfAgregarCodigo();

    public abstract void setTfAgregarCodigo(JTextField x);

    public abstract JButton getJbAgregarCancelar();

    public abstract void setJbAgregarCancelar(JButton x);

    public abstract JButton getJbAgregarAceptar();

    public abstract void setJbAgregarAceptar(JButton x);

    public abstract JTextField getTfEditarNombre();

    public abstract void setTfEditarNombre(JTextField x);

    public abstract JSpinner getJsEditarPrecio();

    public abstract void setJsEditarPrecio(JSpinner x);

    public abstract JTextArea getJtaEditarDetalles();

    public abstract void setJtaEditarDetalles(JTextArea x);

    public abstract JComboBox<pojo.Categoria> getJcbEditarCategoria();

    public abstract void setJcbEditarCategoria(JComboBox<pojo.Categoria> x);

    public abstract JComboBox<pojo.Marca> getJcbEditarMarca();

    public abstract void setJcbEditarMarca(JComboBox<pojo.Marca> x);

    public abstract JTextField getTfEditarCodigo();

    public abstract void setTfEditarCodigo(JTextField x);

    public abstract JButton getJbEditarCancelar();

    public abstract void setJbEditarCancelar(JButton x);

    public abstract JButton getJbEditarAceptar();

    public abstract void setJbEditarAceptar(JButton x);
}
