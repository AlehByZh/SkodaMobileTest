package org.example.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MainScreen {
    private final AppiumDriver driver;

    @FindBy(id = "ru.skoda.service:id/bottom_home")
    private WebElement mainHomeButton;

    @FindBy(id = "ru.skoda.service:id/bottom_service")
    private WebElement serviceButton;

    @FindBy(id = "ru.skoda.service:id/bottom_profile")
    private WebElement profileButton;

    @FindBy(id = "ru.skoda.service:id/bottom_systemInfo")
    private WebElement aboutButton;

    @FindBy(className = "android.widget.ImageButton")
    private WebElement sideMenuButton;

    @FindBy(id = "ru.skoda.service:id/cardViewOneEntryToTheService")
    private WebElement entryServiceCard;

    @FindBy(id = "ru.skoda.service:id/cardViewTwoHelpOnTheRoad")
    private WebElement helpRoadCard;

    @FindBy(id = "ru.skoda.service:id/cardViewFourDynamic")
    private WebElement profileCard;

    @FindBy(id = "ru.skoda.service:id/cardViewThreeListOfDealers")
    private WebElement dealersCard;

    public MainScreen(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
        this.driver = driver;
    }

    @Step("Тап на кнопку Сервис")
    public MainScreen clickServiceButton() {
        serviceButton.click();
        return this;
    }

    @Step("Тап на кнопку Главная")
    public MainScreen clickMainButton() {
        mainHomeButton.click();
        return this;
    }

    @Step("Тап на кнопку Профиль")
    public MainScreen clickProfileButton() {
        profileButton.click();
        return this;
    }

    @Step("Тап на кнопку О SKODA")
    public MainScreen clickAboutButton() {
        aboutButton.click();
        return this;
    }

    @Step("Тап на карточку Записаться на сервис")
    public MainScreen clickEntryServiceCard() {
        entryServiceCard.click();
        return this;
    }

    @Step("Тап на карточку Помощь в дороге")
    public MainScreen clickHelpRoadCard() {
        helpRoadCard.click();
        return this;
    }

    @Step("Тап на карточку Заполнить профиль")
    public MainScreen clickProfileCard() {
        profileCard.click();
        return this;
    }

    @Step("Тап на карточку Список дилеров")
    public MainScreen clickDealersCard() {
        dealersCard.click();
        return this;
    }
}
