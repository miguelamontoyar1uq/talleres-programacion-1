package co.edu.uniquindio.poo;

public class Curso {
    String nombre= "Programación";
    String codigo= "1001";

    public static void main(String[] args){
        String ingresarEstudiante= Repositorio.ingresarTexto("Desea ingresar un nuevo estudiante?: ");

        while(ingresarEstudiante.equalsIgnoreCase("si")){
            Estudiante.nuevoEstudiante();

            String ingresarNotas= Repositorio.ingresarTexto("Desea ingresar notas?: ");
            while(ingresarNotas.equalsIgnoreCase("si")){
                Nota.nuevaNota();
                ingresarNotas= Repositorio.ingresarTexto("Desea ingresar otra nota?: ");
            }

            ingresarEstudiante= Repositorio.ingresarTexto("Desea ingresar otro estudiante?: ");
        }

    }

}
