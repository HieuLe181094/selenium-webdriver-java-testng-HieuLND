package testng;

import org.testng.annotations.Test;

public class Topic_06_Skip {
    @Test
    public void Product_01_CreateNewProduct(){System.out.println("shouldBeRegisterFailWithInvalidEmail");}

    @Test(enabled = false)
    public void Product_02_ViewProduct(){System.out.println("shouldBeLoginPass");}

    @Test
    public void Product_03_EditProduct(){System.out.println("shouldBeLoginFail");}

    // @Test
    public void Product_04_DeleteProduct(){System.out.println("shouldBeDeleteProduct");}
}
