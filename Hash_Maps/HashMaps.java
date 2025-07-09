import java.util.*;


public class HashMaps{
    // Implementation 
    static class HashMap<K, V>{ //generics (the data type of key and value is not known)
        private class Node{
            K key;
            V value;
            Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

            private int N;  // total number buckets
            private int n; // total number of nodes
            private LinkedList<Node> buckets[];
            
            @SuppressWarnings("unchecked") // supresses warning thrown by java, linked list sometimes requires to specify the type of data being stored in it 

            public HashMap(){ 
                this.N = 4; // completely random
                this.buckets = new LinkedList[4];
                for(int i = 0; i < 4; i++){
                    this.buckets[i] = new LinkedList<>();
                }
            }

            private int hashFunction(K key){
                int hc = key.hashCode();
                return Math.abs(hc) % N;
            }

            private int searchInLL(K key, int bi){
                LinkedList<Node> ll =buckets[bi];
                for(int i = 0 ; i< ll.size(); i++){
                    Node node = ll.get(i);
                    if(node.key == key){
                        return i;
                    }
                }
                return -1;

            }
            @SuppressWarnings("unchecked")
            private void rehash(){
                LinkedList<Node> oldBucket[] = buckets;
                buckets = new LinkedList[N * 2];
                N = 2 * N;
                for(int i = 0; i < oldBucket.length; i++){
                    buckets[i] = new LinkedList<>();
                }
                for(int i = 0; i < oldBucket.length; i++){
                    LinkedList<Node> ll = oldBucket[i];
                    for(int j = 0 ; j < ll.size(); j++){
                        Node node = ll.remove();
                        put(node.key, node.value);
                    }
                }
            }

            public void put(K key, V value){
                int bi = hashFunction(key);
                int di = searchInLL(key, bi);

                if(di != -1){
                    Node node = buckets[bi].get(di);
                    node.value = value;
                }
                else{
                    Node node = new Node(key, value);
                    buckets[bi].add(node);
                    n++;
                }

                double lambda = (double)n/N;
                if(lambda > 2.0){
                    rehash();
                }
            }

            public boolean containsKey(K key){
                int bi = hashFunction(key);
                int di = searchInLL(key, bi);

                if(di != -1){
                    return true;
                }
                else{
                    return false;
                }
            }

            public V get(K key){
                int bi = hashFunction(key);
                int di = searchInLL(key, bi);

                if(di != -1){
                  LinkedList<Node> ll = buckets[bi];
                  return ll.get(di).value;

                }
                else{
                    return null;
                }
            }

            public V remove(K key){
                int bi = hashFunction(key);
                int di = searchInLL(key, bi);
                if(di != -1){
                     LinkedList<Node> ll = buckets[bi];
                    Node node =  ll.remove(di);
                     n--;
                         return node.value;
                }
                else{
                    return null;
                }
            }

            public ArrayList<K> keySet(){
                ArrayList<K> keys = new ArrayList<>();
                for(int i = 0 ; i < buckets.length; i++){
                    LinkedList<Node> ll = buckets[i];
                    for (Node node : ll) {
                        keys.add(node.key);
                    }

                }
                return keys;

            }

            public boolean isEmpty(){
                return n == 0;
            }
            @SuppressWarnings("unchecked")
            public void print(){
                for(int i = 0; i < buckets.length; i++){
                    LinkedList<Node> ll = buckets[i];
                   for(int j =0; j < ll.size(); j++){
                    Node node = ll.get(j);
                    System.out.println(node.key + " = " + node.value);
                   }
                }
            }    
    }

    // Majority element : 
    // Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

 
    public static void majorityElement(int arr[]){
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < arr.length;i++){
           hm.put(arr[i], hm.get(arr[i]) + 1);

        }
        for (int key : hm.keySet()) {
            if(hm.get(key) >= arr.length / 3){
                System.out.println(key);
            }
        }
      
    }

    // Count distinct elements : 
    public static int distinctElements(int arr[]){
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0 ; i < arr.length; i++){
            hs.add(arr[i]);
        }
        return hs.size();
    }


    // Find itinerary for tickets : 
