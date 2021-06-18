/*Given a number n, find the smallest number that has same set of digits as n and is greater than n. If n is the greatest possible number with its set of digits, then print “not possible”. */
package Arrays;
import java.util.Arrays;
import java.util.Scanner;

public class NextPermutation {
    static void swap(int[] num , int i , int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
    static boolean nextpermutation(int[] num) {
        int n = num.length;
        int i;
        for(i=n-1;i>0;i--)
        {
            if(num[i]>num[i-1])
                break;
        }

        if(i == 0)
            return false;

        int x = num[i-1];
        int min = i;
        for(int j = i+1;j<n;j++)
        {
            if(num[j]>x && num[j] < num[min])
                min = j;
        }
        swap(num,i-1,min);
        Arrays.sort(num,i,n);

        return true;
    }
    static void print(int[] num) {
        for(int digit : num)
            System.out.print(digit);
        System.out.println();
    }
    public static void main(String[] args) {
        System.out.println("Enter digits in number");
        Scanner sc = new Scanner(System.in);
        int digits = sc.nextInt();
        int[] num = new int[digits];
        System.out.println("Enter digits in number :");
        for(int i=0;i<digits;i++)
            num[i] = sc.nextInt();
        System.out.println("Original number :");
        print(num);
        if(nextpermutation(num)) {
            System.out.println("Next permutation of number : ");
            print(num);
        }
        else
            System.out.println("Next permutation of number is not possible .");
    }
}
