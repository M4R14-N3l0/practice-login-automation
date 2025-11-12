package steps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.SecureAreaPage;
import support.Config;
import support.DriverFactory;
import support.Evidence;

import java.time.Duration;

public class LoginSteps {

    private LoginPage loginPage;
    private SecureAreaPage securePage;
    private Scenario scenario;

    @Before(order = 1)
    public void init(Scenario sc) {
        this.scenario = sc;
        this.loginPage = new LoginPage();
        this.securePage = new SecureAreaPage();
    }

    @Given("que navego a la página de login")
    public void abrirLogin() {
        loginPage.open(Config.get("baseUrl"));
    }

    @When("introduzco usuario {string} y contraseña {string}")
    public void introducirCredenciales(String user, String pass) {
        loginPage.setUsername(user);
        loginPage.setPassword(pass);
        // 📸 Captura 1: mostrar claramente que los campos quedaron rellenos (resaltamos usuario)
        Evidence.captureElement(loginPage.usernameEl(), "login_filled", scenario);
    }

    @When("hago clic en Login")
    public void clicLogin() {
        loginPage.clickLogin();

        // Espera a que aparezca éxito o error
        WebDriver driver = DriverFactory.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        try {
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1, header h1, .post-title")),
                    ExpectedConditions.presenceOfElementLocated(By.cssSelector("#error, .show #error, .error, .alert"))
            ));
        } catch (Exception ignored) {}

        // 📸 Captura 2: resalta el resultado (éxito o error)
        try {
            // prioriza éxito si existe
            Evidence.captureElement(securePage.headingEl(), "login_result", scenario);
        } catch (Exception e) {
            Evidence.captureElement(loginPage.errorEl(), "login_result", scenario);
        }
    }

    @Then("debería ver el mensaje de éxito {string}")
    public void verificarExito(String expected) {
        String heading = securePage.getHeading();
        Assertions.assertTrue(
                heading != null && heading.toLowerCase().contains(expected.toLowerCase()),
                "No se encontró el mensaje esperado. Obtenido: " + heading
        );
    }

    @Then("debería ver el mensaje de error {string}")
    public void verificarErrorUnico(String msg) {
        String err = loginPage.getErrorText();
        Assertions.assertTrue(
                err != null && err.toLowerCase().contains(msg.toLowerCase()),
                "Esperaba que el mensaje contuviera '" + msg + "', pero obtuve: '" + err + "'"
        );
    }

    @Then("debería ver el mensaje de error {string} or {string}")
    public void verificarErrorDos(String m1, String m2) {
        String err = loginPage.getErrorText();
        Assertions.assertTrue(
                err != null && (err.toLowerCase().contains(m1.toLowerCase()) || err.toLowerCase().contains(m2.toLowerCase())),
                "Esperaba alguno: '" + m1 + "' o '" + m2 + "', pero obtuve: '" + err + "'"
        );
    }

    @Then("debería poder cerrar sesión")
    public void cerrarSesion() {
        securePage.logout();
    }
}
