import java.util.*;

public class Graphs {

    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    // bfs : 

    // public static void bfs(ArrayList<Edge>[] graph) {
    //     Queue<Integer> q = new LinkedList<>();
    //     boolean vis[] = new boolean[graph.length];
        
    //     // Start BFS from node 0
    //     q.add(0);
    //     vis[0] = true;

    //     while (!q.isEmpty()) {
    //         int curr = q.remove();
    //         System.out.print(curr + " ");

    //         // Explore all neighbors of curr
    //         for (int i = 0; i < graph[curr].size(); i++) {
    //             int neighbor = graph[curr].get(i).dest;
    //             if (!vis[neighbor]) {
    //                 q.add(neighbor);
    //                 vis[neighbor] = true;
    //             }
    //         }
    //     }
    // }

    // dfs : 

    // public static void dfs(ArrayList<Edge>[] graph, int curr, boolean vis[]){
    //     System.out.print(curr+ " ");
    //     vis[curr] = true;
    //     for(int i = 0 ; i < graph[curr].size(); i++){
    //         if(!vis[graph[curr].get(i).dest]){
    //             dfs(graph, graph[curr].get(i).dest, vis);
    //         }
    //     }
    // }

    //has path : given source and dest, tell if the path exists

    public static boolean hasPath(ArrayList<Edge>[] graph,int src, int dest, boolean vis[]){
        if(src == dest){
            return true;
        }
        vis[src] = true;
        for(int i = 0; i < graph[src].size(); i++){
            if(!vis[graph[src].get(i).dest] && hasPath(graph, graph[src].get(i).dest,dest, vis)){
                return true;
               
            }
        }
        return false;
    }

    // connected components : Used for disconnected graphs : 

