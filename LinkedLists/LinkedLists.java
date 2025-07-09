


public class LinkedLists{

public static class Node{ 
    int data; 
    Node next;
    public Node(int data){
        this.data = data;
        this.next = null; 
    }
    // Creating head and tail : 
    
}

public static Node head;
public static Node tail;
public static int size = 0;

public void addFirst(int data){
    size++;
    Node newNode  = new Node(data);
    if(head == null){
        head = tail =  newNode;
        return;
    }
    newNode.next = head;
    head = newNode;

}
public void addLast(int data){
    size++;
    Node newNode = new Node(data);
    if(head == null){
        head = tail = newNode;
        return;
    }
    tail.next = newNode;
    tail = newNode;
}

//Printing a linked list : 
public void printList(){
    Node temp = head;
    while(temp != null){
        System.out.print(" " + temp.data);
        temp = temp.next;
    }
    System.out.println();
}


//Adding an element in the middle
// NOTE : For example -
// Node1 (memory address: 0x001)
//   data: A
//   next: 0x002 (address of Node2)

// Node2 (memory address: 0x002)
//   data: B
//   next: 0x003 (address of Node3)

// Node3 (memory address: 0x003)
//   data: C
//   next: null

//     : When you do Node temp = head;, you’re saying:
// 	•	“Let temp hold the same memory address as head.”
// 	•	Now, temp points to the object at 0x001 (Node1).

// When you update temp.next:
// 	•	You are accessing the memory location 0x001 (Node1) and modifying its next field to point to another memory address (like newNode).

// Why Changes Reflect in the List

// Because temp and head both point to the same memory location (Node1), modifying temp.next directly updates the actual Node1 object in memory. Any other variable pointing to the same node will see the updated structure.
// •	Primitive types (like int) are passed/copied by value.
// •	Reference types (like objects) share the same memory location.


public void addInMiddle(int index, int data){
    Node newNode = new Node(data);
    size++;
    if(index == 0){
        addFirst(data);
    }
    int i = 0;
    Node temp = head;
    while(i < index){
       temp = temp.next; 
       i++;
    }
    newNode.next = temp.next;
    temp.next = newNode;
   
    
}

//Remove first : 
public void removeFirst(){
    if(size == 0){
        System.out.println("ERROR");
    }
    if(size == 1){
        head = tail = null;
    }
    head = head.next;
    size--;
}

// Remove last : 
public void removeLast(){
    if(size == 0){
        System.out.println("ERROR");
    }
    if(size == 1){
        head = tail = null;
        size--;
    }
    Node currNode = head;
    for(int i = 0; i < size - 2; i++){ // 0th index corresponds to the next node after head
        currNode = currNode.next;
    }
    currNode.next = null;
   tail = currNode;
    size--;
}

// Iterative search :
public int itrSearch(int key){
    Node currNode = head;
    int i = 0;
    while(currNode != null){
        if(currNode.data == key){
            return i;
        }
        currNode = currNode.next;
        i++;
    }
    return -1;
}


// Recursive Search : 
// Consider a linked list: 10 -> 20 -> 30 -> 40, and the key is 30.
// 	1.	First call: helper(curr=10, key=30)
// 	•	curr.data != key
// 	•	Recursive call: helper(curr=20, key=30)
// 	2.	Second call: helper(curr=20, key=30)
// 	•	curr.data != key
// 	•	Recursive call: helper(curr=30, key=30)
// 	3.	Third call: helper(curr=30, key=30)
// 	•	curr.data == key
// 	•	Return 0 (position at this node)
// 	4.	Returning back up:
// 	•	From the third call: Return 0 + 1 = 1
// 	•	From the second call: Return 1 + 1 = 2
// 	•	From the first call: Return 2 + 1 = 3
public int helper(Node curr, int key){
    if(curr.data == key){
        return 0;
    }
    if(head == null || curr == null){
        return -1;
    }
    int index = helper(curr.next, key); // recursive step
    if(index == -1){
        return -1;
    }
    return index + 1;
}
public int recSearch(int key){
    Node curr = head;
    return helper(curr, key);
}

// Reversing a linked list : 

public void rev(){
    Node curr = head.next;
    Node next;
    Node prev = tail = head; // implementation starts from right to left for this equations
    while(curr != null){
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    head = prev;
    tail.next = null;

}

// Finding and removing nth node from the end : 
public void removeNth(int n){
    int sz = 0;
    Node temp = head;
    while(temp != null){
        temp = temp.next;
        sz++;
    } // Finding size
    if(n == size){
        head = head.next;
        return;
    }
    int index = sz - n ;
    Node prev = head;
    for(int i = 0 ; i < index; i++){
        prev= prev.next;
    }
    prev.next = prev.next.next;

}

// Detect cycle code : 
public static boolean isCycle(){
    Node slow = head;
    Node fast = head;
    while(fast != null && fast.next != null){
        fast = fast.next.next;
        slow = slow.next;
        if(fast == slow){
            return true;
        }
    }
    return false;
}

// Removing the cycle : 
public static void removeCycle(){
    Node fast = head;
    Node slow = head;
    boolean cycle = false;
    while(fast != null && fast.next !=null){
        fast = fast.next.next;
        slow = slow.next;
        if(fast == slow){
            cycle = true;
            break;
        }
    }
    Node prev = null;
    if(cycle == true){
        slow = head;
        while(fast != slow){
            prev = fast;
            fast = fast.next;
            slow = slow.next;
        }
        prev.next = null;
    }
   

}

// Merge Sort :
    // Finding mid : 
public static Node getMid(Node head){
    Node slow = head;
    Node fast = head.next;
    while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}
    // Merge function : 

public static Node merge(Node leftHead, Node rightHead){
    if(leftHead == null){
        return rightHead;
    }
    if(rightHead == null){
        return leftHead;
    }
   
    Node tempHead = new Node(-1);
    Node temp = tempHead;
    while(leftHead != null && rightHead != null){
    if(rightHead.data >= leftHead.data){
        temp.next= leftHead;
        leftHead = leftHead.next;
        temp =temp.next;
       
    }
    else{
        temp.next= rightHead;
        rightHead = rightHead.next;
        temp = temp.next;
       
    }
}
    while(rightHead != null){
        temp.next = rightHead;
        rightHead = rightHead.next;
        temp = temp.next;
    }
    while(leftHead != null){
        temp.next = leftHead;
        leftHead = leftHead.next;
        temp = temp.next;
    }
    return tempHead.next;

}
    // Merge sort function

public static Node mergeSort(Node head){
    if(head == null || head.next == null){
        return head;
    }
   Node mid = getMid(head);
   Node leftHead = head;
   Node rightHead = mid.next;
   mid.next = null; // to break the linked list into two
   Node newLeft = mergeSort(leftHead);
   Node newRight = mergeSort(rightHead);
   
   return merge(newLeft, newRight);
}


// Zig zag linked list : 
public void zigZag(Node head){
    Node mid = getMid(head);
    Node rightTail = mid.next;
    Node curr = mid.next;
    Node curr1 = mid;
    mid.next = null;
    // reversing the right part
    while(curr != null){
        Node temp = curr.next;
        curr.next = curr1;
        curr1 = curr;
        curr = temp;

    }
      
    rightTail.next = null;

    Node left =head;
    Node right = curr1;
    Node nextL = new Node(-1), nextR = new Node(-1);
    while(nextL!= null && nextR != null){
        nextL = left.next;
        left.next = right;
        nextR = right.next;
        right.next = nextL;

        left = nextL;
        right = nextR;
    }

}




    public static void main(String args[]) {  
        LinkedLists ll = new LinkedLists();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.printList();
        ll.zigZag(head);
        ll.printList();
     

}

}