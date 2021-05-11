package Graph;

public class DijkstraAlgorithm_using_AdjacencyMatrix {
    static class Graph
    {
        int V; //no of vertices in Adjacenecy Matrix
        int[][] matrix;
        Graph(int v)
        {
            V = v;
            matrix = new int[V][V];
        }
        void addEdge(int source,int destination,int weight)
        {
            matrix[source][destination] = weight;
            // for undirected weighted graph
            matrix[destination][source] = weight;
        }
        void Dijkstra_GetMinimum(int source)
        {
            boolean[] visited = new boolean[V];
            int[] distance = new int[V];
            int INFINITY = Integer.MAX_VALUE;
            for(int i=0;i<V;i++)
                distance[i] = INFINITY;
            distance[source] = 0;
            for(int i=0;i<V;i++)
            {
                int u = getMinimum(visited,distance);
                visited[u] = true;
                for(int v=0;v<V;v++)
                {
                    if(matrix[u][v]>0)
                    {
                        if(visited[v]==false && matrix[u][v] != INFINITY)
                        {
                            int newkey = matrix[u][v] + distance[u];
                            if(newkey<distance[v])
                                distance[v] = newkey;
                        }
                    }
                }
            }
                printDijkstra(source,distance);

        }

        private void printDijkstra(int source, int[] distance) {
            System.out.println("Dijkstra Algorithm using Adjacency matrix :");
            for (int i = 0; i < V; i++)
                System.out.println("Source "+source+ " for vertex "+i+" with weight "+distance[i]);
            System.out.println();
        }

        private int getMinimum(boolean[] visited,int[] distance) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for(int i=0;i<V;i++)
            {
                if(visited[i]==false && distance[i]<min)
                {
                    min = distance[i];
                    index = i;
                }
            }
            return index;
        }
    }
    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);
        graph.Dijkstra_GetMinimum(0);


    }
}
