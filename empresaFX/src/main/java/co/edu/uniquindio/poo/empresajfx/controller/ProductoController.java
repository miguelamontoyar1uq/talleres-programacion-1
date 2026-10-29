package co.edu.uniquindio.poo.empresajfx.controller;

import co.edu.uniquindio.poo.empresajfx.model.Empresa;
import co.edu.uniquindio.poo.empresajfx.model.Producto;

import java.util.List;

public class ProductoController {
    private Empresa empresa;

    public ProductoController(Empresa empresa) {
        this.empresa = empresa;
    }
    public boolean crearProducto (Producto producto) {
        return empresa.crearProducto(producto);
    }
    public boolean actualizarProducto (String codigo, String nuevoNombreProducto, String nuevaCantidad,
                                      String nuevoProveedor) {
        return empresa.actualizarProducto(codigo, nuevoNombreProducto, nuevaCantidad, nuevoProveedor);
    }

    public boolean eliminarProducto(String codigo) {
        return empresa.eliminarProducto(codigo);
    }
    public List<Producto> obtenerListaProductos() {
        return empresa.getListaProductos();
    }
}
