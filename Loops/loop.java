import java.util.*;
public class loop{
    public static void main(String args[]){


// 1. While loop :
/*
    int number = 0;
    while(number <= 100){
        System.out.println("Hello world !");
        number++;
    }
*/


// 2. Print numbers from 1 to 100 :
/*
int number = 1;
while(number <= 100){
    System.out.println(number);
    number++;
}
*/


//  Count numbers from 1 to n :
/*
    System.out.println("Input the number :");
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int a = 1;
    while(a <= n){
        System.out.println(a);
        a++;
    }
*/

 // 3. Print the sum of first n natural numbers- 
/*
 System.out.println("Input the number : ");
 Scanner sc = new Scanner(System.in);
 int number  = sc.nextInt();
 int n = 1;
 int sum = 0;
 while(n <= number){
    sum = sum + n;
    n++;
 }
System.out.println(sum);
*/


// 4. For loop :
/*
for (int i = 1; i <= 100; i++){
    System.out.println(i +". Hello world !"); //NOTE: THE VARIABLE DECLARED IN THE FOR LOOP CANNOUT BE USED OUTSIDE THE { - } OF THE FOR LOOP !!!!!
}
*/

// 5. Square pattern: 
/*
for(int line =1; line <= 4; line++){
    System.out.println("* * * *");
}

//alt-
int line = 1;
while(line <= 4){
    System.out.println("* * * *");
    line++;
}
*/


// 6. Print reverse of a number:  NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ
/*
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
while(n > 0){
    int lastdigit = n % 10;
    System.out.print(lastdigit);
    n = n / 10;
}
*/



// 7. Reverse the given number : NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ
/*
Scanner sc = new Scanner(System.in);
int number = sc.nextInt();
int rev = 0;
while (number > 0){
int lastdigit = number % 10;
rev = rev * 10 + lastdigit;
number = number / 10;
}
System.out.println(rev);
*/


// 8. Do while loop : 
/*
int counter = 1;
do{
    System.out.println("Hello World");
    counter++;
}while(counter <= 10);
*/


// 9. Break Statement :
/*
for(int n = 1; n <= 10; n++){
     if (n == 7){
        break;
    }  // Agar print k baad if statement use karte to counting 7 tak chalti    
    System.out.println(n);
   
}
System.out.println("I am out of the loop");
*/


// 10. Keep entering numbers till user enters a multiple of 10 :
/*
Scanner sc = new Scanner(System.in);
do{
    System.out.print("Input your number : ");
    int number = sc.nextInt();
    if(number % 10 == 0){
        break;
    }
    System.out.println(number);
}while(true);
System.out.println("Invalid number");
// Alt : 
Scanner sc = new Scanner(System.in);
while(true){
    System.out.print("Input the number : ");
    int number = sc.nextInt();
    if(number % 10 == 0){
        break;
    }
    System.out.println(number);
}
System.out.println("The number is a multiple of 10");
*/


// 11. Continue Statement :
/*
for ( int i = 1; i <= 10; i++){
    if (i == 3){
        continue;
    }
    System.out.println(i);
}
*/


// 12. Display all numbers entered by the user except the mulitples of 10 :
/*
Scanner sc = new Scanner(System.in);
while(true){
    System.out.print("Input the number : ");
    int number = sc.nextInt();
    if(number % 10 == 0){
        continue;
    }
    System.out.println(number);
}
*/


// 13. To check if a nubmer is prime : NNNNNNNNNNNNNNNNNNNNQQQQQQQQQQQQQQQQQQQQQQQQ
/*
Scanner sc = new Scanner(System.in);
System.out.print("Enter the number : ");
int number = sc.nextInt();
int i = 2;
boolean prime = true;
if(number == 2){
    System.out.println("Prime");
}
else{
for (i = 2; i < number; i++){
    if(number % i == 0){
        prime  = false;
        break;
    }
}
    if(prime == true){
        System.out.println("Prime");
    }
    else{
        System.out.println("Not a Prime");
    }
   
}

//ALT: 
Scanner sc = new Scanner(System.in);
System.out.print("Enter the number : ");
int number = sc.nextInt();
int i = 2;
boolean prime = true;
if(number == 2){
    System.out.println("Prime");
}
else{
for (i = 2; i <= Math.sqrt(number); i++){// LOOK HERE !!!!!!!!!!!!!!
    if(number % i == 0){
        prime  = false;
        break;
    }
}
    if(prime == true){
        System.out.println("Prime");
    }
    else{
        System.out.println("Not a Prime");
    }
   
}
*/
    }
}