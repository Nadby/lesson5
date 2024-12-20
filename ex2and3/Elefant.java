package ex2and3;

import ex2and3.interfaces.Run;
import ex2and3.interfaces.Swim;

public class Elefant extends Animal implements Run, Swim {

    private final String name;

    public Elefant() {
        this.name = "слон";
    }

    @Override
    public void getName() {
        System.out.println(name);
    }

    @Override
    public void run() {
        System.out.println(name + " бегает");
    }

    @Override
    public void swim() {
        System.out.println(name + " плавает");
    }
}
