public class MedianOfTwoSortedArrays {

    // Time: O(log(min(m, n)))
    //Space: O(1) 
    public static double medianOfTwoSortedArrays(int nums1[], int nums2[]) {
        int m = nums1.length;
        int n = nums2.length;
        // perform binary search on smaller length array
        if(m > n) {
            return medianOfTwoSortedArrays(nums2, nums1);
        }

        int lo = 0, hi = m;
        while(lo <= hi) {
            int partitionA = lo + (hi - lo) / 2;
            int partitionB = (m + n) / 2 - partitionA;
            int leftMaxA, leftMaxB, rightMinA, rightMinB;

            if(partitionA == 0) {
                // no elements to left exist
                leftMaxA = Integer.MIN_VALUE;
            } else {
                leftMaxA = nums1[partitionA - 1];
            }

            if(partitionB == 0) {
                // no elements to left exist
                leftMaxB = Integer.MIN_VALUE;
            } else {
                leftMaxB = nums2[partitionB - 1];
            }

            if(partitionA == m) {
                // no elements to right exist
                rightMinA = Integer.MAX_VALUE;
            } else {
                rightMinA = nums1[partitionA];
            }

            if(partitionB == n) {
                // no elements to right exist
                 rightMinB = Integer.MAX_VALUE;
            } else {
                rightMinB = nums2[partitionB];
            }

            if(leftMaxA <= rightMinB && leftMaxB <= rightMinA) {
                // correct partition
                if((m + n) % 2 == 0) {
                    return ((double)Math.max(leftMaxA, leftMaxB) + Math.min(rightMinA, rightMinB)) / 2;
                } else {
                    return Math.min(rightMinA, rightMinB);
                }
            } else if(leftMaxA > rightMinB) {
                hi = partitionA - 1;
            } else {
                lo = partitionA + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums1[] = {1, 3};
        int nums2[] = {2};
        // ans 2
        System.out.println(medianOfTwoSortedArrays(nums1, nums2));
        int nums3[] = {1, 2};
        int nums4[] = {3, 4};
        // ans 2.5
        System.out.println(medianOfTwoSortedArrays(nums3, nums4));
        int nums5[] = {7,12,14,15};
        int nums6[] = {1,2,3,4,9,11};
        int nums7[] = {7,12,14,15};
        int nums8[] = {1,2,3,4,8,9,11};
        int nums9[] = {7,10,12,14,15};
        int nums10[] = {1,2,3,4,8,9,11};
        // ans 8
        // System.out.println(medianOfTwoSortedArrays(nums5, nums6));
        // // ans 8
        // System.out.println(medianOfTwoSortedArrays(nums7, nums8));
        // // ans 8.5
        // System.out.println(medianOfTwoSortedArrays(nums9, nums10));
    }
}