package Practice;

public class KokoEatingBananas {

    public static boolean canEat(int piles[], int h, int mid) {
        int timeTaken = 0;
        for(int pile : piles) {
            int eachPileTime = (int)Math.ceil((double)pile / mid);
            timeTaken += eachPileTime;
        }
        return timeTaken <= h;
    }

    // Total piles <= hours
    //Time O(nlog(maxValue of piles))
    public static int kokoEatingBananas(int piles[], int h) {
        int max = Integer.MIN_VALUE;
        for(int elem : piles) {
            max = Math.max(elem, max);
        }
        int lo = 1; // the lowest speed with which koko can eat is 1 banana / hour
        int hi = max; // The maximum speed with which koko can eat is max pile count / hour
        int ans = 1;

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(canEat(piles, h, mid)) {
                // found potential answer
                ans = mid;
                // search even lesser speed
                hi = mid - 1; 
            } else {
                // increase the speed
                lo = mid + 1;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int piles[] = {5, 10, 3};
        int h = 4;
        // ans 5
        System.out.println(kokoEatingBananas(piles, h));
    }
}
