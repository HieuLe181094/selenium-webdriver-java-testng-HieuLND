package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_22_Random_Popup {


    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }


    @Test
    public void TC_01_VNK_Edu() throws InterruptedException {
        driver.get("https://vnk.edu.vn/");
        Thread.sleep(30000);

        By marketingPopup = By.cssSelector("div#popmake-39268");

        // Hiển thị thì close đi rồi action tiếp
        if (driver.findElements(marketingPopup).size() > 0
        && driver.findElements(marketingPopup).get(0).isDisplayed()) {
            System.out.println("-------- GO TO IF -------------");
            driver.findElement(By.cssSelector("div#popmake-39268 button")).click();
            Thread.sleep(2000);
        }

        // Ko hiển thị thì action tiếp
        driver.findElement(By.xpath("//ul[@id='mega-menu-primary']//a[text()='Liên hệ']")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("div.title-content>h1")).isDisplayed());

    }

    @Test
    public void TC_02_Java_Code_Geeks() throws InterruptedException {
        driver.get("https://www.javacodegeeks.com/");

        By introProgramingPopup = By.xpath("//div[@data-type='rectangle' and contains(@style,'width:800px')]");

        // Hiển thị thì close đi rồi action tiếp
        if (driver.findElements(introProgramingPopup).size() > 0
        && driver.findElements(introProgramingPopup).get(0).isDisplayed()) {
            System.out.println("--------- GO TO IF -------");
            driver.findElement(By.xpath("//div[@data-type='html' and contains(@style,'width:auto')]//a[contains(@onclick,'lepopup_close')]"))
                    .click();
            Thread.sleep(2000);
        }

        // KO hiển thị thì action tiếp
        System.out.println("------- IGNORE IF --------");
        driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys("Agile");
        driver.findElement(By.cssSelector("form#search button")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("header>h1.page-title")).isDisplayed());

    }

    @Test
    public void TC_03_DeHieu() throws InterruptedException {
        driver.get("https://dehieu.vn/");

        By formPopup = By.xpath("//div[@class='modal-dialog modal-lg']");

        // Hiển thị thì close đi rồi action tiếp
        if (driver.findElements(formPopup).size() > 0
        && driver.findElements(formPopup).get(0).isDisplayed()){
            System.out.println("--------- GO TO IF -------");
            driver.findElement(By.xpath("//div[@class='modal-dialog modal-lg']//button[@class='close']")).click();
            Thread.sleep(3000);

            // Verify popup kocofn hiển thị
            Assert.assertFalse(driver.findElement(formPopup).isDisplayed());
        }

        // KO hiển thị thì action tiếp
        System.out.println("------- IGNORE IF --------");
        driver.findElement(By.cssSelector("input.search-form")).sendKeys("Khóa học lập trình PLC Siemens S7 – 1200");
        driver.findElement(By.cssSelector("button.header-search")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div.course-item-detail a")).getAttribute("title")
                , "Khóa học lập trình PLC Siemens S7 – 1200");

    }



    @AfterClass
    public void TC_04_Clean(){
        driver.quit();}
    }
