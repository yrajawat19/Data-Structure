package Arrays;
import java.util.*;
public class MinimumPlatformNeeded {
    public static void main(String[] args) {
        int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
        int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
        System.out.println("Minimum platforms required : "+ findPlatform(arr,dep));
    }

    private static int findPlatform(int[] arr, int[] dep)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int currentPlatforms = 1;
        int maxPlatforms = 1;
        int i=1,j=0;
        while(i<arr.length && j<dep.length)
        {
            if(arr[i]<= dep[j]) {
                currentPlatforms++;
                i++;
            }
            else
            {
                currentPlatforms--;
                j++;
            }
            maxPlatforms = Math.max(maxPlatforms,currentPlatforms);
        }

        return maxPlatforms;
    }
}
