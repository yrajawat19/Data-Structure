/* You are given n activities with their start and finish times. Select the maximum number of activities that can be performed by a single person, assuming that a person can only work on a single activity at a time. */
package Algorithms.Greedy;
import java.util.*;

class Activity {
    int start;
    int finish;
    public Activity(int start, int finish) {
        this.start = start ;
        this.finish = finish ;
    }
}
// This class is used to define user defined comparator
class Compare {
    public static void compare(Activity[] arr) {
        Arrays.sort(arr, new Comparator<Activity>() {
            @Override
            public int compare(Activity a, Activity b) {
                return a.finish - b.finish;
            }
        });
    }
}

public class ActivitySelectionProblem {
    // Function to find how activities a single person can perform .
    public static void findActivities(Activity[] arr) {
        Compare obj = new Compare();
        obj.compare(arr);
        System.out.println("Following activities are selected : ");
        int i = 0;
        System.out.println("Activity no "+i+" = Time "+arr[i].start+" to "+arr[i].finish);
        for(int j = 1;j < arr.length;j++)
        {
            if(arr[j].start >= arr[i].finish) {
                System.out.println("Activity no " + j + " = Time " + arr[j].start + " to " + arr[j].finish);
                i = j;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of activities : ");
        int n = sc.nextInt();
        Activity[] arr = new Activity[n];
        System.out.println("Enter start and finish time for activities :");
        for(int i = 0 ; i < n ; i++) {
            System.out.print("Activity no "+i+" start time : ");
            int starttime = sc.nextInt();
            System.out.print("Activity no "+i+" finish time : ");
            int finishtime = sc.nextInt();
            arr[i] = new Activity(starttime,finishtime);
        }

        System.out.println("Input activities timings :");
        for(int i = 0; i < n; i++)
            System.out.println("Activity no "+i+" = Time "+arr[i].start+" to "+arr[i].finish);
        // Selecting activities .
        findActivities(arr);
    }
}
