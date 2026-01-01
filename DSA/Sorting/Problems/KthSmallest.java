package Problems;

public class KthSmallest {

    /* Time: 
        1. Average case: O(n)
        2. Worst case: O(n^2)
       Space:
        1. Average case: O(logn)
        2. Worst case: O(n)
     */
    public static int quickSelect(int nums[], int lo, int hi, int k) {
        if(lo <= hi) {
            int pIndex = partition(nums, lo, hi);
            
            if(pIndex == k) {
                return nums[k];
            } else if (pIndex > k) {
                return quickSelect(nums, lo, pIndex - 1, k);
            } else {
                return quickSelect(nums, pIndex + 1, hi, k);
            }
        }
        return -1;
    }

    public static int kthSmallest(int nums[], int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    public static int randomIndex(int lo, int hi) {
        return (int)(Math.random() * (hi - lo + 1) + lo);
    }

    public static void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int partition(int nums[], int lo, int hi) {
        int pivotIndex = randomIndex(lo, hi);
        int pivotElement = nums[pivotIndex];
        swap(nums, pivotIndex,  hi);
        int m = lo - 1;
        int i = lo;

        while(i <= hi - 1) {
            if(nums[i] < pivotElement) {
                m++;
                swap(nums, m, i);
            }
            i++;
        }

        ++m; // move to correct pivot position
        // place the pivotElement at it's correct position
        swap(nums, m, hi);
        return m;
    }

    public static void main(String[] args) {
        int nums[] = {5, 2, -2, 7, 4, 3, 1};
        // -1
        // System.out.println(kthSmallest(nums, 0));
        // 1
        // System.out.println(kthSmallest(nums, 1));
        // // 2
        System.out.println(kthSmallest(nums, 6));
    }

    /*    Algorithm to generate a random number b/w a & b where a is min value 
      1. Math.random() returns double value b/w 0.0 & 0.1 where 0.0 is included while 0.1 is excluded.
      2. int randomValue = (int) (Math.random() * (N.o value b/w a & b) + min_value(a, b));
                         = (int) (Math.random() * (b - a + 1) + min_value(a, b));
    */
}