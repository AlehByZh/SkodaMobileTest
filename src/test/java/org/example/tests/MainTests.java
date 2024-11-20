package org.example.tests;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Epic;
import org.example.factory.MobileFactory;
import org.example.screens.MainScreen;
import org.example.screens.ServiceScreen;
import org.junit.jupiter.api.*;

@Epic("Проверка главной страницы приложения")
public class MainTests {
    private AppiumDriver driver;
    private MainScreen main;
    private ServiceScreen service;

    @BeforeEach
    public void setUp() {
        driver = MobileFactory.getDriver("ANDROID");
        main = new MainScreen(driver);
        service = new ServiceScreen(driver);
    }

    @Test
    @DisplayName("Проверка работоспособности кнопки \"Сервис\"")
    public void serviceButtonTest () {
        main.clickServiceButton();
        service.checkCalculatorIsVisible();
    }

    @Test
    @DisplayName("Проверка работоспособности кнопки \"Главная\"")
    public void mainHomeButtonTest() {
        main.clickServiceButton();
        main.clickMainButton();
        main.checkIsEntryServiceVisible();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
