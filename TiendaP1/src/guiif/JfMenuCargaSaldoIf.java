/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiif;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Profesor Bastar
 */
public interface JfMenuCargaSaldoIf extends FrameRegresable {

    public abstract JTextField getTfBuscar();

    public abstract void setTfBuscar(JTextField x);

    public abstract JTable getJtClientes();

    public abstract void setJtClientes(JTable x);

    public abstract JRadioButton getRb20();

    public abstract void setRb20(JRadioButton x);

    public abstract JRadioButton getRb50();

    public abstract void setRb50(JRadioButton x);

    public abstract JRadioButton getRb100();

    public abstract void setRb100(JRadioButton x);

    public abstract JRadioButton getRb200();

    public abstract void setRb200(JRadioButton x);

    public abstract JRadioButton getRb500();

    public abstract void setRb500(JRadioButton x);

    public abstract JRadioButton getRb1000();

    public abstract void setRb1000(JRadioButton x);

    public abstract JRadioButton getRbOtra();

    public abstract void setRbOtra(JRadioButton x);

    public abstract JSpinner getJsOtra();

    public abstract void setJsOtra(JSpinner x);
}
