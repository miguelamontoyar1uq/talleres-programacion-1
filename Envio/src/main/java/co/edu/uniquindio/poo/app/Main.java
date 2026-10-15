package co.edu.uniquindio.poo.app;

import co.edu.uniquindio.poo.model.*;

public class Main {

    public static void main(String[] args) {
        Mensajeria mensajeria = new Mensajeria("chamoExpress", "321910", "323", "carrera 27 calle 19");
        int opcion;

        do {
            opcion = Repositorio.ingresarEntero(
                    "BIENVENIDO al sistema de gestión de " + mensajeria.getNombre() +
                            "\nPor favor seleccione la opción deseada:" +
                            "\n1. Registrar/Crear envío" +
                            "\n2. Consultar/Buscar envío" +
                            "\n3. Salir");

            switch (opcion) {
                case 1:
                    crearEnvio(mensajeria);
                    break;
                case 2:
                    consultarEnvio(mensajeria);
                    break;
                case 3:
                    Repositorio.mostrarMensaje("¡Hasta luego!");
                    break;
                default:
                    Repositorio.mostrarMensaje("Opción no válida.");
                    break;
            }
        } while (opcion != 3);
    }

    private static void crearEnvio(Mensajeria mensajeria) {
        int tipoEnvio = Repositorio.ingresarEntero("Seleccione el tipo de envío:\n1. Nacional\n2. Internacional\n3. Exprés");

        String codigo = Repositorio.ingresarTexto("Ingrese el código del envío:");
        String destinatario = Repositorio.ingresarTexto("Ingrese el destinatario:");
        double peso = Repositorio.ingresarNumeroDecimal("Ingrese el peso en kg:");

        Envio nuevoEnvio = null;

        if (tipoEnvio == 1) {
            String ciudad = Repositorio.ingresarTexto("Ingrese la ciudad de destino:");
            boolean necesitaDomicilio = Repositorio.ingresarValorBooleano("¿Requiere entrega a domicilio?", "Atención");
            nuevoEnvio = new EnvioNacional(codigo, destinatario, peso, ciudad, necesitaDomicilio);
        } else if (tipoEnvio == 2) {
            String pais = Repositorio.ingresarTexto("Ingrese el país de destino:");
            boolean necesitaSeguro = Repositorio.ingresarValorBooleano("¿Requiere seguro?", "Atención");
            nuevoEnvio = new EnvioInternacional(codigo, destinatario, peso, pais, necesitaSeguro);
        } else if (tipoEnvio == 3) {
            String ciudad = Repositorio.ingresarTexto("Ingrese la ciudad de destino:");
            boolean necesitaDomicilio = Repositorio.ingresarValorBooleano("¿Requiere entrega a domicilio?", "Atención");
            boolean esUrgente = Repositorio.ingresarValorBooleano("¿Es urgente?", "Atención");
            nuevoEnvio = new EnvioExpress(codigo, destinatario, peso, ciudad, necesitaDomicilio, esUrgente);
        }

        if (nuevoEnvio != null) {
            boolean creado = mensajeria.crearEnvio(nuevoEnvio);
            if (creado) {
                Repositorio.mostrarMensaje("Envío registrado exitosamente.\nCosto Total: $" + nuevoEnvio.calcularCosto());
            } else {
                Repositorio.mostrarMensaje("Error: Ya existe un envío registrado con ese código.");
            }
        }
    }

    private static void consultarEnvio(Mensajeria mensajeria) {
        String codigo = Repositorio.ingresarTexto("Ingrese el código del envío a buscar:");
        Envio envio = mensajeria.consultarEnvio(codigo);

        if (envio != null) {
            Repositorio.mostrarMensaje("Envío encontrado:\n" + envio.toString() + "\nCosto calculado: $" + envio.calcularCosto());
        } else {
            Repositorio.mostrarMensaje("No se encontró ningún envío con el código " + codigo);
        }
    }
}