package org.example.factory;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.remote.options.BaseOptions;

public class MobileCapabilities {

    public static UiAutomator2Options getAndroidCapabilities() {
        var cap = new UiAutomator2Options();
        cap.setPlatformName(MobilePlatform.ANDROID);
        cap.setDeviceName("sdk_gphone_x86_64");
        cap.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        cap.setApp("C:\\Program Files\\Cygwin\\home\\cygdrive\\c\\Users\\zhili\\AppiumTest\\src\\test\\resources\\app\\Skoda_1.0.16.apk");
        return cap;
    }

    public static XCUITestOptions getIosCapabilities() {
        var cap = new XCUITestOptions();
        cap.setPlatformName(MobilePlatform.IOS);
        cap.setDeviceName("iPhone_11");
        cap.setAutomationName(AutomationName.IOS_XCUI_TEST);
        cap.setApp("C:\\Program Files\\Cygwin\\home\\cygdrive\\c\\Users\\zhili\\AppiumTest\\src\\test\\resources\\app\\Skoda_1.0.16.ipa");
        return cap;
    }
}
