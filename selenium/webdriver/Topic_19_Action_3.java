package webdriver;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.io.*;
import java.nio.charset.Charset;
import java.time.Duration;

public class Topic_19_Action_3 {


    WebDriver driver;
    Actions action;
    JavascriptExecutor jsExecutor;
    String projectPath = System.getProperty("user.dir");

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        action = new Actions(driver);
        jsExecutor = (JavascriptExecutor) driver;

    }


    @Test
    public void TC_01_Right_Click() throws InterruptedException {
        driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");

        // Click chuột phải vào button
        action.contextClick(driver.findElement(By.cssSelector("span.btn-neutral"))).perform();
        Thread.sleep(3000);

        By quitContextBy = By.cssSelector("li.context-menu-icon-quit");

        Assert.assertTrue(driver.findElement(quitContextBy).isDisplayed());

        // Hover mouse
        action.moveToElement(driver.findElement(quitContextBy)).perform();
        Thread.sleep(3000);

        Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-quit.context-menu-visible.context-menu-hover")).isDisplayed());

        // Click Quit
        action.click(driver.findElement(quitContextBy)).perform();
        Thread.sleep(3000);

        driver.switchTo().alert().accept();

        Assert.assertTrue(driver.findElement(quitContextBy).isDisplayed());

    }





    @AfterClass
    public void Clean(){
        driver.quit();}
    }
