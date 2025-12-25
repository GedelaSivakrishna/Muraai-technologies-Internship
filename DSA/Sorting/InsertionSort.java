public class InsertionSort {

    // Time: O(n^2)
    //Space: O(1)
    public static void insertionSort(int nums[]) {
        int n = nums.length;
        // First element is sorted, we need to sort [1, n - 1] elements
        for(int i = 1; i < n; i++) {
            int element = nums[i];
            int j;
            for(j = i - 1; j >= 0; j--) {
                if(nums[j] > element) {
                    nums[j + 1] = nums[j]; // push the greater element to the right, this step is shifting not swapping
                    continue;
                }
                break;
            }
            // place the element at it's correct position
            nums[j + 1] = element;
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
        insertionSort(nums);
        print(nums);
    }

    /* Notes
     1. The first element is always sorted. We pick each element from index [1, n - 1] and place them
        in the correct position of sorted part.
     2. We do no swaps in this algorithm.
     3. Still the time complexity is same as bubble & selection sort but the advantage comes here is no swaps.
     4. The worst case occurs when all the elements are in either ascending / descending order and we try to
        arrange in opposite way.
     5. It is an inplace algorithm and stable {doesn't change the relative ordering of the elements}.
     6. In Best case, it takes Ω(n) time.
    */
}
