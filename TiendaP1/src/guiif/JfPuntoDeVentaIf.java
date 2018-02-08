/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiif;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Profesor Bastar
 */
public interface JfPuntoDeVentaIf extends FrameRegresable{
    
    public abstract JTable getJtProductos();
public abstract void setJtProductos(JTable x);

    public abstract JTable getJtProductosSeleccionados();
public abstract void setJtProductosSeleccionados(JTable x);

public abstract JLabel getJlTotal();
public abstract void setJlTotal(JLabel x);

public abstract JLabel getJlProductos();
public abstract void setJlProductos(JLabel x);

public abstract JButton getJbRegresar();
public abstract void setJbRegresar(JButton x);

public abstract JTextField getTfFiltrar();
public abstract void setTfFiltrar(JTextField x);

public abstract JComboBox<Object> getJcbNombres();
public abstract void setJcbNombres(JComboBox<Object> x);

public abstract JButton getJbConfirmaVenta();
public abstract void setJbConfirmaVenta(JButton x);
}
