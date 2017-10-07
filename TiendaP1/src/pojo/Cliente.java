/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pojo;

import java.awt.Image;


public class Cliente {
    private int idCliente;
    private int grupo_idGrupo;
    private String nombre;
    private double saldo;
    private String qr;
    private Image foto;
    private String tutor;
    private String telefono;
    private String correo;
    private int compras_sin_credencial;
    private double limite_deuda;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getGrupo_idGrupo() {
        return grupo_idGrupo;
    }

    public void setGrupo_idGrupo(int grupo_idGrupo) {
        this.grupo_idGrupo = grupo_idGrupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getQr() {
        return qr;
    }

    public void setQr(String qr) {
        this.qr = qr;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getCompras_sin_credencial() {
        return compras_sin_credencial;
    }

    public void setCompras_sin_credencial(int compras_sin_credencial) {
        this.compras_sin_credencial = compras_sin_credencial;
    }

    public double getLimite_deuda() {
        return limite_deuda;
    }

    public void setLimite_deuda(double limite_deuda) {
        this.limite_deuda = limite_deuda;
    }
}
