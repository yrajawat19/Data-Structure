package Strings;

public class KMPSearch {
    static void search(String pattern, String text)
    {
         int M = pattern.length();
         int N = text.length();
         int[] lps = new int[M];
         int j=0;
         computeLPS(pattern,lps,M);
         int i=0;
         while(i<N)
         {
             if(pattern.charAt(j) == text.charAt(i)) {
                 i++;
                 j++;
             }
             if(j == M) {
                 System.out.println(" Found pattern at index "+(i-j));
                 j = lps[j-1];
             }

         }
    }
    static void computeLPS(String pattern,int[] lps,int M)
    {
        int len = 0;
        int i = 1;
        lps[0] = 0;
        while(i<M)
        {
            if(pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else
            {
                if(len != 0)
                    len = lps[len-1];
                else
                    lps[i++] = len;
            }
        }
    }
    public static void main(String[] args) {
        String text = "AAAAABAAABA";
        String pattern = "AAAB";
        search(pattern,text);
    }
}
