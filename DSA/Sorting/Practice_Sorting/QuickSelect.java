package Practice_Sorting;

public class QuickSelect {

    public static int kthSmallest(int nums[], int k) {
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }

    /* Time:
        1. Average case: O(n) -> in each level, we pick only one side of problem
        2. Worst case: O(n^2)
       Space: call stack space
        1. Average case: O(logn)
        2. Worst case: O(n)
       Properties
        1. This algorithm is used to solve kth order statistics problems where we need to find kth largest / kth smallest;
    */
    public static int quickSelect(int nums[], int lo, int hi, int k) {
        if(lo <= hi) {
            int pIndex = partition(nums, lo, hi);
            if(pIndex == k) {
                return nums[k];
            } else if(pIndex > k) { // go left
                return quickSelect(nums, lo, pIndex - 1, k);
            } else { // go right
                return quickSelect(nums, pIndex + 1, hi, k);
            }
        }
        return -1;
    }

    public static int partition(int nums[], int lo, int hi) {
        int pivotIndex = randomIndex(lo, hi);
        int pivotElement = nums[pivotIndex];
        // swap pivot & element at hi index
        swap(nums, pivotIndex, hi);
        int m = lo - 1;

        for(int i = lo; i <= hi - 1; i++) {
            if(nums[i] < pivotElement) {
                ++m;
                swap(nums, i, m);
            }
        }

        // move to correct position of pivot
        ++m;
        // place the pivot at it's correct position
        swap(nums, m, hi);
        return m;
    }

    public static void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int randomIndex(int lo, int hi) {
        return (int)(Math.random() * (hi - lo + 1) + lo);
    }
    
    public static void main(String[] args) {
        int nums[] = {-1, -4, 3, 5, 2, 9, 6, -10};
        System.out.println(kthSmallest(nums, 7));
    }
}
