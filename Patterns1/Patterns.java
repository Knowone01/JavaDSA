import java.util.*;

public class Patterns{
    public static void main(String args[]){

// 1. Print Star Pattern :
/*
int i = 1;
int j = 1;
Scanner sc = new Scanner(System.in);
System.out.print("Input n : ");
int n = sc.nextInt();
while(i <= n){
   while(j < i){
    System.out.print(" * ");
    j++;
   }
System.out.println(" * ");
i++;
j = 1;
}

//ALT: 
System.out.print("Input n : ");
Scanner sc = new Scanner(System.in);
int number = sc.nextInt();
for(int i = 1; i<= number; i++){
    for(int line = 1; line <= i; line++){
        System.out.print(" * ");
    }// NOTE: YAHAN PAR LINE KI VALUE APNE RESET HOKAR 1 HO JAEGI KYUNKI YE EK LOOP K ANDAR HAI!!!
    System.out.println();
 
}
*/


// 2. Inverted Star Pattern: 
/*
Scanner sc = new Scanner(System.in);
System.out.print("Input n : ");
int n = sc.nextInt();
for (int i = n; i >= 1; i--){
    for(int line =1; line <= i; line++){
        System.out.print(" * ");
    }
    System.out.println();
}
*/


// 3. Print Half-Pyramid pattern : 
/*
Scanner sc = new Scanner(System.in);
System.out.print("Input n : ");
int line = sc.nextInt();
for(int i = 1; i <= line; i++ ){
    for (int star = 1; star <= i; star++){
        System.out.print(" " + star + " ");
    }
    System.out.println();
}
*/


// 4. Character Pattern : 
/*
System.out.print("Input n : ");
Scanner sc = new Scanner (System.in);

int n = sc.nextInt();
int line = 1;
int line1 = 1;
char ch = 'A';
while(line <= n){
    while(line1 <= line){
        System.out.print(" " + ch + " " );
        ch++;
        line1++;
    }
    System.out.println();
    line++;
    line1 = 1;
}
//ALT:
System.out.print("Input n : ");
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
char ch = 'A';
for(int line = 1; line <= n; line++){
    for(int line1 = 1; line1 <= line; line1++){
        System.out.print(" " + ch + " ");
        ch++;
    }
System.out.println();
}
*/

    }
}