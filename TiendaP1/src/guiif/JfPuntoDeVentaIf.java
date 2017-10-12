/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiif;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Profesor Bastar
 */
public interface JfPuntoDeVentaIf extends FrameRegresable{
    public abstract JTable getJtDatos();
public abstract void setJtDatos(JTable x);

public abstract JLabel getJlTotal();
public abstract void setJlTotal(JLabel x);

public abstract JLabel getJlProductos();
public abstract void setJlProductos(JLabel x);

public abstract JButton getJbRegresar();
public abstract void setJbRegresar(JButton x);

public abstract JTextField getTfBuscar();
public abstract void setTfBuscar(JTextField x);

public abstract JButton getJbFiltrar();
public abstract void setJbFiltrar(JButton x);

public abstract JList getJlClientes();
public abstract void setJlClientes(JList x);

public abstract JButton getJbClientes();
public abstract void setJbClientes(JButton x);
}
