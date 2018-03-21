/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiif;

import com.github.sarxos.webcam.WebcamPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Fernando
 */
public interface JfGeneradorCredencialIf {
    
    public abstract JButton getJbTomar();

    public abstract void setJbTomar(JButton bt);
    
    public abstract JButton getJbRepetir();

    public abstract void setJbRepetir(JButton bt);
    
    public abstract JButton getJbGuardar();

    public abstract void setJbguardar(JButton bt);
    
    public abstract JLabel getJlNombre();

    public abstract void setJlNombre(JLabel lb);
    
    public abstract JLabel getJlNivel();

    public abstract void setJlnivel(JLabel lb);
    
    public abstract JLabel getJlGradoGrupo();

    public abstract void setJlGradoGrupo(JLabel lb);
    
    public abstract JLabel getJlVigencia();

    public abstract void setJlVigencia(JLabel lb);
    
    public abstract JLabel getJlMatricula();

    public abstract void setJlMatricula(JLabel lb);
    
    public abstract JLabel getJlQr();

    public abstract void setJlQr(JLabel lb);
    
    public abstract JPanel getJpCamara();

    public abstract void setJpCamara(JPanel pn);
    
    public abstract WebcamPanel getWcPanel();

    public abstract void setWcPanel(WebcamPanel wp);
    
}
