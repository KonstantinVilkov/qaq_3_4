package page;
import data.CreditCard;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CreditCardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private SelenideElement amountInput = $("[data-test-id=amount] input");
    private SelenideElement numberCard = $("[data-test-id=from] input");
    private SelenideElement buttonTransfer= $("[data-test-id=action-transfer]");
    private SelenideElement buttonCancel = $("[data-test-id=action-cancel]");

    public CreditCardPage() {
        heading.shouldBe(Condition.visible);
    }


    public DashBoardPage transferFromInfoBalance(CreditCard card, int amount) {
        amountInput.setValue(String.valueOf(amount));
        numberCard.setValue(card.getNumberCardTwo());
        buttonTransfer.click();
        return new DashBoardPage();
    }

    public DashBoardPage cancelRequest(CreditCard card, int amount) {
        amountInput.setValue(String.valueOf(amount));
        numberCard.setValue(card.getNumberCardTwo());
        buttonCancel.click();
        return new DashBoardPage();
    }


}
