package ex1.session;

public class Session {

    private final int drinkId;
    private int balance;

    public Session(int drinkId) {
        this.drinkId = drinkId;
        this.balance = 0;
    }

    /**
     * Изменение баланса
     * Имеется дополнительная проверка, что в случае изменения баланс не уйдет в минус
     * @param d величина изменения баланса, руб.
     * @return успешность изменения баланса
     */
    public boolean changeBalance(int d) {
        boolean res = false;
        try {
            if (balance + d >= 0) {
                balance += d;
                res = true;
            }
        }
        catch (Exception e) {
            //перед изменением баланса (changeBalance) вызывается проверка на достаточность средств (checkPurchasePossibility, validateSum)
            //здесь отлавливаются другие ошибки, которое могут возникнуть при изменении баланса, потому что это касается денежных средств клиента и ПО обязано их вернуть
            return false;
        }
        return res;
    }
    /**
     * @return текущий баланс сессии
     */
    public int getBalance() {
        return balance;
    }
    /**
     * @return идентификатор текущего выбранного напитка
     */
    public int getDrinkId() {
        return drinkId;
    }
}