        //bfs 
    public static void bfs(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        for(int i = 0; i < vis.length; i++){
            bfsUtil(graph, vis);
        }
    }
    public static void bfsUtil(ArrayList<Edge>[] graph, boolean vis[]) {
            Queue<Integer> q = new LinkedList<>();
            
            
            // Start BFS from node 0
            q.add(0);
            vis[0] = true;
    
            while (!q.isEmpty()) {
                int curr = q.remove();
                System.out.print(curr + " ");
    
                // Explore all neighbors of curr
                for (int i = 0; i < graph[curr].size(); i++) {
                    int neighbor = graph[curr].get(i).dest;
                    if (!vis[neighbor]) {
                        q.add(neighbor);
                        vis[neighbor] = true;
                    }
                }
            }
        }
        public static void dfs(ArrayList<Edge>[] graph){
            boolean vis[] = new boolean[graph.length];
            for(int i = 0; i < vis.length; i++){
                if(!vis[i]){
                dfsUtil(graph,i, vis);
                }
            }
        }
        public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean vis[]){
            System.out.print(curr+ " ");
            vis[curr] = true;
            for(int i = 0 ; i < graph[curr].size(); i++){
                if(!vis[graph[curr].get(i).dest]){
                    dfsUtil(graph, graph[curr].get(i).dest, vis);
                }
            }
        }


        // detect cycle undirected graph : 

        public static boolean detectCycle(ArrayList<Edge> graph[]){
            boolean vis[] = new boolean[graph.length];
            for(int i = 0; i < graph.length; i++){
                if(!vis[i]){
                   if(detectCycleUtil(graph, i , -1, vis)){
                    return true;
                   }
                }
            }
            return false;
        }

        public static boolean detectCycleUtil(ArrayList<Edge> graph[], int curr, int parent, boolean vis[]){
            vis[curr] = true;
           for(int i = 0; i < graph[curr].size(); i++){

            // not visited => call the function
            if(!vis[graph[curr].get(i).dest]){
                if(detectCycleUtil(graph, graph[curr].get(i).dest, curr, vis)){
                    return true;
                }
            }
            
            // visited and parent is not current => return true
            else if(vis[graph[curr].get(i).dest] && parent != graph[curr].get(i).dest){
                return true;
            }

            // visited and parent is current => do nothing
           }

          return false;

        }

        // Bipartite graph : 
        // A bipartite graph is a graph whose vertices can be divided into two disjoint sets such that:
	// •	Every edge connects a vertex from one set to the other set,
	// •	No edge connects two vertices in the same set.


        public static boolean isBipartite(ArrayList<Edge> graph[]){
            int col[] = new int[graph.length];
            for(int i = 0; i < col.length; i++){
                col[i] = -1;
            }
            for(int i = 0; i< col.length; i++){
          return isBipartiteUtil(graph, col);
        }
        return false;
    }

        public static boolean isBipartiteUtil(ArrayList<Edge> graph[], int col[]){
            Queue<Integer> q = new LinkedList<>();
            q.add(0);
            col[0] = 0;
          while(!q.isEmpty()){
            int curr = q.remove();
            for(int i = 0; i < graph[curr].size(); i++){
               int neighbour = graph[curr].get(i).dest;
               if(col[neighbour] == -1){
                col[neighbour] = col[curr] == 1 ? 0 : 1;
                q.add(neighbour);
               }
               else if(col[neighbour] == col[curr]){
                return false;
               }

            }
            
          }
          return true;
            
        }


    // Detect cycle : Directed Graph 
    public static boolean detectCycledir(ArrayList<Edge>[] graph){
         boolean[] vis =new boolean[graph.length];
         boolean[] st = new boolean[graph.length];
         for(int i = 0; i < graph.length; i++){
            if(!vis[i]){
              if(detectCycleUtildir(graph, 0, vis, st)){
               return true;
              } 
            }
         }
         return false;
      }

      public static boolean detectCycleUtildir(ArrayList<Edge>[] graph,int curr, boolean[] vis, boolean[] st){
         vis[curr] = true;
         st[curr] = true;
         for(int i = 0; i <graph[curr].size(); i++){
            int temp = graph[curr].get(i).dest;
            if(!vis[temp]){
               if(detectCycleUtildir(graph, temp, vis, st)){
                  return true;
               }
         }
            else if (vis[temp] && st[temp]){       
               return true;
            }
            } 
            st[curr] = false;
            return false;  
      }


        // Topological sorting using dfs
      public static void topoUtil(ArrayList<Edge>[] graph, boolean[] vis, Stack<Integer> st, int curr){
        vis[curr] = true;
        for(int i = 0 ; i < graph[curr].size(); i++){
            int temp = graph[curr].get(i).dest;
            if(!vis[temp]){
                topoUtil(graph, vis, st, temp);
            }
            else{
                continue;
            }
            
        }
        st.push(curr);
      }
      public static void topo(ArrayList<Edge>[] graph){
        boolean[] vis= new boolean[graph.length];
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < graph.length; i++){
            if(!vis[i]){
                 topoUtil(graph, vis, st, i);
            }
           
        }
        while(!st.isEmpty()){
            System.out.println(st.pop());
        }
      }


      //Topological sorting using bfs(kahn's algo)
      /*
      Input :  // From node 5
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

        // From node 2
        graph[2].add(new Edge(2, 3));

        // From node 4
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        // From node 3
        graph[3].add(new Edge(3, 1));

        Output : 
        4 5 0 2 3 1
      */

      public static void kahns(ArrayList<Edge>[] graph){
         int[] indeg = new int[graph.length];
         for(int i = 0 ; i < graph.length; i++){
            for(int j = 0 ; j < graph[i].size(); j++){
               indeg[graph[i].get(j).dest]++;
            }
         }
         Queue<Integer> q = new LinkedList<>();
         for(int i = 0 ; i < indeg.length; i ++){
            if(indeg[i] ==0){
               q.add(i);
            }
         }
         while(!q.isEmpty()){
            int curr = q.remove();
            for(int i = 0 ; i < graph[curr].size(); i++){
               indeg[graph[curr].get(i).dest]--;
               if(indeg[graph[curr].get(i).dest] ==0){
                  q.add(graph[curr].get(i).dest);
               }

            }
            System.out.println(curr);
         }


      }


    //    Kosaraju's Algo : Strongly connected components.. refer striver

    //  input : 
    //  graph[0].add(new Edge(0, 1, 2));

    // graph[1].add(new Edge(1, 3, 7));
    // graph[1].add(new Edge(1, 2, 1));

    // graph[2].add(new Edge(2, 0, 3));

    // graph[3].add(new Edge(3, 4, 1));

    // graph[4].add(new Edge(4, 5, 2));
    // graph[4].add(new Edge(4, 7, 5));
    // graph[5].add(new Edge(5, 6, 5));
    // graph[4].add(new Edge(6, 4, 5));
    // graph[7].add(new Edge(7, 6, 5));

    //  Output : 3


        public static void kosaUtil(ArrayList<Edge> [] graph, boolean[] vis, Stack<Integer> s, int idx){
            vis[idx] = true;
            s.add(idx);
            for(int i = 0 ; i < graph[idx].size(); i++){
                int child = graph[idx].get(i).dest;
                if(!vis[child]){
                    kosaUtil(graph,vis,s,child);
                }
            }
        }

        public static void dfs(ArrayList<Edge>[] graph, boolean[] vis,int idx){
            vis[idx] = true;
            for(int i = 0 ; i < graph[idx].size(); i++){
                int child = graph[idx].get(i).dest;
                if(!vis[child]){
                    dfs(graph,vis,child);
                }
            }
        }

        public static int kosa(ArrayList<Edge>[] graph){
            boolean vis[] = new boolean[graph.length];
            Stack<Integer> s = new Stack<>();
            kosaUtil(graph, vis, s, 0);
            int ans = 0;
            for(int i = 0 ; i < vis.length; i++){
                vis[i] = false;
            }
            while(!s.isEmpty()){
                int start = s.pop();
                if(!vis[start]){
                    dfs(graph, vis, start);
                    ans++;
                }
            }
            return ans;
        }


    //  Print all possible paths from src to dest : 

    /*
    Input : 
        5 → 0 ← 4
        ↓   ↓   ↑
        2 → 3 → 1

     Output : 
     5031
     5231   
    */
      public static void path(ArrayList<Edge>[] graph, int src, int dest, String str){
        if(src == dest){
            System.out.println(str+src);
        }
        for(int i = 0; i < graph.length; i++){
            path(graph, graph[src].get(i).dest, dest, str + src);
        }
      }


    // Dijkstra's Algo : Print the shortes dist from a given src to all the vertices
    /*
    Input : 
    graph[0].add(new Edge(0, 1, 2));
    graph[0].add(new Edge(0, 2, 4));

    graph[1].add(new Edge(1, 3, 7));
    graph[1].add(new Edge(1, 2, 1));

    graph[2].add(new Edge(2, 4, 3));

    graph[3].add(new Edge(3, 5, 1));

    graph[4].add(new Edge(4, 3, 2));
    graph[4].add(new Edge(4, 5, 5));

    Output : 
    0 2 3 8 6 9
    */
    public static class Pair implements Comparable<Pair>{
        int n;
        int path;
        Pair(int n, int path){
            this.n = n;
            this.path = path;
        }
        @Override
        public int compareTo(Pair p2){
            return this.path -p2.path;
        }
    }

    public static void dijkstras(ArrayList<Edge>[] graph, boolean[] vis, int src){
        int dist[] = new int[graph.length];
        dist[src] = 0;
        for(int i = 0 ; i < graph.length; i++){
            if(i!=src){
                dist[i] = Integer.MAX_VALUE;
            }   
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(); 
        pq.add(new Pair(src,0));
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(vis[curr.n]) continue;
            vis[curr.n] = true;
            for(int i = 0; i < graph[curr.n].size();i++){
                Edge e = graph[curr.n].get(i);
                int s = e.src;
                int d = e.dest;
                int w = e.wt;
                int newDist = curr.path + w;
                if(newDist < dist[d]){ 
                    dist[d] = newDist;
                    pq.add(new Pair(d, newDist));
                }

            }
        }
        for(int i = 0; i < dist.length; i++){
            System.out.println(dist[i]);
        }
    }
    /*
    NOTE : 
    -> We can use a queue as well but we will have to eliminate the use case of vis[] array because it is not guaranteed that we will get the shortest path fist in the queue.
       By using a pq, and a vis[] array we can ensure that we will always get the shortest path first. And hence we can use the vis[] array to eliminate the use case of the queue.
    -> For the derivation of the T.C. and the reason of using a PQ over a queue refer strivers graph playlist :)
    */



    //Bellman Ford Algo : 

    public static void bellman(ArrayList<Edge>[] graph, int src){
        int[] dist = new int[graph.length];
        for(int i = 0; i < dist.length; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;


        for(int i = 0; i < graph.length- 1;i++){ // Number of iterations is equal to number of vertices - 1
            // Relaxation step :
            for(int j = 0 ; j < graph.length; j++){
                for(int k = 0 ; k < graph[j].size(); k++){
                    int s = j;
                    int dest = graph[j].get(k).dest;
                    int wt =  graph[j].get(k).wt;
                    int newdist = dist[s] + wt;
                    if(dist[s] != Integer.MAX_VALUE && newdist < dist[dest]){ // if we add something to integer.maxvalue we get a negative result
                        dist[dest] = newdist;
                    }

                }
            }
        }
        // Negative cycle detection :
        for(int j = 0 ; j < graph.length; j++){
                for(int k = 0 ; k < graph[k].size(); k++){
                    int s = j;
                    int dest = graph[j].get(k).dest;
                    int wt =  graph[j].get(k).wt;
                    int newdist = dist[s] + wt;
                    if(newdist < dist[dest]){
                        System.out.println("invalid");
                       return;
                    }

                }
            }
            for(int i = 0; i < dist.length; i++){
                System.out.println(dist[i]);
            }
        
    }

    // NOTE : 
    /*
    -> To understand why are iterating graph.length - 1 times, refer striver's graph playlist
    */

//  MST Using Prim's Algo :

    class KosarajuSolution {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    
    }
    static class Pair implements Comparable<Pair>{
        int src;
        int wt;
        public Pair(int src, int wt){
            this.src= src;
            this.wt = wt;
        }
        public int compareTo(Pair pair){
            return this.wt - pair.wt;
        }
    }
       
    
    static int spanningTree(int V, int E, List<List<int[]>> edges) {
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for(int i = 0 ; i < V; i++){
            graph.add(new ArrayList<>());
        }
         for(int i = 0 ; i < edges.size(); i++){
           for(int j = 0 ; j < edges.get(i).size(); j++){
                int src = i;
                int dest = edges.get(i).get(j)[0];
                int wt = edges.get(i).get(j)[1];
                graph.get(src).add(new Edge(src,dest,wt));
            }
        }
        
        PriorityQueue<Pair> q = new PriorityQueue<>();
        boolean[] vis = new boolean[V];
        int ans = 0;
        q.add(new Pair(0,0));
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int src = curr.src;
            if(vis[src]) continue;
            ans+= curr.wt;
            vis[src] = true;
            for(int i =0 ; i < graph.get(src).size(); i++){
                Pair pair = new Pair(graph.get(src).get(i).dest,graph.get(src).get(i).wt);
                q.add(pair);
            }
           
        }
        return ans;
    }
}


