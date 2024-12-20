package ex2and3;

import ex2and3.interfaces.Fly;
import ex2and3.interfaces.Run;
import ex2and3.interfaces.Swim;

public class Duck extends Animal implements Fly, Run, Swim {

    private final String name;

    public Duck() {
        this.name = "утка";
    }

    @Override
    public void getName() {
        System.out.println(name);
    }

    @Override
    public void fly() {
        System.out.println(name + " летает");
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
