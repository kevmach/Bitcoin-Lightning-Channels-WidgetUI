package Pages;
import io.cucumber.java.an.E;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class SettingsPage {
    WebDriver browser;
    WebDriverWait wait;
    public SettingsPage(WebDriver browserDriver) {
        this.browser = browserDriver;
        this.wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div/div[1]/h4")));
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[1]/div/div/div/div[2]/div/div[1]/div[2]/div[1]")));
        SettingsPage.clickMyOrdersButton();
}
