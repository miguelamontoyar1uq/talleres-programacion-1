package co.edu.uniquindio.poo.model;

public class Perro extends Animal{

    private String raza;

    public Perro(String codigo, byte edad, String color, String nombre, String raza) {
        super(codigo, edad, color, nombre);
        this.raza = raza;
    }

    @Override
    public void comer() {
        System.out.println("El perro está comiendo...");
    }

    @Override
    public void dormir() {
        System.out.println("ZZZ...");
    }

    @Override
    public void hacerSonido(){
        System.out.println("Guau Guau");
    }
}
