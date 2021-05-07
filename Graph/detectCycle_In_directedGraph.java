package Graph;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class CyclicGraph
{
    final int V;
    LinkedList<Integer> adj[];
    CyclicGraph(int v)
    {
        V = v;
        adj = new LinkedList[V];
        for(int i=0;i<V;i++)
            adj[i] = new LinkedList();
    }
    public void addEdge(int v,int w)
    {
        adj[v].add(w);
    }

    boolean isCyclic()
    {
        boolean visited[] = new boolean[V];
        boolean recStack[] = new boolean[V];
        for(int i=0;i<V;i++) {
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, recStack))
                    return true;
            }
        }
        return false;
    }
    boolean isCyclicUtil(int v,boolean visited[], boolean recStack[])
    {
        if(recStack[v])
            return true;
        if(visited[v])
            return false;
        visited[v] = true;
        recStack[v] = true;
        Iterator<Integer> i = adj[v].listIterator();
        while(i.hasNext())
        {
            int n =i.next();
                if(isCyclicUtil(n,visited,recStack))
                    return true;
        }
        recStack[v] = false;
        return false;
       
    }
}
public class detectCycle_In_directedGraph {
    public static void main(String[] args) {
        // G1 graph is cyclic .
        CyclicGraph G1 = new CyclicGraph(7);
        // g2 graph is acycliv .
        CyclicGraph G2 = new CyclicGraph(7);
        G1.addEdge(0,1);
        G1.addEdge(0,5);
        G1.addEdge(0,6);
        G1.addEdge(1,2);
        G1.addEdge(2,3);
        G1.addEdge(3,1);
        G1.addEdge(4,3);
        G1.addEdge(5,2);
        G1.addEdge(6,5);
        G2.addEdge(0,1);
        G2.addEdge(0,2);
        G2.addEdge(2,3);
        G2.addEdge(3,1);
        if(G1.isCyclic())
            System.out.println("Graph is Cyclic .");
        else
            System.out.println("Graph is not cyclic .");
        if(G2.isCyclic())
            System.out.println("Graph is Cyclic .");
        else
            System.out.println("Graph is Acyclic .");
    }
}
