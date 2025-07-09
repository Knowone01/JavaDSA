import java.util.*;
public class arrays{
//     //linear search
//     public static int linearsearch(int arr[], int key){
//         for (int i = 0; i < arr.length; i ++){
//             if(arr[i] == key){
//                 return 1;
//             }
           
//         }
//         return 0;
//     }

//     // How to search the maximum number in an array
//     public static int maximum(int arr[]){
//         int max = arr[0];
//         for(int i = 0; i < arr.length; i++){
//             if(arr[i] > max){
//                 max = arr[i];
//             }
//         }
//         return max;
//     }
//     //sorting an array in ascending order
//     public static void asc(int arr[]){
//         for(int i = 0 ; i < arr.length; i++){
//             for(int j = i + 1; j < arr.length; j ++){
//                 if(arr[j] < arr[i]){
                
//                     int temp = arr[i];
//                     arr[i] = arr[j];
//                     arr[j] = temp;
//                 }
//             }
//         }
//     }

    //binary search
    public static int binarysearch(int arr[], int n){
        int size = arr.length;
        int mid, min, max;
        max = size - 1;
        min = 0;
        mid = (min + max) / 2;
        while(min <= max){
            if(arr[mid] < n){
                max = size - 1;
                min = mid  + 1;
                mid = (min + max) / 2 ;
                
            }
            if(arr[mid] > n){
                min = 0;
                max = mid - 1;
                mid = (min + max) / 2;
            }
            
            if(arr[mid] == n){
                return mid;
            }
        }
       return -1;
    }

    // //reversing an array : most efficient method, best space complexity
    // public static void reverse(int arr[]){
    //     int start = 0, end = arr.length - 1;
    //     while(start <= end){    //start < end bhi chal jata
    //         int temp = arr[start];
    //         arr[start] = arr[end];
    //         arr[end] = temp;
    //         start++;
    //         end--;
    //     }

    // }

//Printing subarrays : 

    public static void subarraysprint(int arr[]){
        for (int i = 0; i < arr.length; i++){
            for(int j = i; j < arr.length;j++){
                for (int k = i; k <= j; k++){
                    System.out.print(arr[k]);
                }
                System.out.println();
            }
        }
    }


    // printing the subarrays for a given array and then finding the maximum sum, BRUTE FORCE METHOD time complexxity = O(n^3) : 

    // public static int subarrays(int arr[]){
    //     int maxsum = Integer.MIN_VALUE; // maxsum  = -infinity
    //     for(int i = 0 ; i < arr.length; i++){
    //         for (int j = i + 1; j < arr.length; j++){
    //             int currsum = 0;
    //             for(int k = 0; k <= j; k++){
    //                 currsum = currsum + arr[k];
    //             }
    //             if(currsum > maxsum){
    //                 maxsum = currsum;
    //             }
    //         System.out.println(currsum);
    //         }
    //     }
    //     return maxsum;
    // }

    // printing the subarrays for a given array and then finding the maximum sum, PREFIX SUM METHOD time complexity = O(n^2): 
    // public static int subarrays(int arr[]){
    //     int prefix[] = new int[arr.length];
    //     prefix[0] = arr[0];
    //     for(int i = 1; i < prefix.length; i++){
    //         prefix[i] = prefix[i - 1] + arr[i];
    //     }
    //     int maxsum = Integer.MIN_VALUE;
    //     for(int i = 0; i < arr.length; i++){
    //         for(int j = i; j < arr.length; j++){
    //             int currsum; 
    //            if(i == 0){
    //             currsum = prefix[j];
    //            }
    //            else{
    //             currsum = prefix[j] - prefix[i - 1];
    //            }
    //             if(currsum > maxsum){
    //             maxsum = currsum;
    //         }
    //         }
            
