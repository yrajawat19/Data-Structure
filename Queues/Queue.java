package Queues;

class QueueDST{
    int size = 5; //Size
    int queue[]=new int[size]; //Queues.Queue declaration as an array of size 5
    int front = 0; // front set to 0
    int rear = -1; // rear set to -1
    void Enqueue(int item) //Enqueue Function
    {
        if(rear<=size)  // If condition that rear should be smaller than Queues.Queue size
        {
            rear++; //rear increment
            queue[rear]=item;
            System.out.println("Item Enqueued:"+item);
        }
        else{
            System.out.println("Queues.Queue Overflow !!");
        }
    }
    void Dequeue() // Dequeue Function
    {
        if(front<size)
        {
           int item = queue[front];
            front++;
           System.out.println("Item Dequeued:"+item);
        }
        else{
            System.out.println("Queues.Queue Underflow!!");
        }
    }
    void Traverse()  //Queues.Queue Traversal Function
    {
        for(int i=front;i<=rear;i++)
        {
            System.out.println("Item in Queues.Queue:"+queue[i]);
        }
    }
}
public class Queue {
    public static void main(String args[])
    {
        QueueDST q = new QueueDST(); //Object of class QueueDST
        q.Enqueue(12); //Enqueue process
        q.Enqueue(15);
        q.Enqueue(14);
        q.Enqueue(17);
        q.Enqueue(13);
        q.Traverse();
        q.Dequeue(); // Queues.Queue first element deletion
        q.Traverse(); // Traversal after first Dequeue
        q.Dequeue();
        q.Dequeue();
        q.Dequeue();
        q.Dequeue();
        q.Dequeue(); //Queues.Queue Underflow Situation
        q.Traverse(); //Prints nothing as Queues.Queue is empty


    }
}
