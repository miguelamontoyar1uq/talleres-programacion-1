package co.edu.uniquindio.poo.model;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Zoologico {
    private final String nombre;
    private final String direccion;

    private List<Animal> listaAnimales;

    public Zoologico(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<Animal> getListaAnimales() {
        return Collections.unmodifiableList(listaAnimales);
    }

    public void setListaAnimales(List<Animal> listaAnimales) {
        this.listaAnimales = listaAnimales;
    }

    //CRUD
    public String registrarAnimal(Animal animal){
        Optional<Animal> animalOptional= buscarAnimal(animal.getCodigo());
        if(animalOptional.isPresent()){
            return "Lo siento, ese animal ya está presente.";
        }else{
            listaAnimales.add(animal);
            return "El animal ha sido registrado exitosamente.";
        }
    }

    public Optional buscarAnimal(String codigo){
        return listaAnimales
                .stream()
                .filter(animal -> animal.getCodigo().equals(codigo))
                .findFirst();
    }

}
