package Leetcode_Practice;

public class ArrangingCoins {

    // Time O(log n)
    //Space O(1)
    public static int arrangingCoins(int coins) {
        if(coins == 1) {
            return 1;
        }
        int lo = 1, hi = coins;
        int ans = 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int coinsRequired = (mid * (mid + 1)) / 2;
            if(coins == coinsRequired) {
                return mid;
            }
            if(coins < coinsRequired) {
                // discard right
                hi = mid - 1;
            } else {
                ans = mid;
                // search better answer
                lo = mid + 1;
            }
        }
        return ans;
    } 
    
    public static void main(String[] args) {
        int coins = 45;
        // ans 9
        System.out.println(arrangingCoins(coins));
    }
}
