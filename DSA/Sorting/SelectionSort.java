public class SelectionSort {

    public static int getMinIndex(int nums[], int i) {
        int minIndex = i; // assuming the first element as minimum
        for(int j = i + 1; j < nums.length; j++) {
            if(nums[j] < nums[minIndex]) {
                minIndex = j;
            }
        }
        return minIndex;
    }

    // Time: O(n^2)
    //Space: O(1)
    public static void selectionSort(int nums[]) {
        // loop through unsorted part
        for(int i = 0; i < nums.length; i++) {
            // get the minimum element of unsorted part
            int minIndex = getMinIndex(nums, i);
            // place the minimum element with just after the sorted portion
            if(i != minIndex) {
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
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
        int nums[] = {-9, 4, -2, 3, 1, 0};
        selectionSort(nums);
        print(nums);
    }

    /* Notes
        1. In selection sort, in worst case there can be n swap operations
        2. There are n^2 comparisions in every case {best & worst}
        3. Selection sort comes under comparision category sorting algorithm
        4. It is an inplace algorithm i.e it doesn't use any extra data structure in it's implementation.
        5. It is not a stable sorting algorithm, order of elements get changed.
        6. Can be made stable? Yes but it will cost more swap operations.
        7. usecase: When sorting heavy data points like files, where less swaps to be done.
        8. There will be n^2 comparisions and n swaps in worst case.
    */
}