package co.edu.uniquindio.poo;

public class Ejercicios {
    public static void main(String[] args) {
        // 1. Crear un arreglo e inicializarlo
        int[] numeros = {1, 2, 4, 5, 6};
        // 2. Realizar un metodo que sume todos los numeros del arreglo y retornar la suma
        int suma= sumarNumerosArreglos(numeros);
        System.out.println(suma);

        // 3. Realizar un metodo que diga si existe un  numero dado en el arreglo
        int numeroDado = 3;
        boolean numeroExiste = determinarNumeroExiste(numeroDado, numeros);
        System.out.println(numeroExiste);

        // 4. Verificar si existe un numero repetido en el arreglo
        boolean numeroRepetido = determinarNumeroRepetido(numeros);
        System.out.println(numeroRepetido);
    }

    public static int sumarNumerosArreglos(int[] numeros){
        int suma = 0;
        for(int i = 0; i < numeros.length; i++){
            suma += numeros[i];
        }
        return suma;
    }

    public static boolean determinarNumeroExiste(int numeroDado, int[] numeros){
        boolean numeroExiste = false;
        for(int i = 0; i < numeros.length; i++){
            int numeroComparar = numeros[i];
            if(numeroComparar == numeroDado){
                numeroExiste = true;
                break;
            }
        }
        return numeroExiste;
    }

    public static boolean determinarNumeroRepetido(int[] numeros){
        boolean existeRepetido = false;
        for(int i = 0; i < numeros.length && !existeRepetido; i++){
            int numeroBase = numeros[i];
            for(int j = i+1; j < numeros.length; j++) {
                int numeroComparar = numeros[j];
                if (numeroComparar == numeroBase){
                    existeRepetido = true;
                    break;
                }
            }
        }
        return existeRepetido;
    }



}