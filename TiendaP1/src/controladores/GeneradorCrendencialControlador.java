/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import auxiliares.CameraTools;
import auxiliares.FileTools;
import auxiliares.GuiTools;
import auxiliares.MailTools;
import auxiliares.QrTools;
import dao.ClienteDAO;
import dao.GrupoDAO;
import gui.JfGeneradorCredencial;
import gui.JfMenuGeneradorCredenciales;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.FileDataSource;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pojo.Cliente;
import pojo.Grupo;

/**
 *
 * @author Fernando
 */
public class GeneradorCrendencialControlador implements ActionListener{
    private JfGeneradorCredencial vista;
    private CameraTools vista2;
    private int caso = 0;

    public GeneradorCrendencialControlador(JfGeneradorCredencial vista, CameraTools ct) {
        this.vista = vista;
        this.vista2 = ct;
        cargarListeners();
        System.out.println("Funciona");
        try {
            cargarDatos();
        } catch (IOException | SQLException e) {
            
        }
        
    }

    private void cargarListeners() {
        vista.getJbTomar().addActionListener(this);
        vista.getJbRepetir().addActionListener(this);
        vista.getJbGuardar().addActionListener(this);
        vista.getJbRegresar().addActionListener(this);
        vista.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent we) {
                System.out.println("Opened");
            }

            @Override
            public void windowClosing(WindowEvent we) {
                System.out.println("Closing");
            }

            @Override
            public void windowClosed(WindowEvent we) {
                System.out.println("Closed");
            }

            @Override
            public void windowIconified(WindowEvent we) {
                System.out.println("Iconified");
            }

            @Override
            public void windowDeiconified(WindowEvent we) {
                System.out.println("Deiconified");
            }

            @Override
            public void windowActivated(WindowEvent we) {
                System.out.println("Activated");
                try {
                    cargarDatos();
                } catch (IOException | SQLException ex) {
                    Logger.getLogger(GeneradorCrendencialControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void windowDeactivated(WindowEvent we) {
                System.out.println("Deactivated");
                vista2.getJpPanel().stop();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getJbTomar())) {
            vista2.getJpPanel().pause();
        } else if (e.getSource().equals(vista.getJbRepetir())) {
            vista2.getJpPanel().resume();
        } else if (e.getSource().equals(vista.getJbGuardar())) {
            File outputfile = new File(System.getProperty("user.home")+"/Documents/system32/");
            FileTools.getInstance().verificaDirectorio(outputfile);
            outputfile = FileTools.getInstance().nombraImagenes(outputfile, "");
            try {
                guardarImagen(outputfile);
                guardarCliente(vista.getCliente(), outputfile);
            } catch (IOException | SQLException ex) {
                Logger.getLogger(GeneradorCrendencialControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource().equals(vista.getJbRegresar())) {
            GuiTools.getInstance().abre(vista, JfMenuGeneradorCredenciales.getInstance());
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
        if (caso == 1) {
//            if (ClienteDAO.getInstance().modificaClienteCredencial(cliente) == true) {
//                System.out.println("Actualizado correctamente");
//                return true;
//            } else {
//                System.out.println("Error al guardar cliente");
//                return false;
//            }
            System.out.println("Ya tiene foto");
            return true;
        } else {
            if (ClienteDAO.getInstance().modificaClienteCredencial(cliente, salida.getAbsolutePath()) == true) {
                System.out.println("Actualizado correctamente");
                return true;
            } else {
                System.out.println("Error al guardar cliente");
                return false;
            }
        }
    }
    
    public final void cargarDatos() throws IOException, SQLException{
        Grupo grupo = GrupoDAO.getInstance().buscaGrupo(vista.getCliente().getGrupo_idGrupo());
        colocarQr(vista.getCliente().getQr());
        if (vista.getCliente().getFoto() != null) {
            InputStream in = vista.getCliente().getFoto().getBinaryStream();  
            BufferedImage image = ImageIO.read(in);
            ImageIcon imagen3 = new ImageIcon(image);
            Icon icono = new ImageIcon(imagen3.getImage().getScaledInstance(vista.getJpCamara().getWidth(), vista.getJpCamara().getHeight(), Image.SCALE_DEFAULT));
            vista.getJpCamara().removeAll();
            vista.getJpCamara().add(new JLabel(icono));
            vista.getJpCamara().repaint();
            vista.getJpCamara().revalidate();
            caso = 1;
        } else {
            vista2.run();
            caso = 0;
        }
        System.out.println("caso: "+caso);
    }
    
    void colocarQr(String matricula){
        ImageIcon imagen3 = new ImageIcon(QrTools.getInstance().generarQR(matricula, null, null));
        Icon icono = new ImageIcon(imagen3.getImage().getScaledInstance(vista.getJlQr().getWidth(), vista.getJlQr().getHeight(), Image.SCALE_DEFAULT));
        vista.getJlQr().removeAll();
        vista.getJlQr().setIcon(icono);
        vista.getJlQr().repaint();
        vista.getJlQr().revalidate();
        System.out.println("Dimensiones: "+vista.getJlQr().getWidth());
    }
    
    void guardarImagen(File outputfile) throws IOException{
        ImageIO.write(createImage(vista.getJpCredencial()), "png", outputfile);
        System.out.println("Éxito al guardar credencial");
        MailTools.getInstance().enviarCorreo(
                "aaronlr160399@hotmail.com", "Imagen", "Mensaje enviado desde STCBB",
                new FileDataSource(outputfile));
    }
}
