package co.edu.uniquindio.poo.model;

import javax.swing.*;
import java.util.Arrays;

/**
 * Esta clase representa un curso de una universidad
 * @version 1.0
 * @author Miguel Angel Montoya
 * @fecha : 22/09/2026
 */
public class Estudiante {
    private String nombre;
    private String apellidos;
    private String numeroId;
    private String correo;
    private String telefono;
    private byte edad;

    private Curso ownedByCurso;
    private Nota[] listaNotas;

    public Estudiante(String nombre, String apellidos, String numeroId, String correo, String telefono, byte edad, Curso ownedByCurso){
        this.nombre= nombre;
        this.apellidos= apellidos;
        this.numeroId= numeroId;
        this.correo= correo;
        this.telefono= telefono;
        this.edad = edad;
        this.ownedByCurso= ownedByCurso;
    }

    public void setNumeroId(String numeroId) {
        this.numeroId = numeroId;
    }
    public String getNumeroId() {
        return numeroId;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getApellidos() {
        return apellidos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getCorreo() {
        return correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getTelefono() {
        return telefono;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }
    public byte getEdad() {
        return edad;
    }

    public void setOwnedByCurso(Curso ownedByCurso) {
        this.ownedByCurso = ownedByCurso;
    }
    public Curso getOwnedByCurso() {
        return ownedByCurso;
    }

    public void setNotas(Nota[] listaNotas) {
        this.listaNotas = listaNotas;
    }
    public Nota[] getNotas() {
        return listaNotas;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", numeroId='" + numeroId + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", edad=" + edad +
                ", ownedByCurso=" + ownedByCurso +
                ", listaNotas=" + Arrays.toString(listaNotas) +
                '}';
    }

    public String registrarNota(String nombreNota, Float valorNota){
        Nota notaEncontrada = buscarNota(nombreNota);
        if(notaEncontrada!=null){
            return "No se puede registrar, la nota ya existe.";
        }else{
            int posicionDisponible= buscarPosicionDisponible();
            if(posicionDisponible==-1){
                return "No se pueden añadir notas, el estudiante ya tiene 5 notas.";
            }else{
                Nota nuevaNota = new Nota(nombreNota, valorNota);
                listaNotas[posicionDisponible]=nuevaNota;
            }
        }return "La nota "+nombreNota+" con valor "+valorNota+" ha sido agregada con éxito.";
    }

    public Nota buscarNota(String nombreNota){
        Nota notaEncontrada= null;
        for(Nota aux: listaNotas){
            if(aux!=null && aux.getNombre().equals(nombreNota)){
                return aux;
            }
        }
        return notaEncontrada;
    }

    public int buscarPosicionDisponible(){
        for(int i=0; i< listaNotas.length; i++){
            if(listaNotas[i]==null){
                return i;
            }
        }
        return -1;
    }
}
