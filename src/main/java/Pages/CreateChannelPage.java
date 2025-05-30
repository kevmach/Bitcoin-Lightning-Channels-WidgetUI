package Pages;

import io.cucumber.java.an.E;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateChannelPage {
    WebDriver browser;
    WebDriverWait wait;

    public CreateChannelPage(WebDriver browserDriver) {
        this.browser = browserDriver;
        this.wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div/div[1]/h4")));
    }

    public void setSats(String number) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"remote-balance\"]")));
        WebElement receivingcapacityTextbox = browser.findElement(By.xpath("//*[@id=\"remote-balance\"]"));
        receivingcapacityTextbox.click();
        receivingcapacityTextbox.clear();
        receivingcapacityTextbox.sendKeys(number);
    }

    public void setChannelExpiry(String expiry) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"channel-expiry\"]")));
        WebElement channelexpiryTextbox = browser.findElement(By.xpath("//*[@id=\"channel-expiry\"]"));
        channelexpiryTextbox.sendKeys(expiry);
    }

    public void createMyChannelButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div/div[2]/form/div[2]/div/button")));
        WebElement mychannelButton = browser.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/form/div[2]/div/button"));
        mychannelButton.click();
    }
    public void clickAcceptTermsButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[1]/div/div/div/div[2]/div[2]/div[5]/div/div")));
        WebElement accepttermsbutton=browser.findElement(By.xpath("//html/body/div[1]/div/div/div/div[2]/div[2]/div[5]/div/div"));
        accepttermsbutton.click();

    }
    //Clicking on the Pay Button on the Payment Page
    public void clickPayButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//html/body/div[1]/div/div/div/div[2]/div[3]/button"))));
        WebElement paybutton=browser.findElement(By.xpath("//html/body/div[1]/div/div/div/div[2]/div[3]/button"));
        paybutton.click();
    }

    public void clickLightningTab(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[1]/div/div/div/div[2]/div[2]/div[1]/div[1]/span[2]")));
        WebElement lightningTab=browser.findElement(By.xpath("//html/body/div[1]/div/div/div/div[2]/div[2]/div[1]/div[1]/span[2]"));
        lightningTab.click();
    }
     public String getLightningInvoiceText() {
         By invoiceXPath = By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/div[1]/div[1]/span[2]");
         WebElement invoiceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(invoiceXPath));
         return invoiceElement.getText();

     }

     public void clickOnChainTab(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".payment-request-middle-value")));
     }
     public String getOnChainAddressText() {
    WebElement addressText = wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/div[2]/div[2]/span")));
    return addressText.getText();
}

}
