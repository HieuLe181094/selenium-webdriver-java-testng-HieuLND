package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_00_Template {

    //1 - Setup: OS/ Browser/ Web/ Page/ Data/ Variable/ Object/,,
    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    //2 - Action/ Execute: Tương tác lên element nào/nhập liệu/verify/…
    @Test
    public void TC_01_() {

    }

    @Test
    public void TC_02_() {

    }

    //3- Clean: delete data test/ account/ close browser/…

    @AfterClass
    public void CleanBrowser(){
        driver.quit();}
    }
