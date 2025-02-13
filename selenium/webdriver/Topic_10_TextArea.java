package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.print.DocFlavor;
import java.util.Random;

public class Topic_10_TextArea {
    WebDriver driver;

    String firstName, lastName, emailAddress, passWord, fullName;

    Random rand;



    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        rand = new Random();

        firstName = "hiu";
        lastName = "bin";
        fullName = firstName + " " + lastName;
        emailAddress = "hiubin"+ rand.nextInt(9999) + "@gmai.com";
        passWord = "123456";


    }

    @Test
    public void TC_01_TechPanda() throws InterruptedException {
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();

        driver.findElement(By.cssSelector("a[title='Create an Account']")).click();

        driver.findElement(By.cssSelector("input#firstname")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input#lastname")).sendKeys(lastName);
        driver.findElement(By.cssSelector("input#email_address")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#password")).sendKeys(passWord);
        driver.findElement(By.cssSelector("input#confirmation")).sendKeys(passWord);

        driver.findElement(By.cssSelector("button[title='Register']")).click();



        // Tuyệt đối
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),
                "Thank you for registering with Main Website Store.");


        String contactInformationText = driver.findElement(By.xpath(
                "//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();

        // Tương đối
        Assert.assertTrue(contactInformationText.contains(fullName) && contactInformationText.contains(emailAddress)); //Full name + Email

        driver.findElement(By.xpath("//h3[text()='Contact Information']/following-sibling::a")).click();

        Assert.assertEquals(driver.findElement(By.id("firstname")).getAttribute("value"),firstName);
        Assert.assertEquals(driver.findElement(By.id("lastname")).getAttribute("value"),lastName);
        Assert.assertEquals(driver.findElement(By.id("email")).getAttribute("value"),emailAddress);

        // Product Review
        driver.findElement(By.xpath("//a[text()='Mobile']")).click();

        driver.findElement(By.xpath("//a[text()='Samsung Galaxy']")).click();

        driver.findElement(By.xpath("//a[text()='Add Your Review']")).click();

        driver.findElement(By.xpath("//input[@id='Quality 1_5']")).click();

        driver.findElement(By.cssSelector("textarea#review_field")).sendKeys("Good application\n" +
                "Pretty easy to navigate. ");

        driver.findElement(By.cssSelector("input#summary_field")).sendKeys("Good");

        driver.findElement(By.cssSelector("input#nickname_field")).clear();
        driver.findElement(By.cssSelector("input#nickname_field")).sendKeys("hiubinbong");

        driver.findElement(By.xpath("//button[@title='Submit Review']")).click();


        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),
                "Your review has been accepted for moderation.");


        // Log out
        driver.findElement(By.cssSelector("div.account-cart-wrapper>a")).click();

        driver.findElement(By.xpath("//a[@title='Log Out']")).click();

        Thread.sleep(6000);

        Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/");





    }

    @Test
    public void TC_02_() {

    }



    @AfterClass
    public void TC_03_Clean(){
        driver.quit();}
    }
