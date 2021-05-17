package Hashing;
import java.util.*;
public class AddElementsToHashMap {
    public static void main(String[] args) {
        HashMap<Integer,String> hm1 = new HashMap<>();
        hm1.put(1,"Burger");
        hm1.put(2,"French Fries");
        hm1.put(3,"Whopper");
        hm1.put(4,"Pizza");
        // To print HashMap content
        System.out.println("Mapping of HashMap hm1 are :"+hm1);
        // To print size of hash map
        System.out.println("Size of map is "+hm1.size());
        // if conditon in HashMap
        System.out.println("Enter key to check its value :");
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();
        if(hm1.containsKey(key)) {
            String fastfood = hm1.get(key);
            System.out.println("Value of key "+ key+ " is "+fastfood);
        }
        else
            System.out.println("key does not exist in HashMap .");
    }
}
