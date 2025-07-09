

public class divideAndConquer{

    //Merge Sort : Time complexity : O(nlogn), Space Complexity : O(n);
    public static void mergeSort(int arr[], int si, int ei){
        if(si == ei){
            return;
        }
        int mid = si + (ei - si)/2;
        mergeSort(arr, si ,mid);
        mergeSort(arr, mid + 1, ei);    
        merge(arr, si, ei, mid);
        
    }
    public static void merge(int arr[], int si, int ei, int mid){
        int i = si; // iterator for first array
        int j = mid + 1; // iterator for second array
        int k = 0; // iterator for temporary array
        int temp[] = new int[ei - si + 1];
        while(i <= mid && j <= ei){
            if(arr[i] <= arr[j]){
                temp[k]= arr[i];
                i++;
            }
            else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        while(i <= mid){
            temp[k++] = arr [i++];
        } // if any element in the first array is left
        while(j <= ei){
            temp[k++] = arr[j++];
        } // if any element in the second array is left
    
        for(k =0, i = si; k < temp.length; k++,i++){
            arr[i] = temp[k];
        } // final sorted array
    }

    // Quick sort : Usual time complexity= O(nlogn) ; worst case -> On^2 (occurs when the pivot element is either the largest or the smallest), Space complexity = O(1)

    public static void quickSort(int arr[], int si, int ei){
        if(si >= ei){
            return;
        }
        int pivotIndex = partition(arr, si, ei);
        quickSort(arr, si, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, ei);
    }
    public static int partition(int arr[], int si, int ei){
        int pivot = ei;
        int i = si-1;
        for (int j = si; j < ei; j++){
            if(arr[j] <= arr[pivot]){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
 
            }
        }
            i++;
            int temp = arr[i];
            arr[i] = arr[pivot];
            arr[pivot] = temp;
            pivot = i;
            return pivot;
        
    }
        
    


    public static void main(String args[]){
        int arr[] = {6,3,9,5,2,8};
       quickSort(arr, 0, arr.length - 1);
       for(int i = 0; i < arr.length; i ++){
        System.out.print(arr[i] + " ");
       }

}
}