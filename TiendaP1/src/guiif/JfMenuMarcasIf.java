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
public interface JfMenuMarcasIf {

    public abstract JTable getJtDatos();

    public abstract void setJtDatos(JTable x);

    public abstract JButton getJbRegresar();

    public abstract void setJbRegresar(JButton x);

    public abstract JButton getJbAgregar();

    public abstract void setJbAgregar(JButton x);

    public abstract JButton getJbEditar();

    public abstract void setJbEditar(JButton x);

    public abstract JButton getJbEliminar();

    public abstract void setJbEliminar(JButton x);

    //Dialogos
    public abstract JDialog getJdAgregar();

    public abstract void setJdAgregar(JDialog x);

    public abstract JDialog getJdEditar();

    public abstract void setJdEditar(JDialog x);

    public abstract JDialog getJdEliminar();

    public abstract void setJdEliminar(JDialog x);

    //Dialogo agregar
    public abstract JTextField getTfAgregarNombre();

    public abstract void setTfAgregarNombre(JTextField x);

    public abstract JButton getJbAgregarCancelar();

    public abstract void setJbAgregarCancelar(JButton x);

    public abstract JButton getJbAgregarAceptar();

    public abstract void setJbAgregarAceptar(JButton x);

    //Dialogo editar
    public abstract JTextField getTfEditarNombre();

    public abstract void setTfEditarNombre(JTextField x);

    public abstract JButton getJbEditarCancelar();

    public abstract void setJbEditarCancelar(JButton x);

    public abstract JButton getJbEditarAceptar();

    public abstract void setJbEditarAceptar(JButton x);

    //Dialogo eliminar
    public abstract JButton getJbEliminarCancelar();

    public abstract void setJbEliminarCancelar(JButton x);

    public abstract JButton getJbEliminarAceptar();

    public abstract void setJbEliminarAceptar(JButton x);

    public abstract JLabel getJlMarca();

    public abstract void setJlMarca(JLabel x);
}
