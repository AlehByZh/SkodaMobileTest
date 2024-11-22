package org.example.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class AboutScreen {

    private final AppiumDriver driver;

    public AboutScreen(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
        this.driver = driver;
    }

    //Карточка Юридические условия
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().resourceId(\"ru.skoda.service:id/aboutRecycler\")).setAsHorizontalList().scrollIntoView(new UiSelector().text(\"ЮРИДИЧЕСКИЕ УСЛОВИЯ\"))")
    private WebElement lawInfoCard;
}
