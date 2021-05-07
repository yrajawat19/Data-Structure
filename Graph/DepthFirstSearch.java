package Graph;

import java.io.*;
import java.util.*;
class DFSGraph
{
    int V;
    LinkedList<Integer> adj[];
    DFSGraph(int v)
    {
        V = v;
        adj = new LinkedList[V];
        for(int i=0;i<V;i++)
        {
            adj[i] = new LinkedList();
        }
    }

    public void addEdge(int v,int w)
    {
        adj[v].add(w);
    }

    public void DFS(int v)
    {
        boolean visited[] = new boolean[V];
        DFSUtil(v,visited);
    }

    public void DFS()
    {
        boolean visited[] = new boolean[V];
        for(int i=0;i<V;i++) {
            if(!visited[i])
            DFSUtil(i, visited);
        }
    }
    public void DFSUtil(int v,boolean visited[])
    {
        visited[v] = true;
        System.out.print(v+" ");
        Iterator<Integer> i = adj[v].listIterator();
        while(i.hasNext())
        {
            int n =i.next();
            if(!visited[n])
                DFSUtil(n,visited);
        }
    }

}
public class DepthFirstSearch {
    public static void main(String[] args) {
        DFSGraph G = new DFSGraph(8);
        G.addEdge(0,1);
        G.addEdge(1,1);
        G.addEdge(2,5);
        G.addEdge(3,6);
        G.addEdge(4,0);
        G.addEdge(4,5);
        G.addEdge(5,6);
        G.addEdge(6,7);
        G.addEdge(7,4);
        G.DFS(2);
        System.out.println();
        G.DFS();

    }
}