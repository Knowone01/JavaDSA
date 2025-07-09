
public class sortingalgo{
    //Bubble sort: 
    public static void bubblesort(int arr[]){
        for(int i = 0; i < arr.length - 1;i++){
            for(int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j] >arr[j + 1]){
                    int temp= arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
        
    }

    //Selection sort:
    public static void selectionsort(int arr[]){
        
        for(int i = 0; i < arr.length - 1; i++){
           int min = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
           int temp = arr[i];
           arr[i] = arr[min];
           arr[min] = temp;
        }
        for(int i = 0; i < arr.length; i ++){
            System.out.println(arr[i]);
        }
    }

        //Insertion sort : 

        public static void insertionsort(int arr[]){
            for(int i = 0; i < arr.length - 1; i++){
                for(int j = i + 1; j > 0; j--){
                    if(arr[j] < arr[j-1]){
                        int temp = arr[j];
                        arr[j] = arr[j-1];
                        arr[j-1] = temp;
                    }
                }
            }
             for(int i = 0; i < arr.length; i ++){
            System.out.println(arr[i]);
        }
        }
        


        //Inbuilt sort: 
        //import java.util.Arrays;
        //Arrays.sort(arr); : time complexity : O(nlogn) < O(n^2)
        //alt method : Arrays.sort(arr.si.ei); si: starting index, ei: ending index which is non exclusive : [) 

        //import java.util.Collections; Impoty for sorting arrays in descending order
        //Arrays.sort(arr,Collections.reverseOrder()); Syntax, Only for Integer(object) variable, won't work for int type variable
        //Arrays.sort(arr,si,ei,Collections.reverseOrder()); si- starting index, ei: ending index
        

        //Counting Sort
    
        public static void countingsort(int arr[]){
            int largest = Integer.MIN_VALUE;
            for(int i = 0; i < arr.length; i++){
                largest = Math.max(largest,arr[i]);
            }

            int count[] = new int[largest + 1];
            for(int i = 0; i < arr.length; i++){
                count[arr[i]]++;
            }
 
            int j = 0; 
            for(int i = 0; i < count.length; i++){
                while(count[i] > 0){
                    arr[j] = i;
                    j++;
                    count[i]--;
                }
            }
        }

    public static void main(String arg[]){
        int arr[] = {5,4,1,3,2};
        insertionsort(arr);
        
       
    }


        
    
}