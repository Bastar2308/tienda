/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import auxiliares.GuiTools;
import dao.UsuarioDAO;
import daoif.UsuarioDAOIf;
import gui.JfLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import pojo.Usuario;
import gui.JfMenuPrincipal;

public class LoginControlador implements ActionListener {

    private JfLogin vista;

    public LoginControlador(JfLogin vista) {
        this.vista = vista;

        cargarListeners();
    }

    private void cargarListeners() {
        vista.getTfPassword().addActionListener(this);
        vista.getJbIngresar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getTfPassword())
                || e.getSource().equals(vista.getJbIngresar())) {
            entra();
        }

    }

    private void entra() {
        String usuario = vista.getTfUsuario().getText();
        String password = vista.getTfPassword().getText();

        Usuario pojo = UsuarioDAO.getInstance().iniciaSesion(usuario, password);

        if (pojo.getIdUsuario() != 0) {
            JOptionPane.showMessageDialog(null, "Bienvenido " + pojo.getNombre());
            JfMenuPrincipal.getInstance().getJlUsuario().setText(pojo.getNombre());
            JfMenuPrincipal.getInstance().setVisible(true);
            vista.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

}
