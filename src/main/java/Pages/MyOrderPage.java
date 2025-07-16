package Pages;

import io.cucumber.java.an.E;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyOrderPage extends BasePage{

    public MyOrderPage(WebDriver browserDriver) {
        super(browserDriver);
    }

        //Navigate to MyOrders Option in the Hamburger Menu


    public void clickMyOrdersButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[1]/div/div/div/div[2]/div/div[1]/div[2]/div[1]")));
        WebElement myOrdersButton = browser.findElement(By.xpath("//html/body/div[1]/div/div/div/div[2]/div/div[1]/div[2]/div[1]"));
        myOrdersButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[1]/div/div/div/div[1]/h4")));
    }


//Text which Appears when a customer has made an order
    public String getMyOrdersText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[1]/div/div/div/div[1]/h4")));
        WebElement myOrdersText = browser.findElement(By.xpath("//html/body/div[1]/div/div/div/div[1]/h4"));
        return myOrdersText.getText();
    }
}

