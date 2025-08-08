import Pages.CreateChannelPage;
import Pages.MyOrderPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.Duration;

public class UiTests {
    @Test
    public void ChannelCreationTests() throws InterruptedException {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");

        //Initialisation
        WebDriver browser = new FirefoxDriver(options);
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));


        // go to website
        browser.get("https://widget.synonym.to/?embed=true");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[1]/div/div/div/div[1]/h4")));

        CreateChannelPage createChannelPage = new CreateChannelPage(browser);
        createChannelPage.setSats("780000");
        Thread.sleep(5000);
        createChannelPage.setChannelExpiry("20");
        Thread.sleep(5000);
        createChannelPage.createMyChannelButton();
        Thread.sleep(5000);
        //This is the element we see on the Term Acceptance and Payment Page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[1]/div/div/div/div[2]/div[1]/span")));
        createChannelPage.clickAcceptTermsButton();


        //Clicking on the Pay Button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[1]/div/div/div/div[2]/div[3]/button")));
        createChannelPage.clickPayButton();

    // Switch to on-chain and assert BTC address
        WebElement onchainoption=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.custom-tabs-heading-container:nth-child(2) > span:nth-child(2)")));
    createChannelPage.clickOnChainTab();
    WebElement onChainElement = wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".payment-request-middle-value")));
    String onChainText = onChainElement.getText();
    System.out.println("On-Chain Address Text: " + onChainText);
boolean bitcoinAddressIsDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bitcoinAddressId"))).isDisplayed();

assertTrue(bitcoinAddressIsDisplayed, "Bitcoin address not displayed!");

        browser.quit();
    }
    //

    //Verify user cannot proceed without input on mandatory field
    @Test
    public void shouldNotProceedWithoutInput() throws InterruptedException {
        WebDriver browser = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));

        browser.get("https://widget.synonym.to/?embed=true");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div/div[1]/h4")));

        // Click button without filling anything
        CreateChannelPage createChannelPage = new CreateChannelPage(browser);
        createChannelPage.setSats("");
        Thread.sleep(5000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[1]/div/div/div/div[2]/form/div[2]/div/button")));
        createChannelPage.createMyChannelButton();
        Thread.sleep(10000);

// Wait for the error message to appear
WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
    By.xpath("/html/body/div[1]/div/div/div/div[2]/form/div[1]/div[2]/div[3]/div/span")
));

// Assert that it contains the expected validation text
String errorText = errorMessage.getText();
Assertions.assertTrue(errorText.contains("Minimum receiving capacity is 100000 sats"),
    "Expected error message not displayed. Found: " + errorText);


        browser.quit();
    }

    //Verifying User Can View Orders
    @Test
    public void verifyUserCanViewOrders() throws InterruptedException {
        WebDriver browser = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(20));

        browser.get("https://widget.synonym.to/?embed=true");
WebElement rect = wait.until(ExpectedConditions.elementToBeClickable(
    By.cssSelector(".header-button svg rect:nth-of-type(3)")
));
rect.click();

        MyOrderPage myOrderPage = new MyOrderPage(browser);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[1]/div/div/div/div[2]/div/div[1]/div[2]/div[1]")));
        myOrderPage.clickMyOrdersButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".header-title")));
        String myOrdersText = myOrderPage.getMyOrdersText();
        Assertions.assertTrue(myOrdersText.contains("My orders"), "My orders not displayed!");


        //Clicking on the Back Icon
        WebElement backIconLocator=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.header-button:nth-child(1) > svg")));
        WebElement backIcon = wait.until(ExpectedConditions.elementToBeClickable(backIconLocator));
        backIcon.click();

        //String errorText = myOrderPage.getErrorMessage();
        //Assertions.assertTrue(errorText.contains("Menu"), "Expected error message not displayed. Found: " + errorText);

        browser.quit();
    }
@Test
    //Verify user can proceed to payment from MyOrderPage
    public void verifyUserCanProceedToPaymentFromMyOrderPage() throws InterruptedException {
        WebDriver browser = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(20));

        browser.get("https://widget.synonym.to/?embed=true");

        WebElement rect = wait.until(ExpectedConditions.elementToBeClickable(
    By.cssSelector(".header-button svg rect:nth-of-type(3)")
));
rect.click();

        MyOrderPage myOrderPage = new MyOrderPage(browser);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[1]/div/div/div/div[2]/div/div[1]/div[2]/div[1]")));
        myOrderPage.clickMyOrdersButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".header-title")));

        //Proceed to Initiate Payment
    WebElement paynowbutton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".action-button-text")));
    paynowbutton.click();

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#root > div:nth-child(1)")));

    browser.quit();
    }
//
}


