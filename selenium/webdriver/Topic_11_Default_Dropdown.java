package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.print.DocFlavor;
import java.util.List;
import java.util.Random;

public class Topic_11_Default_Dropdown {

    WebDriver driver;

    Select select;
    // Nhận driver làm tham số

    String firstName, lastName, email, companyName, password;

    Random rand;



    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        rand = new Random();

        firstName = "Candy";
        lastName = "Dran";
        email = "cdran0" + rand.nextInt(9999) + "@gmail.com";
        companyName = "ARhealthy";
        password = "1234456";

    }

    @Test
    public void TC_01_Facebook_SingUp() {
        driver.get("https://www.facebook.com/reg/");
        // Dropdown xuất hiện
        select = new Select(driver.findElement(By.cssSelector("select#day")));

        // Chọn 1 item
        select.selectByVisibleText("15");

        // Chọn xong verify đã chọn thành công hay chưa?
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"15");

        // Verify cái dropdown có phải là multiple select hay ko?
        // Nếu multiple -> trả về là true
        // Nếu là single -> trả về là false
        Assert.assertFalse(select.isMultiple());

        // Verify xem tổng số lượng item trong dropdown này la bao nhiêu?
        Assert.assertEquals(select.getOptions().size(),31);

        select = new Select(driver.findElement(By.cssSelector("select#month")));
        select.selectByVisibleText("Feb");
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Feb");

        select = new Select(driver.findElement(By.cssSelector("select#year")));
        select.selectByVisibleText("2025");
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"2025");
    }

    @Test
    public void TC_02_NopComerce() throws InterruptedException {
        driver.get("https://demo.nopcommerce.com/");

        driver.findElement(By.xpath("//div[@class='header-links']//a[@class='ico-register']")).click();

       // driver.findElement(By.cssSelector("input#gender-female")).click();

        driver.findElement(By.cssSelector("input#FirstName")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input#LastName")).sendKeys(lastName);
        driver.findElement(By.cssSelector("input#Email")).sendKeys(email);
        driver.findElement(By.cssSelector("input#Company")).sendKeys(companyName);
        driver.findElement(By.cssSelector("input#Password")).sendKeys(password);
        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys(password);

        driver.findElement(By.cssSelector("button#register-button")).click();;

        Assert.assertEquals(driver.findElement(By.cssSelector("div.registration-result-page div.result")).getText(),
                "Your registration completed");

        driver.findElement(By.xpath("//a[@class='ico-account']")).click();

        driver.findElement(By.cssSelector("input#Email")).sendKeys(email);
        driver.findElement(By.cssSelector("input#Password")).sendKeys(password);
        driver.findElement(By.cssSelector("button.login-button")).click();

        driver.findElement(By.cssSelector("a.ico-account")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("input#FirstName")).getAttribute("value"),"");
        Assert.assertEquals(driver.findElement(By.cssSelector("input#LastName")).getAttribute("value"),"");
        Assert.assertEquals(driver.findElement(By.cssSelector("input#Email")).getAttribute("value"),"");
        Assert.assertEquals(driver.findElement(By.cssSelector("input#Company")).getAttribute("value"),"");
        Thread.sleep(6000);

    }
    @Test
    public void TC_03_Rode() throws InterruptedException {
        driver.get("https://rode.com/en/support/where-to-buy");

        new Select(driver.findElement(By.cssSelector("select#country"))).selectByVisibleText("Vietnam");
        driver.findElement(By.cssSelector("input#map_search_query")).sendKeys("HO CHI MINH");
        driver.findElement(By.cssSelector("button.btn-default")).click();

        List <WebElement> dealers = driver.findElements(By.xpath("//h3[text()='Dealers']/following-sibling::div//h4"));
        Assert.assertEquals(dealers.size(),16);

        for(WebElement element: dealers){
            System.out.println(element.getText());
        }
        Thread.sleep(6000);
    }



    @AfterClass
    public void cleanBrowser(){
        driver.quit();}
    }



