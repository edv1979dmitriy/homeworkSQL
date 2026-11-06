package ru.netology.pages;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {

    public DashboardPage() {
    }

    public void checkPageVisible() {
        $("[data-test-id='dashboard']").shouldHave(text("  Личный кабинет")).shouldBe(visible, Duration.ofSeconds(10));
    }
}
