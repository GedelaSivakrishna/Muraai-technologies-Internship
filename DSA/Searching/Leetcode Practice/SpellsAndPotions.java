package Practice;
import java.util.Arrays;

public class SpellsAndPotions {

    public static int lowerBound(int nums[], int target) {
        int n = nums.length;
        if(n > 0 && nums[0] >= target) {
            return 0;
        }

        int lo = 0, hi = n - 1;
        int ans = n;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] >= target) {
                ans = mid;
                // search better answer to left
                hi = mid - 1;
            } else {
                // discard left
                lo = mid + 1;
            }
        }
        return ans;
    }

    // Time O(mlogm + mlogn)
    //Space O(1) 
    public static int[] spellsAndPotions(int spells[], int potions[], int success) {
        int n = spells.length;
        int m = potions.length;
        int ans[] = new int[n];
        Arrays.sort(potions);
        for(int i = 0; i < n; i++) {
            int currentSpell = spells[i];
            int multiplyFactor = (int)Math.ceil((double)success / currentSpell);
            int lb = lowerBound(potions, multiplyFactor);
            ans[i] = m - lb;
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int spells[] = {3,2,5};
        int potions[] = {1,2,3,4,5};
        int success = 6;
        // ans {4,3,4}
        int ans1[] = spellsAndPotions(spells, potions, success);
        for(int element : ans1) {
            System.out.print(element + " ");
        }

    }
}
