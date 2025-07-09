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


        // detect cycle : 

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

    public static void dijkstras(ArrayList<Edge>[] graph, int src){
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

    //Bellman Ford Algo : for proper example visit https://www.youtube.com/watch?v=FtN3BYH2Zes

    public static void bellman(ArrayList<Edge>[] graph, int src){
        int[] dist = new int[graph.length];
        for(int i = 0; i < dist.length; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;


        for(int i = 0; i < graph.length- 1;i++){
            for(int j = 0 ; j < graph.length; j++){
                for(int k = 0 ; k < graph[k].size(); k++){
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

       

      





    public static void main(String args[]){

        int V = 6;
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
    
       dijkstras(graph, 0);

    }
    
}
