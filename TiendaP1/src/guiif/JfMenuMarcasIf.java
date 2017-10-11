/*
 * Coded by David Vazquez using NetBeans.
 */
package guiif;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author BurnKill
 */
public interface JfMenuMarcasIf {
    public abstract JTable getJtDatos();
    public abstract JTable setJtDatos(JTable jt);
    
    public abstract JButton getJbRegresar();
    public abstract JButton setJbRegresar(JButton jb);
    
    public abstract JButton getJbAgregar();
    public abstract JButton setJbAgregar(JButton jb);
    
    public abstract JButton getJbEditar();
    public abstract JButton setJbEditar(JButton jb);
    
    public abstract JButton getJbEliminar();
    public abstract JButton setJbEliminar(JButton jb);
    //Dialogos
    public abstract JDialog getJdAgregar();
    public abstract JDialog setJdAgregar(JDialog jd);
    
    public abstract JDialog getJdEditar();
    public abstract JDialog setJdEditar(JDialog jd);
    
    public abstract JDialog getJdEliminar();
    public abstract JDialog setJdEliminar(JDialog jd);
    
    //Dialogo agregar
    public abstract JTextField getTfAgregarNombre();
    public abstract JTextField setTfAgregarNombre(JTextField tf);
    
    public abstract JButton getJbAgregarCancelar();
    public abstract JButton setJbAgregarCancelar(JButton jb);
    
    
    public abstract JButton getJbAgregarAceptar();
    public abstract JButton setJbAgregarAceptar(JButton jb);
    
    //Dialogo editar
    public abstract JTextField getTfEditarNombre();
    public abstract JTextField setTfEditarNombre(JTextField tf);
    
    public abstract JButton getJbEditarCancelar();
    public abstract JButton setJbEditarCancelar(JButton jb);
    
    
    public abstract JButton getJbEditarAceptar();
    public abstract JButton setJbEditarAceptar(JButton jb);
    //Dialogo eliminar
    public abstract JButton getJbEliminarCancelar();
    public abstract JButton setJbEliminarCancelar(JButton jb);
    
    
    public abstract JButton getJbEliminarAceptar();
    public abstract JButton setJbEliminarAceptar(JButton jb);    
}
