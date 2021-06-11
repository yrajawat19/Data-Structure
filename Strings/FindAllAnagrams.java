package Strings;

public class FindAllAnagrams {
    static final int MAX = 256;
    static boolean compare(char[] arr1,char[] arr2)
    {
        for(int i=0;i<MAX;i++)
            if(arr1[i] != arr2[i])
                return false;
            return true;
    }
    private static void search(String text,String pat)
    {
        int M = pat.length();
        int N = text.length();

        char[] countP = new char[MAX];
        char[] countTW = new char[MAX];

        for(int i=0;i<M;i++) {
            countP[pat.charAt(i)]++;
            countTW[text.charAt(i)]++;
        }

        for(int i=M;i<N;i++) {
            if(compare(countP,countTW))
                System.out.println("Anagram found at index : "+ (i-M));
            countTW[text.charAt(i)]++;
            countTW[text.charAt(i-M)]--;
        }
        if(compare(countP,countTW))
            System.out.println("Anagram found at index : "+(N-M));
    }
    public static void main(String[] args) {
        String text1 = "ABCDGDBCAECBAFDACB"; // Test 1 Text
        String pat1 = "ABCD"; // Test 1 pattern
        search(text1,pat1); // Test 1
        String text2 = "hgfjhsloeihfhjhgfjslk"; // Test 2 Text
        String pat2 = "hgfj"; // Test 2 pattern
        search(text2,pat2); // Test 2
    }
}
