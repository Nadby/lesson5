package ex1.helpers;

import ex1.exceptions.DrinkNotFoundException;
import ex1.exceptions.MilkRunOutException;
import ex1.models.Drink;
import ex1.repositories.DrinkRepository;

import java.util.Comparator;

public class DrinkHelper {
    /**
     * Печать напитков (меню)
     */
    public static void printDrinks() {
        System.out.println("меню:");

        DrinkRepository.getAllDrinks().sort(Comparator.comparingInt(Drink::getId));

        for (Drink drink : DrinkRepository.getAllDrinks()) {
            System.out.printf("%3d\t%15s\t%5d\n", drink.getId(), drink.getName(), drink.getPrice());
        }
    }

    /**
     * Проверка напитка, выбранного пользователем
     * Проверка осуществляется перед дальнейшими действиями (готовка, подача)
     * @param id идентификатор напитка
     */
    public static void validateDrinkById(int id) throws DrinkNotFoundException, MilkRunOutException {
        if (DrinkRepository.getDrinkById(id).getIsDrinkWithMilk()) {
            if (!DrinkRepository.hasStillMilk() || (DrinkRepository.getMilkLiters() - DrinkRepository.milkBitForDrink < 0)) {
                throw new MilkRunOutException(String.format("напиток %s не может быть сделан: молоко закончилось",
                        DrinkRepository.getDrinkById(id).getName()));
            }
        }
    }
}
