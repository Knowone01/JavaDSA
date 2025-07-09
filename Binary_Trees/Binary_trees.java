
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;





public class Binary_trees {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }  
    }
    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int Nodes[]){
            idx++;
            if(Nodes[idx] == -1 ){
                return null;
            }
            Node newNode = new Node(Nodes[idx]);
            newNode.left = buildTree(Nodes);
            newNode.right = buildTree(Nodes);
        

            return newNode;
        }
        
    }

    // Pre order traversal : 
    public static void preOrder(Node root){
        if(root == null){
            System.out.print("-1 ");
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    
    }

    // Inorder traversal : 
    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
       inOrder(root.right);
    }

    // post order traversal : 
    public static void postOrder(Node root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
       
    }

    //level order traversal : 

    public static void leveOrder(Node root){
        Queue <Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                    System.out.println();
                }
            }
            else{
                System.out.print(curr.data + " ");
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }

        }
    }

    // height of a tree : 
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        int currH = Math.max(rh, lh) + 1;
        return currH;
        
        
    }

    // Number of nodes : 
    public static int number(Node root){
        if(root == null){
            return 0;
        }
        int lCount = number(root.left);
        int rCount = number(root.right);
        int currCount = lCount + rCount + 1;
        return currCount;
    }

    // Sum of nodes : 
    public static int sum(Node root){
        if(root == null){
            return 0;
        }
        int lSum = sum(root.left);
        int rSum = sum(root.right);
        int currSum = lSum + rSum + root.data;
        return currSum;
    }

    // Diameter #1 : O(n^2) 

    // Give the number of nodes in the longest path b/w any two leaves
    public static int diameter1(Node root){
        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        int selfD = lh + rh + 1;
        int rd = diameter1(root.right);
        int ld = diameter1(root.left);
        return Math.max(selfD, Math.max(ld, ld));
    }

    // // Diameter #2 : O(n)
    // static class Info{
    //     int dia;
    //     int ht;
    //      Info( int dia, int ht){
    //         this.dia = dia;
    //         this.ht = ht;
    //     }
    // }
    // public static Info diameter2(Node root){
    //     if(root == null){
    //         return new Info(0,0);
    //     }
    //     Info leftInfo = diameter2(root.left);
    //     Info rightInfo = diameter2(root.right);
    //     int height = Math.max(leftInfo.ht, rightInfo.ht) + 1;
    //     int diameter = Math.max(Math.max(leftInfo.dia, rightInfo.dia), leftInfo.ht + rightInfo.ht + 1);
    //     return new Info(diameter, height);
    // }

    // Subtreees : 
    
    public static boolean isIdentical(Node node, Node subRoot){
        if(node == null && subRoot == null){
            return true;
        }
        else if(node == null || subRoot == null || node.data != subRoot.data){
            return false;
        }
        if(!isIdentical(node.left, subRoot.left)){
            return false;
        }
        if(!isIdentical(node.right, subRoot.right)){
            return false;
        }
        return true;

    }
    public static boolean isSubtree(Node root, Node subRoot){
        if(root == null){
            return false;
        }
        if(isIdentical(root,subRoot)){
            return true;
        }
        
        return isSubtree(root.left, subRoot)|| isSubtree(root.right, subRoot);
    }

    // Top view of a tree : 
//     Given the root of a binary tree, print the top view of the binary tree.
    // The top view of a binary tree is the set of nodes visible when the tree is viewed from the top. You need to return the nodes in order from leftmost to rightmost horizontal distance.
    // Each node is associated with a horizontal distance (hd) from the root:
    // 	•	The root has hd = 0
    // 	•	The left child of a node has hd = hd - 1
    // 	•	The right child has hd = hd + 1
    // If two or more nodes are at the same horizontal distance, only the first node encountered in level order traversal should be included in the top view.

    static class Info{
        Node node;
        int hd;

        public Info(Node node, int hd) {
            this.hd = hd;
            this.node = node;
        }
        
    }
    public static void topView(Node root){
            Queue <Info> q = new LinkedList<>();
            HashMap<Integer, Node> map = new HashMap<>();
            int min =0, max = 0;

            q.add(new Info(root, 0));
            q.add(null);

            while(!q.isEmpty()){
                Info curr = q.remove();
                if(curr == null){
                    if(q.isEmpty()){
                        break;
                    } else{
                        q.add(null);
                    }

                }
                else{
                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd, curr.node);
                }
                if(curr.node.left != null){
                    q.add(new Info(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }
                if(curr.node.right != null){
                    q.add(new Info(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }

            }
        }
            for(int i = min; i<= max; i++){
                System.out.print(map.get(i).data + " ");
            }


    }

    // lowest common ancestor : 
//     Given the root of a binary tree and two node values n1 and n2, return the Lowest Common Ancestor (LCA) of the two nodes.
//     The lowest common ancestor is defined as the lowest node in the tree that has both n1 and n2 as descendants (where a node can be a descendant of itself).
        // M1 : 
    public static boolean getPath(Node root, int n, ArrayList<Node> path){
        if(root == null){
            return false;
        }
        path.add(root);
        if(root.data == n){
            return true;
        }
        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);
        if(foundLeft || foundRight){
            return true;
        }
        path.remove(path.size() -1);

        return false;
       


    }

    public static Node leastCommonAncestor(Node root, int n1, int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        getPath(root, n1, path1);
        getPath(root, n2, path2);
        int i = 0;
        for(; i < path1.size() && i < path2.size(); i++){
            if(path1.get(i) != path2.get(i)){
            break;
            }
        }
        Node lca  = path1.get(i-1);
        return lca;

    }

        // M2 : 
    
        public static Node lca2(Node root, int n1, int n2){
            if(root.data ==n1 || root.data == n2 || root == null){
                return root;
            }
            Node leftLca = lca2(root.left, n1, n2);
            Node rightLca = lca2(root.right, n1, n2);

            if(leftLca == null){
                return rightLca;
            }
            if(rightLca == null){
                return leftLca;
            }
            return root;
        }

    // Post Order, level order and preorder traversal in one traversal : 

    public static void traversal(Node root, ArrayList<Integer> pre, ArrayList<Integer> in, ArrayList<Integer> post){
        if(root == null){
            return;
        }
        pre.add(root.data);
        traversal(root.left,pre,in,post);
        in.add(root.data);
        traversal(root.right,pre,in,post);
        post.add(root.data);
    }


    public static void main(String[] args) {
      Node root = new Node(1);
      root.left = new Node(2);
      root.right = new Node(3);
      root.left.left = new Node(4);
      root.left.right = new Node(5);
      root.right.left = new Node(6);
      root.right.right = new Node(7);


      Node subRoot = new Node(2);
      subRoot.left = new Node(4);
      subRoot.right = new Node(6);

      System.out.println(isSubtree(root, subRoot));
     topView(root);
     System.out.println();
     System.out.println(leastCommonAncestor(root, 4, 5).data);

       

        
    }
}
