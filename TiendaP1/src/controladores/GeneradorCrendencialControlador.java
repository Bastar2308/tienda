/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import auxiliares.MailTools;
import dao.ClienteDAO;
import gui.JfGeneradorCredencial;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.FileDataSource;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import pojo.Cliente;

/**
 *
 * @author Fernando
 */
public class GeneradorCrendencialControlador implements ActionListener{
    private JfGeneradorCredencial vista;

    public GeneradorCrendencialControlador(JfGeneradorCredencial vista) {
        this.vista = vista;
        cargarListeners();
    }

    private void cargarListeners() {
        vista.getJbTomar().addActionListener(this);
        vista.getJbRepetir().addActionListener(this);
        vista.getJbGuardar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getJbTomar())) {
            vista.getWcPanel().pause();
        } else if (e.getSource().equals(vista.getJbRepetir())) {
            vista.getWcPanel().resume();
        } else if (e.getSource().equals(vista.getJbGuardar())) {
            File outputfile = new File(System.getProperty("user.home")+"/Documents/system32/");
            verificaDirectorio(outputfile);
            outputfile = nombraImagenes(outputfile, "");

        try {
            ImageIO.write(createImage(vista.getJpCredencial()), "png", outputfile);
            System.out.println("Éxito al guardar credencial");
            MailTools.getInstance().enviarCorreo(MailTools.getInstance().iniciarSesion("correo_prueba456@hotmail.com", "Contrasena"),
                    "aaronlr160399@hotmail.com", "Imagen", "Mensaje enviado desde STCBB",
                    new FileDataSource(outputfile));
        } catch (IOException ex) {
            System.out.println("Error al guardar: " + ex);
        }
        
        try {
            actualizarCliente(vista.getCliente(),outputfile);
        } catch (IOException ex) {
            Logger.getLogger(GeneradorCrendencialControlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GeneradorCrendencialControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        } 
    }
    
    public File nombraImagenes(File outputfile, String carpeta){
        int n = 0;
        do {
            n ++;
            outputfile = new File(System.getProperty("user.home")+"/Documents/system32/"+carpeta+"/imagen0" + n + ".png");
        }while (outputfile.isFile());
        return outputfile;
    }
    
    public BufferedImage createImage(JPanel panel) {
        int w = panel.getWidth();
        int h = panel.getHeight();
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();
        panel.paint(g);
        return bi;
    }
    
    public void verificaDirectorio(File salida){
        File newDirectory = null;
        if (!salida.isDirectory()) {
            salida.mkdirs();
            newDirectory = salida;
        }  
    }
    
    public boolean actualizarCliente(Cliente cliente, File outFile) throws IOException, SQLException{
        File salida = new File(System.getProperty("user.home")+"/Documents/system32/Alumnos");
        verificaDirectorio(salida);
        salida = nombraImagenes(salida, "Alumnos");
        ImageIO.write(createImage(vista.getJpCamara()), "png", salida);
        if (ClienteDAO.getInstance().modificaCliente(cliente, outFile.getAbsolutePath()) == true) {
            System.out.println("Actualizado correctamente");
            return true;
        } else {
            System.out.println("Error en la actualización");
            return true;
        }
    }
    
}
