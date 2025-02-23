package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



import java.time.Duration;
import java.util.List;

public class Topic_12_Custom_Dropdown {


    WebDriver driver; //null

    WebDriverWait explicitWait;


    @BeforeClass
    public void initialBrowser() {
//        Assert.assertNull(driver);



        driver = new FirefoxDriver();
//        Assert.assertNotNull(driver);

        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));



    }


    @Test
    public void TC_01_JQuery() throws InterruptedException {
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");

        selectItemCustomDropdown("span#speed-button","ul#speed-menu>li>div","Medium");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button>span.ui-selectmenu-text")).getText(),"Medium");

        selectItemCustomDropdown("span#number-button","ul#number-menu>li>div","3");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#number-button>span.ui-selectmenu-text")).getText(),"3");

        selectItemCustomDropdown("span#salutation-button","ul#salutation-menu>li>div","Mrs.");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#salutation-button>span.ui-selectmenu-text")).getText(),"Mrs.");
    }
    @Test
    public void TC_02_React() throws InterruptedException {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");

        selectItemCustomDropdown("div.dropdown","div.item>span","Elliot Fu");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Elliot Fu");

        selectItemCustomDropdown("div.dropdown","div.item>span","Justen Kitsune");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Justen Kitsune");

    }
    @Test
    public void TC_03_VueJS() throws InterruptedException {
        driver.get("https://mikerodham.github.io/vue-dropdowns/");

        selectItemCustomDropdown("li.dropdown-toggle","ul.dropdown-menu>li>a","Second Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(),"Second Option");

        selectItemCustomDropdown("li.dropdown-toggle","ul.dropdown-menu>li>a","Third Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(),"Third Option");

        selectItemCustomDropdown("li.dropdown-toggle","ul.dropdown-menu>li>a","First Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(),"First Option");

    }

    @Test
    public void TC_04_React() throws InterruptedException {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");

        enterItemCustomDropdown("input.search","div.item>span","Antigua");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Antigua");

        enterItemCustomDropdown("input.search","div.item>span","Armenia");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Armenia");

    }

    // Dự án thực tế: 1 hàm để thao tác lên dropdown chỉ dùng 1 site/app
    // Ko dùng cho nhiều application khác nhau
    // Cơ chế của dropdown giống nhau

    private void selectItemCustomDropdown(String parentCss, String childCss,String textItem) throws InterruptedException {
        // Hành vi (behavior) để thao tác lên Dropdown
        // 1- Chờ cho Dropdown có thể thao tác lên được (clickable)
        // 2- Click vào element nào để nó xổ ra dropdown ra
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(parentCss))).click();
        Thread.sleep(2000);

        // 3- Chờ cho tất cả các item được load ra (presence)
        // 4- Tìm cái item nào đúng với mong đợi
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childCss)));


        // 5 items
        for (WebElement item: allItems){
            System.out.println("---" + item.getText() + "---");
            if (item.getText().equals(textItem)){
                // 5- Click lên item đó
                item.click();
                break;
            }
        }
    }

    private void enterItemCustomDropdown(String parentCss, String childCss,String textItem) throws InterruptedException {
        // Hành vi (behavior) để thao tác lên Dropdown
        // 1- Chờ cho Dropdown có thể thao tác lên được (clickable)
        // 2- Senkey vào dropdown
        WebElement dropdownTextbox = explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(parentCss)));
        dropdownTextbox.clear();
        dropdownTextbox.sendKeys(textItem);
        Thread.sleep(2000);

        // 3- Chờ cho tất cả các item được load ra (presence)
        // 4- Tìm cái item nào đúng với mong đợi
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childCss)));


        // 5 items
        for (WebElement item: allItems){
            System.out.println("---" + item.getText() + "---");
            if (item.getText().equals(textItem)){
                // 5- Click lên item đó
                item.click();
                break;
            }
        }
    }

    // Wait
    // If
    // List
    // Break

    @Test
    public void TC_02_() {

    }



    @AfterClass
    public void TC_03_Clean(){
        driver.quit();}
    }
