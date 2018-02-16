/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiif;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Profesor Bastar
 */
public interface JfMenuClientesIf extends FrameRegresable {

    public abstract JDialog getJdAgregar();

    public abstract void setJdAgregar(JDialog x);

    public abstract JDialog getJdEditar();

    public abstract void setJdEditar(JDialog x);

    public abstract JTable getJtDatos();

    public abstract void setJtDatos(JTable x);

    public abstract JButton getJbControlDeGrupos();

    public abstract void setJbControlDeGrupos(JButton x);

    public abstract JButton getJbAgregar();

    public abstract void setJbAgregar(JButton x);

    public abstract JButton getJbEliminar();

    public abstract void setJbEliminar(JButton x);

    public abstract JButton getJbEditar();

    public abstract void setJbEditar(JButton x);

    public abstract JTextField getTfAgregarNombre();

    public abstract void setTfAgregarNombre(JTextField x);

    public abstract JComboBox<pojo.Grupo> getJcbAgregarGrupo();

    public abstract void setJcbAgregarGrupo(JComboBox<pojo.Grupo> x);

    public abstract JSpinner getJsAgregarSaldo();

    public abstract void setJsAgregarSaldo(JSpinner x);

    public abstract JTextField getTfAgregarQr();

    public abstract void setTfAgregarQr(JTextField x);

    public abstract JLabel getJlAgregarImagen();

    public abstract void setJlAgregarImagen(JLabel x);

    public abstract JButton getJbAgregarTomarFoto();

    public abstract void setJbAgregarTomarFoto(JButton x);

    public abstract JTextField getTfAgregarTutor();

    public abstract void setTfAgregarTutor(JTextField x);

    public abstract JTextField getTfAgregarTelefono();

    public abstract void setTfAgregarTelefono(JTextField x);

    public abstract JTextField getTfAgregarCorreo();

    public abstract void setTfAgregarCorreo(JTextField x);

    public abstract JSpinner getJsAgregarComprasSinCredencial();

    public abstract void setJsAgregarComprasSinCredencial(JSpinner x);

    public abstract JButton getJbAgregarCancelar();

    public abstract void setJbAgregarCancelar(JButton x);

    public abstract JButton getJbAgregarAceptar();

    public abstract void setJbAgregarAceptar(JButton x);

    public abstract JTextField getTfEditarNombre();

    public abstract void setTfEditarNombre(JTextField x);

    public abstract JComboBox<pojo.Grupo> getJcbEditarGrupo();

    public abstract void setJcbEditarGrupo(JComboBox<pojo.Grupo> x);

    public abstract JSpinner getJsEditarSaldo();

    public abstract void setJsEditarSaldo(JSpinner x);

    public abstract JTextField getTfEditarQr();

    public abstract void setTfEditarQr(JTextField x);

    public abstract JLabel getJlEditarImagen();

    public abstract void setJlEditarImagen(JLabel x);

    public abstract JButton getJbEditarTomarFoto();

    public abstract void setJbEditarTomarFoto(JButton x);

    public abstract JTextField getTfEditarTutor();

    public abstract void setTfEditarTutor(JTextField x);

    public abstract JTextField getTfEditarTelefono();

    public abstract void setTfEditarTelefono(JTextField x);

    public abstract JTextField getTfEditarCorreo();

    public abstract void setTfEditarCorreo(JTextField x);

    public abstract JSpinner getJsEditarComprasSinCredencial();

    public abstract void setJsEditarComprasSinCredencial(JSpinner x);

    public abstract JButton getJbEditarCancelar();

    public abstract void setJbEditarCancelar(JButton x);

    public abstract JButton getJbEditarAceptar();

    public abstract void setJbEditarAceptar(JButton x);

    public abstract JButton getJbVer();

    public abstract void setJbVer(JButton x);

    public abstract JTextField getTfVerNombre();

    public abstract void setTfVerNombre(JTextField x);

    public abstract JComboBox<pojo.Grupo> getJcbVerGrupo();

    public abstract void setJcbVerGrupo(JComboBox<pojo.Grupo> x);

    public abstract JSpinner getJsVerSaldo();

    public abstract void setJsVerSaldo(JSpinner x);

    public abstract JTextField getTfVerQr();

    public abstract void setTfVerQr(JTextField x);

    public abstract JLabel getJlVerImagen();

    public abstract void setJlVerImagen(JLabel x);

    public abstract JTextField getTfVerTutor();

    public abstract void setTfVerTutor(JTextField x);

    public abstract JTextField getTfVerTelefono();

    public abstract void setTfVerTelefono(JTextField x);

    public abstract JTextField getTfVerCorreo();

    public abstract void setTfVerCorreo(JTextField x);

    public abstract JSpinner getJsVerComprasSinCredencial();

    public abstract void setJsVerComprasSinCredencial(JSpinner x);
}
