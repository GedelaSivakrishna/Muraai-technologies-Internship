package Leetcode_Practice;
import java.util.Arrays;

public class AggresiveCows {

    // Time O(n)
    public static boolean canPlaceCows(int stalls[], int n, int cows, int mid) {
        int count = 1; // placed first cow
        int lastPosition = stalls[0]; // first cows position
        
        for(int i = 1; i < n; i++) {
            if(stalls[i] - lastPosition >= mid) {
                // place next cow here
                count++;
                // update last cows position
                lastPosition = stalls[i];
            }
            // check if all cows are placed
            if(count == cows) {
                return true;
            }
        }
        return false;
    }

    // Time O(nlogn + nlog(max of stall - min of stall))
    public static int aggresiveCows(int stalls[], int cows) {
        int n = stalls.length;
        Arrays.sort(stalls);
        // apply Binary Search on answer
        int lo = 1; // the minimum distance b/w any two cows can be atleast 1
        int hi = stalls[n - 1] - stalls[0];
        int ans = -1;

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(canPlaceCows(stalls, n, cows, mid)) {
                // found potential answer
                ans = mid;
                // search better maximum distance to right
                lo = mid + 1;
            } else {
                // discard right
                hi = mid - 1;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int stalls[] = {1,2,4,8,9};
        int cows = 3;
        // ans 3
        System.out.println(aggresiveCows(stalls, cows));
        // ans 1
        System.out.println(aggresiveCows(stalls, 4));
    }
}
