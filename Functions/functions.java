import java.util.*;
public class functions{
    // 1. Syntax :
/*    
public static void helloworld(){
    System.out.println("Hello world");
}
    public static void main(String args[]){

helloworld();

    }
*/


    // 2. Syntax with parameters :
/*
    public static int calculatesum (int num1, int num2){ 
        int sum = num1 + num2;
        return sum;

    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int sum = calculatesum(a , b); // NOTE: VARIABLES WITH SAME NAME ARE CONSIDERED DIFFERENT IF THEY ARE DEFINED UNDER DIFFERENT FUNCTIONS !!!!!!!!
        System.out.println(sum);
    }
*/

    // 3. Call by value :
    /*
    public static void sum  (int num1, int num2){
        num1 = 10;
        num2 = 5;
        System.out.println(num1);
        System.out.println(num2);


    } 
    public static void main(String args[]){
        int a = 5;
        int b = 10;
        sum(a , b);
        System.out.println(a); // NO CHANGE IN ORIGINAL VALUE
        System.out.println(b); // NO CHANGE IN ORIGNIAL VALUE
    }
    */


   // 4. Product of two numbers a and b :
/*
   public static int mul(int num1, int num2){
    int product = num1 * num2;
    return product;
   }
   public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int product = mul(a , b);
    System.out.println(product); 
   }
*/


    // 5. Find the factorial of the given number :
/*
    public static int factorial(int num1){
        int i = 1;
        int product = 1;
        while(i <= num1){
            product = product * i;
            i++;
        }
        System.out.println("The factorial of the given number is : " + product);
        return product;
        }
        
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt(); 
        int factorial1 = factorial(number);
        System.out.println(factorial1);// NOTE: FUNCTION KI RETURN VALUE SEPARATELY USE NHI KAR SAKTE... POORA FUNCTION EXECUTE HOGA AGAR CALL KARA HAI TO !!!!1
    }
*/


    // 6. Binmoial coefficient: 
/*
    public static int bc(int num1, int num2){
        int product = 1;
        for(int i = 1; i <= num1; i++){
            product = i * product;
        }
        int product1 = 1;
        for (int i = 1; i <= num2; i++ ){
            product1 = i * product1;
        }
        int product2 = 1;
        for(int i = 1; i <= (num1 -num2); i++){
            product2 = i * product2;
        }
        int nCr =   (product / product1 / product2);
        return nCr; 
        }

        public static void main(String args[]){
            Scanner sc = new Scanner(System.in);
            System.out.print("Input n : "); 
            int n = sc.nextInt();
            System.out.print("Input r : ");
            int r = sc.nextInt();
            int nCr = bc(n , r);
            System.out.println("nCr = " + nCr);
*/


    // 7. Function overloading using parameters :
/*
    public static int sum(int a, int b){
        return (a + b);
    }

    public static int sum(int a, int b, int c){
        return (a + b + c);
    }

    public static void main(String args[]){
        int a =10;
        int b = 5;
        int c = 15;
        System.out.println(sum(a , b));
        System.out.println(sum (a, b, c));

    }
*/

    // Function overloading using different data types : 
/*
public static int sum(int a, int b){
    return (a + b);
}

public static float sum(float a , float b){
    return (a + b);
}

public static void main(String args[]){
    System.out.println(sum(3 , 5));
    System.out.println(sum(4.2f , 3.8f));
}
*/


    // To check if a number is prime :
    /*
    public static boolean prime(int a){
        boolean isprime = true;
        int remainder = 0;
        if(a == 1){
            isprime = false;
        }
        else if(a == 2){
            isprime = true;
        }
        else{
        for(int i = 2; i < Math.sqrt(a); i++){
            remainder = a % 2;
            if (remainder == 0){
                isprime = false;
                break;
            }
        }
        }
        return isprime;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if(prime(number)){
            System.out.println("Prime");
        }
        else{
            System.out.println("Not prime");
        }
    }
 */


    // Print all primes in range :
/*
    public static boolean prime(int a){
        boolean isprime = true;
        int remainder = 0;
        if (a == 1){
            return false;
        }
        else if(a == 2){
            return true;
        }
        else{
       for (int i = 2; i < a; i++){
        remainder = a % i;
        if(remainder == 0){
            isprime = false;
            break;
        }
        else{
            isprime = true;  
            }
        }    
        }
        return isprime;
        }

   public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int number = sc.nextInt();
    for(int i = 1; i <= number; i++){
        if(prime(i) == true){
            System.out.println(i);
        }
        else{
            continue;
        }
    } 
   } 
*/


    // Convert binary to decimal :
    /*
   public static void bin(int a){
    int pow = 0;
    int num = 0;
    while(a > 0){
        int rem = a % 10;
        num = num + (rem * (int)Math.pow(2 , pow)); NOTE : POWER K LIE Math.pow(- , -) use hota hai. 2^5 = Math.pow(2 , 5) = 32
        a = a /10;
        pow++;
    }
    System.out.println(num);
   }
   public static void main (String args[]){
    System.out.println("Input the number : ");
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    bin(a);
}
*/


    // Decimal to Binary : 
    /*
    public static int bin(int a){
        int rem = 0;
        int i = 1;
        while(a > 0){
            rem = (a % 2) * i + rem;
            i = i * 10;
            a = a / 2;
        }
         System.out.println(rem);
         return rem;
    }
    public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int dec = sc.nextInt();
    bin(dec);
    }
    */
}



