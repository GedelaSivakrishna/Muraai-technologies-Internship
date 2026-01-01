public class MergeSort {

    public static void merge(int nums[], int lo, int mid, int hi) {
        int temp[] = new int[hi - lo + 1];
        int k = 0;
        int i = lo, j = mid + 1;

        while(i <= mid && j <= hi) {
            if(nums[i] <= nums[j]) {
                temp[k++] = nums[i];
                i++;
            } else {
                temp[k++] = nums[j];
                j++;
            }
        }

        // remaining elements in 1st array
        while(i <= mid) {
            temp[k++] = nums[i++];
        }

        // remaining elements in 2nd array
        while(j <= hi) {
            temp[k++] = nums[j++];
        }

       // copy elements to original array
       k = lo;
       for(int elem : temp)
            nums[k++] = elem;

    }

    public static void mergeSort(int nums[], int lo, int hi) {
        // handle empty / single length arrays
        if(lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid+1, hi);
        merge(nums, lo, mid, hi);
    }

    public static void print(int nums[]) {
        for(int elem : nums) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int nums[] = {5, 2, 12, 1, 4, 17, -1, 10, 11};
        // ans -1 1 2 4 5 10 12 17
        mergeSort(nums, 0, nums.length - 1);
        print(nums);
    }

    /* Notes
      1. Merge sort is not an inplace algorithm.
    */
}
