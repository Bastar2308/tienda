/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiif;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Fernando
 */
public interface JfCamaraPortatilIf {
    public abstract JPanel getJpCamra();

    public abstract void setJpCamara(JPanel jpCamara);
    
    public abstract JButton getJbTomar();

    public abstract void setJbTomar(JButton jbTomar);
    
    public abstract JButton getJbRepetir();

    public abstract void setJbRepetir(JButton jbRepetir);
    
    public abstract JButton getJbAceptar();

    public abstract void setJbAceptar(JButton jbAceptar);
}
