import java.util.*;
public class patterns{

// 1. Hollow Rectangle :
/*
public static void pattern(int row , int col){
    for(int i = 1; i <= row; i++){
        for(int j = 1; j <= col; j++){
            if (i == 1 || j == 1 || i == row || j == col){
                System.out.print(" * ");
            }
            else {
                System.out.print("   ");

            }
        }
        System.out.println();
    }
}
public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int row = sc.nextInt();
    int col = sc.nextInt();
    pattern(row , col);
}
*/


// 2. Inverted and rotated half pyramid :
/*
// M1:
public static void star(int n){
    for(int i = 1; i <= n; i++){
       for(int j = 1; j <= n; j++){
        if(j <= (n - i)){
            System.out.print("   ");
        }
        else{
            System.out.print(" * ");
        }
       }
       System.out.println();
    }
}
public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int rows = sc.nextInt();
    star(rows);
}

// M2:
public static void star(int n){
    for(int i = 1; i <= n; i++){
        for(int j1 = 1; j1 <= (n - i); j1++){
            System.out.print("   ");
        }
        for(int j2 = 1; j2 <= i; j2++){
            System.out.print(" * ");
        }
        System.out.println();
    }
}

public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int row = sc.nextInt();
    star(row);
}
*/


// 3. Inverted half pyramid with numbers :
/*
public static void num(int n){
    for(int row = 1; row <= n; row++){
        for(int i = 1; i <= (n -row + 1); i++){
            System.out.print(" " + i + " ");
        }
        System.out.println();
    }
}

public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    num(n);
}
*/


// 4. Floyd's Triangle : 
/*
public static void flo(int n){
    int num = 1;
    for(int row = 1; row <= n; row++){
        for(int col = 1; col <= row; col++){
            System.out.print(" " + num);
            num++;
        }
        
        System.out.println();
    }
}

public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    flo(n);
}
*/


// 5. 0-1 Triangle :
/*
public static void mat(int n){
    for(int row = 1; row <=n; row++){
        for(int col = 1; col <= row; col++){
            if(((row % 2 == 0) && (col % 2 != 0)) || ((row % 2 != 0) && (col % 2 == 0))){ // Yahan par 0 k lie i + j = odd 
                System.out.print(" 0");
            }
            else{
                System.out.print (" 1");
            }
        }
        System.out.println();
    }
}

public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    mat(n);
}
*/


// 6. Butterfly pattern : //NNNNNNNNNNNNNNNNNNNNQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ
/*
    // M1 : 
public static void btfly1(int n){
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= (2 * n); j++){
            if(j == 1 || j == (2 * n) || j >= ((2 * n) - i + 1) || j <= i){
                System.out.print(" *");
            }
            else{
                System.out.print("  ");
            }
        }
        System.out.println();
    }
}

public static void btfly2(int n){
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= (2 * n); j++){
            if(j == 1 || j <= (n - i + 1) || j >= (n + i)){
                System.out.print(" *");
            }
            else{
                System.out.print("  ");
            }
        }
        System.out.println();
    }
}

public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    btfly1(n);
    btfly2(n);
}


// M2 : 
public static void btfly1(int n){
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= (2 * n); j++){
            if(j == 1 || j == (2 * n) || j >= ((2 * n) - i + 1) || j <= i){
                System.out.print(" *");
            }
            else{
                System.out.print("  ");
            }
        }
        System.out.println();
    }
}

public static void btfly2(int n){
    for(int i = n; i >= 1; i--){
        for(int j = 1; j <= (2 * n); j++){
            if(j == 1 || j == (2 * n) || j >= ((2 * n) - i + 1) || j <= i){
                System.out.print(" *");
            }
            else{
                System.out.print("  ");
            }
        }
        System.out.println();
    }
}

public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    btfly1(n);
    btfly2(n);
}
*/
    // M3 : 
    /*
   public static void btfly1(int n){
    for(int i = n; i >= 1; i--){
        for(int j = 1; j <= 2 * n; j++){
            if((j <= n - i + 1) || (j >= i + n)){
                System.out.print(" *");
            }
            else{
                System.out.print("  ");
            }
        }
        System.out.println();
    }
   }
public static void btfly2(int n){
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= (2 * n); j++){
            if(j <= (n - i + 1) || j >= (n + i)){
                System.out.print(" *");
            }
            else{
                System.out.print("  ");
            }
        }
        System.out.println();
    }
}

public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    btfly1(n);
    btfly2(n);
}
*/

    // M4: 
/*
public static void btfly1(int n){
    for (int i = 1; i <= n; i++){
    for(int j = 1; j <= i; j++){
        System.out.print(" *");
    }
    for(int j = 1; j <= 2 * (n - i); j++){
        System.out.print("  ");
    }
    for(int j = 1; j <= i; j++){
        System.out.print(" *");
    }
    System.out.println();
}    
}
public static void btfly2(int n){
 for (int i = n; i >= 1; i--){
    for(int j = 1; j <= i; j++){
        System.out.print(" *");
    }
    for(int j = 1; j <= 2 * (n - i); j++){
        System.out.print("  ");
    }
    for(int j = 1; j <= i; j++){
        System.out.print(" *");
    }
    System.out.println();
}    
}

public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    btfly1(n);
    btfly2(n);
}
*/


public static void rom(int n){
    for(int i = 1; i <= n; i++){
        for(int j1 = 1; j1 <= (n - i); j1++){
            System.out.print("  ");
        }
        for(int j2 =1; j2 <= n; j2++){
            System.out.print(" *");
        }
     System.out.println();   
    }
}

public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    rom(n);
}
}
