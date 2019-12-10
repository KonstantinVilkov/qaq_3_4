package page;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashBoardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private SelenideElement buttonReload = $("[data-test-id=action-reload]");
    private SelenideElement buttonCardOne = $$("[data-test-id=action-deposit").first();
    private SelenideElement buttonCardTwo = $$("[data-test-id=action-deposit").last();
    private SelenideElement balanceCardOne = $$("li").first();
    private SelenideElement balanceCardTwo = $$("li").last();

    public DashBoardPage() {
        heading.shouldBe(visible);
    }

    public CreditCardPage cardOnePage() {
        buttonCardOne.click();
        CreditCardPage cardOne = new CreditCardPage();
        return cardOne;
    }

    public CreditCardPage cardTwoPage() {
        buttonCardTwo.click();
        CreditCardPage cardTwo = new CreditCardPage();
        return cardTwo;
    }

    public String getTextBalanceCardOne() {
        String [] text = balanceCardOne.innerText().substring(3).split(" ");
        String balance = text[5];
        return balance;
    }

    public String getTextBalanceCardTwo() {
        String [] text = balanceCardTwo.innerText().substring(3).split(" ");
        String balance = text[5];
        return balance;
    }

    public int getCheckBalanceCardOne() {
        int balanceAmount = Integer.parseInt(getTextBalanceCardOne());
        return balanceAmount;
    }

    public int getCheckBalanceCardTwo() {
        int balanceAmount = Integer.parseInt(getTextBalanceCardTwo());
        return balanceAmount;
    }


}









