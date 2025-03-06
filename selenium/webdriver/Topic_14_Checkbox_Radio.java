package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_14_Checkbox_Radio {


    WebDriver driver;
    JavascriptExecutor jsExecutor;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        jsExecutor = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        // Kích thước của browser là 1366x768
//        driver.manage().window().setSize(new Dimension(1366,768));

    }


    @Test
    public void TC_01_Telerik() {
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
        // Element HTML: input

        // Verify checkbox/radio is enable/disable
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Leather trim']/preceding-sibling::span/input")).isEnabled());
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Towbar preparation']/preceding-sibling::span/input")).isEnabled());

        // Verify checkbox/radio is selected/deselected
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Leather trim']/preceding-sibling::span/input")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Towbar preparation']/preceding-sibling::span/input")).isSelected());

        // Select to Dual-zone air conditioning checkbox

        By dualZoneAirBy = By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input");

        // Nếu như chưa chọn thì mới click
        if (!driver.findElement(dualZoneAirBy).isSelected()){
            driver.findElement(dualZoneAirBy).click();
        }
        Assert.assertTrue(driver.findElement(dualZoneAirBy).isSelected());

        // Scroll xuống thêm 1 đoạn
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,300)");

        // Deselect to Dual-zone air conditioning checkbox (bỏ chọn)
        if (driver.findElement(dualZoneAirBy).isSelected()){
            driver.findElement(dualZoneAirBy).click();
        }
        Assert.assertFalse(driver.findElement(dualZoneAirBy).isSelected());

        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
        js.executeScript("window.scrollBy(0,300)");

        By twoPetroBy = By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::span/input");
        if (!driver.findElement(twoPetroBy).isSelected()){
            driver.findElement(twoPetroBy).click();
        }
        Assert.assertTrue(driver.findElement(twoPetroBy).isSelected());

    }

    @Test

    public void TC_02_Material() {
        driver.get("https://material.angular.io/components/radio/examples");

        By summmer = By.cssSelector("input[value='Summer']");
        if (!driver.findElement(summmer).isSelected()){
            driver.findElement(summmer).click();
        }

        driver.get("https://material.angular.io/components/checkbox/examples");
        WebElement checkedCheckbox = driver.findElement(By.xpath("//label[text()='Checked']/preceding-sibling::div/input"));
        checkedCheckbox.click();
        WebElement indenterminateCheckbox = driver.findElement(By.xpath("//label[text()='Indeterminate']/preceding-sibling::div/input"));
        indenterminateCheckbox.click();

        Assert.assertTrue(checkedCheckbox.isSelected());
        Assert.assertTrue(indenterminateCheckbox.isSelected());


        if (checkedCheckbox.isSelected()) {
            checkedCheckbox.click();
        }
        Assert.assertFalse(checkedCheckbox.isSelected());

        if (indenterminateCheckbox.isSelected()) {
            indenterminateCheckbox.click();
        }
        Assert.assertFalse(indenterminateCheckbox.isSelected());


    }

    @Test
    public void TC_03_Multiple() {
        driver.get("https://automationfc.github.io/multiple-fields/");

        // Select all checkboxes
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("span.form-checkbox-item>input"));

        // Click all checkboxes
        for (WebElement checkbox: checkboxes){
            if (!checkbox.isSelected()){
                checkbox.click();
            }
        }

        // Verify all checkboxes selected
        for(WebElement checkbox: checkboxes){
            Assert.assertTrue(checkbox.isSelected());
        }

        // Deselect all checkboxes
        for (WebElement checkbox: checkboxes){
            if (checkbox.isSelected()){
                checkbox.click();
            }
        }

        // Verify all checkboxes deselected
        for (WebElement checkbox: checkboxes){
            Assert.assertFalse(checkbox.isSelected());
        }

        // Select 1 in all + verify
        driver.findElement(By.cssSelector("input[value='Ulcer Disease']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input[value='Ulcer Disease']")).isSelected());

        for(WebElement checkbox: checkboxes){
            if (!checkbox.isSelected() && checkbox.getAttribute("value").equals("High Blood Pressure")){
                checkbox.click();
            }
        }

    }

    @Test
    public void TC_04_Ubuntu() {
        driver.get("https://login.ubuntu.com");

        // Thẻ input: dùng để click
        // Dùng để verify: isSelected()

        By newUserRadio = By.cssSelector("input#id_new_user");

        // 1- Dùng thẻ input để click -> Fail
        // Dùng thể input này để verify
        // driver.findElement(By.cssSelector("input#id_new_user")).click();
        // Assert.assertTrue(driver.findElement(newUserRadio).isSelected());

        newUserRadio = By.cssSelector("label.new-user");
        // 2 - Dùng 1 thẻ khác input để click -> Pass
        // Dùng thể đó để verify -> Fail
        // isSelected() -> Dùng cho thẻ input/option
        // driver.findElement(newUserRadio).click();
        // Assert.assertFalse(driver.findElement(newUserRadio).isSelected());

        // 3 - Dùng 1 thẻ khác input để click -> Pass
        // Dùng thể input này để verify -> Pass


        // 4 - Dùng duy nhất thẻ input để click/verify dùng JS Excutor
        By newUserRadioInput =  By.cssSelector("input#id_new_user");

        jsExecutor.executeScript("arguments[0].click()",driver.findElement(newUserRadioInput));
        Assert.assertTrue(driver.findElement(newUserRadioInput).isSelected());

        By termCheckbox = By.cssSelector("input#id_accept_tos");

        jsExecutor.executeScript("arguments[0].click();",driver.findElement(termCheckbox));
        Assert.assertTrue(driver.findElement(termCheckbox).isSelected());

    }
    @Test
    public void TC_05_Docs() throws InterruptedException {
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");
        Thread.sleep(5000);

        By canthoRadio = By.xpath("//div[@aria-label='Cần Thơ']");
        By xuquangRadio = By.xpath("//div[@aria-label='Xứ Quảng']");

        driver.findElement(canthoRadio).click();
        Assert.assertEquals(driver.findElement(canthoRadio).getAttribute("aria-checked"),"true");

//        // Check
//        if (driver.findElement(xuquangRadio).getAttribute("aria-checked").equals("false")){
//            driver.findElement(xuquangRadio).click();
//        }
//
//        // Uncheck
//        if (driver.findElement(xuquangRadio).getAttribute("aria-checked").equals("true")){
//            driver.findElement(xuquangRadio).click();
//        }

//        driver.findElement(xuquangRadio).click();
//        Assert.assertEquals(driver.findElement(xuquangRadio).getAttribute("aria-checked").equals("false"));
    }




    @AfterClass
    public void TC_03_Clean(){
        driver.quit();}
    }
