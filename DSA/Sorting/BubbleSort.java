public class BubbleSort {

    // Time: O(n^2)
    //Space: O(1)
    public static void bubbleSort(int nums[]) {
        int n = nums.length;
        // we need to do n - 1 iterations to place all elements in correct positions
        for(int i = 0; i < n - 1; i++) {
            boolean isSwapped = false;
            for(int j = 0; j < n - i - 1; j++) {
                // checking if current element is greater than next element
                if(nums[j] > nums[j + 1]) { 
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    isSwapped = true;
                }
            }
            // if no swaps in any iteration, then array is sorted, break from loop
            if(!isSwapped) {
                break;
            }
        }
    }

    public static void print(int nums[]) {
        for(int elem : nums) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int nums[] = {5, 4, 3, 2, 1};
        bubbleSort(nums);
        print(nums);
    }

    /*  Notes
      1. Places the largest elements from unsorted to sorted.
      2. It is stable & inplace algorithm.
      3. Time Complexity: 
        i. Best case: Ω(n)
       ii. Worst case: O(n^2)
      4. Space Complexity: O(1)
      5. In worst case, it does n - 1 swaps and comparisions {worse than selection sort}.
      6. The only best part of bubble sort is it does only Ω(n) comparisions in best case.
      7. This algorithm should not be considered when sorting heavy data {such as files with very large size}
         as high swapping involved which is a costly operation. 
    */
}
