package ex1;

import ex1.exceptions.DrinkNotFoundException;
import ex1.exceptions.MilkRunOutException;
import ex1.exceptions.NotEnoughBalanceException;
import ex1.helpers.DrinkHelper;
import ex1.services.ISessionService;
import ex1.services.SessionService;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner sc;
    private static ISessionService sessionService;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        welcome();
        sc.close();
    }

    //приветственный экран
    private static void welcome() {
        System.out.println("добро пожаловать!");
        makeNewFullCycle();
        int answer = 1;
        while (answer == 1) {
            System.out.println("еще кофе? (1 - да, 2 - нет)");
            if (sc.hasNextInt()) {
                answer = sc.nextInt();
            }
            else {
                answer = 2;
            }
            if (answer == 1) {
                makeNewFullCycle();
            }
        }
        System.out.println("хорошего дня!");
    }

    //полный цикл покупки и выдачи напитка
    private static void makeNewFullCycle() {
        showMenu();
        selectDrink();
        if (topUpBalance()) {
            process();
        }
        sessionService = null;
    }
    //показ меню
    private static void showMenu() {
        DrinkHelper.printDrinks();
    }

    //выбор напитка
    private static void selectDrink() {
        System.out.println("выберите напиток из представленных в меню, введя соответствующий номер:");
        int drinkId = 0;
        try {
            drinkId = sc.nextInt();
            DrinkHelper.validateDrinkById(drinkId);
            System.out.println("отличный выбор!");
            if (sessionService == null) {
                sessionService = new SessionService(drinkId);
            }
        } catch (InputMismatchException e) {
            System.out.println("введенная строка не может быть преобразована в целое число!");
            sc.next();
            selectDrink();
        }
        catch (MilkRunOutException e) {
            System.out.println(e.getMessage());
            showMenu();
            selectDrink();
        }
        catch (DrinkNotFoundException e) {
            System.out.printf("не найден напиток по введенному номеру: %s\n", drinkId);
            showMenu();
            selectDrink();
        }
    }

    //пополнение баланса
    private static boolean topUpBalance() {
        System.out.println("введите сумму пополнения:");
        try {
            int sum = sc.nextInt();
            if (validateSum(sum)) {
                sessionService.topUpBalance(sum);
            }
            else {
                return false;
            }
        } catch (InputMismatchException e) {
            System.out.println("введенная строка не может быть преобразована в целое число!");
            sc.next();
            topUpBalance();
        }
        return true;
    }

    //оплата, производство и выдача напитка
    private static void process() {
        boolean processed;
        try {
            processed = sessionService.process();
            if (processed) {
                System.out.printf("ваш напиток %s готов!\n", sessionService.getNameOfSelectedDrink());
                if (sessionService.getBalance() > 0) {
                    System.out.printf("заберите сдачу %s руб.\n", sessionService.getBalance());
                }
            } else {
                //транзакция откатывается, возврат средств
                System.out.println("произошла ошибка");
            }
        } catch (NotEnoughBalanceException e) {
            sessionService.printBalance();
            System.out.printf("пополните баланс, не хватает %s руб.\n", sessionService.getPriceOfSelectedDrink() - sessionService.getBalance());
            topUpBalance();
            process();
        }
    }

    //валидация суммы перед пополнением баланса
    private static boolean validateSum(int sum) {
        return sum > 0;
    }
}