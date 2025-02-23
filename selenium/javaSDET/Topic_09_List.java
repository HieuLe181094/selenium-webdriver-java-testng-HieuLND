package javaSDET;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.*;

public class Topic_09_List {

    public static void main(String[] args){
        // Java collection

        RemoteWebDriver driver; // Cha

        driver = new FirefoxDriver(); // Con
        driver = new ChromeDriver(); // Con
        driver = new EdgeDriver(); // Con

        FirefoxDriver ffDriver = new FirefoxDriver();

//        ArrayList<String> address = new ArrayList<>();
//
//        Vector<Float> studentPoit = new Vector<>();
//
//        LinkedList<Integer> studentAge = new LinkedList<>();
//
//        Stack<Boolean> status = new Stack<>();

        List<String> address = new ArrayList<>();
        address.add("Ho Chi Minh");
        address.add("Ha Noi");
        address.add("Hue");
        address.add("Da Nang");

        // Lấy ra 1 element cụ thể
        System.out.println(address.get(2));

        // Lấy ra toàn bộ
        for (int i = 0; i < address.size(); i++){
            System.out.println(address.get(i));
        }

        // Lấy ra toàn bộ
//        for (String a: address){
//            System.out.println(address.get(a));
//        }



    }
}
