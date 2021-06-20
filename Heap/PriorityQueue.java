package Heap;
class BinaryHeap
{
    int maxSize;
    int size;
    int[] Heap;
    BinaryHeap(int maxSize)
    {
        this.maxSize = maxSize;
        int size = 0;
        Heap = new int[this.maxSize+1];
        Heap[0] = Integer.MAX_VALUE;
    }
    public int parent(int pos)
    {
        return pos/2;
    }
    public int leftChild(int pos)
    {
        return (2*pos);
    }
    public int rightChild(int pos)
    {
        return (2*pos)+1;
    }
    public boolean isLeaf(int pos)
    {
        if(pos>size/2 && pos<=size)
            return true;
        return false;
    }
    public void swap(int fpos , int spos)
    {
        int temp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = temp;
    }

    public void insert(int element)
    {
        if(size>=maxSize)
            return;
        Heap[++size] = element;
        int current = size;
        while(Heap[current]>Heap[parent(current)])
        {
            swap(current,parent(current));
            current = parent(current);
        }
    }

    public void changePriority(int i, int element)
    {
        int oldValue = Heap[i];
        Heap[i] = element;
        if(element<oldValue)
        {
            maxHeapify(i);
        }
        else
        {
            while(Heap[i]>Heap[parent(i)])
            {
                swap(i,parent(i));
                i = parent(i);

            }

        }
    }

    public void maxHeapify(int pos)
    {
        if(isLeaf(pos))
            return;
        if(Heap[pos]<Heap[leftChild(pos)] || Heap[pos]<Heap[rightChild(pos)])
        {
            if(Heap[pos]<Heap[leftChild(pos)])
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

    public int getMax()
    {
        return Heap[1];
    }
    public int extractMax()
    {
        int popped = Heap[1];
        Heap[1] = Heap[size--];
        maxHeapify(1);
        return popped;
    }

    public void print()
    {
        for(int i=1;i<size;i++)
        {
            System.out.print(Heap[i]+" ");
        }
    }
}
public class PriorityQueue {
    public static void main(String[] args) {
        BinaryHeap q = new BinaryHeap(20);
        q.insert(45);
        q.insert(20);
        q.insert(14);
        q.insert(12);
        q.insert(31);
        q.insert(7);
        q.insert(11);
        q.insert(13);
        q.insert(7);
        System.out.println("Priority Queues.Queue :");
        q.print();
        System.out.println();
        System.out.println("Element with maximum priority : "+q.getMax());
        System.out.println("extracting maximum element : "+q.extractMax());
        System.out.println("PQ after extracting maximum element : ");
        q.print();
        System.out.println();
        q.changePriority(2,49);
        System.out.println("PQ after changing priority: ");
        q.print();
        System.out.println();


    }
}
