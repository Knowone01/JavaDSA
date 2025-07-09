// Q1-
/*
import java.util.*;

public class hw{
    public static void main(String args[]){
        System.out.println("Input the number -");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if(number > 0){
            System.out.println("The given number is positive");
        }
        else if(number < 0){
            System.out.println("The given number is negative");
        }
        else {
            System.out.println("The given number is neither positive or negative");
        }
    }
    
}
*/


// Q2-
/*
import java.util.*;
public class hw{
    public static void main(String args[]){
        System.out.println("Please input the temperature :");
        Scanner sc = new Scanner(System.in);
        double temp = sc.nextDouble();
        String fever = (temp > 100) ? "You have fever" : "You do not have fever";
        System.out.println(fever);

    }
}
*/


// Q3-
/*
import java.util.*;
public class hw{
    public static void main(String args[]){
        System.out.println("Input the week number");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        switch (number){
            case 1 : System.out.println("Monday"); break;
            case 2 : System.out.println("Tuesday"); break;
            case 3 : System.out.println("Wednesday"); break;
            case 4 : System.out.println("Thursday"); break;
            case 5 : System.out.println("Friday"); break;
            case 6 : System.out.println("Saturday"); break; 
            case 7 : System.out.println("Sunday"); break;
            default : System.out.println("Invalid input");
        }
    }
}
*/


// Q4-
/*
import java.util.*;
public class hw{
    public static void main(String args[]){

        System.out.println("Input the year");
        Scanner sc = new Scanner(System.in);
        long year = sc.nextLong();
        if (year % 400 == 0){
            System.out.println("Leap year");
        }
        else if ((year % 100 != 0) && (year % 4 == 0 )){
            System.out.println("Leap year");
        }
        else {
            System.out.println("Not a leap year");
        }
    }
}
*/

