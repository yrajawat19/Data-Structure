package Stacks;

class TwoQueues{
    int size =5;
    int queue1[]=new int[size];
    int queue2[]=new int[size];
    int queue1_front=0;
    int queue2_front=0;
    int queue1_rear = -1;
    int queue2_rear = -1;

    void Enqueue1(int item)
    {
        if(queue1_rear<size)
        {
            queue1_rear++;
            queue1[queue1_rear]=item;
            System.out.println("Item Inserted :"+item);
        }
        else{
            System.out.println("Overflow Condition  in Queues.Queue 1!!");
        }
    }
    void Enqueue2()
    {
        if(queue2_rear<size)
        {
            for(int j=queue1_rear;j>=queue1_front;j--)
            {
                for(int i=queue2_front;i<size;i++) {
                    queue2_rear++;
                    queue2[i] = queue1[j];
                    System.out.println("Item inserted in queue 2:" + queue2[i]);
                }
            }
        }
        else
        {
            System.out.println("Overflow in Queues.Queue 2!!");
        }
    }
    void Traversal()
    {
        for(int i=queue2_front;i<size;i++)
        {
            System.out.println("Item in Stacks.Stack:"+queue2[i]);
        }
    }

}
public class TwoQueueOneStack {
    public static void main(String args[])
    {
        TwoQueues Q = new TwoQueues();
        Q.Enqueue1(2);
        Q.Enqueue1(3);
        Q.Enqueue1(4);
        Q.Enqueue1(5);
        Q.Enqueue1(6);
        Q.Enqueue2();
        Q.Traversal();
    }
}
