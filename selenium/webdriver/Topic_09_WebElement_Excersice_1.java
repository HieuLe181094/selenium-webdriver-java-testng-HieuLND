package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.security.Key;

public class Topic_09_WebElement_Excersice_1 {


    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();


    }

    @Test
    public void TC_01_Displayed() {
        // isDisplayed: Kiểm tra bất kì 1 element nào hiển thị
        // Hiển thị: có thể nhìn thấy - co kích thước cụ thể
        driver.get("https://automationfc.github.io/basic-form/index.html");

        WebElement emailTextbox = driver.findElement(By.cssSelector("input#email"));

        if(emailTextbox.isDisplayed()) {
            System.out.println("Email Textbox is displayed");
            emailTextbox.sendKeys("Automation Testing");
        } else {
            System.out.println("Email Textbox is not displayed");
        }

        WebElement ageUnder18Radio = driver.findElement(By.cssSelector("input#under_18"));

        if(ageUnder18Radio.isDisplayed()){
            System.out.println("Age Under 18 is displayed");
            ageUnder18Radio.click();
        } else {
            System.out.println("Age Under 18 is not displayed");
        }

        WebElement educationTextarea = driver.findElement(By.cssSelector("textarea#edu"));

        if(educationTextarea.isDisplayed()) {
            System.out.println("Education Textarea is displayed");
            educationTextarea.sendKeys("Automation Testing");
        } else {
            System.out.println("Education Textarea is not displayed");
        }

        WebElement user5Text = driver.findElement(By.xpath("//h5[text()='Name: User5']"));

        if(user5Text.isDisplayed()) {
            System.out.println("User 05 is displayed");
        } else {
            System.out.println("User 05 is not displayed");
        }

    }
    @Test
    public void TC_02_Enable() {
        // isDisplayed: Kiểm tra bất kì 1 element nào co thể tương tác lên được # ngược lại với read-only
        // Hiển thị: có thể nhìn thấy - co kích thước cụ thể
        driver.get("https://automationfc.github.io/basic-form/index.html");

        WebElement emailTextbox = driver.findElement(By.cssSelector("input#email"));

        if(emailTextbox.isEnabled()) {
            System.out.println("Email Textbox is enable");
        } else {
            System.out.println("Email Textbox is disable");
        }

        WebElement ageUnder18Radio = driver.findElement(By.cssSelector("input#under_18"));

        if(ageUnder18Radio.isEnabled()){
            System.out.println("Age Under 18 is enable");
        } else {
            System.out.println("Age Under 18 is disable");
        }

        WebElement jobRole1Dropdown = driver.findElement(By.cssSelector("select#job1"));

        if(jobRole1Dropdown.isEnabled()){
            System.out.println("Job Role 01 Dropdown is enable");
        } else {
            System.out.println("Job Role 01 Dropdown is disable");
        }

        WebElement jobRole2Dropdown = driver.findElement(By.cssSelector("select#job2"));

        if(jobRole2Dropdown.isEnabled()){
            System.out.println("Job Role 2 Dropdown is enable");
        } else {
            System.out.println("Job Role 2 Dropdown is disable");
        }

        WebElement interestsDevelopmentcheckbox = driver.findElement(By.cssSelector("input#development"));

        if(interestsDevelopmentcheckbox.isEnabled()){
            System.out.println("Interests Devolopment Checkbox is enable");
        } else {
            System.out.println("Interests Devolopment Checkbox is disable");
        }

        WebElement slider1 = driver.findElement(By.cssSelector("input#slider-1"));
        
        if (slider1.isEnabled()) {
            System.out.println("Slider 1 is enable");
        } else {
            System.out.println("Slider 1 is disable");
        }

        WebElement passwordTexbox = driver.findElement(By.cssSelector("input#disable_password"));

        if (passwordTexbox.isEnabled()) {
            System.out.println("Password Textbox is enable");
        } else {
            System.out.println("Password Textbox is disable");
        }

        WebElement radioButtonisdisabledcheckbox = driver.findElement(By.cssSelector("input#radio-disabled"));

        if (radioButtonisdisabledcheckbox.isEnabled()) {
            System.out.println("Age (Radiobutton is disable) checkbox is enable");
        } else {
            System.out.println("Age (Radiobutton is disable) checkbox is disable");
        }

        WebElement biographyTextarea = driver.findElement(By.cssSelector("textarea#bio"));

        if (biographyTextarea.isEnabled()){
            System.out.println("Biography Textarea is enable");
        } else {
            System.out.println("Biography Textarea is disable");
        }

        WebElement jobRole3Dropdown = driver.findElement(By.cssSelector("select#job3"));

        if (jobRole3Dropdown.isEnabled()){
            System.out.println("Job Role 3 Dropdown is enable");
        } else {
            System.out.println("Job Role 3 Dropdown is disable");
        }

        WebElement interestsCheckboxisdisable = driver.findElement(By.cssSelector("input#check-disbaled"));

        if (interestsCheckboxisdisable.isEnabled()){
            System.out.println("Interests (Checkbox is disable) is enable");
        } else {
            System.out.println("Interests (Checkbox is disable) is disable");
        }

        WebElement slider2 = driver.findElement(By.cssSelector("input#slider-2"));

        if (slider2.isEnabled()){
            System.out.println("Slider 2 is enable");
        } else {
            System.out.println("Slider 2 is disable");
        }

    }

    @Test
    public void TC_03_Selected() {
        // Kiểm tra 1 element đã được chọn thành công (Radio/ Checkbox/ Dropdown)
        driver.get("https://automationfc.github.io/basic-form/index.html");

        WebElement ageUnder18Radio = driver.findElement(By.cssSelector("input#under_18"));
        ageUnder18Radio.isEnabled();

        if (ageUnder18Radio.isSelected()) {
            System.out.println("Under 18 Radio is selected");
        } else {
            System.out.println("Under 18 Radio is de-selected ");
        }

        WebElement languagesJavaCheckbox = driver.findElement(By.cssSelector("input#java"));
        languagesJavaCheckbox.click();

        if (languagesJavaCheckbox.isSelected()){
            System.out.println("Languages Java checkbox is selected");
        } else {
            System.out.println("Languages Java checkbox is de-selected");
        }

    }

    @Test
    public void TC_04_Mailchimp_Register_Validate()  {
        driver.get("https://login.mailchimp.com/signup/");

        driver.findElement(By.cssSelector("input#email")).sendKeys("lengoduchieu@gmail.com");
        driver.findElement(By.cssSelector("input#email")).sendKeys(Keys.TAB);

        // Only number
        driver.findElement(By.id("new_password")).sendKeys("12345678");
        driver.findElement(By.id("new_password")).sendKeys(Keys.TAB);

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        // Only lower text
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("hiubin");
        driver.findElement(By.id("new_password")).sendKeys(Keys.TAB);

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        // Only upper text
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("HIUBIN");
        driver.findElement(By.id("new_password")).sendKeys(Keys.TAB);

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        // Only special text
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("******");
        driver.findElement(By.id("new_password")).sendKeys(Keys.TAB);

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        // Full
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("Hiubin12*#");
        driver.findElement(By.id("new_password")).sendKeys(Keys.TAB);



        // Content Username
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("lengoduchieu");
        driver.findElement(By.id("new_password")).sendKeys(Keys.TAB);

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.not-completed")).isDisplayed());

    }


    @AfterClass
    public void TC_05_Clean(){
        driver.quit();}
    }
