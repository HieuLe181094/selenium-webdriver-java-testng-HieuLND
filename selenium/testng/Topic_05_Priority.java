package testng;

import org.testng.annotations.Test;

public class Topic_05_Priority {
    // CRUD
    // Flow

    @Test(priority = 0)
    public void shouldBeCreateNewProduct(){System.out.println("shouldBeRegisterFailWithInvalidEmail");}

    @Test(priority = 1)
    public void shouldBeViewProduct(){System.out.println("shouldBeLoginPass");}

    @Test(priority = 2)
    public void shouldBeEditProduct(){System.out.println("shouldBeLoginFail");}

    @Test(priority = 3)
    public void shouldBeDeleteProduct(){System.out.println("shouldBeDeleteProduct");}
}
