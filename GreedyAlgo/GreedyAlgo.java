
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;



public class GreedyAlgo {

    // Number of activities : ending time should be sorted
    public static int activities(int start[], int end[]){

        // sorting : 
        int activity[][] = new int[start.length][3];
        for(int i = 0; i < start.length; i++){
            activity[i][0] = i;
            activity[i][1] = start[i];
            activity[i][2] = end[i];
        }
        // lambda function : 

        Arrays.sort(activity, Comparator.comparingDouble(o -> o[2]));


        int maxAct = 0; 
        ArrayList <Integer> ans = new ArrayList<>();
        maxAct = 1;
        ans.add(activity[0][0]);
        int lastEnd = activity[0][2];
        for(int i =1; i < start.length; i++){
            if(activity[i][1] >= lastEnd){
                maxAct++;
                ans.add(activity[i][0]);
                lastEnd = activity[i][2];
            }
        }
        return maxAct;
    }

    // Min abs difference : 
    public static int absDifference(int arr1[], int arr2[]){
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int minDif = 0;
         for(int i = 0; i < arr1.length; i++){
            minDif += Math.abs(arr1[i] - arr2[i]);
         }
        
         return minDif;
    }

    // Chocola problem : 

    public static int choc(Integer costVert[], Integer costHor[]){
       Arrays.sort(costHor, Collections.reverseOrder());
       Arrays.sort(costVert, Collections.reverseOrder());
       int h= 0, v= 0 ;
       int hp = 1, vp =1;
       int cost = 0;
       while(h < costHor.length&& v < costVert.length){
        if(costHor[h] >= costVert[v]){
            cost += vp * costHor[h];
            hp++;
            h++;
        }
        else{
            cost += hp * costVert[v];
            vp++;
            v++;
        }
       }
       while(h < costHor.length){
        cost += vp * costHor[h];
        hp++;
        h++;
    }
    while (v < costVert.length){
        cost += hp * costVert[v];
        vp++;
        v++;
    }
       return cost;
    }
    public static void main(String[] args) {
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};
        System.out.println(activities(start, end));
        int arr1[] = {4,1,8,7};
        int arr2[] = {2,3,6,5};
        System.out.println(absDifference(arr1, arr2));

        Integer costVert[] = {2,1,3,1,4};
        Integer costHor[] = {4,1,2};
        System.out.println(choc(costVert, costHor));
    }
}
