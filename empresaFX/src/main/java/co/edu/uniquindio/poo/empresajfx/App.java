package co.edu.uniquindio.poo.empresajfx;

import co.edu.uniquindio.poo.empresajfx.model.Producto;
import co.edu.uniquindio.poo.empresajfx.viewController.ProductoViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

import co.edu.uniquindio.poo.empresajfx.model.Cliente;
import co.edu.uniquindio.poo.empresajfx.model.Empresa;
import co.edu.uniquindio.poo.empresajfx.viewController.ClienteViewController;
import co.edu.uniquindio.poo.empresajfx.viewController.PrimaryController;

/**
 * Clase principal de JavaFX
 */
public class App extends Application {

    private Stage primaryStage;

    public static Empresa empresa = new Empresa("UQ");

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Gestión de Clientes");

        // 1. Cargar datos de prueba
        inicializarData();

        // 2. Pantalla de bienvenida
        openViewPrincipal();
    }

    // Cargar la pantalla principal
    private void openViewPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("primary.fxml"));
            VBox rootLayout = (VBox) loader.load();

            // Conectamos el controlador con App
            PrimaryController primaryController = loader.getController();
            primaryController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Carga la pantalla del CRUD
    public void openCrudCliente() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudCliente.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();

            // Conectamos el ClienteController con App
            ClienteViewController clienteViewController = loader.getController();
            clienteViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Carga la pantalla de CRUD Producto
    public void openCrudProducto() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudProducto.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();

            // Conexión del ProductoController con App
            ProductoViewController productoViewController = loader.getController();
            productoViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Datos por defecto para que las listas no empiecen vacías
    public void inicializarData() {
        Cliente cliente = new Cliente("12233", "Juan", "Gómez");
        empresa.crearCliente(cliente);
        Producto producto = new Producto("10", "NVIDIA GeForce RTX 0560", "3", "NVIDIA");
        empresa.crearProducto(producto);
    }

    public static void main(String[] args) {
        launch();
    }
}