/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.venta;

import dao.Detalle_VentaDAO;
import dao.ProductoDAO;
import dao.VentaDAO;
import pojo.Detalle_Venta;
import pojo.Producto;
import pojo.Venta;

/**
 *
 * @author Fernando
 */
public class VentaModificar {
    public static void main(String[] args) {
        Venta venta = new Venta();
        venta.setCliente_idCliente(2);
        venta.setFechahora(null);
        venta.setIdVenta(10);
        venta.setNota("Primera modificación con éxito");
        Detalle_Venta detalle_venta = new Detalle_Venta();
        detalle_venta.setCantidad(3);
        detalle_venta.setProducto_idProducto(3);
        Producto producto = ProductoDAO.getInstance().buscaCategoria(3);
        detalle_venta.setSubtotal(3*producto.getPrecio());
        detalle_venta.setVenta_idVenta(venta.getIdVenta());
        if (Detalle_VentaDAO.getInstance().eliminaDetalle_Venta(venta.getIdVenta())) {
            System.out.println("Detalle eliminado correctamente");
            if (Detalle_VentaDAO.getInstance().insertaDetalle_Venta(detalle_venta) != 0) {
                venta.setTotal(detalle_venta.getSubtotal());
                System.out.println("Detalle actualizado correctamente");
                if (VentaDAO.getInstance().modificaVenta(venta, venta.getIdVenta())) {
                    System.out.println("Exito al modificar venta");
                } else {
                    System.out.println("Error al modificar venta");
                }
            } else {
                System.out.println("Error en la actualización del detalle");
            }
        } else {
            System.out.println("Error al eliminar detalle");
        }
    }
}
