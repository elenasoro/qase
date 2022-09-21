package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

import java.awt.*;

public class BaseTest {
    @BeforeSuite
    public void setUp() {
        Configuration.timeout = 10000;
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) size.getWidth();
        int height = (int) size.getHeight() - 50;
        Configuration.browserSize = String.format("%dx%d", width, height);
    }
}
