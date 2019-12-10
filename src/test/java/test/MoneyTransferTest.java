package test;
import data.*;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import data.DataHelper;

import page.LoginPage;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTransferTest {
    private CreditCard cardOne = new CreditCard();
    private CreditCard cardTwo = new CreditCard();


    @DisplayName("Перевод с карты 0002 на карту 0001 ")
    @Test
    void shouldTransferMoneyBetweenOwnCards() {

        open("http://localhost:9999/");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashBoardPage = verificationPage.validVerify(verificationCode);
        val cardPage = dashBoardPage.cardOnePage();
        int amount = DataHelper.generateRandomInt(cardOne.getBalanceCard());
        cardPage.transferFromInfoBalance(cardTwo, amount);
        CreditCard.transferMoneyCardToCard(cardOne, cardTwo, amount);
        assertEquals(dashBoardPage.getCheckBalanceCardOne(), cardOne.getBalanceCard() + amount);
        assertEquals(dashBoardPage.getCheckBalanceCardTwo(), cardTwo.getBalanceCard() - amount);
    }
}
