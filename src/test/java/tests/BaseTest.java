package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import utils.TestListeners;

import java.awt.*;

@Listeners(TestListeners.class)
public class BaseTest {

    @BeforeSuite
//    @Parameters({"browser"})
//    public void setUp(@Optional("chrome") String browser) {
        public void setUp() {
//        Configuration.browser = browser;
        Configuration.timeout = 10000;
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) size.getWidth();
        int height = (int) size.getHeight();
        Configuration.browserSize = String.format("%dx%d", width, height);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        options.addArguments("--headless");

        options.addArguments("--disable-notifications");

        options.addArguments("--disable-popup-blocking");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        WebDriverRunner.getWebDriver().quit();
    }

}
