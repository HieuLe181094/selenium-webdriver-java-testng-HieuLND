package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Topic_05_Run_On_Browser_Version_4x {


    WebDriver driver;
    //String projectPath = System.getProperty("user.dir");


    @Test
    public void TC_01_Run_On_Firefox() {
        //System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.quit();

    }
    @Test
    public void TC_02_Run_On_Chrome() {

        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.quit();

    }

    @Test
    public void TC_03_Run_On_Edge() {

        driver = new EdgeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.quit();

    }
}



