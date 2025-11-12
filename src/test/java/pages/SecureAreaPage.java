package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SecureAreaPage extends BasePage {

    @FindBy(css = "a[href*='logout'], #logout, .button.logout")
    private WebElement logoutButton;

    @FindBy(css = "h1, header h1, .post-title")
    private WebElement heading;

    public String getHeading() {
        try {
            return heading.getText();
        } catch (Exception e) {
            return "";
        }
    }

    public void logout() {
        try {
            logoutButton.click();
        } catch (Exception ignored) {}
    }

    // 👉 Getter necesario para las capturas en LoginSteps
    public WebElement headingEl() {
        return heading;
    }
}
