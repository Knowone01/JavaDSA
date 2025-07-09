

public class DoublyLinkedList {
    class Node{
        int data;
        Node prev;
        Node next;
        Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    public static Node head;
     public static Node tail;
    public static int size = 0;
    // add first : 
     public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            size ++;
            return;
        }
        newNode.next = head;
        head.prev = newNode;   
        head = newNode;
        size ++;
     }
     // remove first : 
     public void removeFirst(){
        if(head == null){
        return;
        }
        if(size == 1){
            head = tail = null;
            size --;
        }
      head = head.next;
      head.prev = null;
        size --;
     }

    // add last : 
    public void addLast(int data){
        Node newNode = new Node(data);
        tail.next = newNode;
        newNode.prev= tail;
        tail = newNode;
        size ++;

    }
    // remove last : 
    public void removeLast(){
        if(size == 0){
            return;
        }
        if(size == 1){
            head= tail = null;
            size--;
        }
        tail = tail.prev;
        tail.next = null;

    }

    // reverse a dll : 

    public void reverse(){
        Node curr = head;
        Node prev= null;
        Node next ;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

     public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.print(" " + temp.data);
            temp = temp.next;
        }
        System.out.println();
    }

     public static void main(String args[]){
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addFirst(1);
        dll.addFirst(2);
        dll.addFirst(3);
        dll.addLast(4);
        dll.reverse();
        dll.printList();
     }
}
