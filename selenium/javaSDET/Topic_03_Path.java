package javaSDET;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class Topic_03_Path {

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);

        String osName = System.getProperty("os.name");
        System.out.println(osName);

        String separator = File.separator;
        System.out.println(separator);

        String uploadFolderPath = System.getProperty("user.dir") + File.separator + "\\UploadFiles\\";

        String body = "Body.jpg";
        String heart = "Heart.jpg";
        String intelligent = "Intelligent.jpg";

        String bodyPath = uploadFolderPath + body;
        String heartPath = uploadFolderPath + heart;
        String intelligentPath = uploadFolderPath + intelligent;

        System.out.println(bodyPath);
        System.out.println(heartPath);
        System.out.println(intelligentPath);
    }
}
