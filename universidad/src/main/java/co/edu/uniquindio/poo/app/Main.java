package co.edu.uniquindio.poo.app;
import co.edu.uniquindio.poo.model.Curso;
import co.edu.uniquindio.poo.model.Estudiante;
import co.edu.uniquindio.poo.model.Nota;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null,"Bienvenido al sistema de gestión academica");
        String nombreCurso = JOptionPane.showInputDialog(null, "Ingresar el nombre del curso: ");
        String codigoCurso = JOptionPane.showInputDialog(null, "Ingresar el código del curso: ");

        Curso curso= new Curso(nombreCurso, codigoCurso);

        int opcion;

        do{
            opcion= Integer.valueOf(JOptionPane.showInputDialog(null, "Por favor, seleccione una opción: ---Menu--- \n"+
                    "1. Agregar un estudiante.\n"+"2. Buscar estudiante.\n"+"3. Actualizar estudiante. \n"));
            switch(opcion) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Gracias por usar nuestro sistema.");
                    break;
                case 1:
                    crearEstudiante(curso);
                    break;
                case 2:
                    buscarEstudiante(curso);
                    break;
                case 3:
                    eliminarEstudiante(curso);
                    break;
                case 4:
                    actualizarEstudiante(curso);
                    break;
                case 5:
                    registrarNotaEstudiante(curso);
                    break;
                default: JOptionPane.showMessageDialog(null, "Opción inválida.");
                    break;
            }
        }while(opcion!=0);

    }

    public static void crearEstudiante(Curso curso){
        String nombre = JOptionPane.showInputDialog("Por favor ingrese los nombres del estudiante: ");
        String apellidos = JOptionPane.showInputDialog("Por favor ingrese los apellidos: ");
        String numeroId = JOptionPane.showInputDialog("Por favor ingrese el número de identificación: ");
        String correo = JOptionPane.showInputDialog("Por favor ingrese el correo electrónico: ");
        String telefono = JOptionPane.showInputDialog("Por favor ingrese el teléfono: ");
        byte edad = Byte.parseByte(JOptionPane.showInputDialog("Por favor ingrese la edad: "));

        String resultado= curso.registrarEstudiante(nombre, apellidos, numeroId, correo, telefono, edad);

        JOptionPane.showMessageDialog(null, resultado);
    }

    public static void buscarEstudiante(Curso curso){
        String numeroId = JOptionPane.showInputDialog(null, "Ingrese el numero de identificación del estudiante: ");

        Estudiante estudianteEncontrado= curso.buscarEstudiante(numeroId);
        if(estudianteEncontrado==null){
            JOptionPane.showMessageDialog(null, estudianteEncontrado.toString());
        }else{
            JOptionPane.showMessageDialog(null, "El estudiante con la identificación "+numeroId+" no existe.");
        }
    }

    public static void eliminarEstudiante(Curso curso){
        String numeroId = JOptionPane.showInputDialog(null, "Ingrese el numero de identificación del estudiante: ");

        boolean eliminado= curso.eliminarEstudiante(numeroId);

        if(eliminado){
            JOptionPane.showMessageDialog(null, "El estudiante con la identificación "+numeroId+" ha sido eliminado.");
        }else{
            JOptionPane.showMessageDialog(null, "Eliminación fallida.");
        }
    }

    public static void actualizarEstudiante(Curso curso){
        String identificacion = JOptionPane.showInputDialog(null, "Ingrese el numero de identificación del estudiante: ");

        String nombreNuevo = JOptionPane.showInputDialog("Por favor ingrese los nombres del estudiante: ");
        String apellidosNuevos = JOptionPane.showInputDialog("Por favor ingrese los apellidos: ");
        String numeroIdNuevo = JOptionPane.showInputDialog("Por favor ingrese el número de identificación: ");
        String correoNuevo = JOptionPane.showInputDialog("Por favor ingrese el correo electrónico: ");
        String telefonoNuevo = JOptionPane.showInputDialog("Por favor ingrese el teléfono: ");
        byte edadNueva = Byte.parseByte(JOptionPane.showInputDialog("Por favor ingrese la edad: "));

        boolean actualizado= curso.actualizarEstudiante(identificacion, nombreNuevo, apellidosNuevos, numeroIdNuevo, correoNuevo, telefonoNuevo, edadNueva);

        if(actualizado){
            JOptionPane.showMessageDialog(null, "El estudiante con la identificación "+identificacion+" ha sido actualizado.");
        }else{
            JOptionPane.showMessageDialog(null, "No ha sido posible actualizar los datos.");
        }
    }

    public static void registrarNotaEstudiante(Curso curso){
        String identificacion = JOptionPane.showInputDialog(null, "Ingrese el numero de identificación del estudiante al que desea registrar la nota: ");
        String nombreNota = JOptionPane.showInputDialog(null, "Ingrese el nombre de la nota: ");
        float  valorNota = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese el valor de la nota: "));
        String resultado = curso.registrarNotaEstudiante(identificacion, nombreNota, valorNota);
        JOptionPane.showMessageDialog(null, resultado);
    }

}