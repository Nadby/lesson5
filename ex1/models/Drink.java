package ex1.models;

public class Drink {

    private final int id;
    private final String name;
    private final int price;
    private WithMilk withMilk;

    public Drink(int id, String name, int price, WithMilk withMilk) {
        this(id, name, price);
        this.withMilk = withMilk;
    }

    public Drink(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.withMilk = WithMilk.NO;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public boolean getIsDrinkWithMilk() {
        return withMilk == WithMilk.YES;
    }
}
