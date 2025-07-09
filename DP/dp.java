
import java.util.Arrays;
import java.util.HashMap;





public class dp{
    //  Fibonacci : Recursion 
    public static int fibo(int n){
        if(n==1|| n==0){
            return n;
        }
        return fibo(n-1) + fibo(n-2);
    }

    // Fibonacci : memoization
    public static int fibo1(int n, int[] arr){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(arr[n]!=0){
            return arr[n];
        }
        else{
            arr[n] = fibo1(n-1, arr) + fibo1(n-2, arr);
        }
        return arr[n];
    }

    // Fibonacci : tabulation 
    public static int fibo2(int n){
        int arr[] = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        for(int i =2; i <= n; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }

    // Climbing stairs : Count ways to reacht the nth stair. The person can clumb either
    //  1 or 2 stairs at a time 

    public static int stairs1(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        return stairs1(n-1) + stairs1(n-2);
    }

    public static int stairs2(int n, int[] arr){
        if(arr[n]!=0){
            return arr[n];
        }
        arr[n]= stairs2(n-1,arr) + stairs2(n-2,arr);
        return arr[n];
    }

    public static int stairs3(int n){
        int arr[] = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        for(int i = 2; i <n; i++){
            arr[i] = arr[i-1]+arr[i-2];
        }
        return arr[n-1];
    }

    // 0-1 Knapsack 
    /*
    Given n items, each with a value v[i] and weight w[i], and a knapsack of capacity W, 
    select a subset of items to maximize total value, such that the total weight ≤ W.
    You cannot take fractions of an item—each item must be either taken whole or not at all.

    Input : val[] = 15,14,10,45,30
            wt[] = 2,5,1,3,4
            maxWt = 7
    Ouput : 75
    */

   public static int knap1(int[] val, int[] wt, int max, int curr){
        if(max ==0 || curr == val.length){
            return 0;
        }
        if(max >= wt[curr]){
        int inc = knap1(val, wt, max - wt[curr], curr+1) + val[curr];
        int exc = knap1(val, wt, max, curr+1);
        return Math.max(inc, exc);
        }
       else{
        return knap1(val, wt, max, curr+1);
       }    
   }

   public static int knap2(int[] val, int[] wt, int max, int curr, int[][]dp){
        if(max ==0 || curr == val.length){
            
            return 0;
        }
        if(dp[curr][max] != -1){
            return dp[curr][max];
        }
        if(max >= wt[curr]){
        int inc = knap2(val, wt, max - wt[curr], curr+1, dp) + val[curr];
        int exc = knap2(val, wt, max, curr+1,dp);
        dp[curr][max] = Math.max(inc, exc);
        return dp[curr][max];
        }
       else{
        dp[curr][max]= knap2(val, wt, max, curr+1,dp);
        return dp[curr][max];
       }  
     
   }

   public static void knap3(int val[], int wt[], int maxWt){
    int dp[][] = new int[val.length+1][maxWt+1];
    for(int i = 1; i < val.length+1; i++){
        for(int w = 1; w< maxWt+1; w++){
            if(wt[i-1] > w){
                dp[i][w] = dp[i-1][w];
                continue;
            }
            int inc = val[i-1] + dp[i-1][w-wt[i-1]];
            int exc =  dp[i-1][w];
            dp[i][w] = Math.max(inc, exc);
        }
    }
    for(int i = 0; i < val.length+1; i++){
        for(int j = 0 ; j < maxWt + 1; j++){
            System.out.print(dp[i][j] + " ");
        }
        System.out.println();
    }
   }


   //   Target Sum Subset : Tell if the target sum can be achieved from the given array of values : 
    // Used tabulation in the code : 
    /*
    Input -> 4,2,7,1,3 and target sum is 10
    Output -> True
    */

    public static boolean sum(int[] val, int key){
        boolean dp[][] = new boolean[val.length+1][key+1];
        for(int i = 0 ; i < val.length; i++){
            dp[i][0] = true;
        }
        for(int i = 1;i < val.length+1; i++){
            for(int j = 1; j < key+1; j++){
                if(dp[i-1][j]){
                    dp[i][j] = true;
                    continue;
                }
                if(val[i-1] > j){
                    continue;
                }
                int rem = j - val[i-1];
                if(dp[i-1][rem]){
                    dp[i][j] = true;
                }
                
            }
        }
        for(int i = 0 ; i < val.length+1;i++){
            if(dp[i][key]){
                return true;
            }
        }
        return false;
    } 

    // Unbounded knapsack : Elements can be added more than once, 

    public static void knap4(int val[], int wt[], int maxWt){
    int dp[][] = new int[val.length+1][maxWt+1];
    for(int i = 1; i < val.length+1; i++){
        for(int w = 1; w< maxWt+1; w++){
            if(wt[i-1] > w){
                dp[i][w] = dp[i-1][w];
                continue;
            }
            int inc = val[i-1] + dp[i][w-wt[i-1]];
            int exc =  dp[i-1][w];
            dp[i][w] = Math.max(inc, exc);
        }
    }
    for(int i = 0; i < val.length+1; i++){
        for(int j = 0 ; j < maxWt + 1; j++){
            System.out.print(dp[i][j] + " ");
        }
        System.out.println();
    }
   }

//  Coin change : Give the total number of ways to make change for a given amount using the given denominations.
// Input : coins[] = 2,5,3,6
// Output : 5

public static void coin(int[] coins, int sum){
    int dp[][] = new int[coins.length+1][sum+1];
    for(int i = 0 ; i < coins.length+1; i++){
        dp[i][0] = 1;
    }
    for(int i = 1 ; i < sum+1; i++){
        dp[0][i] = 0;
    }
    for(int i = 1; i < coins.length+1; i++){
        for(int j = 1 ; j < sum+1; j++){
            if(coins[i-1] <= j){
                 dp[i][j] = dp[i][j - coins[i-1]] + dp[i-1][j];
            }
            else{
                dp[i][j] = dp[i-1][j];
            }
           
        }
    }
    for(int i = 0; i < coins.length+1; i++){
        for(int j = 0 ; j < sum + 1; j++){
            System.out.print(dp[i][j] + " ");
        }
        System.out.println();
    }

}

// Rod cutting : Given a rod of length n inches and an array of prices that includes prices of all pieces of size smaller than n. 
// Determine the maximum value obtainable by cutting up the rod and selling the pieces
// length  = 1  2  3  4  5  6  7  8  
// price   = 1  5  8  9 10 17 17 20  
// rodLength = 8
// NOTE : The same cut can be made more than once

public static void rod(int[] cuts, int[] val, int length){
    int dp[][] = new int[cuts.length+1][length+1];
    for(int i = 0; i < cuts.length+1; i++){
        dp[i][0] = 0;
    }
    for(int i = 1; i <length+1; i++){
        dp[0][i] = 0;
    }

    for(int i = 1; i < cuts.length+1; i++){
        for(int j = 1; j < length+1; j++){
            if(cuts[i-1] >= j){
                dp[i][j]  = dp[i-1][j];
            }
            else{
                dp[i][j] = Math.max(val[i-1] + dp[i][j - cuts[i-1]], dp[i-1][j]);
            }
        }
    }
    for(int i = 0; i < cuts.length+1; i++){
        for(int j = 0; j < length+1; j++){
            System.out.print(dp[i][j] + " ");
        }
        System.out.println();
    }

}

// Longest Common Subsequence : A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted 
// without changing the relative order of the remaining characters.
/*
str1 = "abcde", str2 = "ace"
ans = 3 // "ace"

str1 = "abcdge", str2 = "abdg"
ans = 4 // "abdg"
*/

public static int sub1(String str1, String str2, int l1, int l2){
    if(l1 == 0 || l2 ==0){
        return 0;
    }
    if(str1.charAt(l1-1) == str2.charAt(l2-1)){
        return sub1(str1, str2, l1-1, l2-1) + 1;
    }
    else{
        int ans1 = sub1(str1, str2, l1-1, l2);
        int ans2 = sub1(str1, str2, l1, l2-1);
        return Math.max(ans1, ans2);
    }
}

// Memoization : 
public static int sub2(String str1, String str2, int l1, int l2, int dp[][]){
    if(l1 == 0 || l2 ==0){
        return 0;
    }
    if(dp[l1][l2] != -1){
        return dp[l1][l2];
    }
    if(str1.charAt(l1-1) == str2.charAt(l2-1)){
        dp[l1][l2] = sub2(str1, str2, l1-1, l2-1,dp) + 1;
        return dp[l1][l2];
    }
    else{
        int ans1 = sub2(str1, str2, l1-1, l2,dp);
        int ans2 = sub2(str1, str2, l1, l2-1,dp);
        dp[l1][l2] = Math.max(ans1, ans2);
        return dp[l1][l2];
    }
}

// Tabulation : 
public static int sub3(String str1, String str2){
    int dp[][] = new int[str1.length()+1][str2.length()+1];
    for(int i = 1; i < str1.length()+1; i++){
        for(int j = 1; j < str2.length()+1; j++){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                dp[i][j] = dp[i-1][j-1] + 1;
            }
            else{
                int ans1 = dp[i-1][j];
                int ans2 = dp[i][j-1];
                dp[i][j] = Math.max(ans1, ans2);
            }
        }
    }
    return dp[str1.length()][str2.length()];

}


// Longest Common Substring : 
// Input : abcde Output : abcge, Output ;2

public static int lcs(String str1, String str2){
    int dp[][] = new int[str1.length()+1][str2.length()+1];
    int ans = 0;
    for(int i = 1;i < str1.length(); i++){
        for(int j = 1; j < str2.length(); j++){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                dp[i][j] = dp[i-1][j-1]+1; // Carrying over the data from the prev iteration, i.e. before these two letters were added (dp[i-1][j-1])
                ans = Math.max(dp[i][j], ans);
            }
            else{
                dp[i][j] = 0;
            }
        }
    }
    return ans;
}

