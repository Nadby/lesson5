package ex2and3;

public class Main {

    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.getName();
        duck.swim();
        duck.run();
        duck.fly();
        Elefant elefant = new Elefant();
        elefant.getName();
        elefant.swim();
        elefant.run();
        //elefant.fly(); //слоны не летают
        Rhinoceros rhinoceros = new Rhinoceros();
        rhinoceros.getName();
        rhinoceros.swim();
        rhinoceros.run();
        //rhinoceros.fly(); // носороги не летают
    }
}
