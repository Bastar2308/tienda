/*
 * Coded by David Vazquez using NetBeans.
 */
package guiif;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author BurnKill
 */
public interface JfComidaDelDiaIf extends FrameRegresable{
    public abstract JTable getJtDatos();
public abstract void setJtDatos(JTable x);

public abstract JButton getJbAgregar();
public abstract void setJbAgregar(JButton x);

public abstract JButton getJbEditar();
public abstract void setJbEditar(JButton x);

public abstract JButton getJbEliminar();
public abstract void setJbEliminar(JButton x);

public abstract JTextField getTfAgregarNombre();
public abstract void setTfAgregarNombre(JTextField x);

public abstract JTextArea getJtaAgregarDescripcion();
public abstract void setJtaAgregarDescripcion(JTextArea x);

public abstract JDateChooser getJdAgregarFecha();
public abstract void setJdAgregarFecha(JDateChooser x);

public abstract JSpinner getJsAgregarPrecio();
public abstract void setJsAgregarPrecio(JSpinner x);

public abstract JButton getJbAgregarCancelar();
public abstract void setJbAgregarCancelar(JButton x);

public abstract JButton getJbAgregarAceptar();
public abstract void setJbAgregarAceptar(JButton x);

public abstract JLabel getJlAlimento();
public abstract void setJlAlimento(JLabel x);

public abstract JButton getJbEliminarCancelar();
public abstract void setJbEliminarCancelar(JButton x);

public abstract JButton getJbEliminarAceptar();
public abstract void setJbEliminarAceptar(JButton x);

public abstract JTextField getTfEditarNombre();
public abstract void setTfEditarNombre(JTextField x);

public abstract JTextArea getJtaEditarDescripcion();
public abstract void setJtaEditarDescripcion(JTextArea x);

public abstract JDateChooser getJdEditarFecha();
public abstract void setJdEditarFecha(JDateChooser x);

public abstract JSpinner getJsEditarPrecio();
public abstract void setJsEditarPrecio(JSpinner x);

public abstract JButton getJbCancelarCancelar();
public abstract void setJbCancelarCancelar(JButton x);

public abstract JButton getJbEditarAceptar();
public abstract void setJbEditarAceptar(JButton x);

}
