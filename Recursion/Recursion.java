public class Recursion{

    //Printing numbers from 1 to n : 

    public static void printN(int n){
        if(n == 1){
            System.out.print(" 1");
            return;
        }
        System.out.print(" " + n);
        printN(n-1);
    }


    //Printing factorial : 

    public static int fact(int n){
        if(n == 0){
            return 1;
        }
       n = n * fact(n -1);
       return n;
    }

    //Printing sum of first n natural numbers : 
    public static int sum(int n){
        if(n == 1){
            return 1;
        }
       n = n + sum(n -1);
       return n;
    }

    //Printing nth Fibonaci number : 

    public static int fibo(int n){
        if(n == 1){
            return 0;
        }
        if(n == 2){
            return 1;
        }
       n = fibo(n- 1) + fibo(n-2);
        return n;
    }

    // Checking if an array is sorted :

    public static boolean isSorted(int arr[], int i){
        if(i == arr.length-1){
            return true;
        }
        if(arr[i] >= arr[i + 1]){
            return false;
        }
        return isSorted(arr, i + 1);
    }

    // Finding the first occurence : 
    public static int occurIndex(int arr[], int key, int i){
       
        if(i == arr.length){
            return -1;
        }
        if(arr[i] == key){
            return i;
        }
        return occurIndex(arr, key, i+1);

    }

    // Finding the last occurence : 
    public static int lastIndex(int arr[], int key, int i){
       if(i == arr.length-1){
        return -1;
       }
       int foundIndex = lastIndex(arr, key, i + 1);
       
       if(foundIndex != -1){
        return foundIndex;
       }

       if(arr[i] == key){
        return i;
       }
       return -1;


    }

    //Printing number to the nth power : 
    public static int power(int n, int x){
        if(n == 0){
            return 1;
        }
        return (x * power(n-1, x));
    }

    //Alt method : O(logn)
    public static int power1(int n, int x){
        int number = power(n/2, x);
        if(n == 0){
             number = 1;
        }
        if(n % 2 == 0){
      //       number = power(n/2, x) * power(n/2, x); //Function called two times hence time complexity remains O(n)
               number = number * number; 
        }
        if(n % 2 != 0){
          // number = x * power(n/2, x) * power(n/2, x);
          number = number * number * x; 
        }
        return number;
    }

    // Tiles problem : size of the board is 2 x n, size of tile is 2 x 1
    public static int tiles(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        return tiles(n -1) + tiles(n-2);
        // tiles(n-1) for placing the tiles vertically and tiles(n-2) for placing the tiles horizontally 
    }

    // Remove duplicates from a String : 
    public static void duplicates(String str, int i, StringBuilder sb, boolean map[]){
               if(i == str.length() - 1){
                    System.out.println(sb);
                    return;
                }
                if(map[str.charAt(i) - 'a'] == true){
                    duplicates(str, i+1, sb, map);
                }
                if(map[str.charAt(i) - 'a'] == false){
                    map[str.charAt(i) - 'a'] = true;
                    duplicates(str, i+1, sb.append(str.charAt(i)), map);
            
              }
            }
        
            public static void main(String args[]){
                // boolean map[] = new boolean[26];
                // duplicates("pulkitttt", 0, new StringBuilder(""), map);
                System.out.println(fibo(9));


            }
}