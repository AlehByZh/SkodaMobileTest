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

    //Кнопка Домой
    @FindBy(id = "ru.skoda.service:id/bottom_home")
    private WebElement mainHomeButton;
    //Кнопка Сервис
    @FindBy(id = "ru.skoda.service:id/bottom_service")
    private WebElement serviceButton;
    //Кнопка Профиль
    @FindBy(id = "ru.skoda.service:id/bottom_profile")
    private WebElement profileButton;
    //Кнопка O SKODA
    @FindBy(id = "ru.skoda.service:id/bottom_systemInfo")
    private WebElement aboutButton;
    //Кнопка Бокового меню
    @FindBy(className = "android.widget.ImageButton")
    private WebElement sideMenuButton;
    //Карточка Записаться на сервис
    @FindBy(id = "ru.skoda.service:id/cardViewOneEntryToTheService")
    private WebElement entryServiceCard;
    //Карточка Помощь в дороге
    @FindBy(id = "ru.skoda.service:id/cardViewTwoHelpOnTheRoad")
    private WebElement helpRoadCard;
    //Карточка Заполнить профиль
    @FindBy(id = "ru.skoda.service:id/cardViewFourDynamic")
    private WebElement profileCard;
    //Карточка Список дилеров
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

    @Step("Проверка отображения карточки Записаться на сервис")
    public void checkIsEntryServiceVisible() {
        assert entryServiceCard.isDisplayed();
    }
}
