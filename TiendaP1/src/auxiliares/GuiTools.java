/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliares;

import gui.JfMenuPrincipal;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MAESTROAD
 */
public class GuiTools {

    private GuiTools() {
    }

    public static GuiTools getInstance() {
        return GuiToolesHolder.INSTANCE;
    }

    private static class GuiToolesHolder {

        private static final GuiTools INSTANCE = new GuiTools();
    }

    public void config(JFrame jFrame) {
        jFrame.setIconImage(new ImageIcon(this.getClass().getResource("/recursos/iconocbb.png")).getImage());
    }

    public void abre(JFrame viejo, JFrame nuevo) {
        viejo.dispose();
        nuevo.setVisible(true);
    }

    public void regresaMenu(JFrame viejo) {
        viejo.dispose();
        JfMenuPrincipal.getInstance().setVisible(true);
    }

    /**
     * Inicializa el JFrame con el título brindado
     *
     * @param jFrame
     * @param titulo
     */
    public void inicializaJFrame(JFrame jFrame, String titulo) {
        jFrame.setTitle(titulo);
    }

    /**
     * Inicializa el JFrame con el título brindado y puede centrarlo
     *
     * @param jFrame
     * @param titulo
     * @param centrar
     */
    public void inicializaJFrame(JFrame jFrame, String titulo, boolean centrar) {
        inicializaJFrame(jFrame, titulo);
        if (centrar) {
            jFrame.setLocationRelativeTo(null);
        }
    }

    /**
     * Inicializa el JFrame con el título brindado, puede centrarlo y agrega
     * ícono
     *
     * @param jFrame
     * @param titulo
     * @param centrar
     * @param icono
     */
    public void inicializaJFrame(JFrame jFrame, String titulo, boolean centrar, Image icono) {
        inicializaJFrame(jFrame, titulo, centrar);
        jFrame.setIconImage(icono);
    }

    /**
     * Inicializa el JFrame con el título brindado, puede centrarlo, agrega
     * ícono
     *
     * @param jFrame
     * @param titulo
     * @param centrar
     * @param icono
     * @param x
     * @param y
     */
    public void inicializaJFrame(JFrame jFrame, String titulo, boolean centrar, Image icono, int ancho, int alto) {
        inicializaJFrame(jFrame, titulo, centrar, icono);
        jFrame.setSize(ancho, alto);
    }

    public void abreDialogo(JDialog dialogo, int largo, int alto) {
        dialogo.setSize(largo, alto);
        dialogo.setLocationRelativeTo(null);
        dialogo.setVisible(true);
    }

    public DefaultTableModel resultSetToDefaultTableModel(ResultSet source) {
        DefaultTableModel modelo = new DefaultTableModel();
        try {
            ResultSetMetaData meta = source.getMetaData();
            for (int i = 0; i < meta.getColumnCount(); i ++) {
                modelo.addColumn(meta.getColumnLabel(i+1));
            }
            while (source.next()) {
                Object[] fila = new Object[meta.getColumnCount()];
                for (int i = 0; i < meta.getColumnCount(); i ++) {
                    fila[i] = source.getObject(i + 1);
                }
                modelo.addRow(fila);
            }
            source.close();
            return modelo;
        } catch (SQLException ex) {
            Logger.getLogger(GuiTools.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
        }
    }

}
