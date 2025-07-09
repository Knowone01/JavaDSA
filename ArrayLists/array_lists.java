import java.util.*;
public class array_lists{

    // Basics : 
public static void basics(ArrayList<Integer> list){
     // add element : 
     list.add(1); //O(1)
     list.add(3);
     list.add(1,4); //O(n)
     // Get element : 
     int n = list.get(1);
     // Remove element : 
     list.remove(1);
     // Set element : 
     list.set(1, 5);
     // Contains element : 
     System.out.println(list.contains(5));
     // Size of the array : 
     System.out.println(list.size());
     list.add(4);
     list.add(7); 
     // Sorting : 
     Collections.sort(list);
     Collections.sort(list, Collections.reverseOrder());
}

// 2D arrays : 
public static void _2Darray(){
    ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    ArrayList<Integer> list1 = new ArrayList<>();
    list1.add(4);
    list1.add(5);
    list1.add(6);
    mainList.add(list);
    mainList.add(list1);
    for(int i = 0 ; i < mainList.size(); i ++){
        ArrayList<Integer> currList = mainList.get(i);
        for(int j = 0; j < currList.size(); j ++){
            System.out.print(currList.get(j));
        }
        System.out.println();

    }

    }

    // Container with max water problem : Two Pointer Approach O(n);
    public static int maxWater(ArrayList<Integer> list){
        int maxWater = 0;
        int lp = 0;
        int rp = list.size() - 1;
        while(lp < rp){
            int height = Math.min(list.get(lp), list.get(rp));
            int width = rp - lp;
            int currWater = height * width;
            maxWater = Math.max(maxWater, currWater);
            if(list.get(lp) < list.get(rp)){
                lp++;
            }
            else{
                rp--;
            }

        }
        return maxWater;

    }

    // Pair sum 1  : 2 pointer approach :  (list should be sorted)
    public static boolean pairSum1(ArrayList<Integer> list, int key){
        int si =0 ;
        int ei = list.size() - 1;
        int sum = list.get(si) + list.get(ei);
        while(si < ei){
            if(sum == key){
                return true;
            }
            if(sum > key){
                si++;
            }
            else{
                ei--;
            }
        }
        return false;
    }

    // Pair sum 2 : rotated arrays : 
    public static boolean pairSum2(ArrayList<Integer> list, int key){
    int bp = -1;
    for(int i = 0; i <list.size() - 1; i++){
        if(list.get(i) > list.get(i+1)){
            bp = i;
            break;
        }
    }
        int n = list.size();
        int si = (bp  + 1) % n;
        int ei = bp;
        while(si != ei){
            int sum = list.get(si) + list.get(ei);
            if(sum == key){
                return true;
            }
            if(sum > key){
                ei = (n + ei - 1)% n;
            }
            else{
                si = (si + 1) % n;
            }
        }
    return false;
    }
    



    public static void main(String args[]){  
     ArrayList<Integer> list = new ArrayList<>();
     list.add(11);
     list.add(15);
     list.add(6);
     list.add(8);
     list.add(9);
     list.add(10);
   System.out.println(pairSum2(list, 16)); 
    }
}

