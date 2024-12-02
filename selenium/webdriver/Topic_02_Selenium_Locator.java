package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_Locator {


    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        //Mở Browser lên
        driver = new FirefoxDriver();

        // Mở app lên đến màn hình Login
        driver.get("https://demo.nopcommerce.com/");
    }


@Test
    public void TC_01_() {
        //Tương tác lên Email Address textbox
    //<input class="email" autofocus="" type="email" data-val="true"
    // data-val-regex="Wrong email"
    // data-val-regex-pattern="^(([^<>()\[\]\\.,;:\s@&quot;]+(\.[^<>()\[\]\\.,;:\s@&quot;]+)*)|(&quot;.+&quot;))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$"
    // data-val-required="Please enter your email"
    // id="Email" name="Email">

    //HTML Source code
    //Thẻ - Thuộc tính - gía trị thuộc tính
    //Tagname - Attribute - Value


    //  Xpath:  //tagname[@attribute='value']
    //  Css:  tagname[attribute='value']

    // Tương tác lên Email address textbox
    // 8 loaijn locator
    driver.findElement(By.id(""));
    }

@Test
    public void TC_02_() {

    }



    @AfterClass
    public void TC_03_Clean(){
        driver.quit();}
    }
