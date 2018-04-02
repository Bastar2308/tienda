/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiif;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Profesor Bastar
 */
public interface JfMenuGeneradorCredencialesIf extends FrameRegresable {
    public abstract JTextField getTfBuscar();
    public abstract void setTfBuscar(JTextField x);

    public abstract JTable getJtClientes();
    public abstract void setJtClientes(JTable x);

    public abstract JButton getJbGenerar();
    public abstract void setJbGenerar(JButton x);
    
    public abstract int getId();
    public abstract void setId(int x);
}
