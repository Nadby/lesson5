package ex4;

public class Runner extends Human{

    private final String name;

    public Runner() {
        name = "бегун";
    }

    public void getName() {
        System.out.println(name);
    }

    @Override
    public void run() {
        System.out.println("бегает быстро");
    }

    @Override
    public void swim() {
        System.out.println("плавать не умеет");
    }
}
