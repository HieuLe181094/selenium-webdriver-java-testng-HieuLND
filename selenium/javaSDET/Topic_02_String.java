package javaSDET;

public class Topic_02_String {
    public static void main(String[] args){
       String link = "http://the-internet.herokuapp.com/basic_auth";

       String usernamr = "admin";
       String password = "admin";

       String[] linkArray = link.split("//");
       link = linkArray[0] + "//" +usernamr + ":" + password + "@" + linkArray[1];
       System.out.println(link);

    }
}
