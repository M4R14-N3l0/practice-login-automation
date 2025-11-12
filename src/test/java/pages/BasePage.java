package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import support.Config;
import support.DriverFactory;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        this.driver = DriverFactory.getDriver();
        if (this.driver != null) {
            int explicit = Integer.parseInt(Config.get("explicitWaitSeconds"));
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(explicit));
            PageFactory.initElements(driver, this);
        }
    }
}
