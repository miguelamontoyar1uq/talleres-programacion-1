package co.edu.uniquindio.poo.app;

import co.edu.uniquindio.poo.model.Animal;
import co.edu.uniquindio.poo.model.Gato;
import co.edu.uniquindio.poo.model.Zoologico;

public class Main {
    public static void main(String[] args) {
        Zoologico zoologico = new Zoologico("Ukumari", "perira via cartago");

        Animal gato1 = new Gato("001", (byte)3, "Gris", "Michi", false);
        zoologico.registrarAnimal(gato1);

        Animal gato2 = new Gato("002", (byte)3, "Gris", "Michi", true);
        zoologico.registrarAnimal(gato2);

        if(gato1.equals(gato2)){
            System.out.println("Son iguales");
        }else{
            System.out.println("No son iguales");
        }

        gato1.comer();
        gato2.hacerSonido();
        gato1.dormir();
    }
}