// Longest Increasing substring : 
public static void lis(int arr[]){
    int dp[][] = new int[arr.length+1][arr.length+1];
    HashMap<Integer, Integer> mp = new HashMap<>();
    for(int i = 0 ; i < arr.length; i++){
        mp.put(arr[i], i);
    }
    int arr2[] = new int[arr.length];
    int idx = 0 ;
    for(Integer val : mp.keySet()){
        arr2[idx] = val;
        idx++;
    }
    Arrays.sort(arr2);
    for(int i = 1; i < arr.length+1; i++){
        for(int j = 1; j < arr2.length+1; j++){
            if(arr[i-1] == arr2[j-1]){
                dp[i][j] = dp[i-1][j-1] + 1;
            }
            else{
                int ans1 = dp[i-1][j];
                int ans2 = dp[i][j-1];
                dp[i][j] = Math.max(ans1, ans2);
            }
        }
    }

    for(int i = 0; i < arr.length; i++){
        for(int j = 0 ; j < arr2.length; j++){
            System.out.print(dp[i][j]);
        }
        System.out.println();
    }

    
}

// Edit dist 
//Input - abc -> sbd, Output - 2

public static int word(String str1, String str2){
    int dp[][] = new int[str1.length()+1][str2.length()+1];
    for(int i = 0; i < str1.length()+1; i++){
        dp[0][i] = i;
    }
    for(int i = 0; i < str2.length()+1; i++){
        dp[i][0] = i;
    }

    for(int i = 1; i < str1.length()+1; i++){
        for(int j = 1; j < str2.length()+1; j++){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                dp[i][j] = dp[i-1][j-1];
            }
            else{
                int ans1 = dp[i][j-1]; //add
                int ans2 = dp[i-1][j]; // adding 
                int ans3 = dp[i-1][j-1]; // replace
                dp[i][j] = Math.min(ans1, Math.min(ans2, ans3)) + 1;

            }
        }
    }
    return dp[str1.length()][ str2.length()];
}


