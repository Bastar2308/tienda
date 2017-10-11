/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoif;

import java.sql.ResultSet;
import pojo.Usuario;

/**
 *
 * @author Profesor Bastar
 */
public interface UsuarioDAOIf {
    
    public abstract Usuario iniciaSesion(String usuario,String password);
    public abstract Usuario inflaUsuario(ResultSet rs);
    

}