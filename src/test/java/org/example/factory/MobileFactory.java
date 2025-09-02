package org.example.factory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.qameta.allure.Step;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class MobileFactory {

    public static AppiumDriver getDriver(String browser) {
        return switch (browser) {
            case "ANDROID" -> getAndroidDriver();
            case "IOS" -> getIosDriver();
            default -> throw new IllegalStateException("Unexpected platform: " + browser);
        };
    }

    @Step("Инициализация драйвера для платформы Android")
    public static AndroidDriver getAndroidDriver() {
        try {
            var url = new URI("http://127.0.0.1:4723/").toURL();
            return new AndroidDriver(url, MobileCapabilities.getAndroidCapabilities());
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @Step("Инициализация драйвера для платформы iOS")
    public static IOSDriver getIosDriver() {
        try {
            var url = new URI("http://127.0.0.1:4723/").toURL();
            return new IOSDriver(url, MobileCapabilities.getIosCapabilities());
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
