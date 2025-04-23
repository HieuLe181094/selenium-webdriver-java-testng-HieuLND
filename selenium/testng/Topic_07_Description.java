package testng;

import org.testng.annotations.Test;

public class Topic_07_Description {
    // Tên testcase = hàm/ function/ method của Java
    // Theo convention của từng ngôn ngữ

    // Chú thích/ diễn giải/ note

    @Test(description = "JIRA#1994 - User can create new product and verify created success")
    public void Product_01_CreateNewProduct(){System.out.println("shouldBeRegisterFailWithInvalidEmail");}

    @Test
    public void Product_02_ViewProduct(){System.out.println("shouldBeLoginPass");}

    @Test
    public void Product_03_EditProduct(){System.out.println("shouldBeLoginFail");}

    @Test
    public void Product_04_DeleteProduct(){System.out.println("shouldBeDeleteProduct");}
}
