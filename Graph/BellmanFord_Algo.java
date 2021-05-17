package Graph;

public class BellmanFord_Algo {
    static class Edge{
        int source;
        int destination;
        int weight;
        Edge()
        {
            source = destination = weight = 0;
        }
    }
    static class Graph
    {
        int V,E;
        Edge edge[];
        static int top = 1;
        Graph(int v,int e) {
            V = v;
            E = e;
            edge = new Edge[e];
            for (int i = 1; i < e; i++)
                edge[i] = new Edge();
        }
        public void addEdge(int source,int destination,int weight)
        {

            if(top<E) {
                edge[top].source = source;
                edge[top].destination = destination;
                edge[top].weight = weight;
                top++;
            }
        }
        public void BellmanFord(int source) {
            int distance[] = new int[V];
            final Integer INFINITY = Integer.MAX_VALUE;
            for (int i = 0; i < V; i++)
                distance[i] = INFINITY;
            distance[source] = 0;
            for (int i = 1; i < V; i++)
            {
                for(int j = 1; j < E; j++)
                {
                    int u = edge[j].source;
                    int v = edge[j].destination;
                    int weight = edge[j].weight;
                    if(distance[u] != INFINITY && distance[u] + weight<distance[v])
                        distance[v] = distance[u]+weight;
                }
            }

            for(int j = 1; j < E;j++)
            {
                int u = edge[j].source;
                int v = edge[j].destination;
                int weight = edge[j].weight;
                if(distance[u] != INFINITY && distance[u]+ weight < distance[v])
                {
                    System.out.println("Graph contains negative cycle .");
                    return;
                }
            }
            printArr(distance,source);
        }
        public void printArr(int[] distance , int source)
        {
            System.out.println("Shortest path to all vertices from source "+ source);
            for(int i=1;i<V;i++)
                System.out.println("Source: "+source+" destination : "+i+" weight : "+distance[i]);
        }
    }
    public static void main(String[] args) {
        Graph g = new Graph(6,7);
        g.addEdge(1,2,2);
        g.addEdge(1,5,3);
        g.addEdge(2,3,2);
        g.addEdge(2,4,5);
        g.addEdge(2,5,4);
        g.addEdge(3,4,2);
        g.addEdge(4,2,-20);
        g.addEdge(5,1,-8);
        g.BellmanFord(1);


    }
}
