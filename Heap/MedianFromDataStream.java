/* The median is the middle value in an ordered integer list. If the size of the list is even,
there is no middle value and the median is the mean of the two middle values.*/
package Heap;
import java.util.Comparator;
import java.util.Queue;
import java.util.Scanner;
import java.util.PriorityQueue;
class median {
    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;
    median() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }
    // Function to return median of integer data stream .
    public Double MedianFromDataStream(Integer num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if(minHeap.size() > maxHeap.size())
            maxHeap.add(minHeap.poll());

        return maxHeap.size() > minHeap.size() ? maxHeap.peek() : (maxHeap.peek()+minHeap.peek())/2.0;
    }
}
public class MedianFromDataStream {
    //Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        median m = new median();
        Integer choice = 1 ;
        while(choice == 1){
            System.out.print("Enter number in data stream : ");
            int num = sc.nextInt();
            System.out.println("Median of data stream is : " + m.MedianFromDataStream(num));
            System.out.print("Press 1 to continue  : ");
            choice = sc.nextInt();
        }
    }
}
