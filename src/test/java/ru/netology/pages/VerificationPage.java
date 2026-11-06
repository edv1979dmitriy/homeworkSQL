package ru.netology.pages;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {

    private final SelenideElement codeField = $("[data-test-id='code'] input");
    private final SelenideElement codeButton = $("[data-test-id='action-verify']");

    public VerificationPage() {
    }

    public DashboardPage verification(DataHelper.VerificationCode verificationCode) {
        codeField.setValue(verificationCode.getCode());
        codeButton.click();
        return new DashboardPage();
    }

    public void errorMessage(String error) {
        $("[data-test-id='error-notification']").shouldBe(visible, Duration.ofSeconds(10));
        $("[data-test-id='error-notification'] .notification__content").shouldHave(text(error));
    }

    public void checkPageVisible() {
        $("h2").shouldHave(text("Интернет Банк")).shouldBe(visible, Duration.ofSeconds(10));
    }
}
