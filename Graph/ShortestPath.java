package Graph;
import java.util.*;
public class ShortestPath {
    public static class Edge
    {
        int source;
        int destination;
        int weight;
        public Edge(int source,int destination,int weight)
        {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }
    public static class Graph
    {
        int V;
        LinkedList<Edge> adj[];
        Graph(int v)
        {
            V = v;
            adj = new LinkedList[V];
            for(int i=0;i<V;i++)
                adj[i] = new LinkedList<>();
        }
        public void addEdge(int source,int destination,int weight)
        {
            adj[source].add(new Edge(source,destination,weight));
        }
       public void shortestPath(int source)
       {
           int[] distance = new int[V];
           int INFINITY = Integer.MAX_VALUE;
           for(int i=1;i<V;i++)
               distance[i] = INFINITY;
           distance[source] = 0;
           for(int i=source;i<V-1;i++)
           {
               Iterator<Edge> e = adj[i].listIterator();
               while(e.hasNext())
               {
                   Edge m = e.next();
                   if(distance[m.source]+ m.weight < distance[m.destination])
                   {
                       distance[m.destination] = distance[m.source]+m.weight;
                   }
               }
           }
           print(distance,source);
       }
        public void print(int[] distance,int source) {
            for (int i = 1; i < V; i++)
            {
                System.out.println("Source : "+source+" Destination :"+i+ " weight :"+distance[i]);
            }
        }
       public static void main(String[] args)
       {
           Graph g = new Graph(6);
           g.addEdge(1,2,2);
           g.addEdge(1,5,3);
           g.addEdge(2,3,2);
           g.addEdge(2,4,5);
           g.addEdge(2,5,4);
           g.addEdge(3,4,2);
           g.addEdge(4,2,-4);
           g.shortestPath(1);
       }
    }
}
