package co.edu.uniquindio.poo.model;

public class Gato extends Animal{

    private boolean vacunado;

    public Gato(String codigo, byte edad, String color, String nombre, boolean vacunado) {
        super(codigo, edad, color, nombre);
        this.vacunado = vacunado;
    }

    @Override
    public void comer() {
        System.out.println("El gato toma leche...");
    }

    @Override
    public void dormir() {
        System.out.println("ZZZ...");
    }

    @Override
    public void hacerSonido(){
        System.out.println("Meow");
    }
}
