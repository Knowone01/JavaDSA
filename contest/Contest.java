import java.io.BufferedReader;
import java.io.IOException;

public class Contest {
    public static class Edge {
        int src, dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }
    
    static class Vertex implements Comparable<Vertex> {
        int id;
        int degree;
        
        Vertex(int id, int degree) {
            this.id = id;
            this.degree = degree;
        }
        
        @Override
        public int compareTo(Vertex other) {
            // Higher degree gets higher priority (descending order)
            return Integer.compare(other.degree, this.degree);
        }
    }

    public static void function1(BufferedReader br) throws IOException {
        // Read number of vertices and edges
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]); 
        String [] secondLine = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
    arr[i] = Integer.parseInt(secondLine[i]);
}
         int[] minLeft = new int[n];  // min[i] = min of arr[0..i-1]
        int[] maxRight = new int[n];
        minLeft[0] = Integer.MAX_VALUE; // No elements to the left of index 0
        for (int i = 1; i < n; i++) {
            minLeft[i] = Math.min(minLeft[i - 1], arr[i - 1]);
        }

        // Build maxRight
        maxRight[n - 1] = Integer.MIN_VALUE; // No elements to the right of last index
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], arr[i + 1]);
        }
        String ans = "";
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > minLeft[i] && arr[i] < maxRight[i]){
                ans+= '0';
            }
            else{
                ans+='1';
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            function1(br);
        }
    }
}