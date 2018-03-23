/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import auxiliares.GuiTools;
import dao.ClienteDAO;
import gui.JfControlDeGrupos;
import gui.JfMenuClientes;
import gui.JfMenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import pojo.Cliente;
import pojo.Grupo;

/**
 *
 * @author MAESTROAD
 */
public class MenuClientesControlador implements ActionListener {

    JfMenuClientes vista;

    public MenuClientesControlador(JfMenuClientes vista) {
        this.vista = vista;

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
        } else if  (e.getSource().equals(vista.getJbAgregar())) {
            if (agregarCliente() != 0) {
                JOptionPane.showMessageDialog(null, "Cliente guardado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar cliente", "Error", JOptionPane.ERROR_MESSAGE);
            }
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
    
}
