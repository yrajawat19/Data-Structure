package Strings;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SortStringWithFrequency {
    // Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string : ");
        String str = sc.nextLine();
        System.out.println("Sorted string : "+sort(str));

    }

    // Function to sort string with frequency of characters .
    private static String sort(String str) {
        // Hashmap to store characters and their respective frequency .
        HashMap<Character , Integer > map = new HashMap<>();
        // Iterating over string .
        for(char c : str.toCharArray())
            map.put(c,map.getOrDefault(c,0)+1);

        // Max-heap to store all characters on the basis of their frequencies and extract max frequency character
        PriorityQueue<Character> maxheap = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));

        // Pushing all keys in max heap .
        maxheap.addAll(map.keySet());

        // String builder to store sorted string
        StringBuilder result = new StringBuilder();

        while(!maxheap.isEmpty()) {
            Character current = maxheap.remove();
            for(int i = 0; i < map.get(current) ; i++)
                result.append(current);
        }

        return result.toString();
    }
}
