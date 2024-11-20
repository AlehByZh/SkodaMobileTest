package org.example.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ServiceScreen {
    private final AppiumDriver driver;

    @FindBy(id = "ru.skoda.service:id/cardViewTwoCalculatorTS")
    private WebElement serviceCalculatorCard;

    @FindBy(id = "ru.skoda.service:id/cardViewFourBodyRepair")
    private WebElement bodyRepairCard;

    //Кнопка Руководство по эксплуатации
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\")).scrollIntoView(new UiSelector().resourceId(\"ru.skoda.service:id/layoutCarManuals\"))")
    private WebElement manualsButton;
    //Кнопка Гарантия на авто
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\")).scrollIntoView(new UiSelector().resourceId(\"ru.skoda.service:id/layoutWarranty\"))")
    private WebElement warrantyButton;

    public ServiceScreen clickServiceCalculatorCard() {
        serviceCalculatorCard.click();
        return this;
    }

    public ServiceScreen clickBodyRepairCard() {
        bodyRepairCard.click();
        return this;
    }

    @Step("Проверка видимости карточки Калькулятор ТО")
    public void checkCalculatorIsVisible() {
        assert(serviceCalculatorCard.isDisplayed());
    }

    public ServiceScreen clickWarrantyButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(warrantyButton)));
        warrantyButton.click();
        return this;
    }

    public ServiceScreen(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
        this.driver = driver;
    }
}
