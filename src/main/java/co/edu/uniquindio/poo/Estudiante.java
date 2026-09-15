package co.edu.uniquindio.poo;

public class Estudiante {
    String nombre;
    String apellidos;
    String numeroId;
    String correo;
    String telefono;
    byte edad;

    public Estudiante(String nombre, String apellidos, String numeroId, String correo, String telefono, byte edad){
        this.nombre= nombre;
        this.apellidos= apellidos;
        this.numeroId= numeroId;
        this.correo= correo;
        this.telefono= telefono;
        this.edad = edad;
    }

    public static void nuevoEstudiante(){
        System.out.println("Ingrese datos del estudiante \n");
        String nombre = Repositorio.ingresarTexto("Nombre: ");
        String apellidos = Repositorio.ingresarTexto("Apellidos: ");
        String numeroId = Repositorio.ingresarTexto("Número de identificación: ");
        String correo = Repositorio.ingresarTexto("Correo electrónico: ");
        String telefono = Repositorio.ingresarTexto("Teléfono: ");
        byte edad = Repositorio.ingresarByte("Edad: ");

        Estudiante estudiante= new Estudiante(nombre, apellidos, numeroId, correo, telefono, edad);
    }

}
