package io.github.ashwith.flutter.example;

import io.github.ashwith.flutter.FlutterFinder;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class FlutterFinderExampleTest {
    AppiumDriver driver;

    @BeforeMethod
    public void openApp() throws MalformedURLException {
        UiAutomator2Options capabilities = new UiAutomator2Options();
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("app", "");
        capabilities.setCapability("automationName", "Flutter");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
   public void appiumFlutterTest() {
        FlutterFinder finder = new FlutterFinder(driver);
        WebElement element = finder.byToolTip("increment");
        element.click();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
