package testng;

import org.testng.Assert;

public class Topic_01_Asssertion {
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
        Assert.assertEquals("NAME","NAME");

    }
}