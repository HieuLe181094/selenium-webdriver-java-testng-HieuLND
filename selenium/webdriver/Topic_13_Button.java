package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;


public class Topic_13_Button {


    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test
    public void TC_01_Fahasa() {
        driver.get("https://www.fahasa.com/customer/account/create");

        driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();

        By loginButton = By.cssSelector("button.fhs-btn-register");

        // isEnable: nếu element mà nó enable thì trả về True/ Disable trả về False
        //Mong đợi nó là disable
        Assert.assertFalse(driver.findElement(loginButton).isEnabled());

        String loginBackgroundColor = driver.findElement(loginButton).getCssValue("background-color");
        Color loginColor = Color.fromString(loginBackgroundColor);
        Assert.assertEquals(loginColor.asHex().toUpperCase(),"#000000");

        Assert.assertEquals(Color.fromString(driver.findElement(loginButton).getCssValue("background-color")).asHex().toUpperCase(),"#000000");

        driver.findElement(By.cssSelector("input#login_username")).sendKeys("hieule@gmail.com");
        driver.findElement(By.cssSelector("input#login_password")).sendKeys("123456");


        //Mong đợi nó là enable
        Assert.assertTrue(driver.findElement(loginButton).isEnabled());
        Assert.assertEquals(Color.fromString(driver.findElement(loginButton).getCssValue("background-color")).asHex().toUpperCase(),"#C92127");

        driver.findElement(loginButton).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.fhs-login-msg")).getText(),"Số điện thoại/Email hoặc Mật khẩu sai!");

        Assert.assertEquals(driver.findElement(loginButton).getText(),"Đăng nhập");

        //#C92127

        //#000000

    }

    @Test
    public void TC_02_Huawei() throws InterruptedException {
        driver.get("https://id5.cloud.huawei.com/CAS/portal/userRegister/regbyemail.html");
        Thread.sleep(5000);

        Assert.assertTrue(driver.findElement(By.cssSelector("div.hwid-reg-btn")).isEnabled());


    }



    @AfterClass
    public void TC_03_Clean(){
        driver.quit();}
    }
