/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.sql.Date;

public class Alimento_Prohibido_Cliente {

    private int cliente_idCliente;
    private int producto_idProducto;
    private Date fecha_inicio;
    private Date fecha_fin;
    private String descripcion;

    public int getCliente_idCliente() {
        return cliente_idCliente;
    }

    public void setCliente_idCliente(int cliente_idCliente) {
        this.cliente_idCliente = cliente_idCliente;
    }

    public int getProducto_idProducto() {
        return producto_idProducto;
    }

    public void setProducto_idProducto(int producto_idProducto) {
        this.producto_idProducto = producto_idProducto;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