    //     }
    //     return maxsum;
    // }


// printing the subarrays for a given array and then finding the maximum sum, Kandane's Algo time complexity = O(n): 
    // public static int subarrays(int arr[]){
    //     int maxsum = Integer.MIN_VALUE;
    //     int currsum = 0;
    //     for(int i = 0; i < arr.length; i++){
    //         currsum = currsum + arr[i];
    //         if(currsum < 0){
    //             currsum = 0;
    //         }
    //         if(maxsum < currsum){   //alt method: maxsum = Math.max(maxsum,currsum);
    //             maxsum = currsum;
    //         }
            
    //     }
    //     if(maxsum == 0){    //if all the elements are less than 0
    //         int max = arr[0];
    //         for(int i = 0; i < arr.length; i++){
    //             if(arr[i] > max){
    //                 max = arr[i];
    //                 maxsum = max;
    //             }
    //         }
    //     }
    //     return maxsum;
    // }

    //Trapping rainwater problem : my method, time complexity  =    O(n^2)

    // public static int trap(int arr[], int w){
    //      int i = 0, area = 0;
    //     int waterlevel;
    //     int max;
    //     while(i < arr.length -1){
    //         max = i + 1;
    //         for(int j = i + 1 ; j < arr.length; j++){
    //             if(arr[j] > arr[max]){
    //                 max = j;

    //             }
    //         }
    //         waterlevel = Math.min(arr[i], arr[max]);
            
    //         for(int j = i + 1; j < max; j++){
    //             int newarea = (waterlevel - arr[j]) * w;
    //             if(newarea < 0){
    //                 newarea = 0;
    //             }
    //             area = area + newarea;
    //         }
    //          i = max;
    //     }
    //     return area;
    // }

    //Trapping rainwater : actual method, time complexity : O(n)
    // public static int trap(int arr[], int w){
    //     int area = 0;
    //     int leftmax[] = new int[arr.length];
    //     int rightmax[] = new int[arr.length];
    //     int lmax = arr[0], rmax = arr[arr.length - 1];
    //     for(int i = 0; i < leftmax.length; i++){
    //         leftmax[i] = Math.max(lmax, arr[i]);
    //         lmax = Math.max(lmax, arr[i]);
    //     } 
    //     for(int i = rightmax.length - 1; i >= 0; i--){
    //         rightmax[i] = Math.max(rmax, arr[i]);
    //         rmax  = Math.max(rmax, arr[i]);
    //     }
    //     for(int i = 0; i < arr.length; i++){
    //         int waterlevel = Math.min(leftmax[i], rightmax[i]);
    //         area = area + (waterlevel - arr[i]) * w;
    //     }
    //     return area;
    // }



    // public static int stocks(int arr[]){
    //     int bpmin = arr[0],profitmax = 0,profit = 0;
    //     for(int i = 0; i < arr.length; i++){
    //         if(arr[i] < bpmin){
    //             bpmin = arr[i];
    //         }
    //         profit = arr[i] - bpmin;
    //         if(profit > profitmax){
    //             profitmax = profit;
    //         }
    //     }
    //     return profitmax;
    // }


    // public static void main(String arg[]){
        // int marks[] = new int[50]; //once the size of the arrays is declared, it cannot be change when the program is running, defualt value is zero
        // int numbers[] = {1,2,3};
        // String fruits[]  = {"apple", "mango"};
        // Scanner sc = new Scanner (System.in);
        // marks[0] = sc.nextInt();
        // marks[1] = sc.nextInt();
        // System.out.println(marks[0]); //unlike in C, we can change the individual values of an array
        // marks[0] = marks[0] + 2;
        // System.out.println(marks[0]);
        // System.out.println(marks.length); //marks.length gives the number of elements in an array


    //     int marks[] = {1,2,3,4,5};
        
    //     for(int i = 0; i < 5; i++){
    //         System.out.println(marks[i]);
    //     }

    //     for (int element: marks){   //other method to display elements
    //         System.out.println(element);
    //     }

    // }
    // int arr[] = {1,2,3,4,5};
    // System.out.println(linearsearch(arr,4));

//     int arr[] = {7,1,5,3,6,4};
   

//     System.out.println(stocks(arr));


// }
 
public static void main(String args[]){
    int arr[] = {2,4,6,8,10,12};
   subarraysprint(arr);

}
}