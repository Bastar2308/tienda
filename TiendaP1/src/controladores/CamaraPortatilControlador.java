/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import auxiliares.CameraTools;
import auxiliares.FileTools;
import auxiliares.GuiTools;
import gui.JfCamaraPortatil;
import gui.JfMenuClientes;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Fernando
 */
public class CamaraPortatilControlador implements ActionListener{
    
    private JfCamaraPortatil vista;
    private JLabel foto;
    private CameraTools vista2;
    private JDialog dialogo;
    private JfMenuClientes ruta;
    
    public CamaraPortatilControlador(JfCamaraPortatil vista, CameraTools ct, JLabel foto, JDialog dialogo, JfMenuClientes ruta) {
        this.vista = vista;
        this.vista2 = ct;
        this.foto = foto;
        this.dialogo = dialogo;
        this.ruta = ruta;
        
        addListeners();
    }
    
    private void addListeners() {
        vista.getJbTomar().addActionListener(this);
        vista.getJbRepetir().addActionListener(this);
        vista.getJbAceptar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(vista.getJbTomar())) {
            System.out.println("Sí");
            vista2.getJpPanel().pause();
            vista.getJbAceptar().setEnabled(true);
        } else if (ae.getSource().equals(vista.getJbRepetir())) {
            System.out.println("repetir");
            vista2.getJpPanel().resume();
        } else if (ae.getSource().equals(vista.getJbAceptar())) {
            File outputfile = new File(System.getProperty("user.home")+"/Documents/system32/");
            FileTools.getInstance().verificaDirectorio(outputfile);
            outputfile = FileTools.getInstance().nombraImagenes(outputfile, "");
            File salida = new File(System.getProperty("user.home")+"/Documents/system32/Alumnos");
            FileTools.getInstance().verificaDirectorio(salida);
            salida = FileTools.getInstance().nombraImagenes(salida, "Alumnos");
            try {
                ImageIO.write(createImage(vista.getJpCamra()), "png", salida);
                ImageIcon imagen = new ImageIcon(salida.getAbsolutePath());
                Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
                foto.setIcon(icono);
                ruta.setSRuta(salida.getAbsolutePath());
                vista.dispose();
                vista2.getJpPanel().stop();
            } catch (IOException ex) {
                Logger.getLogger(CamaraPortatilControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            GuiTools.getInstance().abreDialogo(dialogo, 500, 588);
        }
    }
    
    public BufferedImage createImage(JPanel panel) {
        int w = panel.getWidth();
        int h = panel.getHeight();
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();
        panel.paint(g);
        return bi;
    }
    
}
