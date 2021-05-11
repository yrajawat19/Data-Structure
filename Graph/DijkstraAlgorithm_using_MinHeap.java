package Graph;
import java.util.*;

class DijkstraAlgorithm_using_MinHeap
{
    static class Edge
    {
        int source;
        int destination;
        int weight;
        public Edge(int source, int destination, int weight)
        {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

    }
    static class HeapNode
    {
        int vertex;
        int distance;
    }
    static class Graph {
        int vertices;
        LinkedList<Edge> adj[];

        Graph(int vertices) {
            this.vertices = vertices;
            adj = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++)
                adj[i] = new LinkedList<>();
        }
        // Method to add Edge
        public void addEdge(int source, int destination, int weight) {
            // For undirected graph
            adj[source].add(new Edge(source,destination,weight));
            adj[destination].add(new Edge(destination,source,weight));

        }
        public void dijkstra_GetMin(int source)
        {
            int INFINITY = Integer.MAX_VALUE;
            boolean[] SPT = new boolean[vertices];
            HeapNode[] heapNodes = new HeapNode[vertices];
            for(int i=0;i<vertices;i++)
            {
                heapNodes[i] = new HeapNode();
                heapNodes[i].vertex = i;
                heapNodes[i].distance = INFINITY;
            }
            heapNodes[source].distance = 0;
            MinHeap minHeap = new MinHeap(vertices);
            for(int i=0;i<vertices;i++)
                minHeap.insert(heapNodes[i]);
            while(!minHeap.isEmpty()) {
                HeapNode extractedNode = minHeap.extractMin();
                int extractedVertex = extractedNode.vertex;
                SPT[extractedVertex] = true;

                LinkedList<Edge> list = adj[extractedVertex];
                for(int i=0;i<list.size();i++)
                {
                    Edge edge = list.get(i);
                    int destination = edge.destination;
                    if(SPT[destination] == false)
                    {
                        int newkey = heapNodes[extractedVertex].distance+edge.weight;
                        int currentkey = heapNodes[destination].distance;
                        if(currentkey>newkey)
                        {
                            decreaseKey(minHeap,newkey,destination);
                            heapNodes[destination].distance = newkey;
                        }
                    }
                }
            }

            printDijkstra(heapNodes,source);
        }
        public void decreaseKey(MinHeap minHeap,int newkey,int vertex)
        {
            int index = minHeap.indexes[vertex];
            HeapNode node = minHeap.mH[index];
            node.distance = newkey;
            minHeap.bubbleUp(index);
        }

        public void printDijkstra(HeapNode[] resultSet,int source)
        {
            System.out.println("Dijkstra Algorithm : ");
            for(int i=0;i<vertices;i++)
                System.out.println("Source vertex : "+source+" to vertex: "+i+" distance : "+resultSet[i].distance);
        }
    }
    static class MinHeap
    {
        int capacity;
        int currentSize;
        HeapNode[] mH;
        int[] indexes;

        public MinHeap(int capacity)
        {
            this.capacity = capacity;
            mH = new HeapNode[capacity+1];
            indexes = new int[capacity];
            mH[0] = new HeapNode();
            mH[0].distance = Integer.MIN_VALUE;
            mH[0].vertex = -1;
            currentSize = 0;
        }
        public void display()
        {
            for(int i=0;i<=currentSize;i++)
            {
                System.out.println(" "+mH[i].vertex+" distance "+mH[i].distance);
            }
        }

        public void insert(HeapNode x)
        {
            currentSize++;
            int idx = currentSize;
            mH[idx] = x;
            indexes[x.vertex] = idx;
            bubbleUp(idx);
        }
        public void bubbleUp(int pos)
        {
            int parentIdx = pos/2;
            int currentIdx = pos;
            while(currentIdx>0 && mH[parentIdx].distance>mH[currentIdx].distance)
            {
                HeapNode currentNode = mH[currentIdx];
                HeapNode parentNode = mH[parentIdx];

                // swap the positons
                indexes[currentNode.vertex] = parentIdx;
                indexes[parentNode.vertex] = currentIdx;
                swap(currentIdx,parentIdx);
                currentIdx = parentIdx;
                parentIdx = parentIdx/2;
            }
        }

        public HeapNode extractMin()
        {
            HeapNode min = mH[1];
            HeapNode lastNode = mH[currentSize];
            indexes[lastNode.vertex] = 1;
            mH[1] = lastNode;
            mH[currentSize] =null;
            sinkDown(1);
            currentSize--;
            return min;
        }

        public void sinkDown(int k)
        {
            int smallest = k;
            int leftChild = 2*k;
            int rightChild = 2*k+1;
            if(leftChild<heapsize() && mH[smallest].distance>mH[leftChild].distance)
                smallest = leftChild;
            if(rightChild<heapsize() && mH[smallest].distance>mH[rightChild].distance)
                smallest = rightChild;
            if(smallest != k)
            {
                HeapNode smallestNode = mH[smallest];
                HeapNode KNode = mH[k];
                indexes[smallestNode.vertex] = k;
                indexes[KNode.vertex] = smallest;
                swap(k,smallest);
                sinkDown(smallest);
            }
        }
        public void swap(int a, int b)
        {
            HeapNode temp = mH[a];
            mH[a] = mH[b];
            mH[b] = temp;
        }
        public boolean isEmpty()
        {
            return currentSize == 0;
        }
        public int heapsize()
        {
            return currentSize;
        }

    }
    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0,1,4);
        graph.addEdge(0,2,3);
        graph.addEdge(1,2,1);
        graph.addEdge(1,3,2);
        graph.addEdge(2,3,4);
        graph.addEdge(3,4,2);
        graph.addEdge(4,5,6);
        graph.dijkstra_GetMin(0);
    }
}



