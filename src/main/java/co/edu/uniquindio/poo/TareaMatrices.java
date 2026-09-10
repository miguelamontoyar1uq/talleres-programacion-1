package co.edu.uniquindio.poo;
//tarea:
// 1.imprimir una matriz
// 2. sumar todos los numeros de una matriz
// 3. Sumar los numeros de la diagonal de una matri
// 4. Dibujar en una matriz un espiral de numeros

public class TareaMatrices {

    public static void main(String[] args){
        int[][] numeros = {
                {1, 2, 3, 4},
                {4, 5, 6, 7},
                {7, 8, 9, 9}
        };
        // 1
        int suma = sumarMatriz(numeros);
        System.out.println(suma);
        // 2
        imprimirMatriz(numeros);
        // 3
        int sumaDiagonal=sumarDiagonal(numeros);
        System.out.println(sumaDiagonal);
        // 4
        System.out.println("Dibujar espiral en matriz");
        int filas = Repositorio.ingresarEntero("Cantidad de filas: ");
        int columnas = Repositorio.ingresarEntero("Cantidad de columnas: ");
        int[][] matriz = dibujarEspiral(filas, columnas);
        recorrerEspiral(matriz); //Comprobación recorrido en espiral
        imprimirMatriz(matriz); //Comprobación recorrido normal
    }

    public static int sumarMatriz(int[][] numeros){
        int suma = 0;
        for(int i = 0; i < numeros.length; i++){
            for(int j = 0; j < numeros[i].length; j++) {
                suma+=numeros[i][j];
            }
        }
        return suma;
    }

    public static void imprimirMatriz(int [][] matriz) {
        for(int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz[i].length; j++){
                System.out.print(matriz[i][j] +" ");
            }
            System.out.println("\n");
        }
    }

    public static int sumarDiagonal(int[][] numeros){
        int suma = 0;
        for(int i = 0; i < numeros.length; i++) {
            for(int j = 0; j < numeros.length; j++){
                if (i == j) {
                    suma += numeros[i][j];
                }
            }
        }
        return suma;
    }

    public static int[][] dibujarEspiral(int filas, int columnas){
        int[][] matriz = new int[filas][columnas];
        int filaInicio = 0;
        int filaFin = matriz.length - 1;
        int colInicio = 0;
        int colFin = matriz[0].length - 1;
        int contador = 1;
        while (filaInicio <= filaFin && colInicio <= colFin) {
            for (int col = colInicio; col <= colFin; col++) {
                matriz[filaInicio][col] = contador;
                contador++;
            }
            filaInicio++;

            for (int fila = filaInicio; fila <= filaFin; fila++) {
                matriz[fila][colFin] = contador;
                contador++;
            }
            colFin--;

            if (filaInicio <= filaFin) {
                for (int col = colFin; col >= colInicio; col--) {
                    matriz[filaFin][col] = contador;
                    contador++;
                }
                filaFin--;
            }

            if (colInicio <= colFin) {
                for (int fila = filaFin; fila >= filaInicio; fila--) {
                    matriz[fila][colInicio] = contador;
                    contador++;
                }
                colInicio++;
            }
        }
        return matriz;
    }

    public static void recorrerEspiral(int[][] matriz){
        int filaInicio = 0;
        int filaFin = matriz.length - 1;
        int colInicio = 0;
        int colFin = matriz[0].length - 1;
        while (filaInicio <= filaFin && colInicio <= colFin) {
            for (int col = colInicio; col <= colFin; col++) {
                System.out.print(matriz[filaInicio][col]+" ");
            }
            filaInicio++;

            for (int fila = filaInicio; fila <= filaFin; fila++) {
                System.out.print(matriz[fila][colFin]+" ");
            }
            colFin--;

            if (filaInicio <= filaFin) {
                for (int col = colFin; col >= colInicio; col--) {
                    System.out.print(matriz[filaFin][col]+" ");
                }
                filaFin--;
            }

            if (colInicio <= colFin) {
                for (int fila = filaFin; fila >= filaInicio; fila--) {
                    System.out.print(matriz[fila][colInicio]+" ");
                }
                colInicio++;
            }
        }
        System.out.print("\n");
    }


}
