package Graph;

import java.util.Iterator;
import java.util.LinkedList;
/* Class UndirectedGraph having data members and methods for creating a graph .*/
/* Graph is implemented using adjacency lists .*/
class UndirectedGraph
{
    // vertices variable named as V
    final int V;
    // Adjacency list
    LinkedList<Integer> adj[];
    // Constructor taking argument as number of vertices
    // and setting adjacency list according to passed parameters.
    UndirectedGraph(int v)
    {
        V = v;
        adj = new LinkedList[V];
        for(int i=0;i<V;i++)
            adj[i] = new LinkedList();
    }
    // Method named addEdge is made to add Edges to vertices in graph .
    // Since Graph is Undirected , edges are pointing in both the direction .
    void addEdge(int v,int w)
    {
        adj[v].add(w);
        adj[w].add(v);
    }
    // Method names isCyclic , calls isCyclicUtil method
    boolean isCyclic()
    {
        boolean visited[] = new boolean[V];
        for(int i=0;i<V;i++)
            if(!visited[i])
                if(isCyclicUtil(i,visited,-1))
                    return true;
        return false;

    }
    // Method to find cycle in undirected graph .
    boolean isCyclicUtil(int v, boolean visited[] ,int parent)
    {
        visited[v] = true;
        Iterator<Integer> i = adj[v].listIterator();
        while(i.hasNext())
        {
            int n = i.next();
            if(!visited[n])
            {
                if(isCyclicUtil(n,visited,v))
                    return true;
            }
            else if(n != parent)
                return true;
        }
        return false;
    }
}

public class detectCycle_In_UndirectedGraph {
    public static void main(String[] args) {
        UndirectedGraph G = new UndirectedGraph(4);
        G.addEdge(0,1);
        G.addEdge(0,2);
        G.addEdge(0,3);
        G.addEdge(1,2);
        G.addEdge(2,3);
        if(G.isCyclic())
            System.out.println("This undirected graph is Cyclic .");
        else
            System.out.println("This undirected graph is Acyclic .");
    }
}
