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

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
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




    @AfterClass
    public void TC_03_Clean(){
        driver.quit();}
    }
