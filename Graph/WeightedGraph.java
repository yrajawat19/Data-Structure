package Graph;
import java.util.*;
// class to represent edge .
class Edge{
    int source; //Variable for source vertex
    int destination; //Variable for destination vertex
    int weight; // variable for weight of edge
    Edge(int source, int destination, int weight) // Constructor which takes values as argument and assign value to variables.
    {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
    Edge()
    {

    }
}

public class WeightedGraph {
    int V;  // No of vertices
    LinkedList<Edge> adj[];  //Adjacency List representation of graph
    WeightedGraph(int v)  // constructor of WeightedGraph class
    {
        V = v;
        adj = new LinkedList[V];
        for(int i=0;i<V;i++)
            adj[i] = new LinkedList<>();
    }

    public void addEgde(int src, int dest, int weight)
    {
        Edge edge = new Edge(src,dest,weight);
        adj[src].add(edge);
    }
    void DFS()
    {
        boolean visited[] = new boolean[V];
        for(int i=0;i<V;i++)
            if(!visited[i])
                DFSUtil(i,visited);
    }

    void DFSUtil(int s , boolean[] visited)
    {
        visited[s] = true;
        System.out.print(s+" ");
        Iterator<Edge> i = adj[s].listIterator();
        while(i.hasNext())
        {
            Edge n = new Edge();
            n = i.next();
            if(!visited[n.source])
            {
                DFSUtil(n.source,visited);
            }

        }

    }

    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph(7);
        graph.addEgde(0, 1, 4);
        graph.addEgde(0, 2, 3);
        graph.addEgde(1, 3, 2);
        graph.addEgde(1, 2, 5);
        graph.addEgde(2, 3, 7);
        graph.addEgde(3, 4, 2);
        graph.addEgde(4, 0, 4);
        graph.addEgde(4, 1, 4);
        graph.addEgde(4, 5, 6);
        graph.DFS();
    }
}
