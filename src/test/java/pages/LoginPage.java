package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(css = "button[type='submit'], #submit")
    private WebElement loginButton;

    @FindBy(css = "#error, .show #error, .error, .alert")
    private WebElement errorBox;

    public void open(String url) {
        driver.get(url);
    }

    // --- nuevas APIs granulares ---
    public void setUsername(String user) {
        usernameInput.clear();
        usernameInput.sendKeys(user);
    }

    public void setPassword(String pass) {
        passwordInput.clear();
        passwordInput.sendKeys(pass);
    }

    public void clickLogin() {
        loginButton.click();
    }

    // getters para evidencias
    public WebElement usernameEl() { return usernameInput; }
    public WebElement passwordEl() { return passwordInput; }
    public WebElement errorEl()    { return errorBox; }

    // método antiguo (opcional, ya no lo usaremos en steps)
    public void login(String user, String pass) {
        setUsername(user);
        setPassword(pass);
        clickLogin();
    }

    public String getErrorText() {
        try { return errorBox.getText(); } catch (Exception e) { return ""; }
    }
}
