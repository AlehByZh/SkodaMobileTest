package org.example.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ServiceScreen {

    private final AppiumDriver driver;

    public ServiceScreen(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
        this.driver = driver;
    }

    //Карточка Калькулятор ТО
    @FindBy(id = "ru.skoda.service:id/cardViewTwoCalculatorTS")
    private WebElement serviceCalculatorCard;
    //Карточка Казовной ремонт
    @FindBy(id = "ru.skoda.service:id/cardViewFourBodyRepair")
    private WebElement bodyRepairCard;
    //Кнопка Руководства по эксплуатации
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\")).scrollIntoView(new UiSelector().resourceId(\"ru.skoda.service:id/layoutCarManuals\"))")
    private WebElement manualsButton;
    //Кнопка Гарантия на авто
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\")).scrollIntoView(new UiSelector().resourceId(\"ru.skoda.service:id/layoutWarranty\"))")
    private WebElement warrantyButton;

    @Step("Тап на карточку \"Калькулятор ТО\"")
    public ServiceScreen clickServiceCalculatorCard() {
        serviceCalculatorCard.click();
        return this;
    }

    @Step("Тап на карточку \"Кузовной ремонт\"")
    public ServiceScreen clickBodyRepairCard() {
        bodyRepairCard.click();
        return this;
    }

    @Step("Проверка видимости карточки Калькулятор ТО")
    public void checkCalculatorIsVisible() {
        assert(serviceCalculatorCard.isDisplayed());
    }

    @Step("Тап на кнопку \"Гарантия на авто\"")
    public ServiceScreen clickWarrantyButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(warrantyButton)));
        warrantyButton.click();
        return this;
    }
}
