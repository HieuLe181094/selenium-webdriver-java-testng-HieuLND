package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.print.DocFlavor;
import java.io.File;
import java.time.Duration;
import java.util.List;

public class Topic_31_Explicit_Ajax {
    WebDriver driver;
    WebDriverWait explicitWait;
    JavascriptExecutor jsExcutor;


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
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(30));
        JavascriptExecutor js = (JavascriptExecutor) driver;

    }


    @Test
    public void TC_01_Calender() {
        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");

        // VERify Calender element is displayed
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#ctl00_ContentPlaceholder1_Panel1"))).isDisplayed();

        // Wait and verify text
        Assert.assertTrue(explicitWait.until(ExpectedConditions.textToBe(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1"),"No Selected Dates to display.")));

        // Wait and click to element
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td/a[text()='5']"))).click();

        // Wait and verify ajax loading invisible
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[id$='RadCalendar1']>div.raDiv"))));

        // Wait and verify text
        Assert.assertTrue(explicitWait.until(ExpectedConditions.textToBe(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1"),"Saturday, April 5, 2025")));

    }

    @Test
    public void TC_02_GoFile() throws InterruptedException {
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://gofile.io/?t=uploadFiles");

        // Wait cho loading icon ở màn hình Upload ko còn hiển thị
        //Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("main#index_main>div>div"))));

        // Wait và click vào màn hình Upload
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/myfiles']/button"))).click();

        // Wait cho loading icon ở màn hình File Manager ko còn hiển thị
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#filemanager>div>div"))));

        // Load file lên màn hình Upload
        WebElement fileInput = driver.findElement(By.cssSelector("input[type='file']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.display = 'block';", fileInput);

        fileInput.sendKeys(bodyPath + "\n" + heartPath + "\n" + intelligentPath);
        Thread.sleep(2000);

        // Wait cho các progress bar của các file biên mất
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div.file-progressbar")))));

        // Wait cho loading icon ở màn hình upload file biến mất
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("main#index_main>div>div>div"))));

        // Verify các file được upload thành công
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ body + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ heart + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ intelligent + "']")).isDisplayed());

    }



    @AfterClass
    public void CleanBrowser(){
        driver.quit();}
    }
