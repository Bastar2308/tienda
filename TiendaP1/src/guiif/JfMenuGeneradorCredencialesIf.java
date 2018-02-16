/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiif;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JTextField;

/**
 *
 * @author Profesor Bastar
 */
public interface JfMenuGeneradorCredencialesIf extends FrameRegresable {

    public abstract JButton getJbSeleccionar();

    public abstract void setJbSeleccionar(JButton x);

    public abstract JButton getJbFiltrar();

    public abstract void setJbFiltrar(JButton x);

    public abstract JTextField getTfRuta();

    public abstract void setTfRuta(JTextField x);

    public abstract JButton getJbGenerar();

    public abstract void setJbGenerar(JButton x);

    public abstract JList getJlLista();

    public abstract void setJlLista(JList x);

    public abstract JFileChooser getFcSelector();

    public abstract void setFcSelector(JFileChooser x);
}
