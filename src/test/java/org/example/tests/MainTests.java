package org.example.tests;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Epic;
import org.example.factory.MobileFactory;
import org.example.screens.AboutScreen;
import org.example.screens.MainScreen;
import org.example.screens.ServiceScreen;
import org.junit.jupiter.api.*;

@Epic("Проверка главной страницы приложения")
public class MainTests {
    private AppiumDriver driver;
    private MainScreen main;
    private ServiceScreen service;
    private AboutScreen about;

    @BeforeEach
    public void setUp() {
        driver = MobileFactory.getDriver("ANDROID");
        main = new MainScreen(driver);
        service = new ServiceScreen(driver);
        about = new AboutScreen(driver);
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

    @Test
    @DisplayName("Проверка нажатия карточки \"Юридические условия\" на странице \"O SKODA\"")
    public void checkLawInfoCardTest() {
        main.clickAboutButton();
        about.clickLawInfoCard();
        about.checkIsLawInfoVisible();
    }

    @Test
    @DisplayName("Проверка нажатия карточки \"ŠKODA FAMILY\" на странице \"О ŠKODA\"")
    public void checkSkodaFamilyCardTest() {
        main.clickAboutButton();
        about.clickSkodaFamilyCard();
        about.checkIsSkodaFamilyScreenVisible();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
