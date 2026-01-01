package Problems;

public class CountInversions {

    public static int count = 0;

    public static void mergeSort(int nums[], int lo, int hi) {
        if(lo == hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    public static void merge(int nums[], int lo, int mid, int hi) {
        int temp[] = new int[hi - lo + 1];
        int i = lo, j = mid + 1, k = 0;

        while(i <= mid && j <= hi) {
            if(nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                count += mid - i + 1;
                temp[k++] = nums[j++];
            }
        }

        // remaining in left half
        while(i <= mid) {
            temp[k++] = nums[i++];
        }

        // remaining in right half
        while(j <= hi) {
            temp[k++] = nums[j++];
        }

        // copy the elements from temp to original array
        k = lo;
        for(int elem : temp)
            nums[k++] = elem;

    }
    
    public static void main(String[] args) {
        int arr[] = {2, 4, 1, 3, 5};
        int arr2[] = {2, 3, 4, 5, 6};
        int arr3[] = {10, 10, 10};
        // count is a global variable
        count = 0;
        mergeSort(arr3, 0, arr3.length - 1);
        // ans 0
        System.out.println(count);
    }
}
