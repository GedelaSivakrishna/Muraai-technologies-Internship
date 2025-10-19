public class FirstAndLastPositionOfElement {
    // Time: O(log n)
    //Space: O(1)
    public static int[] firstAndLastPositionInSortedSearchSpace(int nums[], int target) {
        int ans[] = {-1, -1};
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if(nums[mid] == target) {
                if(nums[mid - 1] == target) {
                    ans[0] = mid - 1;
                    ans[1] = mid;
                }
                else if (nums[mid + 1] == target) {
                    ans[0] = mid;
                    ans[1] = mid + 1;
                }
                return ans;
            }
            else if (nums[mid] < target) {
                // discard left half
                lo = mid + 1;
            }
            else {
                // discard right half
                hi = mid - 1;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int nums[] = {5, 7, 7, 8, 8, 10};
        int target1 = 8;
        int target2 = 6;
        // ans - [3, 4]
        int ans1[] = firstAndLastPositionInSortedSearchSpace(nums, target1);
        System.out.println(ans1[0] + ", " + ans1[1]);
        // ans - [-1, -1]
        int ans2[] = firstAndLastPositionInSortedSearchSpace(nums, target2);
        System.out.println(ans2[0] + ", " + ans2[1]);
    }
}
