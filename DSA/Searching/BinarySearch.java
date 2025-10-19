public class BinarySearch {
    // time: O(log n)
    //space: O(1)
    public static int binarySearch(int nums[], int target) {
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if(nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < target) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        int nums[] = {1,2,3,4,6,7,9};
        int target = 1;
        System.out.println(binarySearch(nums, target));
    }

}