// WildCard : You are given two strings:
// 	•	s — the input string
// 	•	p — the pattern string, which may contain the wildcard characters:
// 	•	'?' matches any single character
// 	•	'*' matches any sequence of characters (including the empty sequence)
//  Task:
// Return true if the entire input string s matches the entire pattern p, considering the wildcard rules. Otherwise, return false.
//  Input : String str = "baaabab";
 //           String pat = "*****ba*****ab";
// Output : true

public static boolean wildCard(String str, String pat){
    boolean dp[][] = new boolean[str.length()+1][pat.length()+1];
    dp[0][0] = true;
    for(int i = 1; i < pat.length()+1; i++){
        if(pat.charAt(i-1) == '*'){
            dp[0][i] = dp[0][i-1];
        }
        else{
            dp[0][i] = false; // ? cannot be null 
        }
    }

    for(int i =1;i < str.length()+1; i++){
        for(int j =1 ; j < pat.length()+1; j++){
            if(str.charAt(i-1) == pat.charAt(j-1) || pat.charAt(j-1) == '?'){
                dp[i][j] = dp[i-1][j-1];
            }
            else if(pat.charAt(j-1) == '*'){
                boolean ignore = dp[i][j-1];
                boolean include = dp[i-1][j];
                dp[i][j] = ignore || include;
            }
            
        }
    }
    return dp[str.length()][pat.length()];
}

//Catalan's problem : 
    //Memoization -> 
public static int catalan1(int n, int[] dp){
    if(dp[n]!= 0){
        return dp[n];
    }
    else{
        int ans = 0;
        for(int i = 0 ; i < n; i++){
            ans+= catalan1(i,dp)*catalan1(n-1-i, dp);
        }
        dp[n] = ans;
        return dp[n];
    }
}
    // Tabulation 
public static int catalan2(int n){
    int dp[] = new int[n+1];
    dp[0] = 1;
    dp[1] = 1;
    for(int i = 2 ; i < n+1; i++){
        for(int j = 0; j < i; j++){
            dp[i]+= dp[j]*dp[i-j-1];
        }
    }
    return dp[n];
}


