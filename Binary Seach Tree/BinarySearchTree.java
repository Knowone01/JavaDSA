
import java.util.*;


public class BinarySearchTree {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
        
    }
// Inserting : 
    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(val > root.data){
            root.right = insert(root.right, val);
        }
        else{
            root.left = insert(root.left, val);

    }
    return root;
}
public static void inOrder(Node root){
    if(root == null){
        return;
    }
    inOrder(root.left);
    System.out.print(root.data + " ");
    inOrder(root.right);
}

// Search : O(h) 

public static boolean search(Node root, int key){
    if(root == null){
        return false;
    }
    if(root.data == key){
        return true;
    }
    if(root.data > key){
        return search(root.left, key);
    }
    else{
        return search(root.right, key);
    }
}

// Root to leaf(print every path from root to leaf) : 
public static void printPath(ArrayList<Integer> path){
    for(int i = 0; i < path.size(); i++){
        System.out.print(path.get(i) + " ");
    }
    System.out.println();
}

public static void rootToLeaf(Node root, ArrayList<Integer> path){
    
    if(root == null){
        return; 
    }
    path.add(root.data);
    if(root.left == null  && root.right == null){
        printPath(path);
    }
    rootToLeaf(root.left, path);
    rootToLeaf(root.right, path);
    path.remove(path.size() - 1);

}

// isValidBST : 

 public int findMin(Node root){
        Node curr = root;
        if(curr.left!=null){
             while(curr.left!=null){
            curr = curr.left;
        }
        }
        
        return curr.data;
    }
    public int findMax(Node root){
        Node curr = root;
        if(curr.right!=null){
            while(curr.right!=null){
            curr = curr.right;
        }
        }
        return curr.data;
    }
    public boolean isValidBST(Node root) {
      int min = 0;
       int max= 0;
        if(root == null){
            return true;
        }
        if(root.right!=null){
            min = findMin(root.right);
            if(root.data >= root.right.data||min<= root.data ){
            return false;
        }
      
        }
        if(root.left!=null){
            max = findMax(root.left);
            if(root.data <= root.left.data|| max >= root.data){
            return false;
        }
        }
        
        return (isValidBST(root.left)&& isValidBST(root.right));
        
        
    
}


// Deleting a node : 
public Node deleteNode(Node root, int key) {
        if (root == null) {
            return null;
        }
        if (root.data > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.data < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                Node node = findInorderSuccessor(root);
                root.data = node.data;
                root.left = deleteNode(root.left, node.data);
            }
        }

        return root;

    }
public static Node findInorderSuccessor(Node root) {
   Node curr = root;
        if (root.left != null) {
            curr = curr.left;
            while (curr.right != null) {
                curr = curr.right;
            }
            return curr;
        }
        return root;
}


// Balanced BST : 

public static Node balancedBST(ArrayList <Integer> inOrderPath, int si, int ei){
    if(si >ei){
        return null;
    }
    int mid = (si + ei) / 2;
    Node root = new Node(mid);
    root.left = balancedBST(inOrderPath, si, mid - 1);
    root.right = balancedBST(inOrderPath, mid + 1, ei);
    return root;
}
public static void preOrder(Node root){
    if(root == null){
        return;
    }
    System.out.print(root.data + " ");
    preOrder(root.left);
    preOrder(root.right);
}



public static void main(String[] args) {
    int values[] = {8,5,3,1,4,6,10,11,14};
    Node root = null;
    for(int i = 0; i < values.length; i++){
        root = insert(root, values[i]);
    }

//    inOrder(root);
//    System.out.println();
//    delete(root, 5);
//    inOrder(root);
//    System.out.println();

   ArrayList<Integer> path = new ArrayList<>();
   path.add(1);
   path.add(3);
   path.add(4);
   path.add(5);
   path.add(6);
   path.add(8);
   path.add(10);
   path.add(11);
   path.add(14);
   balancedBST(path, 0, path.size() - 1);
   

   balancedBST(path, 0, path.size() - 1);
    preOrder(root);



    }     
}  
