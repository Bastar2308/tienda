/*
 * Coded by David Vazquez using NetBeans.
 */
package guiif;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author BurnKill
 */
public interface JfControlDeGruposIf extends FrameRegresable{
    public abstract JTable getJtDatos();
public abstract void setJtDatos(JTable x);

public abstract JButton getJbAgregar();
public abstract void setJbAgregar(JButton x);

public abstract JButton getJbEditar();
public abstract void setJbEditar(JButton x);

public abstract JButton getJbRegresar();
public abstract void setJbRegresar(JButton x);

public abstract JButton getJbEliminar();
public abstract void setJbEliminar(JButton x);

public abstract JTextField getTfAgregarNombre();
public abstract void setTfAgregarNombre(JTextField x);

public abstract JTextField getTfAgregarNivel();
public abstract void setTfAgregarNivel(JTextField x);

public abstract JButton getJbAgregarCancelar();
public abstract void setJbAgregarCancelar(JButton x);

public abstract JButton getJbAgregarAceptar();
public abstract void setJbAgregarAceptar(JButton x);

public abstract JLabel getJlGrupo();
public abstract void setJlGrupo(JLabel x);

public abstract JButton getJbEliminarCancelar();
public abstract void setJbEliminarCancelar(JButton x);

public abstract JButton getJbEliminarAceptar();
public abstract void setJbEliminarAceptar(JButton x);

public abstract JTextField getTfEditarNombre();
public abstract void setTfEditarNombre(JTextField x);

public abstract JTextField getTfEditarNivel();
public abstract void setTfEditarNivel(JTextField x);

public abstract JButton getJbEditarCancelar();
public abstract void setJbEditarCancelar(JButton x);

public abstract JButton getJbEditarAceptar();
public abstract void setJbEditarAceptar(JButton x);
}