// Cheapest flights with k stops : 

    class Solution1{
    class Pair{
        int node;
        int dist;
        int stops;
        public Pair(int node, int dist, int stops){
            this.node = node;
            this.stops = stops;
            this.dist = dist;
        }
    }
    class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int source, int dst, int k) {
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0 ; i < flights.length; i++){
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];
            graph.get(src).add(new Edge(src,dest,wt));
        }
        Queue<Pair> q = new LinkedList<>();
        int[] dist = new int[n];
        for(int i = 0; i < n ; i++){
            if(i==source) dist[i] = 0;
            else dist[i] = 1000000;
        }
        q.add(new Pair(source,0,0));
        while(!q.isEmpty()){
            Pair curr = q.poll();
            if(curr.stops > k) break;
            int s = curr.node;
            for(int i = 0 ; i < graph.get(s).size(); i++){
                int d = dist[graph.get(s).get(i).dest];
                int newdist = curr.dist+graph.get(s).get(i).wt;   // Note that we are not using dist[s] here because we are not sure if the current path is the shortest path to the destination
                if(d>newdist){
                    q.add(new Pair(graph.get(s).get(i).dest, newdist, curr.stops+1));
                    dist[graph.get(s).get(i).dest] = newdist;
                }
            }
        }
        if(dist[dst]==1000000) return -1;
        else return dist[dst];
    }
}

