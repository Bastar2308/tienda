/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiif;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author Profesor Bastar
 */
public interface JfMenuFinanzasIf extends FrameRegresable {

    public abstract JComboBox getJcbConsultas();

    public abstract void setJcbConsultas(JComboBox x);

    public abstract JButton getJbConsultar();

    public abstract void setJbConsultar(JButton x);

    public abstract JButton getJbRegresar();

    public abstract void setJbRegresar(JButton x);

    public abstract JTable getJtResultados();

    public abstract void setJtResultados(JTable x);
}
