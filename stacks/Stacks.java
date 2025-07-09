

import java.util.*;

public class Stacks {


    //Using arrayList : 
    static class StackAL{
        static ArrayList<Integer> list = new ArrayList();
        public static boolean isEmpty(){
            return list.size() == 0;
        }

        //push : 
        public static void push1(int data){
            list.add(data);
        
        }

        // pop : 
        public static int pop1(){
            if(isEmpty()){
                return -1;
            }
            int top = list.get(list.size() - 1);
            list.remove(list.get(list.size() - 1));
            return top;

        }
        public static int peek1(){
            return list.get(list.size() - 1);
        }
    }

    // Using linkedList : 

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static class StackLL{
        static Node head = null;

        public static boolean isEmpty(){
            return head == null;
        }

        // push : 

        public static void push2(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        // pop  :
        public static int pop2(){
            if(isEmpty()){
                return -1;
            }
            int data = head.data;
            head = head.next;
            return data;
        }

        // peek :
        public static int peek2(){
            if(isEmpty()){
                return -1;
            }
            return head.data;
        }


    }


    // Push at bottom  : 
    public static void pushAtBottom(Stack<Integer> s, int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }
        //alt approach (using LL): 

    // public static void pushAtBottom(int data){
    //      Node newNode = new Node(data);
    //      Node temp = head;
    //      while(temp.next != null){
    //         temp = temp.next;
    //      }
    //      temp.next = newNode;
    //   }



    // Reversing a String : 
    public static String reveString(String str){
        Stack<Character> s = new Stack<>();
        int index= 0;
        while(index < str.length()){
            s.push(str.charAt(index));
            index++;
        }
        StringBuilder newStr = new StringBuilder("");
        while(!s.isEmpty()){
            newStr = newStr.append(s.pop());
                }
        return newStr.toString();

    }

    // Reversing a stack :
    public static void revStack(Stack<Integer> s){
        if(s.isEmpty()) {
            return;
        }
        
       int data =  s.pop();
        revStack(s);
        pushAtBottom(s, data);
    }

    // Stock span problem : 
//     You are given an array stocks[] of size n, where stocks[i] represents the price of a stock on day i.
    //    For each day i, you need to calculate the stock span, which is defined as:
    //    The number of consecutive days just before day i (including day i itself) for which the stock price was less than or equal to the price on day i.
    //  Input : stocks[] = {100, 80, 60, 70, 60, 75, 85}
    // Output : span[] =   {1,   1,  1,  2,  1,  4,  6}

    public static void stockSpan(int stocks[], int span[]){
        Stack<Integer> s = new Stack<>();
        span[0] = 1 ;
        s.push(0);
        for(int i = 1; i < stocks.length; i++){
            
            while(!s.isEmpty() && stocks[i] > stocks[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i] = i+1;
            }
            else{
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }
            s.push(i);


        }
    }
    // my soln : 

     public static void stock(int[] stock){
      int[] data = new int[stock.length];
      for(int i = 0; i < stock.length; i++){
         data[i] = 1;
      }
      Stack<Integer> s = new Stack<Integer>();
      s.push(0);
      for(int i = 1; i < stock.length; i++){
         if(stock[i] <= stock[s.peek()]){
            s.push(i);
         }
         else{
            while(!s.isEmpty() && stock[i] >= stock[s.peek()]){
               data[i] += data[s.peek()];
               s.pop();
            }
            s.push(i);
         }
      }
      for(int i = 0; i < data.length; i++){
         System.out.print(data[i] + " ");
      }

    }

    // next greater : 
    // Given an array of integers elements[], for each element, find the next greater element to its right.
    // The Next Greater Element for an element x is the first element to the right of x in the array that is greater than x.
    // If no such element exists, assign -1.
    // Input:  [6, 8, 0, 1, 3]
    // Output: [8, -1, 1, 3, -1]


    public static void nextGreater(int elements[]){
        int nextG[] = new int[elements.length];
        nextG[nextG.length - 1] = -1;
        Stack <Integer> s = new Stack<>();
        s.push(nextG.length - 1);
        for(int i = elements.length - 2; i >= 0; i--){
        while(!s.isEmpty() && elements[i] >= elements[s.peek()]){
            s.pop();
        }
        if(s.isEmpty()){
            nextG[i] = -1;
        }
        else{
        nextG[i] = elements[s.peek()];
        }
        s.push(i);
    }
        for(int i= 0; i < nextG.length; i++){
            System.out.print( " " + nextG[i]);
        }
    }

    

    // Valid parentheses : 
    // Given a string str consisting of characters '(', ')', '{', '}', '[', and ']', determine if the input string has valid parentheses.
    // A string is considered valid if:
	// 1.	Every opening bracket has a corresponding closing bracket of the same type.
	// 2.	Brackets are closed in the correct order (i.e., no mismatched or out-of-order brackets).
	// 3.	Every closing bracket has a corresponding opening bracket before it.
    // Input: "({[]})"
    // Output: true

    // Input: "((]"
    // Output: false

    // Input: "([)]"
    // Output: false

    // Input: "{[]}"
    // Output: true
    public static boolean validParentheses(String str){
        Stack <Character> s = new Stack<>();
        for(int i =0 ; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){ 
                s.push(ch);
            }
            else{
                if(s.isEmpty()){
                    return false;
                }
                if(
                    (s.peek() == '(' && ch == ')') ||
                    (s.peek() == '{' && ch == '}')||
                    (s.peek() == '[' && ch == ']')
                )
                {
                    s.pop();
                } 
                else{
                    return false;
                }
            }
            
        }
        if(!s.isEmpty()){
            return false;
        }
        return true;

    }