// Disjoint set : 
    class DisjointSet{
        int n;
        int[] par;
        int[] rank;
        public DisjointSet(int n){
            par = new int[n];
            rank = new int[n];
            for(int i = 0 ; i < n ; i++){
                par[i] = i;
                rank[i] = 0;
            }
        }
        public int find(int a){
            if(a==par[a]){
                return a;
            }
            par[a] = find(par[a]); //Path compression
            return par[a];
        }
        public void union(int a, int b){
            int parA = find(a);
            int parB = find(b);
            if(rank[parA]>=rank[parB]){
                par[parB] = parA;
               if(rank[parA]==rank[parB]) rank[parA]++;
            }
            else{
                par[parA] = parB;
            }
        }
 
    }
// kruskal's algo : Minimum spanning tree using disjoint set
    class Solution3 {
        static class Edge implements Comparable<Edge>{
            int src;
            int dest;
            int wt;
            public Edge(int src, int dest, int wt){
                this.src = src;
                this.dest = dest;
                this.wt = wt;
            }
            public int compareTo(Edge e){
                return this.wt - e.wt;
            }
        }
        static int find(int[] par, int a){
            if(a == par[a]){
                return a;
            }
            par[a] = find(par,par[a]);
            return par[a];
        }
        static void union(int[] par, int[] rank, int a, int b){
            int parA = find(par,a);
            int parB = find(par,b);
            if(rank[parA]>=rank[parB]){
                par[parB] = parA;
                if(rank[parA]==rank[parB]) rank[parA]++;
            }
            else{
                par[parA] = parB;
            }
        }
        static int kruskalsMST(int V, int[][] edges) {
            // code here
            int[] par = new int[V];
            int[] rank = new int[V];
            for(int i = 0 ; i < V; i++){
                par[i] = i;
                rank[i] = 0;
            }
            ArrayList<Edge> graph = new ArrayList<>();
            for(int i = 0 ; i < edges.length; i++){
                graph.add(new Edge(edges[i][0],edges[i][1],edges[i][2]));
            }
            Collections.sort(graph);
            int ans = 0;
            for(int i = 0 ; i < graph.size(); i++){
                Edge e = graph.get(i);
                int src = e.src;
                int dest = e.dest;
                int wt = e.wt;
                if(find(par,src)==find(par,dest)) continue;
                ans+=wt;
                union(par,rank,src,dest);
                
            }
            return ans;
        }
    }


