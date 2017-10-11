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
    public abstract void setJtDatos(JTable jt);
    
    public abstract JButton getJbRegresar();
    public abstract void setJbRegresar(JButton jb);
    
    public abstract JButton getJbAgregar();
    public abstract void setJbAgregar(JButton jb);
    
    public abstract JButton getJbEditar();
    public abstract void setJbEditar(JButton jb);
    
    public abstract JButton getJbEliminar();
    public abstract void setJbEliminar(JButton jb);
    //Dialogos
    public abstract JDialog getJdAgregar();
    public abstract void setJdAgregar(JDialog jd);
    
    public abstract JDialog getJdEditar();
    public abstract void setJdEditar(JDialog jd);
    
    public abstract JDialog getJdEliminar();
    public abstract void setJdEliminar(JDialog jd);
    
    //Dialogo agregar
    public abstract JTextField getTfAgregarNombre();
    public abstract void setTfAgregarNombre(JTextField tf);
    
    public abstract JButton getJbAgregarCancelar();
    public abstract void setJbAgregarCancelar(JButton jb);
    
    
    public abstract JButton getJbAgregarAceptar();
    public abstract void setJbAgregarAceptar(JButton jb);
    
    //Dialogo editar
    public abstract JTextField getTfEditarNombre();
    public abstract void setTfEditarNombre(JTextField tf);
    
    public abstract JButton getJbEditarCancelar();
    public abstract void setJbEditarCancelar(JButton jb);
    
    
    public abstract JButton getJbEditarAceptar();
    public abstract void setJbEditarAceptar(JButton jb);
    //Dialogo eliminar
    public abstract JButton getJbEliminarCancelar();
    public abstract void setJbEliminarCancelar(JButton jb);
    
    
    public abstract JButton getJbEliminarAceptar();
    public abstract void setJbEliminarAceptar(JButton jb);    
}