    // Duplicate parentheses : 
    //     You are given a valid mathematical expression as a string str, containing lowercase characters, operators (+, -, *, /), and parentheses '(' and ')'.
//  Your task is to detect if the expression contains any duplicate (redundant) parentheses.
// Duplicate parentheses are those which do not enclose any meaningful content — for example:
// 	•	Empty parentheses like "()"
// 	•	Parentheses that enclose only another pair of parentheses like "((a))" 
    // Input: "((a+b))"
    // Output: true  
    // Explanation: The outermost pair of parentheses is unnecessary — duplicate.


    // Input: "(a+b*(c-d))"
    // Output: false

    // Input: "(a+(b))"
    // Output: true  
    // Explanation: `(b)` is enclosed unnecessarily — duplicate.

    // Input: "()"
    // Output: true  
    // Explanation: Empty parentheses — definitely duplicate.
    public static boolean  duplicate(String str){
        Stack <Character> s =new Stack<>();
        for(int i = 0; i <str.length(); i++){
            int count = 0;
            if(str.charAt(i) == ')'){
                while(s.pop() != '('){
                    count++;
                }
                if(count < 1){
                    return true;
                }
            }
            else{
                s.push(str.charAt(i));
            }
        }
        return false;
    }


    // max area :
    // You are given an array arr[] representing the heights of bars in a histogram where the width of each bar is 1.
    // Task:
    // Find the area of the largest rectangle that can be formed within the bounds of the histogram.
//     Input: arr = [2, 1, 5, 6, 2, 3]
//     Output: 10
//     Explanation: The largest rectangle has area 10 and is formed by bars with heights 5 and 6.
    public static int maxArea(int arr[]){
        Stack<Integer> s = new Stack<>();
        int[] nsr = new int[arr.length];
        int [] nsl = new int[arr.length];

        for(int i = arr.length - 1; i >= 0 ; i--){
            while(!s.isEmpty()&& arr[i] <= arr[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i] = arr.length;
            }
            else{
                nsr[i] = s.peek();
            }
            s.push(i);
            
        }
        s = new Stack<>();
        for(int i = 0; i < arr.length; i++){
           while(!s.isEmpty() && arr[i] <= arr[s.peek()]){
            s.pop();
           }
           if(s.isEmpty()){
            nsl[i] = -1;
           }
           else{
            nsl[i] = s.peek();
           }
           s.push(i);
        }

    int maxArea = 0;
    for(int i = 0; i < arr.length; i++){
        int height = arr[i];
        int width = nsr[i] -nsl[i] - 1;
        maxArea = Math.max(height*width, maxArea);
    }
    return maxArea;
    }

    public static void main(String args[]){
         // Using java collections framework : 
        Stack<Integer> s2 = new Stack<>();
        s2.push(1);
        s2.push(2);
        s2.push(3);
       revStack(s2);
        while(!s2.isEmpty()){
            System.out.println(s2.peek());
            s2.pop();
        }

      int arr[] = {2,1,5,6,2,3};
      System.out.println(maxArea(arr));
    
    }

   
   
    
}
