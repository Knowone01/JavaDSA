
public class bit{
    /*
    Binary Left Shift : Whole number in binary numbers shifts towards left by b spaces ( a << b), remaining spaces
    are filled by 0s. Shortcut : Final number in decimal = a * 2^b;

    Binary Right Shift : Whole number in binary numbers shifts towards right by b spaces ( a >> b), remaining spaces
    are filled by 0s. Shortcut : Final number in decimal = a / 2^b;
    */

    //Finding out whether the number is even or odd : 
    public static void oddOReven(int n){
        if((n & 1) == 1){
            System.out.println("odd");
        }
        else{
            System.out.println("even");
        }

    }

    //Getting the ith bit : (give from the right, counting starts from 0)
    public static int getIthBit(int n, int i){
        int bitmask = 1<<i;
        if((n & bitmask) == 0){
            return 0;
        }
        else{
            return 1;
        }

    }

    //Setting ith bit : 

    public static int setIthBit(int n , int i){
        int bitmask = 1 << i;
        return (n | bitmask);
    }

    //Clear ith bit : (sets ith bit to 1) 
    public static int clearIthBit(int n, int i){
        int bitmask = ~(1 << i);
        return (n & bitmask);
    }

    //Clear i bits : 

    public static int clearIbits(int n, int i){
        int bitmask = ~0<<i;
        return (n & bitmask);
    }

    //Clear range of bits : 01 = 2^1 -1; 011 = 2^2 - 1; 0111 = 2^3 -1 and so on , a is of type (1111..)000000... and b is of type 0000000000...(11111...)

    public static int rangeBits(int i, int j, int n){
        int a = 1<<j+1;
        int b = 1<<i -1;               
        int bitmask = a | b;
        return (n & bitmask);
    }

    //To check whether a number is in the power of 2 or not : every power of two is of like 100000...(n zeros for ith power), and the n-1 th number is of type
    //                                                      0111111... such that n & n-1 = 0
    public static boolean power(int n){
        return (n & (n-1)) == 0;
    }

    //To check number of set bits : Number of ones in a binary number, every number requires log(base 2)n + 1 bits to be represented in binary form
    //O(logn);

    public static void setBits(int n){
        int count  = 0;
        while(n != 0){
            if((n & 1) != 0){
                count ++;
            }
            n = n>>1;
        }
        System.out.print(count);
    }

    //Fast exponentiation : O(logn + 1);

    public static void fastExpo(){
        int a = 3;
        int n = 5;
        int ans = 1;
        while(n !=0){
            if((n & 1) != 0){
                ans = a * ans;
            }
            n = n >> 1;
            a = a * a;

        }
        System.out.println(ans);
    }

public static void main(String args[]){
    System.out.print(getIthBit(10, 3));



}
}