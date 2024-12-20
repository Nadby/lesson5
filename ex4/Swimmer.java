package ex4;

public class Swimmer extends Human {

    private final String name;

    public Swimmer() {
        name = "пловец";
    }

    public void getName() {
        System.out.println(name);
    }
    @Override
    public void run() {
        System.out.println("бегает не очень быстро");
    }

    @Override
    public void swim() {
        System.out.println("плавает быстро");
    }
}
