/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import daoif.UsuarioDAOIf;
import pojo.Usuario;


public class UsuarioDAO implements UsuarioDAOIf{

    
    
    @Override
    public Usuario iniciaSesion(String usuario, String password) {
        Usuario pojo = new Usuario();
        pojo.setIdUsuario(1);
        pojo.setNombre("Nombre");
        pojo.setUsuario("Usuario");
        pojo.setPassword("Contrasena");
        return pojo;
    }

}
