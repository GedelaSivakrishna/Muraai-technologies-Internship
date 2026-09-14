package Practice_Sorting;

public class CountInversions {

    public static int inversionsCount = 0;

    public static void f(int nums[], int lo, int hi) {
        if(lo >= hi) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        f(nums, lo, mid); // left
        f(nums, mid + 1, hi); // right
        merge(nums, lo, mid, hi);
    }

    public static void merge(int nums[], int lo, int mid, int hi) {
        int temp[] = new int[hi - lo + 1];
        int k = 0;
        int i = lo;
        int j = mid + 1;

        while(i <= mid && j <= hi) {
            if(nums[i] > nums[j]) {
                // If i'th element is greater than nums[j] then all elements to right of i are also greater. 
                // so total possible inversions = (mid - i + 1)
                inversionsCount += mid - i + 1;
                temp[k++] = nums[j++];
            } else {
                temp[k++] = nums[i++];
            }
        }

        // remaining elements in first part
        while(i <= mid) {
            temp[k++] = nums[i++];
        }

        // remaining elements in second part
        while(j <= hi) {
            temp[k++] = nums[j++];
        }

        // copy temp elements to original array
        k = lo;
        for(int elem : temp) 
            nums[k++] = elem;

    }

    // Time: O(nlogn)
    //Space: O(1)
    public static void countInversions(int nums[]) {
        f(nums, 0, nums.length - 1);
    }

     public static void print(int nums[]) {
        for(int elem : nums) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    
    public static void main(String[] args) {
        int nums[] = {5, -1, 3, 4, 2};
        int nums2[] = {4, 3, 2, 1};
        inversionsCount = 0;
        countInversions(nums);
        // countInversions(nums2);
        // o/p -> 6
        System.out.println(inversionsCount);
        // print(nums2);
    }
}
