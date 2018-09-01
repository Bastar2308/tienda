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
public class Abono {
    private int id;
    private int cliente_idCliente;
    private double monto;
    private double saldo_anterior;
    private double saldo_nuevo;
    private Date fecha_hora;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCliente_idCliente() {
        return cliente_idCliente;
    }

    public void setCliente_idCliente(int cliente_idCliente) {
        this.cliente_idCliente = cliente_idCliente;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getSaldo_anterior() {
        return saldo_anterior;
    }

    public void setSaldo_anterior(double saldo_anterior) {
        this.saldo_anterior = saldo_anterior;
    }

    public double getSaldo_nuevo() {
        return saldo_nuevo;
    }

    public void setSaldo_nuevo(double saldo_nuevo) {
        this.saldo_nuevo = saldo_nuevo;
    }

    public Date getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Date fecha_hora) {
        this.fecha_hora = fecha_hora;
    }
}
