package javaSDET;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.*;

public class Topic_01_DataType {
    // 2 nhóm kiểu dữ liệu

    // Cách khai báo:
    // Access modifier: phạm vi truy cập (private/ public/ protected/ default)
    // 1 - Access modifier - Kiểu dữ liệu - Tên biến - Gía trị của biến (Ngoài hàm/ Trong hàm đều đc)
    public char cName = 'b';

    // 2.1 - Access modifier - Kiểu dữ liệu - Tên biến
    private char cAddress;

    // 2.2 - Tên biến - Gía trị gán sau (Hàm)
    public void clickToElement(){
        cAddress = 'c';

        char cCity = 'b';
    }



    // Nhóm 1 - Kiểu dữ kiệu nguyên thủy (primitive type)
    // char: kí tự (character)
    // Khi gán giá trị (khởi tạo) thì nằm trong dấu nháy đơn (')
    char cZip = 'b';

    // byte/ short/ int/ long: số nguyên (dạng số ko dùng số thập phân)
    // Khi gán giá trị (khởi tạo) thì không nằm trong dấu gì
    byte bNumber = -120;

    short sNumber = 1200;

    int iNumber = 350000;

    long lNumber = 168136;

    // float/ double: số thực
    // Khi gán giá trị (khởi tạo) thì không nằm trong dấu gì
    float fNumber = 15.7F;

    double dNumber = 15.897d;

    // boolean: logic
    // Khi gán giá trị (khởi tạo) thì không nằm trong dấu gì
    boolean gender = false;

    // Nhóm 2 - Kiểu dữ liệu tham chiếu (reference type/ non-primitive)
    // string: chuỗi
    // Khi gán giá trị (khởi tạo) thì không nằm trong dấu nháy đơn ("")
    String fullName = "hieulnd";

    // Class
    FirefoxDriver fDriver;
    Actions action = new Actions(fDriver);
    Topic_01_DataType topic01DataType = new Topic_01_DataType();

    // Interface
    WebDriver driver;
    JavascriptExecutor javascriptExecutor;

    // Array (mảng) - cố định
    String [] studentName = {"Nam","An","Hong"};
    Integer [] studentPhone = {86133646, 893459933,81438236};

    // List/ Set/ Queue
    List<String> studentAddress = new ArrayList<String>();
    List<String> studentCity = new LinkedList<String>();

    // Map
    Map<String, Integer> zip = new HashMap<String, Integer>();


    // Object
    Object name = "NAM";
    Object phone = 1568;
    Object isDisplayed = true;

    // Convention: Quy ước khi lập trình
    // Tên biến/ tên hàm: viết dưới dạng camel case
    // Chữ cái đầu tiên luôn viết thường
    // name/ address/ city/ phone/ zipCode
    // clickToElement/ getUserName/ getPhoneNumber/ selectItemDropdown
}
