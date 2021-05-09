package Graph;
import java.util.*;
import java.io.*;
class DirectedGraph
{
    int V;
    LinkedList<Integer> adj[];
    DirectedGraph(int v)
    {
        V = v;
        adj = new LinkedList[V];
        for(int i=0;i<V;i++)
            adj[i] = new LinkedList();
    }
    void addEdge(int u, int v)
    {
        adj[u].add(v);
    }

    void printAllPath(int src, int dest)
    {
        boolean visited[] = new boolean[V];
        ArrayList<Integer> pathList = new ArrayList<>();
        pathList.add(src);
        printAllPathUtil(src,dest,visited,pathList);

    }

    private void printAllPathUtil(int src, int dest, boolean[] visited, ArrayList<Integer> pathList) {
        if(src == dest) {
            System.out.println(pathList);
            return;
        }
        visited[src] = true;

        for(int i:adj[src])
        {
            if(!visited[i])
            {
                pathList.add(i);
                printAllPathUtil(i,dest,visited,pathList);
                pathList.remove(i);
            }
        }
        visited[src] = false;
    }

}
public class find_all_path_using_DFS {
    public static void main(String[] args) {
        DirectedGraph g = new DirectedGraph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 1);
        g.addEdge(1, 3);

        // arbitrary source
        int s = 2;

        // arbitrary destination
        int d = 3;

        System.out.println(
                "Following are all different paths from "
                        + s + " to " + d);
        g.printAllPath(s, d);
    }
}
