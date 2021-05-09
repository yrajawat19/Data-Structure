package Graph;
// Representation of graph using adjacency matrix
class AdjacencyMatrix_Graph
{
     int V; // no of vertices .
    private int[][] g = new int[10][10]; // Adjacency matrix
    AdjacencyMatrix_Graph(int v)
    {
        V = v;
        for(int i=0;i<V;i++)
            for(int j=0;j<V;j++)
                g[i][j] = 0;
    }

    void printMatrix()
    {
        for(int i=0;i<V;i++)
        {
            System.out.println();
            for(int j=0;j<V;j++)
                System.out.print(" "+ g[i][j]);
        }
    }

    void addEdge(int u, int v)
    {
        if(u == v)
            System.out.println("Vertex is same .");
        if((u>V) || (v>V))
            System.out.println("Vertex does not exist .");
        else{
            g[u][v] = 1;
            g[v][u] = 1;
        }
    }

    void addVertex()
    {
        V++;
        for(int i = 0;i<V;i++)
        {
            g[V-1][i] = 0;
            g[i][V-1] = 0;
        }

    }

    void removeVertex(int u)
    {
        if(u>V)
            System.out.println("Vertex not present !");
        else
        {
            while(u<V)
            {
                for(int i=0;i<V;i++)
                    g[i][u] = g[i][u+1];
                for(int i=0;i<V;i++)
                    g[u][i] = g[u+1][i];
                u++;
            }

            V--;
        }
    }

}
public class Graph_as_adjacencyMatrix {
    public static void main(String[] args) {
        AdjacencyMatrix_Graph obj = new AdjacencyMatrix_Graph(4);
        // calling methods
        obj.addEdge(0, 1);
        obj.addEdge(0, 2);
        obj.addEdge(1, 2);
        obj.addEdge(2, 3);

        // the adjacency matrix created
        obj.printMatrix();

        // adding a vertex to the graph
        obj.addVertex();

        // connecting that verex to other existing vertices
        obj.addEdge(4, 1);
        obj.addEdge(4, 3);

        // the adjacency matrix with a new vertex
        obj.printMatrix();

        // removing an existing vertex in the graph
        obj.removeVertex(1);

        // the adjacency matrix after removing a vertex
        obj.printMatrix();
    }
}
