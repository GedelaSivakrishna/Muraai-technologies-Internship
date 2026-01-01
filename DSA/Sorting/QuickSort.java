public class QuickSort {

    public static void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Time: O(n)
    //Space: O(1)
    public static int partition(int nums[], int lo, int hi, int pIndex) {
        int pivot = nums[pIndex];
        // swap pivot & last element
        swap(nums, pIndex, hi);
        int i = lo - 1;

        for(int j = lo; j <= hi - 1; j++) {
            if(nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }

        swap(nums, ++i, hi);
        return i;
    }

    public static int randomIndex(int lo, int hi) {
        int index = (int)(Math.random() * (hi - lo + 1) + lo);
        return index;
    }

    // Time: 
    //  worst case: O(n^2)
    //  average case: O(nlogn)
    //Space: O(logn) callstack space
    public static void quickSort(int nums[], int lo, int hi) {
        // handle empty / single length arrays
        if(lo >= hi) {
            return;
        }
        int pivotIndex = randomIndex(lo, hi);
        int partionIndex = partition(nums, lo, hi, pivotIndex);
        quickSort(nums, lo, partionIndex - 1); // sort left of partitionIndex
        quickSort(nums, partionIndex + 1, hi); // sort right of partitionIndex
    }

    public static void print(int nums[]) {
        for(int elem : nums) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int nums[] = {2, 3, 1, 5, 9, -1, 0, 9, -3, 8};
        quickSort(nums, 0, nums.length - 1);
        // ans -3 -1 0 1 2 3 5 8 9 9
        print(nums);
    }

}
