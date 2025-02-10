package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.security.Key;

public class Topic_07_WebElement_Commands {
    // Chứa các hàm để tương tác với Browser

    WebDriver driver;

    WebElement element;


    @BeforeClass
    public void initialBrowser() throws MalformedURLException {
        driver = new FirefoxDriver();
    }

    @Test
    public void TC_01_() {
    // Dùng 1 lần
    driver.findElement(By.xpath("")).click(); //**

    element = driver.findElement(By.xpath(""));

        // Click vào các element dạng: button/ checkbox/ radio/ link/ image/ icon/ ...
        element.click();

        // Nhập liệu các element dạng: textbox/ textarea/ dropdown (edit)
        element.clear(); // Xóa dữ liệu trước khi sendkey //*
        element.sendKeys("lehieu@gmail.com"); //**
        element.sendKeys(Keys.ENTER);

        driver.findElement(By.cssSelector("div.login-page"))
                .findElement(By.cssSelector("div.customer-blocks"))
                .findElement(By.cssSelector("Email")); //**

        driver.findElement(By.cssSelector("div.login-page div.customer-blocks input#Email"));

        // Tác dụng với form (SignUp/ Login/ Search/...)
        // thẻ form
        driver.findElement(By.id("")).sendKeys("Email");
        driver.findElement(By.id("Password")).sendKeys("");
        driver.findElement(By.id("Password")).submit();

        // Ap dụng cho tất cả các loại element
        // Kiểm tra 1 element có hiển thị hay không
        // Size > 0: width/ height >0
        // Nhìn thấy/ thao tác đc
        element.isDisplayed(); //**

        Assert.assertTrue(element.isDisplayed());
        Assert.assertFalse(element.isDisplayed());

        // Ap dụng cho duy nhất 3 loại: checkbox/ radio/ dropdown (default)
        // Kiểm tra 1 element đã được chọn hay chưa
        element.isSelected(); //*

        // Ap dụng cho tất cả các loại
        // Kiểm tra 1 element có bị disable hay ko (read-only)
        element.isEnabled();

        element.getCssValue("background-color");//*
        //#4ab2f1

        // GUI: Font/ size/ Color/ Position/ Location/...
        element.getCssValue("font-size");
        //15px

        // Ap dụng cho element chứa text (Link/ Button/ Header/ Label..)
        element.getText();//**

        element.getAttribute("placeholder");//**
        // Search store
        Dimension dimensionBrowser = driver.manage().window().getSize();

        //Dimension dimension = driver.manage().window().setSize();

        // Chiều rộng/ chiều cao của element?
        Dimension dimensionElement = element.getSize();

        Point pointBrowser = driver.manage().window().getPosition();
        // Vị trí của element so với viewpoint
        Point pointElement = element.getLocation();

        Rectangle rectangle = element.getRect();

        // Size
        rectangle.getHeight();
        rectangle.getWidth();
        rectangle.getDimension();

        // Location
        rectangle.getX();
        rectangle.getY();
        rectangle.getPoint();

        // Lấy ra cái thẻ HTML của element đó
        // Element A
        String tagname = driver.findElement(By.cssSelector("FirstName")).getTagName();

        // Element B
        driver.findElement(By.xpath("//" + tagname + "[id@='LastName']"));

        element.getAccessibleName();

        element.getAriaRole();

        //element.getDomAttribute();

       // element.getDomProperty();//*

        // Pop-up
        element.getShadowRoot();//**

        // Framework: HTML report
        element.getScreenshotAs(OutputType.FILE);//*
        element.getScreenshotAs(OutputType.BYTES);
        element.getScreenshotAs(OutputType.BASE64);//*

        ;

    }

    }
