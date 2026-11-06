package ru.netology.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AuthorizationPage {

    public AuthorizationPage() {
    }

    private final SelenideElement login = $("[data-test-id='login'] input");
    private final SelenideElement password = $("[data-test-id='password'] input");

    public VerificationPage loginOfPersonalAccount(DataHelper.AuthInfo info) {
        login.setValue(info.getLogin());
        password.setValue(info.getPassword());
        $("[data-test-id='action-login']").click();
        return new VerificationPage();
    }

    public void cleanField() {
        login.click();
        login.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        password.click();
        password.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
    }

    public void checkPageVisible() {
        login.shouldBe(visible, Duration.ofSeconds(10));
    }

    public void errorMessage(String error) {
        $("[data-test-id='error-notification']").shouldBe(visible, Duration.ofSeconds(10));
        $("[data-test-id='error-notification'] .notification__content").shouldHave(text(error));
    }
}
