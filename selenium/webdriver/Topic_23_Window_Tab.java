package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Topic_23_Window_Tab {


    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }


    @Test
    public void TC_01_Github() throws InterruptedException {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        // Lấy ra ID của tab/window mà driver đang active tại page đó
        String githubWindowID = driver.getWindowHandle();

        // Click vào Google link -> nó sẽ bật lên 1 tab mới và tự nhảy qua
        // Nhưng về code Selenium là driver ko tự nhảy qua - nó vẫn ở tab cũ
        driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
        Thread.sleep(2000);

        // Switch qua tab Google
        switchToWindowByID(githubWindowID);
        Thread.sleep(2000);

        String googleWindowID = driver.getWindowHandle();

        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("Selenium Webdriver");
        Thread.sleep(2000);

        // Switch về tab Github
        switchToWindowByID(googleWindowID);

        // Click vào Facebook link  -> nó sẽ bật lên 1 tab mới và tự nhảy qua
        driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
        Thread.sleep(2000);

        switchWindowByTitle("Facebook – log in or sign up");

        // Quay về Github
        switchWindowByTitle("Selenium WebDriver");
        Thread.sleep(2000);
        System.out.println(driver.getTitle());

        // Click vào TIKI link -> nó sẽ bật lên 1 cửa sổ rồi tự nhảy qua
        driver.findElement(By.xpath("//a[text()='TIKI']")).click();
        Thread.sleep(2000);

         // Switch qua TIKI
        switchWindowByTitle("Tiki - Mua hàng online giá tốt, hàng chuẩn, ship nhanh");
        Thread.sleep(2000);

        closeAllWindowWithoutParent(githubWindowID);

        // Sau khi chạy hết thì đóng hết các tab/window ngoại trừ Github
        // Driver nó đang active/ đứng ở window/tab nào ??

    }

    @Test
    public void TC_02_TechPanda() throws InterruptedException {
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        Thread.sleep(2000);

        // Click to Add to Compare button at Sony Xperia
        driver.findElement(By.xpath("//a[text()='Sony Xperia']/parent::h2/following-sibling::div[@class='actions']//a[@class='link-compare']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText()
                ,"The product Sony Xperia has been added to comparison list.");
        Thread.sleep(2000);

        // Click to Add to Compare button at SamSung Galxy
        driver.findElement(By.xpath("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']//a[@class='link-compare']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText()
                ,"The product Samsung Galaxy has been added to comparison list.");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@title='Compare']")).click();
        Thread.sleep(2000);

        switchWindowByTitle("Products Comparison List - Magento Commerce");
        Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/catalog/product_compare/index/");

        driver.findElement(By.xpath("//button[@title='Close Window']")).click();
        Thread.sleep(3000);

        switchWindowByTitle("Mobile");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[text()='Clear All']")).click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.switchTo().alert().getText()
                ,"Are you sure you would like to remove all products from your comparison?");
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText()
                ,"The comparison list was cleared.");


    }

    @Test
    public void TC_03_Cambridge() throws InterruptedException {
        driver.get("https://dictionary.cambridge.org/vi/");

        driver.findElement(By.xpath("//div[@class='hdn hdib-s']//div[@amp-access='NOT loggedIn']")).click();
        Thread.sleep(2000);

        switchWindowByTitle("Login");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@value='Log in']")).click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='username']/following-sibling::span[text()='This field is required']"))
                .getText(),"This field is required");
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='password']~span.gigya-error-msg-active"))
                .getText(),"This field is required");
        Thread.sleep(3000);

        driver.close();

        switchWindowByTitle("Cambridge Dictionary | Từ điển tiếng Anh, Bản dịch & Từ điển từ đồng nghĩa");
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("input#searchword")).sendKeys("code");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@title='Tìm kiếm']")).click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#cald4-1 ~div span.headword span")).getText(),"code");
        Thread.sleep(2000);
    }

    @Test
    public void TC_04_Selenium_4x() throws InterruptedException {
        driver.get("http://live.techpanda.org/");

        // Hành vi này giống như Business/ End User
        // Khi nhảy qua tab mới thì nó tự switch luôn

        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        Thread.sleep(2000);

        System.out.println("Driver ID = " + driver.toString());
        System.out.println("Window ID = " + driver.getWindowHandle());
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.switchTo().newWindow(WindowType.TAB).get("http://live.techpanda.org/index.php/customer/account/login/");
        Thread.sleep(2000);

        System.out.println("Driver ID = " + driver.toString());
        System.out.println("Window ID = " + driver.getWindowHandle());
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.findElement(By.cssSelector("button#send2")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-email")).getText(),
                "This is a required field.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-pass")).getText(),
                "This is a required field.");


        switchWindowByTitle("Mobile");
        Thread.sleep(3000);


    }

    @Test
    public void TC_05_Harvard() throws InterruptedException {
        driver.get("https://courses.dce.harvard.edu/");

        driver.findElement(By.cssSelector("a[data-action='login']")).click();
        Thread.sleep(2000);
//        System.out.println("Driver ID = " + driver.toString());
//        System.out.println("Window ID = " + driver.getWindowHandle());
//        System.out.println(driver.getTitle());
//        System.out.println(driver.getCurrentUrl());

        switchWindowByTitle("Harvard Division of Continuing Education Login Portal");
        Thread.sleep(3000);



    }


    private void closeAllWindowWithoutParent(String githubWindowID) throws InterruptedException {
        // Lấy hết toàn bộ ID của window/tab
        Set<String> allWindowIDs = driver.getWindowHandles();

        // Dùng vùng lặp duyệt qua từng ID
        for (String id : allWindowIDs) {
            if (!id.equals(githubWindowID)){
                driver.switchTo().window(id);
                Thread.sleep(2000);
                driver.close();
            }
        }
        // Switch vào window duy nhất còn lại
        driver.switchTo().window(githubWindowID);
    }

    private void switchWindowByTitle(String expectedPageTitle) throws InterruptedException {
        // Lấy hết toàn bộ ID của window/tab
        Set<String> allWindowIDs = driver.getWindowHandles();

        // Dùng vùng lặp duyệt qua từng ID
        for (String id : allWindowIDs) {
            // Mỗi lần duyệt sẽ cho nó switch vào trước
            driver.switchTo().window(id);
            Thread.sleep(2000);

            // Get ra Title của window/tab hiện tại
            String pageTitle = driver.getTitle();

            // Kiểm tra title
            if (pageTitle.equals(expectedPageTitle)){
                break;
            }
        }
    }

    // Chỉ đúng với 2 Tab/window
    private void switchToWindowByID(String windowID) {
        // Lấy ra hết tất cả ID của window/tab hiện tại
        Set<String> allWindowIDs = driver.getWindowHandles();

        // Dùng vòng lặp để duyệt qua từng ID môt
        for (String id: allWindowIDs) {
            // Kiểm tra điều kiện: nếu mà ID nào khác với ID mong đợi thì switch qua
            if (!id.equals(windowID)){
                driver.switchTo().window(id);
            }
        }
    }

    @Test
    public void TC_02_() {

    }



    @AfterClass
    public void TC_03_Clean(){
        driver.quit();}
    }
