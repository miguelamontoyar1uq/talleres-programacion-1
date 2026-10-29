package co.edu.uniquindio.poo.empresajfx.viewController;

import co.edu.uniquindio.poo.empresajfx.App;
import co.edu.uniquindio.poo.empresajfx.controller.ProductoController;
import co.edu.uniquindio.poo.empresajfx.model.Producto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ProductoViewController {

    private App app;
    private ProductoController productoController;
    private ObservableList<Producto> listProductos = FXCollections.observableArrayList(); // Lista reactiva para la tabla
    private Producto selectedProducto;

    @FXML
    private ResourceBundle resources;
    @FXML private URL location;

    // Campos de texto
    @FXML private TextField txtCodigo;
    @FXML private TextField txtNombreProducto;
    @FXML private TextField txtCantidad;
    @FXML private TextField txtProveedor;

    // Tabla y columnas
    @FXML private TableView<Producto> tblListProductos;
    @FXML private TableColumn<Producto, String> tbcCodigo;
    @FXML private TableColumn<Producto, String> tbcNombreProducto;
    @FXML private TableColumn<Producto, String> tbcCantidad;
    @FXML private TableColumn<Producto, String> tbcProveedor;

    // Botnes
    @FXML private Button btbAgregarProducto;
    @FXML private Button btnActualizarProducto;
    @FXML private Button btnEliminar;
    @FXML private Button btnLimpiar;

    // --- MÉTODOS ASOCIADOS #OnAction ---

    @FXML
    void onAgregarProducto() {
        agregarProducto();
    }

    @FXML
    void onActualizarProducto() {
        actualizarProducto();
    }

    @FXML
    void onEliminar() {
        eliminarProducto();
    }

    @FXML
    void onLimpiar() {
        limpiarSeleccion();
    }

    @FXML
    void initialize() {
    }

    // RecibeApp e inicia la vista
    public void setApp(App app) {
        this.app = app;
        this.productoController = new ProductoController(app.empresa);
        initView();
    }

    private void initView() {
        initDataBinding();
        obtenerProductos();
        tblListProductos.getItems().clear();
        tblListProductos.setItems(listProductos);
        listenerSelection();
    }

    // Qué atributo del Producto muestra cada columna
    private void initDataBinding() {
        tbcCodigo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigo()));
        tbcNombreProducto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombreProducto()));
        tbcCantidad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCantidad()));
        tbcProveedor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProveedor()));
    }

    private void obtenerProductos() {
        listProductos.addAll(productoController.obtenerListaProductos());
    }

    // Detecta que el usuario selecciona una fila de la tabla
    private void listenerSelection() {
        tblListProductos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedProducto = newSelection;
            mostrarInformacionProducto(selectedProducto);
        });
    }

    // Pasa datos del producto seleccionado a las cajas de texto
    private void mostrarInformacionProducto(Producto producto) {
        if (producto != null) {
            txtCodigo.setText(producto.getCodigo());
            txtNombreProducto.setText(producto.getNombreProducto());
            txtCantidad.setText(producto.getCantidad());
            txtProveedor.setText(producto.getProveedor());
        }
    }

    // --- ACCIONES CRUD ---

    private void agregarProducto() {
        Producto producto = buildProducto();
        if (productoController.crearProducto(producto)) {
            listProductos.add(producto);
            limpiarCamposProducto();
        }
    }

    private void actualizarProducto() {
        if (selectedProducto != null &&
                productoController.actualizarProducto(selectedProducto.getCodigo(), txtNombreProducto.getText(), txtCantidad.getText(), txtProveedor.getText())) {

            selectedProducto.setNombreProducto(txtNombreProducto.getText());
            selectedProducto.setCantidad(txtCantidad.getText());
            selectedProducto.setProveedor(txtProveedor.getText());

            tblListProductos.refresh();
            limpiarSeleccion();
        }
    }

    private void eliminarProducto() {
        if (selectedProducto != null && productoController.eliminarProducto(selectedProducto.getCodigo())) {
            listProductos.remove(selectedProducto);
            limpiarSeleccion();
        }
    }

    private Producto buildProducto() {
        return new Producto(txtCodigo.getText(), txtNombreProducto.getText(), txtCantidad.getText(), txtProveedor.getText());
    }

    private void limpiarSeleccion() {
        tblListProductos.getSelectionModel().clearSelection();
        limpiarCamposProducto();
    }

    private void limpiarCamposProducto() {
        txtCodigo.clear();
        txtNombreProducto.clear();
        txtCantidad.clear();
        txtProveedor.clear();
    }
}
