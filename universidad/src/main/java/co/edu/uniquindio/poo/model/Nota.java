package co.edu.uniquindio.poo.model;

/**
 * Esta clase representa un curso de una universidad
 * @version 1.0
 * @author Miguel Angel Montoya
 * @fecha : 22/09/2026
 */
public class Nota {
    private String nombre;
    private double valor;

    public Nota(String nombre, double valor){
        this.nombre=nombre;
        this.valor=valor;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    public String toString() {
        return nombre + ": " + valor;
    }

}
