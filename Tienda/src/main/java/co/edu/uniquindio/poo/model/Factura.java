package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.ArrayList;

public record Factura(String codigo, LocalDate fecha, double total,
                      EstadoFactura estadoFactura, MetodoPago metodoPago, Cliente cliente,
                      ArrayList<DetalleFactura> listaDetallesFactura, Tienda ownedByTienda) {

    public boolean contieneProducto(String nombreProductoBuscado) {
        for (DetalleFactura detalleAux : listaDetallesFactura) {
            if (detalleAux.buscarProductoPorNombre(nombreProductoBuscado)) {
                return true;
            }
        }
        return false;
    }
}
