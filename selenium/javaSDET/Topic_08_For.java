package javaSDET;

import java.util.ArrayList;
import java.util.List;

public class Topic_08_For {

    public static void main(String[] args){
        // Biểu thức vòng lặp (loop)
        int number = 100;




        // for (classic - interator)
//        for (int i = 0; i < number; i++);{
//           if (i==5){
//            System.out.println(i);
//            break;
//        }

        // Collection: List/ Set/ Queue/ Map
        List<String> name = new ArrayList<String>();
        name.add("Manual Testing");
        name.add("Automation Testing");
        name.add("Regression Testing");
        name.add("API Testing");
        name.add("UI Testing");
        name.add("Mobile Testing");

        // for-each
        for (String a: name){
            if (a.equals("Automation Testing")){
                System.out.println("Interview");
            }
        }
        int i = 1000;

        // while
        while (i < number){
            System.out.println(i);
            i++;
        }

        // do-while
        do {
            System.out.println(i);
            i++;
        } while (i < number);

        // while
    }
}
