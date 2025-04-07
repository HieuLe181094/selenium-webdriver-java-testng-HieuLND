package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_26_Wait_Element_Status {


    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));


    }


    @Test
    public void TC_01_Visible() {
        driver.get("https://www.facebook.com/");

        // 1 - Element có trên UI và có trong cây HTML
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")));


    }

    @Test
    public void TC_02_Invisible() {
        driver.get("https://ngoaingu24h.vn/");

        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();

        // Wait cho Email textbox được visible
        explicitWait.until((ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[autocomplete='username']"))));

        // 2 - Element ko có trên UI nhưng vẫn có trong cây HTML
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//input[@autocomplete='username']/parent::div/following-sibling::div[@class='auth-error-msg']")));

        driver.findElement(By.xpath("//button[contains(@class,'close-btn css-100vahc')]")).click();

        // 3 - Element ko có trên UI và ko có trong HTML
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//input[@autocomplete='username']/parent::div/following-sibling::div[@class='auth-error-msg']")));


    }

    @Test
    public void TC_03_Presence() {
//        driver.get("https://ngoaingu24h.vn/");
//
//        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
//
//        // Wait cho Email textbox được visible
//        explicitWait.until((ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[autocomplete='username']"))));
//
//        // Điều kiện mới để cho Error Message được xuất hiện có trên UI
//        driver.findElement(By.cssSelector("div.MuiPaper-root button[type='submit']")).click();
//
//        // 1 - Element có trên UI và có trong HTML
//        explicitWait.until(ExpectedConditions.presenceOfElementLocated(
//                By.xpath("//input[@autocomplete='username']/parent::div/following-sibling::div[@class='auth-error-msg']")));
//
//        // Điều kiện mồi để cho Email Error Message ko còn xuất hiện trên UI
//        driver.findElement(By.cssSelector("input[autocomplete='username")).sendKeys("aaa");
//
//        // 2 - Element ko có trên UI nhưng vẫn có trong cây HTML
//        explicitWait.until(ExpectedConditions.presenceOfElementLocated(
//                By.xpath("//input[@autocomplete='username']/parent::div/following-sibling::div[@class='auth-error-msg']")));

    }

    @Test
    public void TC_04_Staleness() {
        driver.get("https://ngoaingu24h.vn/");

        // Click để mở pop-up ra
        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();

        // Wait cho Email textbox được visible
        explicitWait.until((ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[autocomplete='username']"))));

        // Điều kiện mới để cho Error Message được xuất hiện có trên UI
        driver.findElement(By.cssSelector("div.MuiPaper-root button[type='submit']")).click();

        // Tại thời điểm này confirm Email Error Message đang có trong HTML
        WebElement emailErrorMessage = driver.findElement(By.xpath("//input[@autocomplete='username']/parent::div/following-sibling::div[@class='auth-error-msg']"));

        // Click đóng pop-up lại
        driver.findElement(By.cssSelector("input[autocomplete='username")).sendKeys("aaa");

        // Element ko có trên UI và ko có trong HTML
        explicitWait.until(ExpectedConditions.stalenessOf(emailErrorMessage));


    }



    @AfterClass
    public void TC_Clean(){
        driver.quit();}
    }
