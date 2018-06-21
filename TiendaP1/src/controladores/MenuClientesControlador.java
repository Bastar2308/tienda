/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import auxiliares.GuiTools;
import dao.ClienteDAO;
import dao.GrupoDAO;
import gui.JfCamaraPortatil;
import gui.JfControlDeGrupos;
import gui.JfMenuClientes;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
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
import javax.swing.table.DefaultTableModel;
import pojo.Cliente;
import pojo.Grupo;

/**
 *
 * @author MAESTROAD
 */
public class MenuClientesControlador implements ActionListener {

    JfMenuClientes vista;
    Cliente cliente;

    public MenuClientesControlador(JfMenuClientes vista) {
        this.vista = vista;

        addListeners();
        cargarTabla();
        cargarCombos();
    }

    public void cargarTabla() {
        DefaultTableModel datos = ClienteDAO.getInstance().cargarTabla();
        DefaultTableModel original = (DefaultTableModel) vista.getJtDatos().getModel();
        original.setRowCount(0);
        for (int i = 0; i < datos.getRowCount(); i ++) {
            original.addRow(new Object[]{
                datos.getValueAt(i, 0),
                datos.getValueAt(i, 3),
                datos.getValueAt(i, 1),
                datos.getValueAt(i, 2),
                datos.getValueAt(i, 6),
                datos.getValueAt(i, 7),
                datos.getValueAt(i, 9)
            });
        }
    }

    public void cargarCombos() {
        vista.getJcbAgregarGrupo().setModel(GrupoDAO.getInstance().cargarCombo());
        vista.getJcbEditarGrupo().setModel(GrupoDAO.getInstance().cargarCombo());
        vista.getJcbVerGrupo().setModel(GrupoDAO.getInstance().cargarCombo());
    }

