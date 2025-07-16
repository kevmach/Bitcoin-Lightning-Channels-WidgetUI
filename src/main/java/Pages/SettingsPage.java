package Pages;
import io.cucumber.java.an.E;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class SettingsPage extends BasePage {
    public SettingsPage(WebDriver browserDriver) {
        super(browserDriver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[1]/div/div/div/div[2]/div/div[1]/div[2]/div[1]")));
    }

}
