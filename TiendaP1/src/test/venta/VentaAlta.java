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
public class VentaAlta {
    public static void main(String[] args) {
        Venta venta = new Venta();
        venta.setCliente_idCliente(3);
        venta.setNota("Nota12");
        int idVenta = VentaDAO.getInstance().insertaVenta(venta);
        int object[] = {1,3};
        int total = 0;
        if (idVenta!=0) {
            System.out.println("Exito en la venta");
            for (int i = 0; i < object.length; i++) {
                Detalle_Venta detalle_Venta = new Detalle_Venta();
                detalle_Venta.setCantidad(2);
                detalle_Venta.setProducto_idProducto(object[i]);
                detalle_Venta.setVenta_idVenta(idVenta);
                Producto producto = ProductoDAO.getInstance().buscaCategoria(1);
                detalle_Venta.setSubtotal((producto.getPrecio()*2));
                if (Detalle_VentaDAO.getInstance().insertaDetalle_Venta(detalle_Venta) != 0) {
                    System.out.println("Exito en el detalle");
                } else {
                    System.out.println("Error en el detalle");
                }
                total += producto.getPrecio()*2;
            }
            venta.setTotal(total);
            if (VentaDAO.getInstance().modificaVenta(venta, idVenta) == true) {
                System.out.println("Exito al modificar venta");
            } else {
                System.out.println("Error al modificar venta");
            }
        } else {
            System.out.println("Error en la venta");
        }
    }
}
