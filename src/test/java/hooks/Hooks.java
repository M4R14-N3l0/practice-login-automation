package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import support.Config;
import support.DriverFactory;

import java.time.Duration;

public class Hooks {

    @Before(order = 0)
    public void setUp() {
        DriverFactory.initDriver();
        WebDriver driver = DriverFactory.getDriver();
        driver.manage().window().setSize(new Dimension(1920, 1080));
        int implicit = Integer.parseInt(Config.get("implicitWaitSeconds"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicit));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}

