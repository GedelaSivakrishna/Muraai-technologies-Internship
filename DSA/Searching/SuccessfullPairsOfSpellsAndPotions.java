import java.util.Arrays;
public class SuccessfullPairsOfSpellsAndPotions {

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
                // search better answer
                hi = mid - 1;
            } else {
                // discard left
                lo = mid + 1;
            }
        }
        return ans;
    }

    // Time O(m logm + n logm)
    //Space O(1)
    public static int[] successfullPairsOfSpellsAndPotions(int spells[], int potions[], int success) {
        Arrays.sort(potions);
        int n = potions.length;
        int ans[] = new int[spells.length];
        int k = 0;
        for(int i = 0; i < spells.length; i++) {
            int mf = (int)Math.ceil( (double)success / spells[i]);
            int lb = lowerBound(potions, mf);
            ans[k++] = n - lb;
        }
        return ans;
    }

    // code two pointer approach
    // Time O(n + m + m logm + n logn)
    //Space O(n)
    public static int[] spellsAndPotionsTwoPointerApproach(int spells[], int potions[], int success) {
        int n = spells.length;
        int m = potions.length;
        int spellsGrid[][] = new int[n][2];
        for(int i = 0; i < n; i++) {
            spellsGrid[i][0] = spells[i];
            spellsGrid[i][1] = i;
        }
        // sort spells with index grid
        Arrays.sort(spellsGrid, (a, b) -> Integer.compare(a[0], b[0]));
        int ans[] = new int[n];
        int left = 0, right = m - 1;
        while(left < n && right >= 0) {
            if(spellsGrid[left][0] * potions[right] >= success) {
                int temp = left;
                while(temp < n) {
                    ans[spellsGrid[temp++][1]]++;
                }
                right--;
            } else {
                left++;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int spells[] = {5, 1, 3};
        int potions[] = {1, 2, 3, 4, 5};
        int success = 7;
        // ans 4, 0, 3
        // int ans[] = successfullPairsOfSpellsAndPotions(spells, potions, success);
        // for(int elem : ans) {
        //     System.out.print(elem + " ");
        // }
        // ans 4, 0, 3
        int ans[] = spellsAndPotionsTwoPointerApproach(spells, potions, success);
        for(int elem : ans) {
            System.out.print(elem + " ");
        }
        
    }
}
