public class MergeTwoSortedArrays {

    // Time: O(m + n)
    //Space: O(1) excluding the output space
    public static int[] mergeTwoSortedArrays(int nums1[], int nums2[]) {
        int m = nums1.length;
        int n = nums2.length;
        int k = 0;
        int mergedArr[] = new int[m + n];
        int i = 0, j = 0;

        while(i < m && j < n) {
            if(nums1[i] <= nums2[j]) {
                mergedArr[k++] = nums1[i];
                i++;
            } else {
                mergedArr[k++] = nums2[j];
                j++;
            }
        }

        // remaining elements in 1st array
        while(i < m) {
            mergedArr[k++] = nums1[i++];
        }

        // remaining elements in 2nd array
        while(j < n) {
            mergedArr[k++] = nums2[j++];
        }

        return mergedArr;
    }

    public static void print(int nums[]) {
        for(int elem : nums) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums1[] = {1, 3, 5, 7};
        int nums2[] = {1, 2, 4, 5, 6, 6, 7, 8};
        int mergedArr[] = mergeTwoSortedArrays(nums1, nums2);
        // ans - 1, 1, 2, 3, 4, 5, 5, 6, 6, 7, 7, 8
        print(mergedArr);
    }
}
