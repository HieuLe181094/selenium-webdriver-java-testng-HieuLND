package javaSDET;

import org.testng.annotations.Test;

import java.util.Random;

public class Topic_05_Random {
    // Biến Global
    String prefixEmail = "lengoduchieu";

    String postFixEmail = "@gmail.com"; // Web Mail Server

    String fullEmail = prefixEmail + postFixEmail;

    @Test
    public void testEmail() {
        Random rand = new Random();

        // Biến Local
        System.out.println(prefixEmail + rand.nextInt(999999) + postFixEmail);
    }

}
