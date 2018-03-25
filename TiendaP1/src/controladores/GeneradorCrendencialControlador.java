/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import auxiliares.CameraTools;
import auxiliares.FileTools;
import auxiliares.MailTools;
import auxiliares.QrTools;
import dao.ClienteDAO;
import gui.JfGeneradorCredencial;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.FileDataSource;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import pojo.Cliente;

/**
 *
 * @author Fernando
 */
public class GeneradorCrendencialControlador implements ActionListener{
    private JfGeneradorCredencial vista;
    private CameraTools vista2;

    public GeneradorCrendencialControlador(JfGeneradorCredencial vista, CameraTools ct) {
        this.vista = vista;
        this.vista2 = ct;
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
            vista2.getJpPanel().pause();
        } else if (e.getSource().equals(vista.getJbRepetir())) {
            vista2.getJpPanel().resume();
        } else if (e.getSource().equals(vista.getJbGuardar())) {
            colocarQr(vista.getJtMatricula().getText());
            File outputfile = new File(System.getProperty("user.home")+"/Documents/system32/");
            FileTools.getInstance().verificaDirectorio(outputfile);
            outputfile = FileTools.getInstance().nombraImagenes(outputfile, "");
            try {
                guardarImagen(outputfile);
            } catch (IOException ex) {
                Logger.getLogger(GeneradorCrendencialControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            Cliente cliente = new Cliente();
            cliente.setNombre(vista.getJtNombre().getText());
            cliente.setGrupo_idGrupo(Integer.parseInt(vista.getJtGradoGrupo().getText()));
            cliente.setVigencia(new Date(Integer.parseInt(vista.getJtVigenciaAA().getText())-1900, 
                    Integer.parseInt(vista.getJtVigenciaMM().getText()), 
                    Integer.parseInt(vista.getJtVigenciaDD().getText())));
            try {
                guardarCliente(cliente, outputfile);
            } catch (IOException ex) {
                Logger.getLogger(GeneradorCrendencialControlador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(GeneradorCrendencialControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
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
    
    public boolean guardarCliente(Cliente cliente, File outFile) throws IOException, SQLException{
        File salida = new File(System.getProperty("user.home")+"/Documents/system32/Alumnos");
        FileTools.getInstance().verificaDirectorio(salida);
        salida = FileTools.getInstance().nombraImagenes(salida, "Alumnos");
        ImageIO.write(createImage(vista.getJpCamara()), "png", salida);
        if (ClienteDAO.getInstance().insertaCliente(cliente, outFile.getAbsolutePath()) != 0) {
            System.out.println("Ingresado correctamente");
            return true;
        } else {
            System.out.println("Error al guardar cliente");
            return true;
        }
    }
    void colocarQr(String matricula){
        ImageIcon imagen3 = new ImageIcon(QrTools.getInstance().generarQR(matricula, null, null));
        Icon icono = new ImageIcon(imagen3.getImage().getScaledInstance(vista.getJlQr().getWidth(), vista.getJlQr().getHeight(), Image.SCALE_DEFAULT));
        vista.getJlQr().setIcon(icono);
        System.out.println("Dimensiones: "+vista.getJlQr().getWidth());
    }
    
    void guardarImagen(File outputfile) throws IOException{
        ImageIO.write(createImage(vista.getJpCredencial()), "png", outputfile);
        System.out.println("Éxito al guardar credencial");
        MailTools.getInstance().enviarCorreo(MailTools.getInstance().iniciarSesion("correo_prueba456@hotmail.com", "Contrasena"),
                "aaronlr160399@hotmail.com", "Imagen", "Mensaje enviado desde STCBB",
                new FileDataSource(outputfile));
    }
}
