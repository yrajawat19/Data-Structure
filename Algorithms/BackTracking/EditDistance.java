package Algorithms.BackTracking;
import java.util.Scanner;
public class EditDistance {
    // Functiont to return min
    public static int min (int x , int y , int z) {
        if(x <= y && x <= z)
            return x;
        if(y <= x && y <= z)
            return y;
        return z;
    }
    // Function to Edit distance between both the input strings .
    public static int editDist(String s1 , String s2,int m,int n) {

        if( m == 0) // If string s1 is empty then ,only option is to insert all characters of string s2 .
            return n;
        if( n == 0) // If string s2 is empty then , only option is to insert all characters of string s1 .
            return m;

        if(s1.charAt(m-1) == s2.charAt(n-1))
            return editDist(s1,s2,m-1,n-1);

        return 1+min(editDist(s1,s2,m-1,n),editDist(s1,s2,m,n-1),editDist(s1,s2,m-1,n-1));
    }
    // Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string s1 : ");
        String s1 = sc.nextLine();
        System.out.print("Enter string s2 : ");
        String s2 = sc.nextLine();
        System.out.println("Minimum operations required to make both strings equal : "+editDist(s1,s2,s1.length(),s2.length()));
    }
}
