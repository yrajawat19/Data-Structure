package Hashing;
import java.util.*;
public class LRUCache {
    // We are using Deque for shifting operation in O(1) time.
    Deque<Integer> deque ; // Deque declaration .
    // We are using HashSet for searching operation in O(1) time .
    HashSet<Integer> hashSet ; // HashSet declaration .
    final int CACHE_SIZE; // Cache window size .
    int pageFaults; // Variable to count total Page Faults .
    // Constructor to initialize all the global declarations .
    LRUCache(int size)
    {
        CACHE_SIZE = size;
        deque = new LinkedList<>();
        hashSet = new HashSet<>();
        pageFaults = 0;
    }
    // Refer function .
    void refer(int page)
    {
        // Searching for page in hashSet , if HashSet does not contains page i.e there is a page fault .
        if(!hashSet.contains(page))
        {
            pageFaults++ ; // increment the Page Fault count .
            // If Cache is full , then we will remove last page from deque which happens to be Least Recently Used page .
            if(deque.size() == CACHE_SIZE)
            {
                int last = deque.removeLast(); // Remove last page .
                hashSet.remove(last); // Remove that page from hashSet too .
            }
        }
        // Page maybe present in Cache but still we have to shift it in front as It is most recently used page .
        else
            deque.remove(page);
        //Adding page in deque at front position in cache .
        deque.push(page);
        hashSet.add(page);
    }

    // Function to display Cache
    void display()
    {
        Iterator<Integer> i = deque.iterator();
        while(i.hasNext())
            System.out.print(i.next()+ " ");
        System.out.println();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(4);
        cache.refer(1);
        cache.refer(2);
        cache.refer(3);
        cache.refer(1);
        cache.refer(4);
        cache.refer(5);
        cache.refer(2);
        cache.refer(2);
        cache.refer(1);
        System.out.println("Page faults : "+cache.pageFaults);
        cache.display();
    }
}