//  Floyd Warshall Algo : To get the shortest path between all pairs of vertices in a weighted graph
    class FloydWarshall {
        public void floydWarshall(int[][] dist) {
            // Code here
            for(int k = 0 ; k < dist.length; k++){
                for(int i = 0 ; i < dist.length; i++ ){
                    if(dist[i][k] == 100000000) continue;
                    for(int j = 0 ; j < dist.length; j++){
                        if(dist[k][j] == 100000000) continue;
                        if(dist[i][j] > dist[i][k]+dist[k][j]){
                            dist[i][j] = dist[i][k]+dist[k][j];
                        }
                    }
                }
            }
        // Negative cycle detection
            for(int i = 0 ; i < dist.length; i++){ 
                if(dist[i][i] < 0){
                    System.out.println("Negative cycle detected");
                    return;
                }
        
        }
    }
}

// Kosaraju's Algo : Strongly connected components


// https://www.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1

// Example where pre order stack wont work : 
// 0-> (2,4)      1->(2)      2-> (3)       stack would look like : top (1,4,3,2,0) bottom

// Example where using a post order queue to avoid graph reversal fails : 

// 0->(2,3).     1->(0).       2->(1).       3->(4).         queue would look like : start (1,2,4,3,0) end

// Hence graph reversal and pre order stack is necessary :)



