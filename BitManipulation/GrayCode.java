package BitManipulation;
import java.util.Scanner;
import java.util.ArrayList;
public class GrayCode {
    // Function to generate Gray code
    static ArrayList<String> graycodes (int n) {
        if(n <= 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("0");
            return bres;
        }
        if(n == 1) {
            ArrayList<String> rres = new ArrayList<>();
            rres.add("0");
            rres.add("1");
            return rres;
        }

        ArrayList<String> L1 = graycodes(n-1);
        ArrayList<String> result = new ArrayList<>();

        for(int i = 0 ; i < L1.size(); i++)
            result.add("0"+L1.get(i));
        for(int i = L1.size() - 1; i>=0;i--)
            result.add("1"+L1.get(i));

        return result;
    }
    // Function to print generated Gray codes
    static void printGrayCodes(int n) {
        ArrayList<String> gray_codes = graycodes(n);
        System.out.println("Gray codes for length "+n+" : ");
        for(String i : gray_codes)
            System.out.println(i);
    }
    // Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length of gray codes : ");
        int n = sc.nextInt();
        printGrayCodes(n);
    }
}
