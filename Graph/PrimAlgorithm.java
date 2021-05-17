package Graph;
import java.util.*;
public class PrimAlgorithm {
    // class Edge
    static class Edge {
        int source;
        int destination;
        int weight;
        Edge(int source, int destination, int weight)
        {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

     static class HeapNode {
        int vertex;
        int weight;
    }
    class Graph {
        int V; // No of vertices in a graph
        LinkedList<Edge>[] adj;
        // Constructor of Graph class
        Graph(int v)
        {
            V = v;
            adj = new LinkedList[V];
            for(int i=0;i<V;i++)
                adj[i] = new LinkedList<>();
        }
        // Method to add Edge in Graph
        public void addEdge(int source, int destination, int weight) {
            adj[source].add(new Edge(source,destination,weight));
            // for undirected weighted graph
            adj[destination].add(new Edge(destination,source,weight));
        }





    }
}
