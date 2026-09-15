package co.edu.uniquindio.poo;
import java.util.Scanner;

/*
Repositorio para la reutilización de funciones
*/

public class Repositorio {

    //Función para ingresar una cadena de texto
    public static String ingresarTexto(String mensaje) {
        Scanner sc= new Scanner(System.in);
        System.out.println(mensaje);
        String texto= sc.nextLine();
        return texto;
    }
    //Función para ingresar un numero entero
    public static int ingresarEntero(String mensaje) {
        Scanner sc= new Scanner(System.in);
        System.out.println(mensaje);
        int numero= sc.nextInt();
        return numero;
    }
    //Función para ingresar un número decimal
    public static double ingresarNumeroDecimal(String mensaje) {
        Scanner sc= new Scanner(System.in);
        System.out.println(mensaje);
        double numero= sc.nextDouble();
        return numero;
    }

    //Función para ingresar un valor booleano
    public static boolean ingresarValorBooleano(String mensaje) {
        Scanner sc= new Scanner(System.in);
        System.out.println(mensaje);
        boolean valor= sc.nextBoolean();
        return valor;
    }

    //Función para ingresar un byte
    public static byte ingresarByte(String mensaje) {
        Scanner sc = new Scanner(System.in);
        System.out.println(mensaje);
        byte numero = sc.nextByte();
        return numero;
    }

    //Función para ingresar un float
    public static float ingresarFloat(String mensaje) {
        Scanner sc = new Scanner(System.in);
        System.out.println(mensaje);
        float numero = sc.nextByte();
        return numero;
    }

}
