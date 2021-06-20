/* You are given n activities with their start and finish times. Select the maximum number of activities that can be performed by a single person, assuming that a person can only work on a single activity at a time. */
package Arrays;
import java.util.Arrays;
public class ActivitySelectionProblem {

    public static void main(String[] args) {
        int s[] =  {1, 3, 0, 5, 8, 5}; // Activity start time array .
        int f[] =  {2, 4, 6, 7, 9, 9}; // Activity finish time array .
        System.out.println("Activities start and finish times : ");
        for(int i = 0; i<s.length;i++) {
            System.out.print("Activity no "+i+" = "+s[i]+" ---> "+f[i]);
            System.out.println();
        }
        findMaxActivities(s,f);
    }

    private static void findMaxActivities(int[] s, int[] f) {
        Arrays.sort(f);
        int i , j ;
        System.out.println("Following activities are selected : ");
        i = 0;
        System.out.println("Activity no "+i+" = "+s[i]+" ---> "+f[i]);

        for(j = 1;j<f.length;j++)
        {
            if(s[j] >= f[i]) {
                System.out.println("Activity no "+j+" = "+s[j]+" ---> "+f[j]);
                i = j;
            }
        }
    }
}
