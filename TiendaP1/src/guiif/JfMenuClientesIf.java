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

    public abstract JDialog getJdReporte();

    public abstract void setJdReporte(JDialog x);

    public abstract JTextField getJlFiltro();

    public abstract void setJlFiltro(JTextField x);

    public abstract JDialog getJdEditar();

    public abstract void setJdEditar(JDialog x);

    public abstract JTable getJtDatos();

    public abstract void setJtDatos(JTable x);

    public abstract JButton getJbControlDeGrupos();

    public abstract void setJbControlDeGrupos(JButton x);

    public abstract JButton getJbRegresar();

    public abstract void setJbRegresar(JButton x);

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

    public abstract JLabel getJlTotal();

    public abstract void setJlTotal(JLabel x);

    public abstract JLabel getJlNombre();

    public abstract void setJlNombre(JLabel x);

    public abstract JLabel getJlDesde();

    public abstract void setJlDesde(JLabel x);

    public abstract JLabel getJlHasta();

    public abstract void setJlHasta(JLabel x);

    public abstract JButton getJbEnviar();

    public abstract void setJbEnviar(JButton x);

    public abstract JButton getJbReporte();

    public abstract void setJbReporte(JButton x);

    public abstract JTextField getTfAgregarTutor();

    public abstract void setTfAgregarTutor(JTextField x);

    public abstract JTextField getTfAgregarTelefono();

    public abstract void setJsAgregarLimite(JSpinner x);

    public abstract JSpinner getJsAgregarLimite();

    public abstract void setJsEditarLimite(JSpinner x);

    public abstract JSpinner getJsEditarLimite();

    public abstract void setJsVerLimite(JSpinner x);

    public abstract JSpinner getJsVerLimite();

    public abstract void setTfAgregarTelefono(JTextField x);

    public abstract JTextField getTfAgregarCorreo();

    public abstract void setTfAgregarCorreo(JTextField x);

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

    public abstract JTextField getTfEditarTutor();

    public abstract void setTfEditarTutor(JTextField x);

    public abstract JTextField getTfEditarTelefono();

    public abstract void setTfEditarTelefono(JTextField x);

    public abstract JTextField getTfEditarCorreo();

    public abstract void setTfEditarCorreo(JTextField x);

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

    public abstract JTextField getTfVerTutor();

    public abstract void setTfVerTutor(JTextField x);

    public abstract JTextField getTfVerTelefono();

    public abstract void setTfVerTelefono(JTextField x);

    public abstract JTextField getTfVerCorreo();

    public abstract void setTfVerCorreo(JTextField x);

    public abstract String getSRuta();

    public abstract void setSRuta(String x);
    
    public abstract JLabel getJlAgregarNombre();

    public abstract void setJlAgregarNombre(JLabel x);
    
    public abstract JLabel getJlAgregarTutor();

    public abstract void setJlAgregarTutor(JLabel x);
    
    public abstract JLabel getJlAgregarGrupo();

    public abstract void setJlAgregarGrupo(JLabel x);
    
    public abstract JLabel getJlEditarNombre();

    public abstract void setJlEditarNombre(JLabel x);
    
    public abstract JLabel getJlEditarTutor();

    public abstract void setJlEditarTutor(JLabel x);
    
    public abstract JLabel getJlEditarGrupo();

    public abstract void setJlEditarGrupo(JLabel x);
}
