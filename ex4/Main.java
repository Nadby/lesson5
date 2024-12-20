package ex4;

public class Main {

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.getName();
        runner.run();
        runner.swim();
        Swimmer swimmer = new Swimmer();
        swimmer.getName();
        swimmer.run();
        swimmer.swim();
    }

}