// Couting Trees : Find all number of all possible BSTs with given n nodes : 
// Input : 3
// Ouput : 5
// code is exactly same as catalan number
public static int countTrees(int n){
    int dp[] = new int[n+1];
    dp[0] = 1;
    dp[1] = 1;
    for(int i = 2 ; i < n+1; i++){
        for(int j = 0; j < i; j++){
            dp[i]+= dp[j]*dp[i-j-1];
        }
    }
    return dp[n];
}

//  Mountain ranges : Find the number of mountains possible for a given number of up and downstroke pairs,
// NOTE : At any moment the number of downstrokes cannot be greater than number of upstrokes, also the starting and the final point should be one the same level
// Input : 4
//  Output : 14
// code is exactly same as catalan number
public static int mountain(int n){
    int dp[] = new int[n+1];
    dp[0] = 1;
    dp[1] = 1;
    for(int i = 2 ; i < n+1; i++){
        for(int j = 0; j < i; j++){
            dp[i]+= dp[j]*dp[i-j-1];
        }
    }
    return dp[n];
}  


// Matrix multiplication : Give the min number of operations required to perform matrix multiplication,
// NOTE : to multiply A(axb) with B (bxc), number of operations required a x b x c
// Input : 1,2,3,4,3 => (1x2), (2x3), (3x4), (4x3)
// Ouput : 30

public static int mcm(int arr[], int i, int j){
    if(i==j){
        return 0;
    }
    int ans = Integer.MAX_VALUE;
    for(int k = i; k < j; k++){
       int cost1 = mcm(arr, i, k);
       int cost2 = mcm(arr, k+1, j);
       int cost3 = arr[i-1]*arr[k]* arr[j];
       ans = Math.min(ans, cost1+cost2+cost3);

    }
    return ans;
}

// Memoization : 
public static int mcm1(int arr[], int i, int j, int[][] dp){
    if(i==j){
        return 0;
    }
    if(dp[i][j] != -1){
        return dp[i][j];
    }
    int ans = Integer.MAX_VALUE;
    for(int k = i; k < j; k++){
       int cost1 = mcm(arr, i, k);
       int cost2 = mcm(arr, k+1, j);
       int cost3 = arr[i-1]*arr[k]* arr[j];
       ans = Math.min(ans, cost1+cost2+cost3);
        dp[i][j] = ans;

    }
    return dp[i][j];
}

// Tabulation : 
public static int mcm2(int val[]){
    int dp[][] = new int[val.length][val.length];
    for(int len = 2; len < val.length; len++){
        for(int i = 1; i<= val.length - len; i++){
            int j = i + len - 1;
            dp[i][j] = Integer.MAX_VALUE;
            for(int k = i; k < j; k++){
                int cost1 =dp[i][k];
                int cost2 = dp[k+1][j];
                int cost3 = val[i-1] * val[k] * val[j];
                dp[i][j] = Math.min(dp[i][j], cost1+cost2+cost3);
            }
        }
    }   
    for(int i = 0 ; i < val.length; i++){
        for(int j = 0 ; j < val.length; j++){
            System.out.print(dp[i][j] + " ");
        }
        System.out.println();
    }
    return dp[1][val.length-1];

}

//  Minimum partitioning : Find min subset sum difference for a given array
// 0-1 Knapsack variation 
// Input : {1,6,11,15}
// Output : 1

public static int part(int val[]){
    int sum = 0;
    for(int i = 0; i < val.length; i++){
        sum+= val[i];
    }
    int w = sum/2;
    int dp[][] = new int[val.length+1][w+1];
    for(int i = 1 ; i < val.length+1; i++){
        for(int j = 1; j < w+1; j++){
            if(val[i-1] <= j){
                int include = val[i-1] + dp[i-1][j-val[i-1]];
                int exclude = dp[i-1][j];
                dp[i][j] = Math.max(include, exclude);
            }
            else{
                dp[i][j] = dp[i-1][j];
            }
        }
    }
    int ans = Math.abs(dp[val.length][w] - (sum - dp[val.length][w]));
    return ans;
}

// Min jumps : 
//  int val[] = {2,3,1,1,4};
// Ouput : 2

public static int jumps(int[] val){
    int n = val.length;
    int dp[] = new int[n];
    Arrays.fill(dp, -1);
    dp[n-1] = 0;
    for(int i = n-2; i>= 0; i--){
        int ans = Integer.MAX_VALUE;
        for(int j = i+1; j <= i+val[i] && j < n; j++){
            if(dp[j]!= -1){
                ans = Math.min(ans, dp[j] + 1);
            }
        }
        if(ans!= Integer.MAX_VALUE){
            dp[i] = ans;
        }
    }
    return dp[0];
}






    public static void main(String[] args) {
    
    int[] val = {2,3,1,1,4};
    System.out.println(jumps(val));
    
    
      
       
    }
}