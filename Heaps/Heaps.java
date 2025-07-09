import java.util.*;
public class Heaps{
    // The compare to class has a function compareTo which needs to be specified (overriden)
   static class Student implements Comparable<Student>{
        String name;
        int age;
       public Student(String name, int age){
            this.name = name;
            this.age = age;
        }
        @Override
        public int compareTo(Student s2){
            return this.age - s2.age;
        }

    }

    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();
        public void add(int data){
            arr.add(data);

            int x = arr.size() - 1;
            int par = (x - 1) / 2;
            while(arr.get(x) <= arr.get(par) && x > 0){
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);
                x = par;
                par = (x - 1)/ 2;
            }
        }

        public void print(){
            for(int i = 0; i < arr.size(); i++){
                System.out.print(arr.get(i) + " ");
            }
        }

        public int peek(){
            return arr.get(0);
        }

    // You are given an ArrayList arr representing a binary heap, which may have been disrupted due to the removal or replacement of an element.
    // Your task is to restore the min-heap property starting from a given index i.
    // Input - arr = [10, 3, 2, 7, 5, 6, 4]
   //  Output - arr = [2, 3, 4, 7, 5, 6, 10]

       private void heapify(int i){
            int min = i; 
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if(left < arr.size() && arr.get(left) < arr.get(min)){
                min = left;
            }
            if(right < arr.size() && arr.get(right) < arr.get(min)){
                min = right;
            }
            if(min != i){
                int temp = arr.get(i);
                arr.set(i, arr.get(min));
                arr.set(min, temp);
                heapify(min); 
            }
           
        }
        public int remove(){
            int data = arr.get(0);
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);
            arr.remove(arr.size() - 1);
            heapify(0);
            return data;
        }
        public boolean isEmpty(){
            return arr.size() == 0;
        }
        
    }
    // Heap sort : 
    public static void maxHeapify(int arr[], int i, int size){
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max = i;
        if(left < size && arr[left] > arr[max]){
            max = left;
        }
        if(right < size && arr[right] > arr[max]){
            max = right;
        }
        if(max != i){
            int temp = arr[i];
            arr[i]  = arr[max];
           arr[max] = temp;
            maxHeapify(arr, max, size); 
        }

    }

    public static void heapSort(int arr[]){
        int n = arr.length;
        for(int i = n/2 - 1; i >= 0; i--){
            maxHeapify(arr, i, n);
        }

        for(int i = n-1; i >= 0; i--){
            int temp = arr[0];
            arr[0]  =arr[i];
            arr[i] = temp;
            maxHeapify(arr, 0, i);
        }
    }

    // max window : 
    // You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. 
    // You can only see the k numbers in the window. Each time the sliding window moves right by one position.
    // Return the max sliding window.

//M1: 
    static class Pair implements  Comparable<Pair>{
        int val;
        int idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
        public int compareTo(Pair p2){
            return p2.val - this.val;
        }
        
    }

    public static void maxWindow(int arr[], int k){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int result[] = new int[arr.length - k + 1];
        for(int i = 0; i < k; i++){
            pq.add(new Pair(arr[i], i));
        }

        result[0] = pq.peek().val;

        for(int i = k; i < arr.length; i++){
            while(pq.size() != 0 && pq.peek().idx <= (i - k)){
                pq.remove();
            }
            pq.add(new Pair(arr[i], i));
            result[i - k + 1] = pq.peek().val;
        }
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
            
        }


    }
    // Much effective solution using deque : 
    //M2:
    class Solution {
    public void print(Deque<Integer> dq){
        if(dq.size() == 0){
            return;
        }
        int n = dq.removeFirst();
        System.out.print(n + " ");
        print(dq);
        dq.add(n);
    }
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[n-k+1];
      for(int i = 0;i<k;i++){
        while(!dq.isEmpty()&& arr[i]>= arr[dq.peekLast()]){
            dq.removeLast();
        }
        dq.addLast(i);
      }
      ans[0] = arr[dq.peekFirst()];
      int l = 1;
      int h = k;
      while(h<n){
        if(dq.peekFirst()<l){
            dq.removeFirst();
        }
        while(!dq.isEmpty() && arr[h]>=arr[dq.peekLast()]){
            dq.removeLast();
        }
        dq.addLast(h);
        ans[l] = arr[dq.peekFirst()];
        l++;
        h++;
      }
      return ans;

        


        
}
}

    public static void main(String args[]){
        // // Priority queues : 
        // PriorityQueue<Student>pq = new PriorityQueue<>(); // ascending order by defualt , new PriorityQueue<>(Comparator.reverseOrder); for descending order
        // pq.add(new Student("a", 20));
        // pq.add(new Student("b", 12));
        // pq.add(new Student("c", 47));

        // while(!pq.isEmpty()){
        //     System.out.println(pq.peek().age);
        //     pq.remove();
        // }

        // Heap h = new Heap();
        // h.add(2);
        // h.add(3);
        // h.add(4);
        // h.add(5);
        // h.add(10);
        // h.add(6);
        // while(!h.isEmpty()){
        //     System.out.print(h.peek() + " ");
        //     h.remove();
        // }

        // int arr[] = {1,2,6,4,5,3};
        // heapSort(arr);
        // for(int i = 0; i < arr.length; i++){
        //     System.out.println(arr[i]);
        // }
        int arr1[] = {1,3,-1,-3,5,3,6,7};
        maxWindow(arr1, 3);
        

    }
}