// You’re given a set of flight tickets represented as a HashMap, where each entry maps a source city to a destination city.
//Your task is to determine the starting city of the complete itinerary — i.e., the city from which the journey starts and is not the destination of any other ticket.


    public static String start (HashMap<String, String> hm){
        HashMap<String , String> rev = new HashMap<>();
        for (String key : hm.keySet()) {
            rev.put(hm.get(key), key);
        }
        for (String  key : hm.keySet()) {
            if(!rev.containsKey(key)){
                return key;
            } 
        }
        return null;
    }


    // Largest subarray with sum 0 : Given an array of integers, find the length of the longest subarray whose elements sum up to zero.

    public static int largestSubarray(int arr[]){
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        int length = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(hm.containsKey(sum)){
                length = Math.max(length, i - hm.get(sum));
            }
            else{
                hm.put(sum, i);
            }
        }
        return length;
    }

    // Number of subarrays with sum equals with k : 
    
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum+= nums[i];
            arr[i] = sum;

        }
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0,1); // imp step to consider the arr[i] itself
        int ans = 0;
        for(int i = 0; i < n;i++){
            int a = arr[i] - k;
            if(mp.containsKey(a) ){
               ans+= mp.get(a);
            }
            if(mp.containsKey(arr[i])){
                 mp.put(arr[i], mp.get(arr[i]) + 1);
            }
            else{
                 mp.put(arr[i], 1);
            }
            
            //if mp.put(0,1) is not used !! -> 
            // if(arr[i] == k){
            //     ans++;
            // }
            
        }

        
        
        return ans;
    }





    public static void main(String[] args) {
        // Iterating over hashmaps : 
        // HashMap<String , Integer> hm = new HashMap<>();
        // hm.put("a", 10);
        // hm.put("b", 20);
        // hm.put("c", 30);
        // Set<String> keys = hm.keySet();
        // for (String k : keys) {
        //     System.out.println(k + hm.get(k));;
        // }

        // HashCode<String , Integer> hm = new HashCode();
        // hm.put("a", 1);
        // hm.put("b", 2);
        // hm.put("c", 4);
        // hm.print();
        // hm.remove("a");
        // ArrayList<String> keySet = hm.keySet();
        // for (String key : keySet) {
        //     System.out.println(key + " ");
        // }
       
       
    //    // Linked Hash Map : 
    //     LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
    //     lhm.put("b", 1);
    //     lhm.put("a", 2);
    //     System.out.println(lhm);

    //     // Tree Map  : 
    //     TreeMap<String, Integer> tm = new TreeMap<>();
    //     tm.put("b", 2);
    //     tm.put("a", 1);
    //     System.out.println(tm);

//     int arr[] = {1,3,2,5,1,3,1,5,1};
//    majorityElement(arr);



//    // Hash sets : 
//    HashSet<String> hs = new HashSet<>();
//    hs.add("Delhi");
//    hs.add("Mumbai");
//    hs.add("Pune");
//    hs.add("Gzb");
//    System.out.println(hs);

//    LinkedHashSet<String> lhs = new LinkedHashSet<>();
//    lhs.add("Delhi");
//    lhs.add("Mumbai");
//    lhs.add("Pune");
//    lhs.add("Gzb");
//    System.out.println(lhs);

//    TreeSet <String> ts = new TreeSet<>();
//    ts.add("Delhi");
//    ts.add("Mumbai");
//    ts.add("Pune");
//    ts.add("Gzb");
//    System.out.println(ts);

  
  
//    // Iterators : 
//    Iterator i = hs.iterator();
//    while(i.hasNext()){
//     System.out.println(i.next());
//    }

//    // alt : 

//    for (String key : hs) {
//     System.out.println(key);
    
//    }
        
        int arr[] = {4,3,2,5,6,7,3,4,2,1};
        System.out.println(distinctElements(arr));

        HashMap<String , String> hm = new HashMap<>();
        hm.put("c", "b");
        hm.put("m", "d");
        hm.put("g", "c");
        hm.put("d", "g");

        String start = start(hm);
        System.out.print(start);
        for (String  key : hm.keySet()) {
            System.out.print(" --->" + hm.get(start));
            start = hm.get(start);
            
        }  
        System.out.println();
        
        int arr1[] = {15,-2,2,-8,1,7,10};
       System.out.println(largestSubarray(arr1));
    }
}   