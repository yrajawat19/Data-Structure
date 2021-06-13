package Queues;

class queue{
    int size = 10; // Size initalized to 10
    int Arr[] = new int[size]; // Array is initialized with size 10
    int queue_front1 = 0; int queue_rear1 = -1;
    int queue_front2=size-1;int queue_rear2 = size;
    void Enqueue1(int item)
    {
        if(queue_rear1<queue_rear2-1)
        {
            queue_rear1++;
            Arr[queue_rear1]=item;
            System.out.println("Item Enqueued in Queues.Queue 1:"+item);
        }
        else{
            System.out.println("Queues.Queue Overflow");
        }
    }
    void Enqueue2(int item)
    {
        if(queue_rear2>queue_rear1+1)
        {
            queue_rear2--;
            Arr[queue_rear2]=item;
            System.out.println("Item Enqueued in Queues.Queue 2:"+item);
        }
        else{
            System.out.println("Queues.Queue Overflow");
        }
    }
    void Dequeue1()
    {
        if(queue_front1!=queue_rear1)
        {
            int item = Arr[queue_front1];
            queue_front1++;
            System.out.println("Item Dequeued in Queues.Queue 1 :"+item);
        }
        else{
            System.out.println("First Queues.Queue Underflow!!");
        }
    }
    void Dequeue2()
    {
        if(queue_front2==size-1 && queue_front2>queue_rear2)
        {
            int item = Arr[queue_front2];
            queue_front2--;
            System.out.println("Item Dequeued in Queues.Queue 2 :"+item);
        }
        else{
            System.out.println("Second Queues.Queue Underflow!!");
        }
    }

    void Show_Q1()
    {
        for(int i=queue_front1;i<=queue_rear1;i++)
        {
            System.out.println("Element in Queues.Queue 1:"+Arr[i]);
        }
    }
    void Show_Q2()
    {
        for(int i=queue_front2;i>=queue_rear2;i--)
        {
            System.out.println("Element in Queues.Queue 2:"+Arr[i]);
        }
    }
}
public class TwoQueueInOneArray {
    public static void main(String args[])
    {
       queue Q = new queue();
        Q.Enqueue1(23);
        Q.Enqueue1(34);
        Q.Enqueue1(45);
        Q.Enqueue1(89);
        Q.Enqueue1(37);
        Q.Enqueue1(33);
        Q.Enqueue2(32);
        Q.Enqueue2(67);
        Q.Enqueue2(76);
        Q.Enqueue2(98);
        Q.Show_Q1();
        Q.Show_Q2();
        Q.Dequeue1();
        Q.Dequeue2();
        Q.Show_Q1();
        Q.Show_Q2();
    }
}
