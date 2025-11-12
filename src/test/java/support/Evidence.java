package support;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Evidence {

    private static void highlight(WebElement el) {
        try {
            WebDriver d = DriverFactory.getDriver();
            ((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView({block:'center'});", el);
            ((JavascriptExecutor) d).executeScript(
                    "arguments[0].setAttribute('data-old-style', arguments[0].getAttribute('style')||'');" +
                            "arguments[0].style.outline='3px solid #e53935';" +
                            "arguments[0].style.boxShadow='0 0 0 3px rgba(229,57,53,0.35)';", el);
            Thread.sleep(120);
        } catch (Exception ignored) {}
    }

    private static void unhighlight(WebElement el) {
        try {
            WebDriver d = DriverFactory.getDriver();
            ((JavascriptExecutor) d).executeScript(
                    "var s=arguments[0].getAttribute('data-old-style')||'';arguments[0].setAttribute('style', s);", el);
        } catch (Exception ignored) {}
    }

    public static void captureFullPage(String baseName, Scenario scenario) {
        try {
            File src = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
            String ts = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String clean = baseName.replaceAll("[^a-zA-Z0-9_\\-]", "_");
            File dest = new File("target/screenshots/" + clean + "_" + ts + ".png");
            dest.getParentFile().mkdirs();
            FileUtils.copyFile(src, dest);
            scenario.attach(FileUtils.readFileToByteArray(dest), "image/png", dest.getName());
        } catch (Exception ignored) {}
    }

    /** Resalta un elemento y hace UNA sola captura de página completa */
    public static void captureElement(WebElement el, String baseName, Scenario scenario) {
        try { highlight(el); } catch (Exception ignored) {}
        captureFullPage(baseName, scenario);
        try { unhighlight(el); } catch (Exception ignored) {}
    }
}
