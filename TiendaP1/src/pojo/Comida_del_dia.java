/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.sql.Date;

/**
 *
 * @author Fernando
 */
public class Comida_del_dia {
    private int idComida_del_dia;
    private String nombre;
    private Date fecha;
    private String descripción;
    private double precio;

    public int getIdComida_del_dia() {
        return idComida_del_dia;
    }

    public void setIdComida_del_dia(int idComida_del_dia) {
        this.idComida_del_dia = idComida_del_dia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    @Override
    public String toString() {
        return getNombre();
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
