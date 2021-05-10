package Tree;
public class MaxHeap {
    int maxsize ; // Maximum size of heap .
    int size; // current size of heap .
    int Heap[]; // Heap represented as array .
    // Constructor
    public MaxHeap(int maxsize)
    {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize+1];
        Heap[0] = Integer.MAX_VALUE;
    }
    // This method returns parent node.
    private int parent(int pos) {
        return pos/2;
    }
    // This method returns lefChild node.
    private int leftChild(int pos) {
        return (2*pos);
    }
    // This method returns rightChild node.
    private int rightChild(int pos) {
        return (2*pos)+1;
    }
    //This method swaps values passed as argument .
    private void swap(int fpos, int spos)
    {
        int temp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = temp;
    }
    private boolean isLeaf(int pos)
    {
        if(pos>size/2 && pos<=size)
            return true;
        return false;
    }
    // This method inserts an element into Heap .
    public void insert(int element)
    {
        if(size>=maxsize)
            return;
        Heap[++size] = element;
        int current = size;
        while(Heap[current]>Heap[parent(current)])
        {
            swap(current,parent(current));
            current = parent(current);
        }
    }
    private void maxHeapify(int pos)
    {
        if(isLeaf(pos))
            return;
        // If node is smaller than its children than Max heapify .
        if(Heap[pos]<Heap[leftChild(pos)] || Heap[pos]<Heap[rightChild(pos)])
        {
            if(Heap[leftChild(pos)]>Heap[rightChild(pos)])
            {
                swap(pos,leftChild(pos));
                maxHeapify(leftChild(pos));
            }
            else
            {
                swap(pos,rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }
    // This method removes root element that is max element in Heap .
    public int extractMax()
    {
        int popped = Heap[1];
        Heap[1] = Heap[size--];
        maxHeapify(1);
        return popped;
    }
    // This method prints MAX HEAP .
    public void print()
    {
        for(int i=1;i<size/2;i++) {
            System.out.print(" PARENT : " + Heap[i] +
                    " LEFT CHILD : " + Heap[leftChild(i)] +
                    " RIGHT CHILD : " + Heap[rightChild(i)]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("The Max Heap is ");
        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);

        maxHeap.print();
        System.out.println("The max val is "
                + maxHeap.extractMax());
    }
}
