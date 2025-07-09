
import java.util.ArrayList;


public class tries {
    static class Node{
        Node[] children = new Node[26];
        boolean eow = false;

         Node() {
            for(int i = 0; i < children.length; i++){
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();


    public static void insert(String str){
        Node curr = root;

        for(int i = 0; i < str.length(); i++){
            int idx = str.charAt(i) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static boolean search(String str){
        Node curr = root;
        for(int i = 0; i < str.length(); i++){
            int idx = str.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }
    // Word Break : 
    // Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
    // Note that the same word in the dictionary may be reused multiple times in the segmentation.

    public boolean wordSearch(String s){
        if(s.length() == 0){
            return true;
        }
        for(int i = 1 ; i <= s.length(); i++){
            if(search(s.substring(0,i)) && wordSearch(s.substring(i,s.length()))){
                return true;
            }
        }
        return false;
    }
    public boolean wordBreak(String s, ArrayList<String> wordDict) {
        for(int i = 0; i < wordDict.size(); i++){
            String str = wordDict.get(i);
            insert(str);
        }
       return wordSearch(s);
    }

    // Prefix Problem :  find the min number length of string which must be printed so that the prefix is unique; 
    //  I : ["zebra", "dove", "duck", "dog"] => O : ["z", "dov", "du", " dog" ]
    /*
    Changes to be made in class : 
   -> class Node{
     Node[] children = new Node[26];
         boolean eow = false;
         int freq = 0;
         Node(){
            for(int i = 0; i < children.length; i++){
               children[i] = null;
            }
            freq=  1;

         }
    }
    and in the insert function : 

  ->   public  static void insert(String word){
            Node curr = root;
            for(int i = 0; i < word.length(); i++){
               int idx = word.charAt(i) - 'a';
               if(curr.children[idx]==null){
                  Node node = new Node();
                  curr.children[idx] = node;
               }
               else{
                  curr.freq++;
               }
               curr =  curr.children[idx];
            }
            curr.eow = true;
         }


  -> final solution incoorporating these changes : 
  public static void output(String ans, Node curr){
         if(root == null){
            return;
         }
          if(curr.freq == 1){
            System.out.println(ans);
            return;
         }
         for(int i =  0 ; i < 26; i++){
            if(curr.children[i] !=null){
            output(ans+ (char)(i + 'a'), curr.children[i]);   
            }
         }
      }
      
      
      public static void prefix(String[] arr){
         for(int i = 0 ; i < arr.length; i++){
            insert(arr[i]);
         }
         root.freq = -1;
         Node curr = root;
         String ans = "";
         output(ans, curr);
      }



    */

    // String break : 

    public static boolean wordBreak(String str){
        if(str.length() == 0){
            return true;
        }
        for(int i = 1; i <= str.length(); i++){
            if(search(str.substring(0,i)) && wordBreak(str.substring(i))){
                return true;
            } ;
        }
        return false;
    }

    // Starts with : 

    public static boolean startsWith(String str){
        Node curr = root;
        for(int i = 0; i < str.length(); i++){
            int idx = str.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    // Unique Substring : Find the total number of distinct substrings of a given string
    // I : abab => O: 10
    public static int numberOfNode(Node curr){
        if(curr == null){
            return 0;
        }
        int nodes= 0;
        for(int i = 0 ; i < 26; i++){
            if(curr.children[i]!= null){
                nodes += numberOfNode(curr.children[i]);
            }
            
        }
        return nodes + 1;
    }
    public static void unique(String s){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            String s1 = s.substring(i);
            insert(s1);
        }
        System.out.println(numberOfNode(root));
    }

    // Longest word : 

    public static String str = "";
    public static void longest(Node root, StringBuilder sb){
        if(root == null){
            return;
        }
        for(int i = 0; i < 26; i++){
            if(root.children[i] != null && root.children[i].eow == true){
                char ch = (char)(i + 'a');
                sb.append(ch);
                if(str.length() < sb.length()){
                    str = sb.toString();
                }
                longest(root.children[i], sb);
            sb.deleteCharAt(sb.length() - 1);
            }   
        }

    }
    

    public static void main(String[] args) {
    
        // String words[] = {"a", "banana", "app", "appl","ap", "apply", "apple"};
        // for(int i = 0 ;i < words.length; i++){
        //     insert(words[i]);
        // }
        // longest(root, new StringBuilder(""));
        // System.out.println(str);

        // String str = "th";
        // System.out.println(startsWith(str));
        unique("apple");
        
    }
}
