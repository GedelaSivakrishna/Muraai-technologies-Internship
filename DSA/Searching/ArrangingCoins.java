public class ArrangingCoins {
    // Time O(log n)
    // Space O(1)
    public static int arrangingCoins(int n) {
        int lo = 1, hi = n;
        int ans = 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int sum = mid * (mid + 1) / 2;
            
            if(sum == n) {
                return mid;
            } else if (sum < n) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 15;
        int n1 = 2;
        int n2 = 5;
        int n3 = 13;
        int n4 = 21;
        //ans 5
        System.out.println(arrangingCoins(n));
        // ans 1
        System.out.println(arrangingCoins(n1));
        // ans 2
        System.out.println(arrangingCoins(n2));
        // ans 4
        System.out.println(arrangingCoins(n3));
        // ans 6
        System.out.println(arrangingCoins(n4));
    }
}