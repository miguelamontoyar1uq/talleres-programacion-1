package co.edu.uniquindio.poo.empresajfx.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Empresa {
     private final  String nombre;
     private List<Cliente> listaClientes;
     private List<Producto> listaProductos;

    public Empresa(String nombre) {
        this.nombre = nombre;
        listaClientes=new ArrayList<>();
        listaProductos=new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Cliente> getListaClientes() {
        return Collections.unmodifiableList(listaClientes);
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Producto> getListaProductos() {
        return Collections.unmodifiableList(listaProductos);
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    //CRUD Cliente
    public boolean crearCliente(Cliente cliente){
        Optional<Cliente> buscado = buscarCliente(cliente.getCedula());
        if(buscado.isPresent()){
            return false;
        }
        listaClientes.add(cliente);
        return true;
    }

    //Buscar
    public Optional<Cliente> buscarCliente(String cedula) {
        return listaClientes.stream().filter(cliente -> cliente.getCedula().equals(cedula)).findFirst();
    }

    // Actualizar Cliente
    public boolean actualizarCliente(String cedula, String nuevoNombre,
                                     String nuevoApellido) {
        Optional<Cliente> buscado = buscarCliente(cedula);
        if(buscado.isPresent()){
            Cliente cliente = buscado.get();
            cliente.setNombre(nuevoNombre);
            cliente.setApellido(nuevoApellido);
            return true;
        }
        return false;
    }

    // Eliminar Cliente
    public boolean eliminarCliente(String cedula){
        Optional<Cliente> buscado = buscarCliente(cedula);
        if(buscado.isPresent()){
            listaClientes.remove(buscado.get());
            return true;
        }
        return false;
    }

    // CRUD Producto
    // Crear Producto
    public boolean crearProducto(Producto producto) {
        Optional<Producto> buscado = buscarProducto(producto.getCodigo());
        if(buscado.isPresent()){
            return false;
        }
        listaProductos.add(producto);
        return true;
    }

    // Buscar producto
    private Optional<Producto> buscarProducto(String codigo) {
        return listaProductos.stream().filter( producto -> producto.getCodigo().equals(codigo)).findFirst();
    }

    // Actualizar Producto
    public boolean actualizarProducto(String codigo, String nuevoNombreProducto,
                                     String nuevaCantidad, String nuevoProveedor) {
        Optional<Producto> buscado = buscarProducto(codigo);
        if(buscado.isPresent()){
            Producto producto = buscado.get();
            producto.setNombreProducto(nuevoNombreProducto);
            producto.setCantidad(nuevaCantidad);
            producto.setProveedor(nuevoProveedor);
            return true;
        }
        return false;
    }

    // Eliminar Producto
    public boolean eliminarProducto(String codigo) {
        Optional<Producto> buscado = buscarProducto(codigo);
        if(buscado.isPresent()){
            listaProductos.remove(buscado.get());
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nombre='" + nombre + '\'' +
                ", listaClientes=" + listaClientes +
                ", listaProductos=" + listaProductos +
                '}';
    }

}

