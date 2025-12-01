public class CanShipWithCapacity {
    
    public static boolean canShip(int weights[], int days, int c) {
        int count = 1; // day 1
        int shipped = 0;
        for(int i = 0; i < weights.length; i++) {
            if(shipped + weights[i] > c) {
                // next day
                count++;
                shipped = weights[i];
            } else {
                shipped += weights[i];
            }
            if(count > days) {
                return false;
            }
        }
        // if can be shipped in less days, can definitely ship in more days
        return count <= days;
    }

    // Time O(n log(sum - max))
    public static int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int sum = 0;
        for(int elem : weights) {
            max = Math.max(elem, max);
            sum += elem;
        }

        int lo = max, hi = sum;
        int ans = -1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(canShip(weights, days, mid)) {
                // can ship with mid capacity, try to find less capacity
                ans = mid;
                hi = mid - 1;
            } else {
                // increase the capacity, if not able to ship
                // with current capacity on time
                lo = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int weights[] = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        // ans 15
        System.out.println(shipWithinDays(weights, days));
    }
}
