public class KthLargestElement {

    // Time: O(nk)
    //Space: O(1)
    public static int kthLargestElement(int nums[], int k) {
        int n = nums.length;
        // do k iterations to push the kth largest element to it's correct position
        for(int i = 0; i < k; i++) {
            boolean isSwapped = false;
            for(int j = 0; j < n - i - 1; j++) {
                if(nums[j] > nums[j + 1]) { // if current element greater than next element, swap them
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    isSwapped = true;
                }
            }
            if(!isSwapped) break;
        }
        return nums[n - k];
    }
    
    public static void main(String[] args) {
        int nums[] = {4, 1, 16, 3, 2, 9};
        System.out.println(kthLargestElement(nums, 4));
    }

    /*  Notes
        1. Better algorithms & approaches exist to solve this problem efficiently
        2. The above approach is using bubblesort which takes O(nk) time.
    */
}
