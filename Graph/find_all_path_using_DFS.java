/* Java Program to find all possible paths in Graph from given source to given destination . */
package Graph;
import java.util.*;

class DirectedGraph
{
    int V; // No of vertices in graph
    ArrayList<Integer> adj[]; // Representation of graph as Adjacency list .
    DirectedGraph(int v) // Constructor to assign values to V and adj[] .
    {
        V = v;
        adj = new ArrayList[V];
        for(int i=0;i<V;i++)
            adj[i] = new ArrayList<>();
    }
    void addEdge(int u, int v) // Method to add Edge between vertices .
    {
        adj[u].add(v);
    }
    // Method to print all possible paths in Graph for given source to destination .
    public void printAllPath(int source, int destination) {
        boolean[] isVisited = new boolean[V];
        ArrayList<Integer> pathList = new ArrayList<>();
        pathList.add(source);
        printAllPathUtil(source,destination,isVisited,pathList);
    }
    // This method uses DFS Algorithm to find all possible paths .
    private void printAllPathUtil(Integer source, Integer destination, boolean[] isVisited, ArrayList<Integer> pathList) {
        if(source.equals(destination)) {
            System.out.println(pathList);
            return;
        }
        isVisited[source] = true;
        for(Integer n : adj[source])
        {
           if(!isVisited[n])
           {
               pathList.add(n);
               printAllPathUtil(n,destination,isVisited,pathList);
               pathList.remove(n);
           }
       }
       isVisited[source] = false;

    }
}
public class find_all_path_using_DFS {
    public static void main(String[] args) {
        DirectedGraph g = new DirectedGraph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,4);
        g.addEdge(1,3);
        g.addEdge(1,4);
        g.addEdge(2,4);
        g.addEdge(3,2);

        // arbitrary source
        int s = 0;

        // arbitrary destination
        int d = 4;

        System.out.println(
                "Following are all different paths from "
                        + s + " to " + d);
        g.printAllPath(s, d);
    }
}
