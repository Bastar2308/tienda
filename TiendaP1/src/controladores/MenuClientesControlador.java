/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import auxiliares.GuiTools;
import auxiliares.MailTools;
import com.toedter.calendar.JDateChooser;
import dao.ClienteDAO;
import dao.ConsultasDAO;
import dao.GrupoDAO;
import gui.JfCamaraPortatil;
import gui.JfControlDeGrupos;
import gui.JfMenuClientes;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import pojo.Cliente;
import pojo.Grupo;

/**
 *
 * @author MAESTROAD
 */
public class MenuClientesControlador implements ActionListener {

    JfMenuClientes vista;
    Cliente cliente;
    JDateChooser desde = new JDateChooser();
    JDateChooser hasta = new JDateChooser();
    Cliente clienteBuscando;

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
        for (int i = 0; i < datos.getRowCount(); i++) {
            original.addRow(new Object[]{
                datos.getValueAt(i, 0),
                datos.getValueAt(i, 3),
                datos.getValueAt(i, 1),
                datos.getValueAt(i, 2),
                datos.getValueAt(i, 10)
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
        vista.getJbReporte().addActionListener(this);
        vista.getJbEnviar().addActionListener(this);
        vista.getJbControlDeGrupos().addActionListener(this);
        vista.getJbAgregar().addActionListener(this);
        vista.getJbAgregarAceptar().addActionListener(this);
        vista.getJbAgregarCancelar().addActionListener(this);
        vista.getJbEditar().addActionListener(this);
        vista.getJbEditarAceptar().addActionListener(this);
        vista.getJbEditarCancelar().addActionListener(this);
        vista.getJbVer().addActionListener(this);
        vista.getJbEliminar().addActionListener(this);
        vista.getJlFiltro().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                filtraClientes();
            }

        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getJbRegresar())) {
            GuiTools.getInstance().regresaMenu(vista);
        } else if (e.getSource().equals(vista.getJbControlDeGrupos())) {
            GuiTools.getInstance().abre(vista, JfControlDeGrupos.getInstance());
        } else if (e.getSource().equals(vista.getJbAgregar())) {
            GuiTools.getInstance().abreDialogo(vista.getJdAgregar(), vista.getJdAgregar().getPreferredSize().width, vista.getJdAgregar().getPreferredSize().height);
            vista.getJlAgregarNombre().setForeground(Color.WHITE);
            vista.getJlAgregarGrupo().setForeground(Color.WHITE);
            vista.getJlAgregarTutor().setForeground(Color.WHITE);
            vista.getJlAgregarNombre().setText("Nombre:");
            vista.getJlAgregarGrupo().setText("Grupo:");
            vista.getJlAgregarTutor().setText("Tutor:");
        } else if (e.getSource().equals(vista.getJbAgregarCancelar())) {
            vista.getJdAgregar().dispose();
        } else if (e.getSource().equals(vista.getJbAgregarAceptar())) {
            if (agregarCliente() != 0) {
                JOptionPane.showMessageDialog(null, "Cliente guardado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                vista.getJdAgregar().dispose();
                cargarTabla();
                resetDatosAgregar();
            } else {
                JOptionPane.showMessageDialog(null, "Verifique los datos", "Error", JOptionPane.ERROR_MESSAGE);
                vista.getJlAgregarNombre().setForeground(Color.BLUE);
                vista.getJlAgregarGrupo().setForeground(Color.BLUE);
                vista.getJlAgregarTutor().setForeground(Color.BLUE);
                vista.getJlAgregarNombre().setText("Nombre:*");
                vista.getJlAgregarGrupo().setText("Grupo:*");
                vista.getJlAgregarTutor().setText("Tutor:*");
            }
        } else if (e.getSource().equals(vista.getJbEditar())) {
            if (vista.getJtDatos().getSelectedRow() != -1) {
                cliente = ClienteDAO.getInstance().buscaCliente(Integer.parseInt(vista.getJtDatos().getValueAt(vista.getJtDatos().getSelectedRow(), 0).toString()));
                cargarDatos();
                GuiTools.getInstance().abreDialogo(vista.getJdEditar(), vista.getJdEditar().getPreferredSize().width, vista.getJdEditar().getPreferredSize().height);
                vista.getJlEditarNombre().setForeground(Color.WHITE);
                vista.getJlEditarGrupo().setForeground(Color.WHITE);
                vista.getJlEditarTutor().setForeground(Color.WHITE);
                vista.getJlEditarNombre().setText("Nombre:");
                vista.getJlEditarGrupo().setText("Grupo:");
                vista.getJlEditarTutor().setText("Tutor:");
            }
        } else if (e.getSource().equals(vista.getJbEditarCancelar())) {
            vista.getJdEditar().dispose();
        } else if (e.getSource().equals(vista.getJbEditarAceptar())) {
            try {
                if (actualizarCliente() != 0) {
                    JOptionPane.showMessageDialog(null, "Cliente editado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Verifique los datos", "Error", JOptionPane.ERROR_MESSAGE);
                    vista.getJlEditarNombre().setForeground(Color.BLUE);
                    vista.getJlEditarGrupo().setForeground(Color.BLUE);
                    vista.getJlEditarTutor().setForeground(Color.BLUE);
                    vista.getJlEditarNombre().setText("Nombre:*");
                    vista.getJlEditarGrupo().setText("Grupo:*");
                    vista.getJlEditarTutor().setText("Tutor:*");
                }
            } catch (IOException | SQLException ex) {
                Logger.getLogger(MenuClientesControlador.class.getName()).log(Level.SEVERE, null, ex);
            }

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
        } else if (e.getSource().equals(vista.getJbReporte())) {
            reporte();
        } else if (e.getSource().equals(vista.getJbEnviar())) {
            envia();
        }
    }

