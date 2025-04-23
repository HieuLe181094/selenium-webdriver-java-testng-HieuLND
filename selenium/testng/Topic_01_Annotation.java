package testng;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_01_Annotation {
    @BeforeClass
    public void beforeClass() {
        System.out.println("Run Before Class");
    }

    @Test
    public void beforeTest() {
        System.out.println("Run Before Test");
    }

    @Test
    public void afterTest() {
        System.out.println("Run After Test");
    }

    @Test
    public void beforeMethod() {
        System.out.println("Run Before Method");
    }

    @Test
    public void afterMethod() {
        System.out.println("Run After Method");
    }


    @Test
    public void TC_01() {
        System.out.println("Run TC 01");
    }

    @Test
    public void TC_02() {
        System.out.println("Run TC 02");
    }

    @Test
    public void TC_03() {
        System.out.println("Run TC 03");
    }


    @AfterClass
    public void afterClass() {
        System.out.println("Run After Class");
    }


}
