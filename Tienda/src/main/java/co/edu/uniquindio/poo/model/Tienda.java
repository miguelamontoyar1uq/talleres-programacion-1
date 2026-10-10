package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.*;

public class Tienda {

    private final String nombre;
    private final String nit;
    private String telefono;

    private final ArrayList<Cliente> listaClientes = new ArrayList<>();
    private final List<Factura> listaFacturas = new LinkedList<>();
    private Map<String, Producto> listaProductos = new HashMap<>();

    public Tienda(String nombre, String nit, String telefono){
        this.nombre = nombre;
        this.nit = nit;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNit() {
        return nit;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String registrarCliente(Cliente cliente){
        return buscarCliente(cliente.getDocumentoIdentidad())
                .map(c -> "No se puede registrar, ya existe un cliente con esa informacion registrado anteriormente.")
                .orElseGet(() -> {
                    listaClientes.add(cliente);
                    return "El cliente fue registrado exitosamente";
                });
    }

    public Optional<Cliente> buscarCliente(String documentoIdentidad) {
        return listaClientes.stream()
                .filter(cliente -> cliente.getDocumentoIdentidad().equals(documentoIdentidad))
                .findFirst();
    }

    public String actualizarCliente(String documentoIdentidad, String nuevoTelefono, String nuevoCorreo, String nuevaCiudadResidencia) {
        return buscarCliente(documentoIdentidad)
                .map(cliente -> {
                    listaClientes.remove(cliente);
                    Cliente clienteActualizado = new Cliente(
                            cliente.getDocumentoIdentidad(),
                            cliente.getNombreCompleto(),
                            cliente.getOwnedByTienda(),
                            nuevoTelefono,
                            nuevoCorreo,
                            nuevaCiudadResidencia
                    );
                    listaClientes.add(clienteActualizado);
                    return "El cliente fue actualizado exitosamente";
                })
                .orElse("No se puede actualizar, el cliente no existe.");
    }

    public String eliminarCliente(String documentoIdentidad) {
        return buscarCliente(documentoIdentidad)
                .map(cliente -> {
                    listaClientes.remove(cliente);
                    return "El cliente fue eliminado exitosamente";
                })
                .orElse("No se puede eliminar, el cliente no existe.");
    }

    public String registrarProducto(Producto producto) {
        return buscarProducto(producto.getCodigo())
                .map(p -> "No se puede registrar, ya existe un producto con ese codigo.")
                .orElseGet(() -> {
                    listaProductos.put(producto.getCodigo(), producto);
                    return "El producto fue registrado exitosamente";
                });
    }

    public Optional<Producto> buscarProducto(String codigo) {
        return Optional.ofNullable(listaProductos.get(codigo));
    }

    public String actualizarProducto(String codigo, String nuevoNombre, String nuevaDescripcion, int nuevaCantidad, double nuevoValor, Categoria nuevaCategoria) {
        return buscarProducto(codigo)
                .map(productoExistente -> {
                    Producto productoActualizado = new Producto(
                            nuevoNombre,
                            codigo,
                            nuevaDescripcion,
                            nuevaCantidad,
                            nuevoValor,
                            nuevaCategoria,
                            productoExistente.getOwnedByTienda()
                    );
                    listaProductos.put(codigo, productoActualizado);
                    return "El producto fue actualizado exitosamente";
                })
                .orElse("No se puede actualizar, el producto no existe.");
    }

    public String eliminarProducto(String codigo) {
        if (listaProductos.containsKey(codigo)) {
            listaProductos.remove(codigo);
            return "El producto fue eliminado exitosamente";
        }
        return "No se puede eliminar, el producto no existe.";
    }

    public String registrarFactura(Factura factura) {
        return obtenerFactura(factura.codigo())
                .map(f -> "No se puede registrar, ya existe una factura con ese codigo.")
                .orElseGet(() -> {
                    listaFacturas.add(factura);
                    return "La factura fue registrada exitosamente";
                });
    }

    public Optional<Factura> obtenerFactura(String codigo) {
        return listaFacturas.stream()
                .filter(factura -> factura.codigo().equals(codigo))
                .findFirst();
    }

    public double calcularValorFactura(String codigo) {
        return obtenerFactura(codigo)
                .map(factura -> factura.listaDetallesFactura().stream()
                        .mapToDouble(detalle -> detalle.calcularSubtotal()) // Reemplaza "calcularSubtotal()" por el método real de tu clase DetalleFactura (ej: getSubtotal() o getCantidad() * getPrecio())
                        .mapToDouble(detalle -> detalle.calcularSubTotal())
                        .sum())
                .orElse(0.0);
    }

    //TALLER


    // 1. Obtener los productos con una cantidad disponible mayor o igual a 10
    public List<Producto> obtenerProductosDisponibles() {
        return listaProductos.values().stream()
                .filter(producto -> producto.getCantidadDisponible() >= 10)
                .toList();
    }

    // 2. Obtener los códigos de los productos con una cantidad disponible mayor o igual a 10 y menor que 50
    public List<String> obtenerCodigosProductos10a50() {
        return listaProductos.values().stream()
                .filter(producto -> producto.getCantidadDisponible() >= 10 && producto.getCantidadDisponible() < 50)
                .map(producto -> producto.getCodigo())
                .toList();
    }

    // 3. Obtener la lista de clientes que hayan comprado el 07 de octubre de 2026 (Estaba intentando practicar programación declarativa, pero este sí me quedó grande profe, y si hay problema en que los otros estén así, me avisa y los cambio.)
    public List<Cliente> obtenerClientesPorFecha(){
        LocalDate fechaBuscada = LocalDate.of(2026, 10, 7);
        List<Cliente> listaClientesResultado = new ArrayList<>();
        for(Factura factura: listaFacturas){
            if(factura.fecha().equals(fechaBuscada)){
                Cliente cliente = factura.cliente();
                if(!listaClientesResultado.contains(cliente)){
                    listaClientesResultado.add(cliente);
                }
            }
        }
        return listaClientesResultado;
    }

    // 4. Obtener las facturas que tengan un cliente donde su nombre empiece por R
    public List<Factura> obtenerFacturasClientesR(){
        char letraInicial = 'r';
        List<Factura> listaFacturasResultado = new ArrayList<>();
        for(Factura facturaAux: listaFacturas){
            String cliente = String.valueOf((facturaAux.cliente()));
            if(cliente.charAt(0)==(letraInicial)){
                listaFacturasResultado.add(facturaAux);
            }
        }
        return listaFacturasResultado;
    }

    // 5. Obtener las facturas donde se haya comprado un celular de marca Iphone 16 pro max
    public List<Factura> obtenerFacturasPorNombreProducto(String nombreProductoBuscado){
        List<Factura> listaFacturasResultado = new ArrayList<>();
        for(Factura facturaAux: listaFacturas){
            if(facturaAux.contieneProducto(nombreProductoBuscado)){
                listaFacturasResultado.add(facturaAux);
            }
        }
        return listaFacturasResultado;
    }

    // 6. Obtener las facturas que tengan un cliente donde su nombre sea Juan y haya comprado un celular de marca Iphone 16 pro max


    // 7. Implementar un metodo que reciba una categoría y retorne todos los productos registrados que pertenezcan a ella.

    // 8. Implementar un metodo que reciba un precio mínimo y un precio máximo, y retorne los productos cuyo precio se encuentre dentro de ese rango, incluyendo ambos límites.

    // 9. Implementar un metodo que retorne todos los productos registrados en la tienda, ordenados de menor a mayor según su precio.

    // 10. Implementar un metodo que identifique el producto con el precio más alto de la tienda. Si no existen productos registrados, el metodo debe retornar un Optional vacío.
}