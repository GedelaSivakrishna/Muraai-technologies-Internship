public class KokoEatingBananas {

    public static boolean canEat(int piles[], int speed, int h) {
        int timeTaken = 0;
        for(int i = 0; i < piles.length; i++) {
            timeTaken += Math.ceil((double)piles[i] / speed);
        }
        return timeTaken <= h;
    }

    // Time O(n log(max of piles))
    //Space O(1)
    public static int kokoEatingBananas(int piles[], int h) {
        int n = piles.length;
        int maxBananas = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++)
            maxBananas = Math.max(maxBananas, piles[i]);
        
        int lo = 1, hi = maxBananas;
        int ans = 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(canEat(piles, mid, h)) {
                // search better answer
                ans = mid;
                hi = mid - 1;
            } else {
                // increase speed
                lo = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int piles[] = {3, 6, 7, 11};
        int h1 = 8;
        int piles2[] = {30, 11, 23, 4, 20};
        int h2 = 5;
        int piles3[] = {30, 11, 23, 4, 20};
        int h3 = 6;
        // ans 4
        System.out.println(kokoEatingBananas(piles, h1));
        // ans 30
        // System.out.println(kokoEatingBananas(piles2, h2));
        // // ans 23
        // System.out.println(kokoEatingBananas(piles3, h3));
    }
}