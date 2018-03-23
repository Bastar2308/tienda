/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiif;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author Profesor Bastar
 */
public interface JfMenuFinanzasIf extends FrameRegresable {

    public abstract JLabel getJlProductoMasVendido();
    public abstract void setJlProductoMasVendido(JLabel x);
    
    public abstract JLabel getJlMarcaMasVendida();
    public abstract void setJlMarcaMasVendida(JLabel x);
    
    public abstract JLabel getJlCategoriaMasVendida();
    public abstract void setJlCategoriaMasVendida(JLabel x);

    public abstract JButton getJbRegresar();
    public abstract void setJbRegresar(JButton x);
}
