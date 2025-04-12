package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_34_PageReady {
    WebDriver driver;
    WebDriverWait explicitWait;


    @BeforeClass
    public void initialBrowser() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--user-data-dir=C:/Users/Admin/AppData/Local/Google/Chrome/User Data/");
        chromeOptions.addArguments("--profile-directory=Default");
        driver = new ChromeDriver(chromeOptions);

        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(15));

    }


    @Test
    public void TC_01_PageReady() {
        driver.get("https://admin-demo.nopcommerce.com");

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#Email")));

        driver.findElement(By.cssSelector("input#Email")).clear();
        driver.findElement(By.cssSelector("input#Password")).clear();

        driver.findElement(By.cssSelector("input#Email")).sendKeys("admin@yourstore.com");
        driver.findElement(By.cssSelector("input#Password")).sendKeys("admin");

        driver.findElement(By.cssSelector("button.button-1")).click();

        Assert.assertTrue(isPageLoadedSuccess());

        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#ajaxBusy"))));

        driver.findElement(By.xpath("//a[text()='Logout']")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("div.login-page form")).isDisplayed());

    }

    public boolean isPageLoadedSuccess() {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
            }
        };

        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
            }
        };
        return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
    }




    @AfterClass
    public void CleanBrowser(){
        driver.quit();}
    }
