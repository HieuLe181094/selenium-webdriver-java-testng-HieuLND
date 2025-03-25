package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_24_JavascriptExcutor {


    WebDriver driver;
    JavascriptExecutor jsExecutor;
    WebDriverWait explicitWait;
    String email;

    @BeforeClass
    public void initialBrowser() {
        driver = new ChromeDriver();
        jsExecutor = (JavascriptExecutor) driver; // Ép kiểu tường mình
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(15));
        email = "automation" + new Random().nextInt(99999) + "@gmail.com";


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(15));

    }


    @Test
    public void TC_01_TechPanda() throws InterruptedException {

        jsExecutor.executeScript("window.location = 'https://live.techpanda.org/'");


        String techPandaDomain = (String) jsExecutor.executeScript("return document.domain;");
        Assert.assertEquals(techPandaDomain,"live.techpanda.org");

        String techPandaURL = (String) jsExecutor.executeScript("return document.URL;");
        Assert.assertEquals(techPandaURL,"https://live.techpanda.org/");

        jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[text()='Mobile']")));


        jsExecutor.executeScript("arguments[0].click();",driver.findElement(
                By.xpath("//a[@title='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']/button[@title='Add to Cart']")));
        Thread.sleep(3000);

        String samsungText = (String) jsExecutor.executeScript("return document.documentElement.innerText;");
        Assert.assertTrue(samsungText.contains("Samsung Galaxy was added to your shopping cart."));

        jsExecutor.executeScript("arguments[0].click();",driver.findElement(By.xpath("//a[text()='Customer Service']")));


        jsExecutor.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.cssSelector("input#newsletter")));

        jsExecutor.executeScript("arguments[0].setAttribute('value','" + email +"')",driver.findElement(By.cssSelector("input#newsletter")));

        jsExecutor.executeScript("arguments[0].click();",driver.findElement(By.xpath("//button[@title='Subscribe']")));
        Thread.sleep(5000);


        String subcriptionText = (String) jsExecutor.executeScript("return document.documentElement.innerText;");
        Assert.assertTrue(subcriptionText.contains("Thank you for your subscription."));
        Thread.sleep(3000);

        jsExecutor.executeScript("window.location = 'https://www.facebook.com/'");


    }

    @Test
    public void TC_02_TechPanda() {
        navigateToUrlByJS("https://live.techpanda.org/");

        Assert.assertEquals(getDomanin(),"live.techpanda.org");
        Assert.assertEquals(getPageURL(),"https://live.techpanda.org/");

        clickToElementByJS("//a[text()='Mobile']");

        clickToElementByJS("//a[@title='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']");

        Assert.assertFalse(getInnerText().contains("Samsung Galaxy was added to your shopping cart."));

        clickToElementByJS("//a[text()='Customer Service']");

        scrollToElementOnTop("//input[@id='newsletter']");

        setAttributeInDOM("//input[@id='newsletter']","value",email);

        clickToElementByJS("//button[@title='Subscribe']");

        Assert.assertFalse(getInnerText().contains("Thank you for your subscription."));

        navigateToUrlByJS("https://www.facebook.com/");


    }

    @Test
    public void TC_03_Role() throws InterruptedException {
        driver.get("https://warranty.rode.com/login");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

        // Empty
        loginButton.click();
        Thread.sleep(3000);

        String emptyEmailMessage = getElementValidationMessage("//input[@id='email']");
        Assert.assertEquals(emptyEmailMessage,"Please fill out this field.");

        // Email invalid
        String invalidEmailData = "'aaa'";
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("aaa");
        loginButton.click();

        String invalidEmailMessage = getElementValidationMessage("//input[@id='email']");

        if (driver.toString().contains("ChromeDriver")){
            Assert.assertEquals(invalidEmailMessage,"Please include an '@' in the email address. " + invalidEmailData + " is missing an '@'.");
            // Please include an '@' in the email address. 'aaa' is missing an '@'.
        } else {
            Assert.assertEquals(invalidEmailMessage,"Please enter an email address.");
        }

//        invalidEmailData = "aaa@aaa.";
//        driver.findElement(By.xpath("//input[@id='email']")).clear();
//        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("aaa");
//        loginButton.click();
//
//        invalidEmailMessage = getElementValidationMessage("//input[@id='email']");
//
//        if (driver.toString().contains("ChromeDriver")){
//            Assert.assertEquals(emptyEmailMessage,"Please include an '@' in the email address." + invalidEmailData + "is missing an '@'.");
//        } else {
//            Assert.assertEquals(emptyEmailMessage,"Please enter an email address.");
//        }

        // Email valid
        driver.findElement(By.xpath("//input[@id='email']")).clear();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
        loginButton.click();

        Assert.assertEquals(getElementValidationMessage("//input[@id='password']"),"Please fill out this field.");

    }




    @AfterClass
    public void TC_03_Clean(){
        driver.quit();}

    public Object executeForBrowser(String javaScript) {
        return jsExecutor.executeScript(javaScript);
    }

    public String getDomanin() {
        return (String) jsExecutor.executeScript("return document.domain;");
    }

    public String getPageURL() {
        return (String) jsExecutor.executeScript("return document.URL;");
    }

    public String getInnerText() {
        return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
    }

    public boolean isExpectedTextInInnerText(String textExpected) {
        String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
        return textActual.equals(textExpected);
    }

    public void scrollToBottomPage() {
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void sleepInSecond(int timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void navigateToUrlByJS(String url) {
        jsExecutor.executeScript("window.location = '" + url + "'");
        sleepInSecond(3);
    }

    public void hightlightElement(String locator) {
        WebElement element = getElement(locator);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSecond(2);
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(String locator) {
        jsExecutor.executeScript("arguments[0].click();", getElement(locator));
        sleepInSecond(3);
    }

    public String getElementTextByJS(String locator) {
        return (String) jsExecutor.executeScript("return arguments[0].textContent;", getElement(locator));
    }

    public void scrollToElementOnTop(String locator) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
    }

    public void scrollToElementOnDown(String locator) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getElement(locator));
    }

    public void setAttributeInDOM(String locator, String attributeName, String attributeValue) {
        jsExecutor.executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue +"');", getElement(locator));
    }

    public void removeAttributeInDOM(String locator, String attributeRemove) {
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(locator));
    }

    public void sendkeyToElementByJS(String locator, String value) {
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(locator));
    }

    public String getAttributeInDOM(String locator, String attributeName) {
        return (String) jsExecutor.executeScript("return arguments[0].getAttribute('" + attributeName + "');", getElement(locator));
    }

    public String getElementValidationMessage(String locator) {
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(locator));
    }

    public boolean isImageLoaded(String locator) {
        boolean status = (boolean) jsExecutor.executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getElement(locator));
        return status;
    }

    public WebElement getElement(String locator) {
        return driver.findElement(By.xpath(locator));
    }
    }
