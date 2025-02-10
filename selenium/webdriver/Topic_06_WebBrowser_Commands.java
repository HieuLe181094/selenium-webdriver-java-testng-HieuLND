package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Topic_06_WebBrowser_Commands {


    WebDriver driver;

    @BeforeClass
    public void initialBrowser() throws MalformedURLException {
        // Run with browser (local)
           driver = new FirefoxDriver();
//        driver = new EdgeDriver();
//        driver = new ChromeDriver();
//        driver = new SafariDriver();
//        driver = new InternetExplorerDriver();

        // Remote (Grid/ Docker/ Cloud Testing)
        // Networking (LAN/ WAN/ IP/ Port)
//        ChromeOptions chromeOptions = new ChromeOptions();
//        driver = new RemoteWebDriver(new URL(""),chromeOptions);


    }

    @Test
    public void TC_01_() {
        // Mở ra 1 Url bất kì (lưu ý phải bắt đầu bằng http/ https)
        driver.get("https://demo.nopcommerce.com/");// **
        driver.get("");

        // Đóng browser (active tab/ window)
        driver.close();// *

        //Đóng browser (đóng bao gồm tất cả các tab/window)
        driver.quit();// **

        // 1 tab thì đóng giống nhau, còn 2 tab trở lên thì khác nhau

        // Lấy ra title của page hiện tại
        // 1- Lưu lại dữ liệu lại rồi kiểm tra sau
        String homePageTitle = driver.getTitle();
        Assert.assertEquals(homePageTitle,"nopCommerce demo store");
        Assert.assertTrue(homePageTitle.contains("demo store"));


        // 2- Kiểm tra trực tiếp
        // Kiểm tra tương đối
        Assert.assertEquals(driver.getTitle(),"nopCommerce demo store");

        // Lấy ra URL của page hiện tại
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/cart");

        // Lấy ra page source code
        String homePageSourceCode = driver.getPageSource();

        // Kiểm tra tương đối
        Assert.assertTrue(homePageSourceCode.contains("top-menu notmobile"));

        // Lấy ra ID của tab/window đang active
        driver.getWindowHandle();

        // Lấy ra tất cả ID của tất cả các tab/ window đang có
        driver.getWindowHandles();

        // Đi tìm 1 element
        driver.findElement(By.xpath(""));// **

        // Đi tìm n element
        driver.findElements(By.xpath(""));// **

        // Selenium ver 3
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.DAYS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.HOURS);

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.MICROSECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.NANOSECONDS);

        WebDriver.Timeouts Timeouts = driver.manage().timeouts();

        // Selenium ver 4
        // Dùng để chờ cho việc tìm element (findElement/ findElements)
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofHours(15));

        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));// **

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofNanos(15));

        // Dùng để chờ cho việc page được load xong
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));

        // Dùng để chờ cho 1 đoạn script được thực thi xong
        // JavascriptExcutor - js
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(15));

        WebDriver.Window Window = driver.manage().window();

        // Thu nhỏ về Taskbar để chạy
        Window.minimize();

        // Phóng tp lên (vẫn còn taskbar)
        Window.maximize();// *

        // Tràn màn hình (ko có taskber)
        Window.fullscreen();

        // Test GUI: Graphic User Interface
        // Font/ Color/ Sizre/ Position/ Location/..

        //Responsive
        driver.manage().window().setSize(new Dimension(1920,1080));
        //Dimension dimension = driver.manage().window().setSize();

        driver.manage().window().setPosition(new Point(0,0));
        Point point = driver.manage().window().getPosition();

        // Lấy hết tất cả cookies: Test Class 01 (Register tài khoản - lưu lại cookies)
        Set<Cookie> cookies = driver.manage().getCookies();// *

        driver.manage().getCookieNamed(".Nop.Antiforgery");

        // Xóa hết cookies
        //driver.manage().deleteAllCookies(".Nop.Antiforgery");

        for (Cookie cookie : cookies) {
            // Add cookies theo thứ tự
            driver.manage().addCookie(cookie);
        }
        //driver.manage().refresh();// Login thành công

        Logs log = driver.manage().logs();
        LogEntries logEntries = log.get("BROWSER");

        for (LogEntry logEn: logEntries) {
            System.out.println(logEn);
        }

        log.getAvailableLogTypes();

        WebDriver.Navigation navigation = driver.navigate();

        // Refresh/F5
        navigation.refresh();

        //Quay lại trang trước đó
        navigation.back();

        // Chuyển tiếp tới trang trước đó
        navigation.forward();

        // Mở Url bất kì
        navigation.to("https://demo.nopcommerce.com/customer/info");

        //Alert/ Iframe/ Window (Tab)
        WebDriver.TargetLocator targetLocator = driver.switchTo();

        // Alert
        targetLocator.alert().accept();;
        targetLocator.alert().dismiss();

        // Frame/ Iframe
        targetLocator.frame("");// *
        targetLocator.defaultContent();// *

        // Windows
        targetLocator.window("");

        // Lấy ra ID của tab/window đang active
        driver.getWindowHandle(); // *

        // Lấy ra tất cả ID của tất cả cá tab/ window đang có
        driver.getWindowHandles(); // *



        }


    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}



