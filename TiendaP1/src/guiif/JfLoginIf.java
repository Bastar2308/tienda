/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiif;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Profesor Bastar
 */
public interface JfLoginIf {

    public abstract JTextField getTfUsuario();

    public abstract void setTfUsuario(JTextField tf);

    public abstract JPasswordField getTfPassword();

    public abstract void setTfPassword(JPasswordField tf);

    public abstract JButton getJbIngresar();

    public abstract void setJbIngresar(JButton bt);

}