    int agregarCliente() {
        Cliente clienteA = new Cliente();
        try {
            if (!vista.getTfAgregarNombre().getText().equals("")) {
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
                    int x;
                    if ((x=ClienteDAO.getInstance().insertaCliente(clienteA)) != 0) {
                        System.out.println(x);
                        Calendar calC = Calendar.getInstance();
                        int year= calC.get(Calendar.YEAR) + 1;
                        if (ClienteDAO.getInstance().agregarQR("BSTR_"+x+"_"+year+"-06-30", x)) {
                            System.out.println("QR insertado correctamente");
                        } else {
                            System.out.println("Error al insertar QR");
                        }
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
        for (int i = 1; i < vista.getJcbEditarGrupo().getItemCount(); i++) {
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
        vista.getTfEditarTutor().setText(cliente.getTutor());
        vista.getTfEditarTelefono().setText(cliente.getTelefono());
        vista.getTfEditarCorreo().setText(cliente.getCorreo());
        vista.getJsEditarLimite().setValue(cliente.getLimite()*-1);
    }

    void cargarDatosVer() {
        System.out.println("Cargando cliente");
        vista.getTfVerNombre().setText(cliente.getNombre());
        vista.getJsVerSaldo().setValue(cliente.getSaldo());
        vista.getTfVerQr().setText(cliente.getQr());

        Grupo grupo = GrupoDAO.getInstance().buscaGrupo(cliente.getGrupo_idGrupo());
        for (int i = 1; i < vista.getJcbEditarGrupo().getItemCount(); i++) {
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
        System.out.println("Actualizando datos");
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
            if (!vista.getTfEditarNombre().getText().equals("")) {
                actualizarDatos();
                if (vista.getSRuta() == null) {
                    System.out.println("modificando cliente IF");
                    if (ClienteDAO.getInstance().modificaCliente(cliente) == true) {
                        vista.setSRuta(null);
                        cargarTabla();
                        vista.getJdEditar().dispose();
                        return 1;
                    } else {
                        return 0;
                    }
                } else {
                    System.out.println("modificando cliente ELSE");
                    if (ClienteDAO.getInstance().modificaCliente(cliente, vista.getSRuta()) == true) {
                        vista.setSRuta(null);
                        cargarTabla();
                        vista.getJdEditar().dispose();
                        return 1;
                    } else {
                        return 0;
                    }
                }
            } else {
                return 0;
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
        vista.getTfAgregarTutor().setText(null);
        vista.getTfAgregarTelefono().setText(null);
        vista.getTfAgregarCorreo().setText(null);
        vista.getJsAgregarLimite().setValue(0);

    }

    void filtraClientes() {
        DefaultTableModel defaultTableModel = (DefaultTableModel) vista.getJtDatos().getModel();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<>(defaultTableModel);
        vista.getJtDatos().setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + vista.getJlFiltro().getText()));
    }

    private void reporte() {
        if (vista.getJtDatos().getSelectedRow() != -1) {
            JOptionPane.showConfirmDialog(null, new Object[]{"Desde:", desde, "Hasta:", hasta}, "Seleccione rango del reporte", JOptionPane.PLAIN_MESSAGE);
            DefaultTableModel original = (DefaultTableModel) vista.getJtReporte().getModel();
            double totalRango = 0;
            original.setRowCount(0);
            DefaultTableModel datos = ConsultasDAO.getInstance().consultaComprasEnRango(
                    (int) vista.getJtDatos().getValueAt(vista.getJtDatos().getSelectedRow(), 0),
                    new Date(desde.getDate().getTime()),
                    new Date(hasta.getDate().getTime()));
            for (int i = 0; i < datos.getRowCount(); i++) {
                original.addRow(new Object[]{datos.getValueAt(i, 0), datos.getValueAt(i, 1), datos.getValueAt(i, 2), datos.getValueAt(i, 3)});
                totalRango += Double.parseDouble(String.valueOf(datos.getValueAt(i, 3).toString()));
            }
            clienteBuscando = ClienteDAO.getInstance().buscaCliente((int) vista.getJtDatos().getValueAt(vista.getJtDatos().getSelectedRow(), 0));
            vista.getJlNombre().setText(clienteBuscando.getNombre());
            vista.getJlDesde().setText(String.format("%tA, %<te de %<tB", desde.getDate()));
            vista.getJlHasta().setText(String.format("%tA, %<te de %<tB", hasta.getDate()));
            vista.getJbEnviar().setText(vista.getJbReporte().getText() + " (" + clienteBuscando.getCorreo() + ")");
            vista.getJlTotal().setText(String.format(Locale.ENGLISH, "$%,.2f", totalRango));
            GuiTools.getInstance().abreDialogo(vista.getJdReporte(), vista.getJdReporte().getPreferredSize());
            desde.setDate(null);
            hasta.setDate(null);
        }
    }

    private void envia() {
        String contenido = "";
        for (int i = 0; i < vista.getJtReporte().getRowCount(); i++) {
            contenido = contenido + vista.getJtReporte().getValueAt(i, 0).toString() + " - ";
            contenido = contenido + vista.getJtReporte().getValueAt(i, 1).toString() + " - ";
            contenido = contenido + vista.getJtReporte().getValueAt(i, 2).toString() + " - $";
            contenido = contenido + vista.getJtReporte().getValueAt(i, 3).toString() + "\n";
        }
        contenido = contenido + "Total: "+vista.getJlTotal().getText();
        MailTools.getInstance().enviarCorreo(MailTools.getInstance().iniciarSesion("bastarpuntodeventa@hotmail.com", "puntodeventa23"), 
                clienteBuscando.getCorreo(), 
                "Consumo: "+vista.getJlNombre().getText() + " "+vista.getJlDesde().getText()+" - "+vista.getJlHasta().getText(), 
                contenido);
        System.out.println("Enviado a: "+clienteBuscando.getCorreo());
        JOptionPane.showMessageDialog(null, "Reporte enviado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }
}
