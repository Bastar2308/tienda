/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiif;

import javax.swing.JButton;
import javax.swing.JLabel;
/**
 *
 * @author Profesor Bastar
 */
public interface JfMenuPrincipalIf {
    
    public abstract JLabel getJlUsuario();
    public abstract void setJlUsuario(JLabel jl);
    
    public abstract JButton getJbAyuda();
    public abstract void setJbAyuda(JButton jb);
    //Menu
    public abstract JButton getJbCargarSaldo();
    public abstract void setJbCargarSaldo(JButton jb);
    
    public abstract JButton getJbComidaDelDia();
    public abstract void setJbComidaDelDia(JButton jb);
    
    public abstract JButton getJbFinanzas();
    public abstract void setJbFinanzas(JButton jb);
    
    public abstract JButton getJbClientes();
    public abstract void setJbClientes(JButton jb);
    
    public abstract JButton getJbGeneradorDeCredenciales();
    public abstract void setJbGeneradorDeCredenciales(JButton jb);
    
    public abstract JButton getJbPuntoDeVentas();
    public abstract void setJbPuntoDeVentas(JButton jb);    

    public abstract JButton getJbMenuProductos();
    public abstract void setJbMenuProductos(JButton jb);    
    
    public abstract JButton getJbSalir();
    public abstract void setJbSalir(JButton jb);    

}
