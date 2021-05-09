package Graph;
import java.util.*;
class DAGraph
{
    int V;
    LinkedList<Integer> adj[];
    public DAGraph(int v)
    {
        V = v;
        adj = new LinkedList[V];
        for(int i=0;i<V;i++)
            adj[i] = new LinkedList();
    }
    public void addEdge(int u,int v)
    {
        adj[u].add(v);
    }

    public void TopologicalSort()
    {
        int indegree[] = new int[V];
        for(int i=0;i<V;i++)
        {
            Iterator<Integer> temp = adj[i].listIterator();
            while(temp.hasNext()) {
                int n = temp.next();
                indegree[n]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++)
            if(indegree[i] == 0)
                q.add(i);
            int count = 0;
            while(!q.isEmpty())
            {
                int u= q.poll();
                System.out.print(u+ " ");
                for(int n:adj[u])
                {
                    if(--indegree[n] == 0)
                        q.add(n);
                }
                count++;
            }
            if(count != V)
            {
                System.out.println("Graph contains cycle .");
                return;
            }

    }
}
public class Kahns_Algorithm {
    public static void main(String[] args) {
        DAGraph g = new DAGraph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        System.out.println("Following is a Topological Sort");
        g.TopologicalSort();
    }
}
