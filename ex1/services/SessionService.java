package ex1.services;

import ex1.exceptions.DrinkNotFoundException;
import ex1.exceptions.NotEnoughBalanceException;
import ex1.repositories.DrinkRepository;
import ex1.session.Session;

public class SessionService implements ISessionService {
    private final Session session;
    public SessionService(int drinkId) {
        this.session = new Session(drinkId);
    }

    /**
     * {@inheritDoc}
     */
    public boolean process() throws NotEnoughBalanceException {
        boolean res = false;
        if (checkPurchasePossibility()) {
            res = session.changeBalance(-1 * getPriceOfSelectedDrink());
            spendMilk(DrinkRepository.milkBitForDrink);
        } else {
            throw new NotEnoughBalanceException("недостаточно средств");
        }
        return  res;
    }
    /**
     * {@inheritDoc}
     */
    public void topUpBalance(int sum) {
       session.changeBalance(sum);
    }

    /**
     * {@inheritDoc}
     */
    public int getPriceOfSelectedDrink() {
        int price = 0;
        try {
            price = DrinkRepository.getDrinkById(session.getDrinkId()).getPrice();
        }
        catch (DrinkNotFoundException e) {
            System.out.printf("не удалось определить цену. не найден напиток с id=%s", session.getDrinkId());
        }
        return price;
    }

    /**
     * {@inheritDoc}
     */
    public String getNameOfSelectedDrink() {
        String name = "";
        try {
            name = DrinkRepository.getDrinkById(session.getDrinkId()).getName();
        }
        catch (DrinkNotFoundException e) {
            System.out.printf("не удалось определить наименование. не найден напиток с id=%s", session.getDrinkId());
        }
        return name;
    }
    /**
     * {@inheritDoc}
     */
    public void printBalance() {
        System.out.printf("текущий баланс: %5d (руб.)\n", getBalance());
    }
    /**
     * {@inheritDoc}
     */
    public int getBalance() {
        return session.getBalance();
    }

    //проверка достаточности средств на балансе для оплаты выбранного напитка
    private boolean checkPurchasePossibility()  {
        return session.getBalance() >= getPriceOfSelectedDrink();
    }

    //подача молоко для текущего напитка (уменьшение общего остатка молока на одну порцию)
    private void spendMilk(double delta) {
        DrinkRepository.setMilkLiters(DrinkRepository.getMilkLiters() - delta);
    }
}
