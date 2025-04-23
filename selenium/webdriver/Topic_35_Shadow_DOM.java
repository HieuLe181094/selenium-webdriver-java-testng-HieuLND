package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_35_Shadow_DOM {


    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }


    @Test
    public void TC_01_() {
        driver.get("https://automationfc.github.io/shadow-dom/");

        // Thuộc DOM cha bên ngoài
        driver.findElement(By.xpath("//a[text()='scroll.html']"));

        // Element chứa cha Shadow host thứ 1
        WebElement shadowHostParent = driver.findElement(By.cssSelector("div#shadow_host"));

        // Lấy ra Element Shadow Root
        SearchContext firstShadow = shadowHostParent.getShadowRoot();

        Assert.assertTrue(firstShadow.findElement(By.cssSelector("input[type='file']")).isDisplayed());

        Assert.assertEquals(firstShadow.findElement(By.cssSelector("span.info")).getText(),"some text");

        // Element cha chứa Shadow Host thứ 2
        WebElement firstShadowHostParent = firstShadow.findElement(By.cssSelector("div#nested_shadow_host"));

        // Lấy ra Element Shadow Root
        SearchContext secondShadow = firstShadowHostParent.getShadowRoot();

        Assert.assertEquals(secondShadow.findElement(By.cssSelector("div#nested_shadow_content>div")).getText(),"nested text");

        Assert.assertTrue(firstShadow.findElement(By.cssSelector("a[href ='scroll.html']")).isDisplayed());

        driver.findElement(By.xpath("//a[text()='scroll.html']"));

    }

    @Test
    public void TC_02_() throws InterruptedException {
        driver.get("https://books-pwakit.appspot.com/");
        Thread.sleep(5000);

        WebElement firstShadowParent = driver.findElement(By.cssSelector("book-app"));
        SearchContext firstShadowHost = firstShadowParent.getShadowRoot();

        WebElement secondShadowHostElement = firstShadowHost.findElement(By.cssSelector("book-input-decorator"));
        SearchContext secondShadowHost = secondShadowHostElement.getShadowRoot();

        firstShadowHost.findElement(By.cssSelector("input#input")).sendKeys("Harry Porter");
        Thread.sleep(2000);

        secondShadowHost.findElement(By.cssSelector("div.icon")).click();
        Thread.sleep(3000);

        WebElement thirdShadowElement = firstShadowHost.findElement(By.cssSelector("book-explore"));
        SearchContext thirdShadowHost = thirdShadowElement.getShadowRoot();

        WebElement fourthShadowElement = thirdShadowHost.findElement(By.cssSelector("ul>li:nth-of-type(1)>book-item"));
        SearchContext fourthShadowHost = fourthShadowElement.getShadowRoot();

        Assert.assertEquals(fourthShadowHost.findElement(By.cssSelector("h2.title")).getText(),"The Ultimate Harry Potter and Philosophy");

    }



    @AfterClass
    public void CleanBrowser(){
        driver.quit();}
    }
