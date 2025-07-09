import java.util.*;


public class cs{
    public static void main(String args[]){

// 1. if/else
/*
        int a = 19;
        if (a >= 18){
             System.out.println("You are an adult and you are " + a + " years old");
            }
            
          else {
            System.out.println("You are not an adult and you are " + a + " years old");
          }  
*/


    // 2. Print the largest of two number- 
/*    
        int a = 10; 
        int b = 5;
        if ( a > b){
            System.out.println("a is greater than b");
            }

        else {
            System.out.println("a is less than b");
        }    
*/


    // 3. Print if a number is even or odd-
/*
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        
        if (a % 2 == 0){
            System.out.println("The given number is even");
        }
        else{
            System.out.println("The given number is odd");
        }
*/


    // 4. else if-
/*    
        System.out.println("How old are you ?");
      Scanner sc = new Scanner(System.in);
      int a = sc.nextInt();
        if (a >= 18){
             System.out.println("You are an adult and you are " + a + " years old");
            }

        else if ((a >= 13) && (a < 18))
            System.out.println("You are a teenager and you are " + a + " years old");   
            
        else {
            System.out.println("You are not an adult and you are " + a + " years old");
          }  
  */ 


        // 5. Income tax calculator- 
/*
        System.out.println("Please input your income :");
        Scanner sc = new Scanner(System.in);
        long income = sc.nextLong();
        if (income <= 500000){
            System.out.println("Your income tax is 0");
        }
        else if((income >500000) && (income < 1000000)){
            System.out.println("Your income tax is " + income * 0.2);
        }
        else {
            System.out.println("Your income tax is " + income * 0.3);
        }
  */   


        //  6.Print the largest of three numbers- 
/*   
        System.out.println("Input the three numbers");
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
         int B = sc.nextInt();
          int C = sc.nextInt();

        if ((A > B) && (A > C)){
            System.out.println("The largest of three numbers is " + A);
          }
        if ((B > A) && (B > C)){
            System.out.println("The largest of three numbers is " + B);
          }
        if ((C > A) && (C > B)){
            System.out.println("The largest of three numbers is " + C);
          }
          
        //ALT- 
        if ((A > B) && (A > C)){
             System.out.println("The largest of three numbers is " + A);
        }
        else if (B > C){
             System.out.println("The largest of three numbers is " + B);
        }
        else {
            System.out.println("The largest of three numbers is " + C);
        }     
*/


        // 7. Ternary operator-
/*
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the number :");
        int number = sc.nextInt();
        String type = (number % 2 == 0) ? "Even" : "Odd";
        System.out.println(type);
*/


    // 8. To check if a student will pass or fail- 
/*
    Scanner sc = new Scanner(System.in);
    System.out.println("Input the marks");
    int marks = sc.nextInt();
    String result = (marks >= 33) ? "Pass" : "Fail";
    System.out.println(result);
*/


    //9. Switch Statements- 
/*    
    char ch = 'a';
    switch (ch) {
        case 'a' : System.out.println("1");
        case 'b' :  System.out.println("2");
        default : System.out.println("3");
    }


    char ch = 'z';
    switch (ch){
        case 'a' : System.out.println("1");
         break;
        case 'b' :  System.out.println("2");
        break;
        default : System.out.println("3");
        break;
    }
*/


    //  10. Calcultor - 
/*
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the first number : ");
    int a = sc.nextInt();
    System.out.println("Enter the second number : ");
    int b = sc.nextInt();
    System.out.println("Enter the operator : ");
    char operator = sc.next().charAt(0); //LOOK HERE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    switch (operator) {
        case '+' : System.out.println(a + b);break;
        case '-' : System.out.println(a - b);break;
        case '*' : System.out.println(a * b);break;
        case '/' : System.out.println(a / b);break;
        case '%' : System.out.println(a % b);break;
        default :  System.out.println("Syntax error");
        }
*/


    



        }    

    }
