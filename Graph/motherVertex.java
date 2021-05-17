/* Java Program to find mother vertex in the graph in O(V+E) time . */
/* A mother vertex in a graph G = (V,E)
is a vertex v such that all other vertices in G can be reached by a path from v.*/
/* Algorithm :
STEP 1 :Do DFS traversal of the given graph.
While doing traversal keep track of
last finished vertex ‘v’. This step takes O(V+E) time.
STEP 2: If there exist mother vertex (or vertices), then v must be one (or one of them).
Check if v is a mother vertex by doing DFS/BFS from v.
This step also takes O(V+E) time.*/
package Graph;

import java.util.Iterator;
import java.util.LinkedList;

public class motherVertex {
    static class Graph
    {
        int V;
        LinkedList<Integer> adj[];
        Graph(int v)
        {
            V = v;
            adj = new LinkedList[V];
            for(int i=0;i<V;i++)
                adj[i] = new LinkedList<>();
        }
        public void addEdge(int u,int v)
        {
            adj[u].add(v);
        }
        public void DFSUtil(int v, boolean[] visited)
        {
            visited[v] = true;
            Iterator<Integer> i = adj[v].listIterator();
            while(i.hasNext())
            {
                int n = i.next();
                if(!visited[n])
                    DFSUtil(n, visited);
            }
        }

        public int MotherVertex()
        {
            boolean[] visited = new boolean[V];
            int v = -1;
            for(int i =0;i<V;i++) {
                if (!visited[i]) {
                    DFSUtil(i, visited);
                    v = i;
                }
            }

            boolean[] check = new boolean[V];
                DFSUtil(v,check);
                for(boolean val: check) {
                    if (!val)
                        return -1;
                }
                    return v;

        }

        public static void main(String[] args) {
            Graph g = new Graph(6);
            g.addEdge(0,1);
            g.addEdge(1,3);
            g.addEdge(2,1);
            g.addEdge(2,4);
            g.addEdge(2,5);
            g.addEdge(3,0);
            g.addEdge(3,4);
            int vertex = g.MotherVertex();
            if(vertex == -1)
                System.out.println("There is no mother vertex in the graph .");
            else
                System.out.println("Mother vertex :"+vertex);
        }
    }
}
