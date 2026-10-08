package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase representa un curso de una universidad
 * @version 1.0
 * @author Miguel Angel Montoya
 * @fecha : 17/09/2026
 */
public class Curso {
    private String nombre;
    private String codigo;
    private ArrayList<Estudiante> listaEstudiantes;

    public Curso(String nombre, String codigo){
        this.nombre= nombre;
        this.codigo= codigo;
        this.listaEstudiantes= new ArrayList<>();
    }

    public void setNombre(String nombre){
        this.nombre= nombre;
    }
    public String getNombre(){
        return nombre;
    }

    public void setCodigo(String codigo){
        this.codigo= codigo;
    }
    public String getCodigo(){
        return codigo;
    }

    public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes){
        this.listaEstudiantes= listaEstudiantes;
    }
    public ArrayList<Estudiante> getListaEstudiantes(){
        return listaEstudiantes;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", listaEstudiantes=" + listaEstudiantes +
                '}';
    }

    public String registrarEstudiante(String nombre, String apellidos, String numeroId, String correo, String telefono, byte edad){
        String mensaje="";
        Estudiante buscado = buscarEstudiante(numeroId);
        if(buscado!=null){
            mensaje="El estudiante que desea registrar ya se encuentra registrado.";
        }else {
            Estudiante estudianteNuevo = new Estudiante(nombre, apellidos, numeroId, correo, telefono, edad, this);
            listaEstudiantes.add(estudianteNuevo);
            mensaje="Estudiante registrado con éxito.";
        }
        return mensaje;
    }

    public Estudiante buscarEstudiante(String numeroId){
        Estudiante estudianteEncontrado= null;
        for(Estudiante aux: listaEstudiantes){
            if(aux.getNumeroId().equals(numeroId)){
                return aux;
            }
        }
        return estudianteEncontrado;
    }

    public boolean eliminarEstudiante(String numeroId){
        Estudiante estudianteEncontrado= buscarEstudiante(numeroId);
        if(estudianteEncontrado!=null){
            listaEstudiantes.remove(estudianteEncontrado);
            return true;
        }else return false;
    }

    public boolean actualizarEstudiante(String identificacion, String nombreNuevo, String apellidosNuevos, String numeroIdNuevo, String correoNuevo, String telefonoNuevo, byte edadNueva){
        Estudiante estudianteEncontrado= buscarEstudiante(identificacion);
        if(estudianteEncontrado!=null){
            estudianteEncontrado.setNombre(nombreNuevo);
            estudianteEncontrado.setApellidos(apellidosNuevos);
            estudianteEncontrado.setNumeroId(numeroIdNuevo);
            estudianteEncontrado.setCorreo(correoNuevo);
            estudianteEncontrado.setTelefono(telefonoNuevo);
            estudianteEncontrado.setEdad(edadNueva);
            return true;
        }else return false;
    }

    public boolean registrarNotaEstudiante(String identificacion, String nombreNota, Float valorNota){
        Estudiante estudianteEncontrado= buscarEstudiante(identificacion);
        if(estudianteEncontrado!=null){
            estudianteEncontrado.registrarNota(nombreNota, valorNota);
            return true;
        }else return false;
    }

}
