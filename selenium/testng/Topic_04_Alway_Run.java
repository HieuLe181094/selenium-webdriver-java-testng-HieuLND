package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Topic_04_Alway_Run {
    WebDriver driver;

    @Test
    public void TC_01(){
        driver = new FirefoxDriver();
        driver.get("https://www.fahasa.com/");

        // Mở đến trang login
        // Login thành ông
        // => không thành công => Fail ở step này
        Assert.assertTrue(false);
    }

    @Test
    public void TC_02(){System.out.println("Run TC 02");}

    @Test
    public void TC_03(){System.out.println("Run TC 03");}

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        driver.quit();
    }
}
