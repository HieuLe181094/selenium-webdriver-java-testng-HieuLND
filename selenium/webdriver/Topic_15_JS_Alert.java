package webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_15_JS_Alert {


    WebDriver driver;
    WebDriverWait explicitWait;



    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(10));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test
    public void TC_01_Accept_Alert() throws InterruptedException {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Thread.sleep(5000);

        Alert alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(),"I am a JS Alert");

        alert.accept();

        Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(),"You clicked an alert successfully");

//        // Accept Alert
//        driver.switchTo().alert().accept();
//
//        // Cancel Alert
//        driver.switchTo().alert().dismiss();
//
        // Get text bên trong Alert (Description)
//        String text = driver.switchTo().alert().getText();
//
//        // Enter text vào trong Alert
//        driver.switchTo().alert().sendKeys("");
    }

    @Test
    public void TC_02_Confirm_Alert() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

//        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

        // Vừa wait alert pressent vừa switch qua

        Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());

        Assert.assertEquals(alert.getText(),"I am a JS Confirm");

        alert.dismiss();

        Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(),"You clicked: Cancel");

    }

    @Test
    public void TC_03_Prompt_Alert() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

        Alert alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(),"I am a JS prompt");

        String value = "Automation FC";

        alert.sendKeys(value);
        alert.accept();

        Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(),"You entered: " + value);

    }



    @AfterClass
    public void TC_03_Clean(){
        driver.quit();}
    }
