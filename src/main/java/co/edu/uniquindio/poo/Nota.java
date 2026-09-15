package co.edu.uniquindio.poo;

public class Nota {
    String nombre;
    float valor;

    public Nota(String nombre, float valor){
        this.nombre=nombre;
        this.valor=valor;
    }

    public static void nuevaNota(){
        String nombre= Repositorio.ingresarTexto("Nombre de la nota: ");
        float valor= Repositorio.ingresarFloat("Valor de la nota: ");
        Nota nota= new Nota(nombre, valor);
    }
}
