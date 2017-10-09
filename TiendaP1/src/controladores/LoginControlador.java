/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.UsuarioDAO;
import daoif.UsuarioDAOIf;
import guiif.JfLoginIf;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import pojo.Usuario;

public class LoginControlador implements ActionListener {

    private JfLoginIf vista;
    private UsuarioDAOIf dao;

    public LoginControlador(JfLoginIf vista) {
        this.vista = vista;
        dao = new UsuarioDAO();
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
        String usuario=vista.getTfUsuario().getText();
        String password=vista.getTfPassword().getText();
        
        Usuario pojo=dao.iniciaSesion(usuario, password);
        if (pojo!=null) {
            JOptionPane.showMessageDialog(null, "Éxito");
        }else{
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

}