    private void addListeners() {
        vista.getJbRegresar().addActionListener(this);
        vista.getJbControlDeGrupos().addActionListener(this);
        vista.getJbAgregar().addActionListener(this);
        vista.getJbAgregarAceptar().addActionListener(this);
        vista.getJbAgregarCancelar().addActionListener(this);
        vista.getJbAgregarTomarFoto().addActionListener(this);
        vista.getJbEditar().addActionListener(this);
        vista.getJbEditarAceptar().addActionListener(this);
        vista.getJbEditarCancelar().addActionListener(this);
        vista.getJbEditarTomarFoto().addActionListener(this);
        vista.getJbVer().addActionListener(this);
        vista.getJbEliminar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getJbRegresar())) {
            GuiTools.getInstance().regresaMenu(vista);
        } else if (e.getSource().equals(vista.getJbControlDeGrupos())) {
            GuiTools.getInstance().abre(vista, JfControlDeGrupos.getInstance());
        } else if (e.getSource().equals(vista.getJbAgregar())) {
            GuiTools.getInstance().abreDialogo(vista.getJdAgregar(), 500, 588);
        } else if (e.getSource().equals(vista.getJbAgregarCancelar())) {
            vista.getJdAgregar().setVisible(false);
        } else if (e.getSource().equals(vista.getJbAgregarAceptar())) {
            if (agregarCliente() != 0) {
                JOptionPane.showMessageDialog(null, "Cliente guardado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                vista.getJdAgregar().dispose();
                cargarTabla();
                resetDatosAgregar();
            } else {
                JOptionPane.showMessageDialog(null, "Verifique los datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource().equals(vista.getJbEditar())) {
            if (vista.getJtDatos().getSelectedRow() != -1) {
                cliente = ClienteDAO.getInstance().buscaCliente(Integer.parseInt(vista.getJtDatos().getValueAt(vista.getJtDatos().getSelectedRow(), 0).toString()));
                cargarDatos();
                GuiTools.getInstance().abreDialogo(vista.getJdEditar(), 469, 546);
            }
        } else if (e.getSource().equals(vista.getJbEditarCancelar())) {
            vista.getJdEditar().setVisible(false);
        } else if (e.getSource().equals(vista.getJbEditarAceptar())) {
            try {
                if (actualizarCliente() != 0) {
                    JOptionPane.showMessageDialog(null, "Cliente editado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Verifique los datos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (IOException | SQLException ex) {
                Logger.getLogger(MenuClientesControlador.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (e.getSource().equals(vista.getJbEditarTomarFoto())) {
            vista.getJdEditar().setVisible(false);
            JfCamaraPortatil.getInstance(vista.getJlEditarImagen(), vista.getJdEditar(), vista).setVisible(true);
        } else if (e.getSource().equals(vista.getJbEliminar())) {
            if (ClienteDAO.getInstance().eliminaCliente(Integer.parseInt(vista.getJtDatos().getValueAt(vista.getJtDatos().getSelectedRow(), 0).toString())) == true) {
                JOptionPane.showMessageDialog(null, "Cliente eliminado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                cargarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar cliente", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else if (e.getSource().equals(vista.getJbVer())) {
            if (vista.getJtDatos().getSelectedRow() != -1) {
                ver();
            }
        } else if (e.getSource().equals(vista.getJbAgregarTomarFoto())) {
            vista.getJdAgregar().setVisible(false);
            JfCamaraPortatil.getInstance(vista.getJlAgregarImagen(), vista.getJdAgregar(), vista).setVisible(true);
        }
    }

    int agregarCliente() {
        Cliente clienteA = new Cliente();
        try {
            if (!vista.getTfAgregarNombre().getText().equals("") && !vista.getTfAgregarTutor().getText().equals("")) {
                System.out.println("Dentro del IF");
                System.out.println(vista.getTfAgregarNombre().getText());
                System.out.println(vista.getTfAgregarTutor().getText());
                Grupo grupo = (Grupo) vista.getJcbAgregarGrupo().getSelectedItem();
                clienteA.setGrupo_idGrupo(grupo.getIdGrupo());
                clienteA.setNombre(vista.getTfAgregarNombre().getText());
                clienteA.setSaldo((Double) vista.getJsAgregarSaldo().getValue());
                clienteA.setTutor(vista.getTfAgregarTutor().getText());
                clienteA.setTelefono(vista.getTfAgregarTelefono().getText());
                clienteA.setCorreo(vista.getTfAgregarCorreo().getText());
                clienteA.setLimite(Integer.parseInt(vista.getJsAgregarLimite().getValue().toString()) * -1);
                if (vista.getSRuta() == null) {
                    if (ClienteDAO.getInstance().insertaCliente(clienteA) != 0) {
                        System.out.println("Insertado correctamente");
                        return 1;
                    } else {
                        System.out.println("Error en la inserción");
                        return 0;
                    }
                } else {
                    if (ClienteDAO.getInstance().insertaCliente(clienteA, vista.getSRuta()) != 0) {
                        System.out.println("Insertado correctamente");
                        vista.setSRuta(null);
                        return 1;
                    } else {
                        System.out.println("Error en la inserción");
                        return 0;
                    }
                }
            } else {
                System.out.println("Dentro del ELSE");
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
    }

    void cargarDatos() {
        vista.getTfEditarNombre().setText(cliente.getNombre());
        Grupo grupo = GrupoDAO.getInstance().buscaGrupo(cliente.getGrupo_idGrupo());
        for (int i = 1; i < vista.getJcbEditarGrupo().getItemCount(); i ++) {
            String grupoDeLaListaActual = vista.getJcbEditarGrupo().getItemAt(i).toString();
            if (grupoDeLaListaActual.equals(grupo.toString())) {
                vista.getJcbEditarGrupo().setSelectedIndex(i);
            }
        }
//        vista.getJcbEditarGrupo().setSelectedItem((Grupo) GrupoDAO.getInstance().buscaGrupo(cliente.getGrupo_idGrupo()));
//        System.out.println(vista.getJcbEditarGrupo().getSelectedItem());
        vista.getJsEditarSaldo().setValue(cliente.getSaldo());
        vista.getTfEditarQr().setText(cliente.getQr());
        InputStream in;
        BufferedImage image;
        ImageIcon imagen3 = null;
        try {
            in = cliente.getFoto().getBinaryStream();
            image = ImageIO.read(in);
            imagen3 = new ImageIcon(image);
        } catch (IOException | SQLException | NullPointerException ex) {
            System.out.println("No hay imagen editar");
            imagen3 = new javax.swing.ImageIcon(getClass().getResource("/recursos/Import_16px.png"));
        }
        Icon icono = new ImageIcon(imagen3.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        vista.getJlEditarImagen().setIcon(icono);
        vista.getTfEditarTutor().setText(cliente.getTutor());
        vista.getTfEditarTelefono().setText(cliente.getTelefono());
        vista.getTfEditarCorreo().setText(cliente.getCorreo());
    }

    void cargarDatosVer() {
        System.out.println("Cargando cliente");
        vista.getTfVerNombre().setText(cliente.getNombre());
        vista.getJsVerSaldo().setValue(cliente.getSaldo());
        vista.getTfVerQr().setText(cliente.getQr());
        
        Grupo grupo = GrupoDAO.getInstance().buscaGrupo(cliente.getGrupo_idGrupo());
        for (int i = 1; i < vista.getJcbEditarGrupo().getItemCount(); i ++) {
            String grupoDeLaListaActual = vista.getJcbEditarGrupo().getItemAt(i).toString();
            if (grupoDeLaListaActual.equals(grupo.toString())) {
                vista.getJcbVerGrupo().setSelectedIndex(i);
            }
        }
        
        ImageIcon imagen3;
        InputStream in;
        BufferedImage image = null;
        try {
            in = cliente.getFoto().getBinaryStream();
            image = ImageIO.read(in);
            imagen3 = new ImageIcon(image);
        } catch (IOException | SQLException | NullPointerException ex) {
            System.out.println("No hay imagen ver");
//            imagen3 = new javax.swing.ImageIcon(getClass().getResource("/recursos/Import_16px.png"));
        }
//        Icon icono = new ImageIcon(imagen3.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
//        vista.getJlVerImagen().setIcon(icono);
        vista.getTfVerTutor().setText(cliente.getTutor());
        vista.getTfVerTelefono().setText(cliente.getTelefono());
        vista.getTfVerCorreo().setText(cliente.getCorreo());
        vista.getJsVerLimite().setValue(cliente.getLimite() * -1);
    }

    void actualizarDatos() throws IOException, SQLException {
        cliente.setNombre(vista.getTfEditarNombre().getText());
        Grupo grupo = (Grupo) vista.getJcbEditarGrupo().getSelectedItem();
        cliente.setGrupo_idGrupo(grupo.getIdGrupo());
        cliente.setSaldo((Double) vista.getJsEditarSaldo().getValue());
        cliente.setQr(vista.getTfEditarQr().getText());
        cliente.setTutor(vista.getTfEditarTutor().getText());
        cliente.setTelefono(vista.getTfEditarTelefono().getText());
        cliente.setCorreo(vista.getTfEditarCorreo().getText());
        cliente.setLimite(Integer.parseInt(vista.getJsEditarLimite().getValue().toString()) * -1);
    }

    int actualizarCliente() throws IOException, SQLException {
        try {
            actualizarDatos();
            if (vista.getSRuta() == null) {
                if (ClienteDAO.getInstance().modificaCliente(cliente) == true) {
                    vista.setSRuta(null);
                    cargarTabla();
                    vista.getJdEditar().dispose();
                    return 1;
                } else {
                    return 0;
                }
            } else {
                if (ClienteDAO.getInstance().modificaCliente(cliente, vista.getSRuta()) == true) {
                    vista.setSRuta(null);
                    cargarTabla();
                    vista.getJdEditar().dispose();
                    return 1;
                } else {
                    return 0;
                }
            }
        } catch (Exception e) {
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

    private void ver() {
        cliente = ClienteDAO.getInstance().buscaCliente(Integer.parseInt(vista.getJtDatos().getValueAt(vista.getJtDatos().getSelectedRow(), 0).toString()));
        cargarDatosVer();
        GuiTools.getInstance().abreDialogo(vista.getJdVer(), 469, 546);
    }

    private void resetDatosAgregar() {
        vista.getTfAgregarNombre().setText(null);
        vista.getJcbAgregarGrupo().setSelectedIndex(0);
        vista.getJsAgregarSaldo().setValue(0);
        vista.getJlAgregarImagen().setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/user.png")));

    }

}
