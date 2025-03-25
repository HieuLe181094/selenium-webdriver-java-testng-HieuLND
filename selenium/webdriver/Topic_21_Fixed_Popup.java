package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_21_Fixed_Popup {


    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }


    @Test
    public void TC_01_NgoaiNgu24h() throws InterruptedException {
        driver.get("https://ngoaingu24h.vn/");

        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();

        By loginPopup = By.cssSelector("div.MuiPaper-root");

        // Kiểm tra 1 element hiển thị trong HTML
        // Kiểm tra trên UI -> True
        // Ko hiển thị trên UI -> False
        Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());

        driver.findElement(By.xpath("//input[@autocomplete='username']")).sendKeys("automationfc");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//div[@role='dialog']//button[@type='submit']")).click();
        Thread.sleep(5000);

//        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'SnackbarItem-message')]"))
//                .getText(),"Bạn đã nhập sai tài khoản hoặc mật khẩu");

        driver.findElement(By.xpath("//button[contains(@class,'close-btn css-100vahc')]")).click();
        Thread.sleep(3000);

//        Assert.assertFalse(driver.findElement(loginPopup).isDisplayed());

    }

    @Test
    public void TC_02_Kyna() throws InterruptedException {
        driver.get("https://skills.kynaenglish.vn/dang-nhap");

        By loginPopup = By.cssSelector("div.k-popup-account-mb-content");

        Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());

        driver.findElement(By.cssSelector("input#user-login")).sendKeys("automation2gmail.com");
        driver.findElement(By.cssSelector("input#user-password")).sendKeys("123456");
        driver.findElement(By.cssSelector("button#btn-submit-login")).click();
        Thread.sleep(3000);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#password-form-login-message")).getText(),"Sai tên đăng nhập hoặc mật khẩu");

    }

    @Test
    public void TC_03_Tiki() throws InterruptedException {
        driver.get("https://tiki.vn/");
        Thread.sleep(3000);

        // Popup 01 - Marketing
        // Hiển thị cố định khi vừa mở site ra
        // Khi đóng lại thì không còn trong trang HTML nữa
        // Khi refesh page thì lại hiện ra
        // By marketingPopup = By.cssSelector("div#VIP_BUNDLE");

        // Kiểm tra hiển thị => hiển thị cố định khi vừa mở site ra
        // Assert.assertTrue(driver.findElement(marketingPopup).isDisplayed());

        // driver.findElement(By.cssSelector("div#VIP_BUNDLE img[alt='close-icon']")).click();
        //Thread.sleep(3000);

        // Kiểm tra ko hiển thị => Khi đóng lại thì ko còn trong HTML nữa
        // Vì element ko có trong HTML nên hàm findelement sẽ ko tìm thấy => đánh fail ngay step này
        // Assert.assertFalse(driver.findElement(marketingPopup).isDisplayed());

        driver.findElement(By.cssSelector("div[data-view-id='header_header_account_container']")).click();
        Thread.sleep(3000);

        // Popup hiển thị

        By loginPopup = By.cssSelector("div.ReactModal__Content");
        Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());


        driver.findElement(By.cssSelector("p.login-with-email")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='email']/parent::div/following-sibling::span[1]"))
                .getText(),"Email không được để trống");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='email']/parent::div/following-sibling::span[2]"))
                .getText(),"Mật khẩu không được để trống");
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("div.ReactModal__Content button.btn-close")).click();
        Thread.sleep(2000);

        // Popup ko hiển thị (ko còn trong DOM/HTML)
        Assert.assertEquals(driver.findElements(loginPopup).size(),0);



    }

    @Test
    public void TC_04_Facebook() throws InterruptedException {
        driver.get("https://www.facebook.com/");

        // findElement -> click()
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
        Thread.sleep(3000);

        // Thay đổi UX -> Ko có show pop-up nhưng dẫn đến 1 đường link khác
        Assert.assertTrue(driver.findElement(By.cssSelector("div._52lo")).isDisplayed());

        // Thay đổi UI -> Ko có close button

    }




    @AfterClass
    public void TC_03_Clean(){
        driver.quit();}
    }
