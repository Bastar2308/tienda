/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pojo;


public class Detalle_Venta {
    private int venta_idVenta;
    private int producto_idProducto;
    private double cantidad;
    private double subtotal;

    public int getVenta_idVenta() {
        return venta_idVenta;
    }

    public void setVenta_idVenta(int venta_idVenta) {
        this.venta_idVenta=venta_idVenta;
    }

    public int getProducto_idProducto() {
        return producto_idProducto;
    }

    public void setProducto_idProducto(int producto_idProducto) {
        this.producto_idProducto=producto_idProducto;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad=cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal=subtotal;
    }
}