class Solution {
    // Function to find number of strongly connected components in the graph.
     public static void kosaUtil(ArrayList<ArrayList<Integer>> graph, boolean[] vis, Stack<Integer> s, int idx){
            vis[idx] = true;
            for(int i = 0 ; i < graph.get(idx).size(); i++){
                int child = graph.get(idx).get(i);
                if(!vis[child]){
                    kosaUtil(graph,vis,s,child);
                }
            }
            s.add(idx);
        }
    public static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] vis,int idx){
            vis[idx] = true;
            for(int i = 0 ; i < graph.get(idx).size(); i++){
                int child = graph.get(idx).get(i);
                if(!vis[child]){
                    dfs(graph,vis,child);
                }
            }
        }
    public int kosaraju(ArrayList<ArrayList<Integer>> graph) {
        // code here
        boolean vis[] = new boolean[graph.size()];
            Stack<Integer> s = new Stack<>();
            for(int i = 0; i < graph.size(); i++){
                if(!vis[i]){
                      kosaUtil(graph, vis, s, i);
                }
            }
        ArrayList<ArrayList<Integer>> graph1 = new ArrayList<>();
        for(int i = 0 ; i < graph.size(); i++){
            graph1.add(new ArrayList<>());
        }
        for(int i = 0 ; i < graph.size(); i++){
            for(int j = 0 ; j < graph.get(i).size(); j++){
                int child = i;
                int par = graph.get(i).get(j);
                graph1.get(par).add(child);
            }
        }
          
             int ans = 0;
            for(int i = 0 ; i < vis.length; i++){
                vis[i] = false;
            }
            while(!s.isEmpty()){
                int start = s.pop();
                if(!vis[start]){
                    dfs(graph1, vis, start);
                    ans++;
                }
            }
            return ans;
    }
}

    public static void main(String args[]){

        int V = 8;
        ArrayList<Edge> graph[] = new ArrayList[V];
        // ex 1: 
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        // graph[0].add(new Edge(0, 1, 5));
        // graph[1].add(new Edge(1, 2, 1));
        // graph[1].add(new Edge(1, 3, 3));
        // graph[1].add(new Edge(1, 0, 5));
        // graph[2].add(new Edge(2, 1, 1));
        // graph[2].add(new Edge(2, 3, 1));
        // graph[3].add(new Edge(3, 2, 1));
        // graph[3].add(new Edge(3, 1 , 3));
        // graph[3].add(new Edge(3, 4, 2));
        // graph[4].add(new Edge(4, 3, 2));
            // 2's neighbours : 

        // for(int i = 0 ; i < graph[2].size();i++){
        //     System.out.println(graph[2].get(i).dest);
        // }

        // graph[0].add(new Edge(0, 1, 1));
        // graph[1].add(new Edge(1, 2, 1));
        // graph[1].add(new Edge(1, 0, 1));
        // graph[1].add(new Edge(1, 4, 1));
        
        // graph[2].add(new Edge(2, 3, 1));
        // graph[2].add(new Edge(2, 4, 1));
        // graph[2].add(new Edge(2, 1, 1));
        // graph[3].add(new Edge(3, 2, 1));
       
        // graph[3].add(new Edge(3, 5, 1));
        // graph[4].add(new Edge(4, 2, 1));
        // graph[1].add(new Edge(4, 1, 1));
       
        // graph[5].add(new Edge(5, 3, 1));
       // dfs(graph);

    //    // From node 5
    //     graph[5].add(new Edge(5, 0,1));
    //     graph[5].add(new Edge(5, 2,1));

    //     // From node 2
    //     graph[2].add(new Edge(2, 3,1));

    //     // From node 4
    //     graph[4].add(new Edge(4, 0,1));
    //     graph[4].add(new Edge(4, 1,1));

    //     // From node 1
    //     graph[1].add(new Edge(1, 3,1));

    graph[0].add(new Edge(0, 1, 2));
    graph[0].add(new Edge(0, 2, 4));

    graph[1].add(new Edge(1, 3, 7));
    graph[1].add(new Edge(1, 2, 1));

    graph[2].add(new Edge(2, 4, 3));

    graph[3].add(new Edge(3, 5, 1));

    graph[4].add(new Edge(4, 3, 2));
    graph[4].add(new Edge(4, 5, 5));
    
       System.out.println(kosa(graph));
    }
    
}
