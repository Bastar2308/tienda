/*
 * Coded by David Vazquez using NetBeans.
 */
package guiif;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author BurnKill
 */
public interface JMenuCategoriasIf extends FrameRegresable{
    
public abstract JButton getJbAgregar();
public abstract void setJbAgregar(JButton x);

public abstract JButton getJbEditar();
public abstract void setJbEditar(JButton x);

public abstract JButton getJbEliminar();
public abstract void setJbEliminar(JButton x);

public abstract JTable getJtDatos();
public abstract void setJtDatos(JTable x);
//dialog
public abstract JDialog getJdAgregar();
public abstract void setJdAgregar(JDialog x);

public abstract JDialog getJdEditar();
public abstract void setJdEditar(JDialog x);

public abstract JDialog getJdEliminar();
public abstract void setJdEliminar(JDialog x);
//agregar
public abstract JTextField getTfAgregarNombre();
public abstract void setTfAgregarNombre(JTextField x);

public abstract JButton getJbAgregarCancelar();
public abstract void setJbAgregarCancelar(JButton x);

public abstract JButton getJbAgregarAceptar();
public abstract void setJbAgregarAceptar(JButton x);
//editar
public abstract JTextField getTfEditarNombre();
public abstract void setTfEditarNombre(JTextField x);

public abstract JButton getJbEditarCancelar();
public abstract void setJbEditarCancelar(JButton x);

public abstract JButton getJbEditarAceptar();
public abstract void setJbEditarAceptar(JButton x);
//eliminar
public abstract JLabel getJlCategoria();
public abstract void setJlCategoria(JLabel x);

public abstract JButton getJbEliminarCancelar();
public abstract void setJbEliminarCancelar(JButton x);

public abstract JButton getJbEliminarAceptar();
public abstract void setJbEliminarAceptar(JButton x);
}
