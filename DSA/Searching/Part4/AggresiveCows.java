import java.util.Arrays;
public class AggresiveCows {

    public static boolean canPlaceCows(int stalls[], int n, int cows, int mid) {
        int count = 1; // first cow already placed
        int lastPosition = stalls[0]; // first cow position
        for(int i = 1; i < n; i++) {
            if((stalls[i] - lastPosition) >= mid) {
                // can place cow
                count++;
                lastPosition = stalls[i];
            }
            if(count == cows) {
                return true;
            }
        }
        return false;
    }

    // Time O(nlogn + nlog(max position - min position))
    //Space O(1)
    public static int aggresiveCows(int stalls[], int cows) {
        Arrays.sort(stalls);
        int n = stalls.length;
        int lo = 1, hi = stalls[n-1] - stalls[0];
        int ans = -1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(canPlaceCows(stalls, n, cows, mid)) {
                ans = mid;
                // search better answer
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int stalls[] = {1,2,8,4,9};
        int cows = 3;
        // ans 3
        System.out.println(aggresiveCows(stalls, cows));
    }
}