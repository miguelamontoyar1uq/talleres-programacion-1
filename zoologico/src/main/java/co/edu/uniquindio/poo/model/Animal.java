package co.edu.uniquindio.poo.model;

import java.util.Objects;

public abstract class Animal {
    private String codigo;
    private byte edad;
    private String color;
    private String nombre;

    public Animal(String codigo, byte edad, String color, String nombre) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.color = color;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(color, animal.color);
    }

    //comer, dormir, hacer sonido
    public abstract void comer();

    public abstract void dormir();

    public abstract void hacerSonido();


}
