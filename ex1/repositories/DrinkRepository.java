package ex1.repositories;

import ex1.models.Drink;
import ex1.models.WithMilk;
import ex1.exceptions.DrinkNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class DrinkRepository {

    public static double milkBitForDrink;

    public static List<Drink> drinks;

    private static double milkLiters;

    /**
     * Получение информации об остатках молока
     *
     * @return остатки молока, в литрах
     */
    public static double getMilkLiters() {
        return milkLiters;
    }

    /**
     * Установка значения остатка молока, в литрах
     */
    public static void setMilkLiters(double milkLiters) {
        DrinkRepository.milkLiters = milkLiters;
    }

    /**
     * Получение информации о наличии молока
     * @return наличие молока (true, false)
     */
    public static boolean hasStillMilk() {
        return milkLiters > 0;
    }

    static {
        drinks = new ArrayList<>(List.of(
                new Drink(1, "капучино", 100, WithMilk.YES),
                new Drink(2, "лате", 120, WithMilk.YES),
                new Drink(3, "эспрессо", 80, WithMilk.NO),
                new Drink(4, "американо", 75, WithMilk.NO)));

        //первоначальная установка остатков молока
        milkLiters = 0.2;
        //количество молока добавляемое в одну единицу напитка
        milkBitForDrink = 0.1;
    }

    /**
     * Получение напитка Drink по идентификатору
     *
     * @param drinkId идентификатор напитка
     * @return напиток Drink
     * @throws DrinkNotFoundException
     */
    public static Drink getDrinkById(int drinkId) throws DrinkNotFoundException {
        return drinks.stream()
                .filter(x -> x.getId() == drinkId)
                .findFirst()
                .orElseThrow(() -> new DrinkNotFoundException("не найден напиток с идентификатором " + drinkId));
    }

    /**
     * Получение всех напитков
     * @return список напитков
     */
    public static List<Drink> getAllDrinks() {
        return drinks;
    }

}
