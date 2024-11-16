package org.example.factory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.qameta.allure.Step;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileFactory {

    public static AppiumDriver getDriver(String browser) {
        switch (browser) {
            case "ANDROID":
            default:
                return getAndroidDriver();
            case "IOS":
                return getIosDriver();
        }
    }

    @Step("Инициализация драйвера для платформы Android")
    public static AndroidDriver getAndroidDriver() {
        try {
            var url = new URL("http://127.0.0.1:4723/wd/hub");
            return new AndroidDriver(url, MobileCapabilities.getAndroidCapabilities());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Step("Инициализация драйвера для платформы iOS")
    public static IOSDriver getIosDriver() {
        try {
            var url = new URL("http://127.0.0.1:4723/wd/hub");
            return new IOSDriver(url, MobileCapabilities.getIosCapabilities());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
