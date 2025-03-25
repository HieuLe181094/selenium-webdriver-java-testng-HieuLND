package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class Topic_25_Upload {


    WebDriver driver;
    String uploadFolderPath = System.getProperty("user.dir") + File.separator + "\\UploadFiles\\";

    String body = "Body.jpg";
    String heart = "Heart.jpg";
    String intelligent = "Intelligent.jpg";

    String bodyPath = uploadFolderPath + body;
    String heartPath = uploadFolderPath + heart;
    String intelligentPath = uploadFolderPath + intelligent;


    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }


    @Test
    public void TC_01_Single_File() throws InterruptedException {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        By inputBy = By.xpath("//input[@type='file']");

        // Load lần lượt từng file lên
        driver.findElement(inputBy).sendKeys(bodyPath);
        Thread.sleep(3000);

        driver.findElement(inputBy).sendKeys(heartPath);
        Thread.sleep(3000);

        driver.findElement(inputBy).sendKeys(intelligentPath);
        Thread.sleep(3000);

        // Verify file được load lên
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='Body.jpg']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='Heart.jpg']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='Intelligent.jpg']")).isDisplayed());

        // Click upload cho từng file
        List<WebElement> startButtons = driver.findElements(By.cssSelector("table button.start"));

        for (WebElement startButton : startButtons){
            startButton.click();
            Thread.sleep(2000);
        }

        // Verify các file được upload thành công
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ body + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ heart + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ intelligent + "']")).isDisplayed());
    }

    @Test
    public void TC_02_Multiple_File() throws InterruptedException {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        By inputBy = By.xpath("//input[@type='file']");

        // Load file lên - 1 LẦN LOAD NHIỀU FILE
        driver.findElement(inputBy).sendKeys(bodyPath + "\n" + heartPath + "\n" + intelligentPath);
        Thread.sleep(3000);

        // Verify file được load lên
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='Body.jpg']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='Heart.jpg']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='Intelligent.jpg']")).isDisplayed());

        // Click upload cho từng file
        List<WebElement> startButtons = driver.findElements(By.cssSelector("table button.start"));

        for (WebElement startButton : startButtons){
            startButton.click();
            Thread.sleep(2000);
        }

        // Verify các file được upload thành công
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ body + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ heart + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ intelligent + "']")).isDisplayed());
    }



    @AfterClass
    public void TC_03_Clean(){
        driver.quit();}
    }
