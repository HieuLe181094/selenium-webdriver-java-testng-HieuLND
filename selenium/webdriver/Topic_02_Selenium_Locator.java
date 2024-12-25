package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_Locator {


    WebDriver driver;

    String fullName = "Selenium locator";

    @BeforeClass
    public void initialBrowser() {
        //Mở Browser lên
        driver = new FirefoxDriver();

        // Mở app lên đến màn hình Login
        driver.get("https://demo.nopcommerce.com/register");
    }


@Test
    public void TC_01_ID()  {
        driver.findElement(By.id("small-searchterms"));

        driver.findElement(By.id("FirstName"));
    }


    @Test
    public void TC_02_Class()  {
        // Giá trị trong Class mà ko có khoảng trắng (lấy toàn bộ)
        // Giá trị trong Class mà có khoảng trắng (lấy 1 phần)
        driver.findElement(By.className("register-next-step-button")).click();
    }

    @Test
    public void TC_03_NAME(){
        driver.findElement(By.name("DateOfBirthDay"));
        driver.findElement(By.name("DateOfBirthMonth"));
        driver.findElement(By.name("DateOfBirthYear"));

    }

    @Test
    public void TC_04_LinkText(){
        //Chỉ làm việc với element là thẻ
        //The a và có thuộc tính là href
        //Phải lấy hết toàn bộ text ko chừa cái nào hết (tuyệt đối)
        driver.findElement(By.linkText("Register"));
        driver.findElement(By.linkText("Log in"));
        driver.findElement(By.linkText("Wishlist"));
    }

    @Test
    public void TC_05_PartialLinkText(){
        //Chỉ làm việc với element là link
        //Có thể lấy hết toàn bộ text hoặc 1 phần (hay dùng)
        driver.findElement(By.partialLinkText("Register"));
        driver.findElement(By.partialLinkText("Digital"));
        driver.findElement(By.partialLinkText("downloads"));

    }

    @Test
    public void TC_06_TagName(){
        // Tên thẻ (HTML)
        // Tìm tất cả các element giống nhau (thẻ của component giống nhau)
        // Tất cả các textbox/button/checkbox/radio/link/...
        driver.findElements(By.tagName("button"));
        driver.findElements(By.tagName("input"));
        driver.findElements(By.tagName("label"));

    }

    @Test
    public void TC_07_CSS(){
        driver.findElement(By.cssSelector("input#Company"));
        driver.findElement(By.cssSelector("#Company"));
        driver.findElement(By.cssSelector("input[id='Company']"));

        driver.findElement(By.cssSelector("button.register-next-step-button"));
        driver.findElement(By.cssSelector("button[class='button-1 register-next-step-button']"));

        driver.findElement(By.cssSelector("select[name='DateOfBirthDay']"));
        driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']"));
        driver.findElement(By.cssSelector("select[name='DateOfBirthYear']"));


        driver.findElement(By.cssSelector("a[href='/register?returnUrl=%2F']"));
        driver.findElement(By.cssSelector("a[href='/login?returnUrl=%2F']"));

        driver.findElement(By.cssSelector("a[href*='register?']"));
        driver.findElement(By.cssSelector("a[href*='login?']"));


        driver.findElement(By.cssSelector("a"));
        driver.findElement(By.cssSelector("button"));
        driver.findElement(By.cssSelector("label"));

    }

    @Test
    public void TC_08_XPATH(){
        driver.findElement(By.xpath("//input[@id='small-searchterms']"));
        driver.findElement(By.xpath("//input[@id='Company']"));
        driver.findElement(By.xpath("//input[@id='Password']"));

        driver.findElement(By.xpath("//button[@class='button-1 register-next-step-button']"));
        driver.findElement(By.xpath("//button[contains(@class,'register-next-step-button')]"));

        driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
        driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));
        driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));

        driver.findElement(By.xpath("//a[text()='Register']"));
        driver.findElement(By.xpath("//a[text()='Log in']"));
        driver.findElement(By.xpath("//a[text()='Sitemap']"));

        driver.findElement(By.xpath("//a[contains(text(),'Shipping')]"));
        driver.findElement(By.xpath("//a[contains(text(),'& returns')]"));

        driver.findElement(By.xpath("//a"));
        driver.findElement(By.xpath("//button"));
        driver.findElement(By.xpath("//input"));

    }

    @Test
    public void TC_09_Relative_locator() {
        driver.get("https://demo.nopcommerce.com/login");

        //Element/ By A
        By passwordTextboxBy = By.cssSelector("input#Password");
        WebElement passwordTextbox = driver.findElement(By.cssSelector("input#Password"));


        //Element/ By B
        By rememberMeCheckboxBy = By.id("RememberMe");

        //Element/ By C
        By forgotPasswordLinkBy = By.cssSelector("span.forgot-password");

        //Element/ By D
        By loginButtonBy = By.cssSelector("button.login-button");

        //Element/By E
        WebElement rememberMeLabelText = driver.findElement(RelativeLocator.with(By.tagName("label"))
                .above(loginButtonBy) //Label nằm trên Login button
                .below(passwordTextbox) //Label nằm dười Password Textbox
                .toRightOf(rememberMeCheckboxBy) // Label nằm bên trái so với RememberMe checkbox
                .toLeftOf(forgotPasswordLinkBy) // Label nằm bên trái so với Forgot Password link
                .near(rememberMeCheckboxBy)
                .near(forgotPasswordLinkBy)
        );

        driver.findElement(By.xpath(""));


        //input type="email" autocapitalize="none" autocorrect="off"
        // spellcheck="false" name="login[username]" value=""
        // id="email" class="input-text required-entry validate-email"
        // title="Email Address"


        //input[@type="email"]
        //input[@autocapitalize="none"]
        //input[@autocorrect="off"]
        //input[@spellcheck="false"]
        //input[@name="login[username]"]
        //input[@value=""]
        //input[@id="email"]
        //input[@class="input-text required-entry validate-email"]
        //input[@title="Email Address"]

        //1- Duy nhất
        //input[@id="email"]
        //input[@name="login[username]"]
        //input[@title="Email Address"]

        //2- Ưu tiên nếu có id/name/class thì dùng trước
        //input[@id="email"]
        //input[@name="login[username]"]

        //3- Ko có id/name/class: dùng bất kì 1 attribute khác

        //4- Giá trị của attribute phải có ý nghĩa - Liên quan tới cái element đó
        //input[@title="Email Address"]

        //=> Tối ưu nhất thì dùng

        //driver.findElement(By.cssSelector(By.id("email")));
        //driver.findElement(By.cssSelector(By.name("login[username]")));
        //driver.findElement(By.xpath("//input[@title='Email Address']"));

    };


    @AfterClass
    public void TC_03_Clean(){
        driver.quit();
    }


}

