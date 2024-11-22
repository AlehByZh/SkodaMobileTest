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

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AboutScreen {

    private final AppiumDriver driver;

    public AboutScreen(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
        this.driver = driver;
    }

    //Карточка Юридические условия
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().resourceId(\"ru.skoda.service:id/aboutRecycler\")).setAsHorizontalList().scrollIntoView(new UiSelector().text(\"ЮРИДИЧЕСКИЕ УСЛОВИЯ\"))")
    private WebElement lawInfoCard;
    //Страница Юридические условия
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"ru.skoda.service:id/toolbarTitle\").text(\"ЮРИДИЧЕСКИЕ УСЛОВИЯ\")")
    private WebElement lawInfoScreen;
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().resourceId(\"ru.skoda.service:id/aboutRecycler\")).setAsHorizontalList().scrollIntoView(new UiSelector().text(\"ŠKODA FAMILY\"))")
    private WebElement skodaFamilyCard;
    //Картинка страницы Skoda Family
    @FindBy(id = "ru.skoda.service:id/backgroundImageFamily")
    private WebElement skodaFamilyImage;

    @Step("Тап на карточку \"ЮРИДИЧЕСКИЕ УСЛОВИЯ\"")
    public AboutScreen clickLawInfoCard() {
        lawInfoCard.click();
        return this;
    }

    @Step("Тап на карточку \"ŠKODA FAMILY\"")
    public AboutScreen clickSkodaFamilyCard() {
        skodaFamilyCard.click();
        return this;
    }

    @Step("Проверка открытия страницы \"ŠKODA FAMILY\"")
    public void checkIsSkodaFamilyScreenVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(skodaFamilyImage));
        assertTrue(skodaFamilyImage.isDisplayed());
    }

    @Step("Проверка открытия страницы \"Юридические условия\"")
    public void checkIsLawInfoVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(lawInfoScreen));
        assertTrue(lawInfoScreen.isDisplayed());
    }
}
