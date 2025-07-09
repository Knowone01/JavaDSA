import java.util.*;

public class Strings{

    /*Ways to define a String : Strings are immutable, that means if you change the value of a string, a completely new St
                                string is created in the memory and the String varible points towards it, leaving the older String 
                                as it is
    */ 



    public static void strings(){
        String name = "xyz";
        String str = new String ("xyz");
    }

    //Input and Output

    public static void io(){
        String name;
        Scanner sc = new Scanner(System.in);
        name = sc.next(); //prints only the first word 
        System.out.println(name);
        sc.nextLine();
        name = sc.nextLine();
        System.out.println(name);
    }

    //Counting the length of a String
    public static void length(){
    String name = "Pulkit Bhardwaj";
    System.out.println(name.length()); //Space is also counted as a character
    }

    //Concatentaion : 

    public static void fun1 (){
        String firstName  = "Pulkit";
        String lastName = "Bhardwaj";
        String fullName = firstName + " " + lastName;
        System.out.println(fullName);
    }

    //String charAt method : 
    public static void fun2 (){
        String name = "Pulkit Bhardwaj";
        for(int i = 0; i < name.length(); i++){
            System.out.print(name.charAt(i));
        }
    }

    //Palindrome function : O(n/2)
    public static boolean palindrome (){
        String word = "abcdba";
        for(int i = 0; i <= (word.length() - 1) / 2 ; i++){
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)){
                return false;
            }
        }
        return true;
    } 

    // Displacement :
    public static void displacement(){
        String path = "EEENNNN";
        int x = 0, y = 0;
        for(int i = 0; i < path.length(); i++){
            if(path.charAt(i) == 'N'){
                y++;
            }
            if(path.charAt(i) == 'S'){
                y--;
            }
            if(path.charAt(i) == 'E'){
                x++;
            }
            if(path.charAt(i) == 'W'){
                x--;
            }

        }
        

           x = x*x;
            y = y*y;
            System.out.print(Math.sqrt(x + y));
    }

    // Comparison : 

    public static void compare(){
        String str1 = "Pulkit";
        String str2  ="Pulkit";
        String str3 = new String("Pulkit");

        // if(str1 == str2){
        //     System.out.println("true");
        // }
        // else{
        //     System.out.println("false");
        // } (true was given)


        // if(str1 == str3){
        //     System.out.println("true");
        // }
        // else{
        //     System.out.println("false");
        // } (false was given)


        if(str1.equals(str3)){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        } //(true was given)
    

    }

    //Substring : 
        //Normal method : 
    public static void substring (){
        String str = "Hello World";
        int si = 0;
        int ei  = 5;
        String substr = "";
         for(int i = si ; i <ei; i++){
            substr += str.charAt(i);
         }
         System.out.println(substr);

         //Java inbuilt function : 

         System.out.println(str.substring(si, ei)); // of type  : [)


    }

     //Print largest string : .comapreTo (takes into account capital and small letters), 
    //                       .compareToIgnoreCase (doesn't take into account)
    //                        0 => equal; >0 => greater; <0 => smaller

    public static void largestString(){
        String str[] = {"apple", "banana", "car"};
        String largest = str[0];
        for (int i = 0; i < str.length; i++){
            if(largest.compareTo(str[i]) < 0){
                largest = str[i];
            };
        }
        System.out.println (largest);
    }

    // String builder : 

    public static void stringBuilder(){
        StringBuilder sb= new StringBuilder("");
        for(char ch = 'a'; ch <= 'z'; ch++){
            sb.append(ch);
        }
         System.out.print(sb);
    }

    //Converting first letter to uppercase (Character.toUpperCase())

    public static void charAtUpperCase(){
        String str = "hello wORLD";
        StringBuilder sb = new StringBuilder("");
        sb.append(Character.toUpperCase(str.charAt(0)));
        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i) == ' ' && i < str.length() - 1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }
            else{
                sb.append(str.charAt(i));
            }
        }
        System.out.print(sb.toString());

    }

    //String Compression : abbc = ab2c, abcd = abcd

    public static void stringCompression(){
        String str = "aabbbbcd";

        StringBuilder sb = new StringBuilder("");

        for(int i = 0; i < str.length(); i++){
            sb.append(str.charAt(i));
            Integer count = 1;
            while(i <str.length() - 1 && str.charAt(i) == str.charAt(i + 1)){
                count++;
                i++;
            }
            
            if(count > 1){
                sb.append(count.toString());
            }
        }


        System.out.println(sb);


    }

    
       


    public static void main(String args[]){
    stringCompression();
    }
}