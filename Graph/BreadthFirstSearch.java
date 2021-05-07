package Graph;

import java.util.Iterator;
import java.util.LinkedList;

class BFSGraph
{
    int V;
    LinkedList<Integer> adj[];
    BFSGraph(int v)
    {
        V = v;
        adj = new LinkedList[V];
        for(int i=0;i<V;i++)
            adj[i] = new LinkedList();
    }
    public void addEdge(int v, int w)
    {
        adj[v].add(w);
    }
    public void BFS(int s)
    {
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[s] = true;
        queue.add(s);
        while(queue.size() != 0)
        {
            s = queue.poll();
            System.out.print(s+" ");
            Iterator<Integer> i = adj[s].listIterator();
            while(i.hasNext())
            {
                int n = i.next();
                if(!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }

            }
        }
    }

}
public class BreadthFirstSearch {
    public static void main(String[] args) {
        BFSGraph g = new BFSGraph(8);
        g.addEdge(0,1);
        g.addEdge(1,1);
        g.addEdge(2,5);
        g.addEdge(3,6);
        g.addEdge(4,0);
        g.addEdge(4,5);
        g.addEdge(5,6);
        g.addEdge(6,7);
        g.addEdge(7,4);
        g.BFS(2);
    }
}
