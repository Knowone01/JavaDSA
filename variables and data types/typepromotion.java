import java.util.*;

public class typepromotion{
    public static void main(String args[]){
        // char a = 'a';
        // char b = 'b';
        // char c = (char)(a-b);
    
        // System.out.println((int)(a));
        // System.out.println((int)(b));
        // System.out.println(a-b);
        // System.out.println(a);
        // System.out.println((int)(c));
        

       short a = 5;
       byte b = 25;
       char c = 'c';
       byte bt = (byte) (a + b + c);
       System.out.println(bt);

       /* int a = 10;
        float b = 20.25f;
        long c = 25;
        double d = 30;
        double ans = a + b + c + d;
        System.out.println(ans);
       */

      /*int a = 10;
        float b = 20.25f;
        long c = 25;
        double d = 30;
        int ans = a + b + c + d; //lossy conversion
        System.out.println(ans); 
    */

        

       /* //wrong 
        byte b = 5;
        byte a = b*2;
        System.out.println(a);
        */

       // right

    //    byte b = 5;
    //    byte a = (byte)(b*2);
    //    System.out.println(a);
       

        

    }
}