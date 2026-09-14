package Practice_Sorting;

public class SquaresOfSortedArray {

    // Time: O(n)
    //Space: O(1)
    public static void squaresOfSortedArrayApproach1(int nums[]) {
        int n = nums.length;
        int temp[] = new int[n];
        int k = n - 1; // track k
        int lo = 0, hi = n - 1;

        while(lo <= hi) {
            if(Math.abs(nums[lo]) >= Math.abs(hi)) {
                temp[k--] = Math.abs(nums[lo]) * Math.abs(nums[lo]);
                lo++;
            } else {
                temp[k--] = Math.abs(nums[hi]) * Math.abs(nums[hi]);
                hi--;
            }
        }

        // copy the temp elements to original array
        k = 0;
        for(int elem : temp)
            nums[k++] = elem;
    }
    
    // Time: O(n)
    //Space: O(1)
    public static void squaresOfSortedArrayApproach2(int nums[]) {
        int n = nums.length;
        int temp[] = new int[n];
        int i = -1, j = 0;
        int m = 0;

        // point i to the first negative number
        for(int k = n - 1; k >= 0; k--) {
            if(nums[k] < 0) {
                i = k;
                break;
            }
        }
        j = i + 1;

        while(i >= 0 && j <= n - 1) {
            if(Math.abs(nums[i]) <= Math.abs(nums[j])) {
                temp[m++] = Math.abs(nums[i]) * Math.abs(nums[i]);
                i--;
            } else {
                temp[m++] = Math.abs(nums[j]) * Math.abs(nums[j]);
                j++;
            }
        }

        // remaining negative numbers
        while(i >= 0) {
            temp[m++] = Math.abs(nums[i]) * Math.abs(nums[i]);
            i--;
        }

        // remaining positive numbers
        while(j <= n - 1) {
            temp[m++] = Math.abs(nums[j]) * Math.abs(nums[j]);
            j++;
        }

        m = 0;
        for(int elem : temp)
            nums[m++] = elem;

    }

    public static void print(int nums[]) {
        for(int elem : nums) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = {-10, -4, -1, 2, 3, 5, 6, 9 };
        // 1 4 9 16 25 36 81 100
        squaresOfSortedArrayApproach1(nums);
        // squaresOfSortedArrayApproach2(nums);
        print(nums);
    }
}
