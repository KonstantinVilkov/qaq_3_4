package data;

import lombok.Data;


@Data
public class CreditCard {
    private String numberCard;
    private int balanceCard;
    private String lastSymbols;


    public static String getNumberCardOne(){
        String numberCard = "5559000000000001";
        return numberCard;
    }

    public static String getNumberCardTwo(){
        String numberCard = "5559000000000002";
        return numberCard;
    }

    public static void transferMoneyCardToCard(CreditCard cardOne, CreditCard cardTwo, int amount) {
        cardOne.setBalanceCard(cardOne.getBalanceCard() - amount);
        cardTwo.setBalanceCard(cardTwo.getBalanceCard() + amount);
    }

    public static int getBalanceCard() {
        return 10000;
    }

}


