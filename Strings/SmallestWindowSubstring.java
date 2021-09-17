package Strings;
import java.util.*;
public class SmallestWindowSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a substring : ");
        String str = sc.next();
        System.out.println("Smallest substring that contains all characters of original string : "+SmallestSubstring(str));
    }

    // Function to return smallest substring containing all distinct character of given string .
    public static String SmallestSubstring(String str) {
        int n = str.length();
        HashMap<Character,Integer> map = new HashMap<>();
        String result = "";
        for(int i = 0 ; i < n ; i++) {
            map.put(str.charAt(i) , map.getOrDefault(str.charAt(i),1)+1);
        }

        int distinct_characters = map.size();
        int size = n ;

        for(int i = 0 ; i < n ; i++) {
            int count = 0;
            int[] visited = new int[256];
            Arrays.fill(visited,0);
            String sub_str = "";
            for(int j = i ; j < n; j++) {
                if(visited[str.charAt(j)] == 0) {
                    count++;
                    visited[str.charAt(j)]  = 1;
                }
                sub_str += str.charAt(j);
                if(count == distinct_characters)
                    break;
            }
            if(sub_str.length() < size && count == distinct_characters) {
                 size = sub_str.length();
                 result = sub_str;
            }
        }

        return result;
    }
}
