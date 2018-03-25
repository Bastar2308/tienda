/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import auxiliares.CameraTools;
import auxiliares.FileTools;
import auxiliares.GuiTools;
import dao.ClienteDAO;
import dao.GrupoDAO;
import daoif.GrupoDAOIf;
import gui.JfControlDeGrupos;
import gui.JfMenuClientes;
import gui.JfMenuPrincipal;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import pojo.Cliente;
import pojo.Grupo;
import test.credencial.JcCameraToolsIf;

/**
 *
 * @author MAESTROAD
 */
public class MenuClientesControlador implements ActionListener {

    JfMenuClientes vista;
    CameraTools vista2;
    Cliente cliente;

    public MenuClientesControlador(JfMenuClientes vista, CameraTools vista2) {
        this.vista = vista;
        this.vista2 = vista2;
        cliente = ClienteDAO.getInstance().buscaCliente(Integer.parseInt(vista.getJtDatos().getValueAt(vista.getJtDatos().getSelectedRow(), 1).toString()));

        addListeners();
        cargarTabla();
    }

    public void cargarTabla() {
        vista.getJtDatos().setModel(ClienteDAO.getInstance().cargarTabla());
    }

    private void addListeners() {
        vista.getJbRegresar().addActionListener(this);
        vista.getJbControlDeGrupos().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getJbRegresar())) {
            GuiTools.getInstance().regresaMenu(vista);
        } else if (e.getSource().equals(vista.getJbControlDeGrupos())) {
            GuiTools.getInstance().abre(vista, JfControlDeGrupos.getInstance());
        } else if(e.getSource().equals(vista.getJbAgregar())){
            GuiTools.getInstance().abreDialogo(vista.getJdAgregar(), 500, 558);
        } else if  (e.getSource().equals(vista.getJbAgregarAceptar())) {
            if (agregarCliente() != 0) {
                JOptionPane.showMessageDialog(null, "Cliente guardado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar cliente", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource().equals(vista.getJbEditar())) {
            GuiTools.getInstance().abreDialogo(vista.getJdEditar(), 469, 546);
            try {
                cargarDatos();
            } catch (IOException ex) {
                Logger.getLogger(MenuClientesControlador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MenuClientesControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource().equals(vista.getJbEditarAceptar())) {
            try {
                actualizarDatos();
                actualizarCliente();
            } catch (IOException ex) {
                Logger.getLogger(MenuClientesControlador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MenuClientesControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource().equals(vista.getJbEliminar())) {
            ClienteDAO.getInstance().eliminaCliente(Integer.parseInt(vista.getJtDatos().getValueAt(vista.getJtDatos().getSelectedRow(), 1).toString()));
        }
    }
    
    int agregarCliente(){
        Cliente cliente = new Cliente();
        Grupo grupo = (Grupo) vista.getJcbAgregarGrupo().getSelectedItem();
        cliente.setNombre(vista.getTfAgregarNombre().getText());
        cliente.setGrupo_idGrupo(grupo.getIdGrupo());
        cliente.setSaldo((Double)vista.getJsAgregarSaldo().getValue());
        cliente.setQr(vista.getTfAgregarQr().getText());
        cliente.setTutor(vista.getTfAgregarTutor().getText());
        cliente.setTelefono(vista.getTfAgregarTelefono().getText());
        cliente.setCorreo(vista.getTfAgregarCorreo().getText());
        if (ClienteDAO.getInstance().insertaCliente(cliente, "") != 0) {
            System.out.println("Insertado correctamente");
            return 1;
        } else {
            System.out.println("Error en la inserción");
            return 0;
        }
    }
    
    void cargarDatos() throws IOException, SQLException{
        vista.getTfEditarNombre().setText(cliente.getNombre());
        vista.getJcbEditarGrupo().setSelectedItem(GrupoDAO.getInstance().buscaGrupo(cliente.getGrupo_idGrupo()));
        vista.getJsEditarSaldo().setValue(cliente.getSaldo());
        vista.getTfEditarQr().setText(cliente.getQr());
        InputStream in = cliente.getFoto().getBinaryStream();  
        BufferedImage image = ImageIO.read(in);
        ImageIcon imagen3 = new ImageIcon(image);
        Icon icono = new ImageIcon(imagen3.getImage().getScaledInstance(vista.getJlEditarImagen().getWidth(), vista.getJlEditarImagen().getHeight(), Image.SCALE_DEFAULT));
        vista.getJlEditarImagen().setIcon(icono);
        vista.getTfEditarTutor().setText(cliente.getTutor());
        vista.getTfEditarTelefono().setText(cliente.getTelefono());
        vista.getTfEditarCorreo().setText(cliente.getCorreo());
    }
    
    void actualizarDatos() throws IOException, SQLException{ 
        cliente.setNombre(vista.getTfEditarNombre().getText());
        Grupo grupo = (Grupo)vista.getJcbEditarGrupo().getSelectedItem();
        cliente.setGrupo_idGrupo(grupo.getIdGrupo());
        cliente.setSaldo((Double)vista.getJsEditarSaldo().getValue());
        cliente.setQr(vista.getTfEditarQr().getText());
        cliente.setTutor(vista.getTfEditarTutor().getText());
        cliente.setTelefono(vista.getTfEditarTelefono().getText());
        cliente.setCorreo(vista.getTfEditarCorreo().getText());
    }
    
    int actualizarCliente() throws IOException{
        File salida = new File(System.getProperty("user.home")+"/Documents/system32/Alumnos");
        FileTools.getInstance().verificaDirectorio(salida);
        salida = FileTools.getInstance().nombraImagenes(salida, "Alumnos");
        ImageIO.write(createImage(vista.getJlEditarImagen()), "png", salida);
        if (ClienteDAO.getInstance().modificaCliente(cliente, salida.getAbsolutePath())== true) {
            System.out.println("Actualizado correctamente");
            return 1;
        } else {
            System.out.println("Error en la actualización");
            return 0;
        }
    }
    
    public BufferedImage createImage(JLabel label) {
        int w = label.getWidth();
        int h = label.getHeight();
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();
        label.paint(g);
        return bi;
    }
    
}
