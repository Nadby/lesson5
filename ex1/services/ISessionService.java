package ex1.services;

import ex1.exceptions.NotEnoughBalanceException;

public interface ISessionService {
    /**
     * Непосредственная покупка напитка
     * @return успешность покупки напитка
     * @throws NotEnoughBalanceException
     */
    boolean process () throws NotEnoughBalanceException;

    /**
     * Пополнение баланса
     * @param sum сумма пополнения баланса
     */
    void topUpBalance(int sum);

    /**
     * Получение цены выбранного напитка
     * @return цена, руб.
     */
    int getPriceOfSelectedDrink();

    /**
     * Получение наименования выбранного напитка
     * @return наименование выбранного напитка
     */
    String getNameOfSelectedDrink();

    /**
     * Печать баланса
     */
    void printBalance();

    /**
     * @return текущий баланс сессии
     */
    int getBalance();

}
