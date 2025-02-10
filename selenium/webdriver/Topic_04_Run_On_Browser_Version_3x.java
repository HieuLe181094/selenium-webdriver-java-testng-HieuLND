package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Topic_04_Run_On_Browser_Version_3x {


    WebDriver driver;

    String projectPath = System.getProperty("user.dir");



    @Test
    public void TC_01_Run_On_Firefox() {

        System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.quit();

    }

    @Test
    public void TC_02_() {

    }
}



