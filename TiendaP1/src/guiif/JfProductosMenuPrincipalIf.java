/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiif;

import javax.swing.JButton;

/**
 *
 * @author ALUMNO
 */
public interface JfProductosMenuPrincipalIf extends FrameRegresable {

    public abstract JButton getJbControlDeCategorias();

    public abstract void setJbControlDeCategorias(JButton boton);
}