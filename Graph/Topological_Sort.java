/* A java program to print topological sort of Directed Acyclic Graph(DAG) .*/
/* Topological sorting for directed acyclic graph is a linear ordering
of vertices such that for every directed Edge uv , vertex u comes
  before v in the ordering . */
package Graph;
import java.util.*;
import java.io.*;
// This class represent a DAG using adjacency list representation .
class DAG
{
    final int V; // no. of vertices
    LinkedList<Integer> adj[]; // adjacency list
    DAG(int v)
    {
        V =v;
        adj = new LinkedList[V];
        for(int i=0;i<V;i++)
            adj[i] = new LinkedList();
    }
    // A method to add vertices in graph .
    void addEdge(int v, int w)
    {
        adj[v].add(w);
    }
    // A method to topological sorting of DAG
    void topologicalSort()
    {
        Stack<Integer> stack = new Stack<Integer>();
        boolean visited[] = new boolean[V];
        for(int i=0;i<V;i++)
            if(!visited[i])
                topologicalSortUtil(i,visited,stack);
            while(!stack.empty())
                System.out.print(stack.pop()+ " ");
    }
    // A recursive method used by topologicalSort() method.
    void topologicalSortUtil(int v, boolean visited[] , Stack<Integer> stack)
    {
        visited[v] = true;
        Iterator<Integer> i = adj[v].listIterator();
        while(i.hasNext())
        {
            int n = i.next();
            if(!visited[n])
                topologicalSortUtil(n,visited,stack);
        }
        stack.push(v);
    }

}
public class Topological_Sort {
    public static void main(String[] args) {
        DAG g = new DAG(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        System.out.println("Following is the topological sort of DAG :");
        g.topologicalSort();

    }
}
