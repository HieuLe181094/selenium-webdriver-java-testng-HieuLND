package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_02_Asssertion {
    WebDriver driver;

    public static void main(String[] args){
        // 3 hàm chính để kiểm tra tính đúng đắn của dữ liệu
        boolean gender  = 3 < 5;

        // Kiểm tra dữ liêu nó phải ĐÚNG
        Assert.assertTrue(gender);


        // Kiểm tra dữ liêu nó phải ĐÚNG
        Assert.assertFalse(3>5);

        // Kiểm tra dữ liệu nó bằng với mong đợi (ACTUAL - EXPECTED)
        // Kiểm tra dữ liệu gióng nhau
        // Giá trị của dữ liệu giống nhau
        Assert.assertEquals(5,6);
        Assert.assertEquals("NAME","NAME");}

    public void assertion(){
        // AssertTrue: khi kiểm tra 1 điều kiện mong đợi nó trả về là ĐÚNG
        // Các hàm trả về true/false
        // Selenium: isDislayed/ isEnabled/ isSelected/ isMultiple
        // User Defined

        Assert.assertTrue(driver.findElement(By.cssSelector("")).isDisplayed());

        // AssertFalse: khi kiểm tra 1 điều kện mong đợi nó sẽ trả về là SAI
        // Mong đợi của button là disabled
        Assert.assertFalse(driver.findElement(By.cssSelector("button.btn-close")).isEnabled());

        // AssertEquals: kiểm tra 1 điều kiện mong đợi (expedted) bằng với điều kiện thực tế (actual)
        // getText/ getAttribute/ getCss/ getTitle/ getUrl/..
        Assert.assertEquals(driver.findElement(By.cssSelector("")).getText(),"");

        Assert.assertEquals(driver.findElement(By.cssSelector("")).getAttribute(""),"");

        Assert.assertEquals(driver.findElement(By.xpath("//a[@href]")).getSize(),"458");

    }
}