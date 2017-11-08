/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import auxiliares.ControladorTools;
import auxiliares.DialogoTools;
import auxiliares.GuiTools;
import dao.MarcaDAO;
import dao.ProductoDAO;
import gui.JfMenuMarcas;
import gui.JfProductosMenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pojo.Marca;

/**
 *
 * @author MAESTROAD
 */
public class MenuMarcasControlador implements ActionListener {

    JfMenuMarcas vista;

    public MenuMarcasControlador(JfMenuMarcas vista) {
        this.vista = vista;
        cargarListeners();
        cargarTabla();
    }

    private void cargarTabla() {
        vista.getJtDatos().setModel(MarcaDAO.getInstance().cargarTabla());
    }

    private void cargarListeners() {
        vista.getJbRegresar().addActionListener(this);
        vista.getJbAgregar().addActionListener(this);
        vista.getJbEditar().addActionListener(this);
        vista.getJbEliminar().addActionListener(this);
        vista.getJbAgregarAceptar().addActionListener(this);
        vista.getJbAgregarCancelar().addActionListener(this);
        vista.getJbEditarAceptar().addActionListener(this);
        vista.getJbEditarCancelar().addActionListener(this);
        vista.getJbEliminarAceptar().addActionListener(this);
        vista.getJbEliminarCancelar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getJbRegresar())) {
            GuiTools.getInstance().abre(vista, JfProductosMenuPrincipal.getInstance());
        } else if (e.getSource().equals(vista.getJbAgregar())) {
            GuiTools.getInstance().abreDialogo(vista.getJdAgregar(), 652, 153);
        } else if (e.getSource().equals(vista.getJbEditar())) {
            if (yaSeleccioneUnaFila()) {
                vista.getTfEditarNombre().setText(obtenerMarcaSeleccionada());
                GuiTools.getInstance().abreDialogo(vista.getJdEditar(), 652, 161);
            }
        } else if (e.getSource().equals(vista.getJbEliminar())) {
            if (yaSeleccioneUnaFila()) {
                vista.getJlMarca().setText(obtenerMarcaSeleccionada());
                GuiTools.getInstance().abreDialogo(vista.getJdEliminar(), 350, 161);
            }
        } else if (e.getSource().equals(vista.getJbAgregarCancelar())) {
            apagaYLimpiaDialogoAlta();
        } else if (e.getSource().equals(vista.getJbEditarCancelar())) {
            apagaYLimpiaDialogoEditar();
        } else if (e.getSource().equals(vista.getJbEliminarCancelar())) {
            apagaDialogoEliminar();
        } else if (e.getSource().equals(vista.getJbEliminarAceptar())) {
            eliminar();
        } else if (e.getSource().equals(vista.getJbAgregarAceptar())) {
            agregar();
        } else if (e.getSource().equals(vista.getJbEditarCancelar())) {
            apagaYLimpiaDialogoEditar();
        } else if (e.getSource().equals(vista.getJbEditarAceptar())) {
            editar();
        }
    }

    private void apagaYLimpiaDialogoAlta() {
        vista.getJdAgregar().dispose();
        limpiaDialogoAlta();
    }

    private void apagaYLimpiaDialogoEditar() {
        vista.getJdEditar().dispose();
        limpiaDialogoEditar();
    }

    private void apagaDialogoEliminar() {
        vista.getJdEliminar().dispose();
    }

    private boolean yaSeleccioneUnaFila() {
        int fs = vista.getJtDatos().getSelectedRow();
        if (fs == -1) {
            DialogoTools.getInstance().mensajeError("Primero selecciona una fila");
            return false;
        } else {
            return true;
        }
    }

    private String obtenerMarcaSeleccionada() {
        return vista.getJtDatos().getValueAt(vista.getJtDatos().getSelectedRow(), 1).toString();
    }

    private void eliminar() {
        int id = ControladorTools.getInstance().idFilaSeleccionada(vista.getJtDatos());
        if (MarcaDAO.getInstance().eliminaMarca(id)) {
            DialogoTools.getInstance().mensajeInformacion("Éxito al eliminar");
            cargarTabla();
            apagaDialogoEliminar();
        } else {
            DialogoTools.getInstance().mensajeError("Error al eliminar");
        }
    }

    private void editar() {
        String nombre = vista.getTfEditarNombre().getText().trim();
        Marca marca = new Marca();
        marca.setNombre(nombre);
        int id = ControladorTools.getInstance().idFilaSeleccionada(vista.getJtDatos());
        marca.setIdMarca(id);
        if (MarcaDAO.getInstance().modificaMarca(marca)) {
            DialogoTools.getInstance().mensajeInformacion("Éxito al modificar");
            cargarTabla();
            apagaYLimpiaDialogoEditar();
        } else {
            DialogoTools.getInstance().mensajeError("Error al eliminar");
        }
    }

    private void agregar() {
        String nombre = vista.getTfAgregarNombre().getText().trim();
        Marca marca = new Marca();
        marca.setNombre(nombre);
        if (MarcaDAO.getInstance().insertaMarca(marca) != 0) {
            cargarTabla();
            DialogoTools.getInstance().mensajeInformacion("Éxito al insertar");
            apagaYLimpiaDialogoAlta();
        } else {
            DialogoTools.getInstance().mensajeError("Error al insertar");
        }
    }

    private void limpiaDialogoAlta() {
        vista.getTfAgregarNombre().setText("");
    }

    private void limpiaDialogoEditar() {
        vista.getTfEditarNombre().setText("");
    }

}
