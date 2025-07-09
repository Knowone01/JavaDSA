import java.util.*;
public class Queues {
    // static int arr[];
    // static int size;
    // static int rear;

    // Queues(int n) {
    //     arr = new int[n];
    //     size = n;
    //     rear = -1;
    // }

    // public static boolean isEmpty(){
    //     if (rear == -1){
    //         return true;
    //     }
    //     return false;
    // }

    // public static void add(int data){
    //     if(rear == size - 1){
    //         return ;
    //     }
    //     rear = rear + 1;
    //     arr[rear] = data;
    // }

    // public static int remove(){ 
    //     if(isEmpty()){
    //         return -1;
    //     }
    //     int front  = arr[0];
    //     for(int i = 0; i < rear; i++){
    //         arr[i] = arr[i + 1];
    //     }
    //     rear = rear - 1;
    //     return front;
    //     }

    //     public static int peek (){
    //         if(isEmpty()){
    //             return -1;
    //         }
    //         return arr[0];
    //     } 






    // Circlular queues : 
    // static int arr[];
    // static int size;
    // static int rear;
    // static int front;

    // Queues(int n) {
    //     arr = new int[n];
    //     size = n;
    //     rear = -1;
    //     front = -1;
    // }

    // public static boolean isEmpty(){
    //    return rear == -1 && front == -1;
    // }
    // public static boolean isFull(){
    //     return (rear + 1) % size == front;
    // }

    // public static void add(int data){
    //     if(isFull()){
    //         return ;
    //     }
    //     if(front == -1){
    //         front = 0 ;
    //     }
    //     rear = (rear + 1) % size;
    //     arr[rear] = data;
    // }

    // public static int remove(){ 
    //     if(isEmpty()){
    //         return -1;
    //     }
    //     int result  = arr[front];
    //    if(rear == front){
    //     rear = front = -1;
    //    }
    //    else{
    //     front = (front + 1) % size;
    //    }
    //     return result;
    //     }

    //     public static int peek (){
    //         if(isEmpty()){
    //             return -1;
    //         }
    //         return arr[front];
    //     } 





    
    // Using Linked List : 
    // static class Node{
    //     int data;
    //     Node next;

    //      Node(int data) {
    //         this.data = data;
    //         this.next = null;
    //     }
    // }
    //      static Node head = null;
    //      static Node tail = null;

    //      public static boolean isEmpty(){
    //         return head == null && tail == null;
    //      }

    //      public static void add(int data){
    //         Node newNode = new Node(data);
    //         if(isEmpty()){
    //             head = tail =  newNode;

    //         }
    //         tail.next = newNode;
    //         tail = newNode;
    //      }

    //      public static int remove(){
    //         if(isEmpty()){
    //             return -1;
    //         }
    //         int result = head.data;
    //         if(head == tail){
    //             head = tail = null;
    //         } else{
    //         head = head.next;
    //         }
    //         return result;
    //      }

    //      public static int peek(){
    //         if(isEmpty()){
    //             return -1;
    //         } 
    //         return head.data;
    //      }




    // Queue using two stacks : 

    // static Stack<Integer> s1 = new Stack<>();
    // static Stack <Integer> s2 = new Stack<>();

    //     public static boolean isEmpty(){
    //         return s1.isEmpty();
    //     }

    //     public static void add(int n){
    //         if(s1.isEmpty()){
    //             s1.push(n);
    //         }
    //         else{
    //             while(!s1.isEmpty()){
    //                 s2.push(s1.pop());
    //             }
    //             s1.push(n);
    //             while(!s2.isEmpty()){
    //                 s1.push(s2.pop());
    //             }
    //         }
    //     }

    //     public static int remove(){
    //         if(s1.isEmpty()){
    //             return -1;
    //         }
    //         return s1.pop();

    //     }

    //     public static int peek(){
    //         if(s1.isEmpty()){
    //             return -1;
    //         }
    //         return s1.peek();
    //     }


    // Stack using two queues : 

       static Queue<Integer> q1 = new LinkedList<>();
       static Queue<Integer> q2 = new LinkedList<>();

       public static boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
       }

       public static void add(int n){
        if(!q1.isEmpty()){
            q1.add(n);
        }       
        else{
            q2.add(n);
        }
       }


       public static int pop(){
        if(isEmpty()){
            return -1;
        }
        int top = -1;
        if(!q1.isEmpty()){
            while(!q1.isEmpty()){
                top = q1.remove();
                if(q1.isEmpty()){
                    break;
                }
                q2.add(top);
            }
        }
        else{
            while(!q2.isEmpty()){
                top = q2.remove();
                if(q2.isEmpty()){
                    break;
                }
                q1.add(top);
            }
        }
        return top;
       }

       public static int peek(){
        if(isEmpty()){
            return -1;
        }
        int top = -1;
        if(!q1.isEmpty()){
            while(!q1.isEmpty()){
                top = q1.remove();
                q2.add(top);
            }
        }
        else{
            while(!q2.isEmpty()){
                top = q2.remove();
                q1.add(top);
            }
        }
        return top;
       
       }



       // Interleave : 

       public static void interLeave(Queue<Integer> q){
        Queue<Integer> q1 = new LinkedList<>();
        int size = q.size();
        for(int i = 0; i < size / 2; i++){
            q1.add(q.remove());
        }
        while(!q1.isEmpty()){
            q.add(q1.remove());
            q.add(q.remove());
        }
       }



       // Implementing stacks using deque : 

       static class Stack{
        Deque<Integer> deque = new LinkedList<>();
        public void push(int data){
            deque.addLast(data);
        }
        public int pop(){
            return deque.removeLast();
        }
        public int peek(){
            return deque.getLast();
        }

       }

       // Implementing queue using deque:
       static class Queue1{
        Deque<Integer> deque = new LinkedList<>();
        public void push(int data){
            deque.addLast(data);
        }
        public int pop(){
            return deque.removeFirst();
        }
        public int peek(){
            return deque.getFirst();
        }

       }
    
        
        public static void main(String[] args) {
           //Queues q = new Queues();

          // Using JCF : 
          Queue<Integer> q = new LinkedList<>(); // ArrayDeque could have also been used instead on linked list
            q.add(1);
            q.add(2);
            q.add(3);
            q.add(4);
            interLeave(q);
            while(!q.isEmpty()){
                System.out.println(q.remove());

            }

            // Deque : 
            Deque<Integer> deque = new LinkedList<>();
            deque.addFirst(1);
            deque.addFirst(2);
            deque.addLast(3);
            deque.addLast(4);
            deque.removeLast();
            deque.removeFirst();
            System.out.println(deque.getFirst());
            System.out.println(deque.getLast());
        }
      
       
        
     }



