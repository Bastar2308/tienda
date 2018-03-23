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
import javax.swing.JTextField;
import pojo.Cliente;

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
    
    public abstract JTextField getJtNombre();

    public abstract void setJtNombre(JTextField tf);
    
    public abstract JTextField getJtNivel();

    public abstract void setJtNivel(JTextField tf);
    
    public abstract JTextField getJtGradoGrupo();

    public abstract void setJtGradoGrupo(JTextField tf);
    
    public abstract JTextField getJtVigenciaDD();

    public abstract void setJtVigenciaDD(JTextField tf);
    
    public abstract JTextField getJtVigenciaMM();

    public abstract void setJtVigenciaMM(JTextField tf);
    
    public abstract JTextField getJtVigenciaAA();

    public abstract void setJtVigenciaAA(JTextField tf);
    
    public abstract JTextField getJtMatricula();

    public abstract void setJtMatricula(JTextField tf);
    
    public abstract JLabel getJlQr();

    public abstract void setJlQr(JLabel lb);
    
    public abstract JPanel getJpCamara();

    public abstract void setJpCamara(JPanel pn);
    
    public abstract JPanel getJpCredencial();

    public abstract void setJpCredencial(JPanel pn);
    
    public abstract Cliente getCliente();

    public abstract void setCliente(Cliente cl);
    
}
