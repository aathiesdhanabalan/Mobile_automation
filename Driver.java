package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static utils.PropertyReader.prop;
import static utils.PropertyReader.testDataReader;

public class Driver {

    public static AppiumDriver<WebElement> driver;

    public static AppiumDriver<WebElement> setWebDriver() throws MalformedURLException {
        testDataReader();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("deviceName"));
        capabilities.setCapability("noReset", prop.getProperty("resetValue"));
        capabilities.setCapability("automationName", "uiAutomator2");
        capabilities.setCapability("appPackage", prop.getProperty("appPackage"));
        capabilities.setCapability("appActivity", prop.getProperty("appActivity"));
        capabilities.setCapability("newCommandTimeout", 0);

        driver = new AndroidDriver(new URL(prop.getProperty("url")), capabilities);
        return driver;
    }
}
