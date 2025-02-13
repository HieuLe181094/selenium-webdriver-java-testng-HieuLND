package javaSDET;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_04_And_Or {

    @Test
    public void verifyAnd() {

        String contactInformation = "hiu bin\n" +
                "lengoduchieu@gmai.com\n" +
                "Change Password";

        Assert.assertTrue(contactInformation.contains("hiu bin")
                && contactInformation.contains("lengoduchieu@gmai.com"));

}
}
