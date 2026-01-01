package Problems;

public class SquareOfSortedArray {

    // Merge two sorted arrays approach
    // Time: O(n)
    //Space: O(n)
    public static int[] squareOfSortedArrayApproach1(int nums[]) {
        int n = nums.length;
        int temp[] = new int[n];
        int k = 0;
        int i = -1; // i points to negative numbers
        int j = 0; // j points to positive numbers

        // point i to first negative number
        for(int m = n - 1; m >= 0; m--) {
            if(nums[m] < 0) {
                i = m;
                j = i + 1;
                break;
            }
        }

        while(i >= 0 && j < n) {
            if(Math.abs(nums[i]) <= nums[j]) {
                temp[k++] = Math.abs(nums[i]);
                i--;
            } else {
                temp[k++] = nums[j];
                j++;
            }
        }

        // remaining elements in 1st part
        while(i >= 0) {
            temp[k++] = Math.abs(nums[i--]);
        }

        // remaining elements in 2nd part
        while(j < n) {
            temp[k++] = nums[j++];
        }

        // copy the squares of temp to original array
        k = 0;
        for(int elem : temp) {
            nums[k++] = elem * elem;
        }

        return nums;
    }

    // Time: O(n)
    //Space: O(n)
    public static int[] squareOfSortedArrayTwoPointerApproach(int nums[]) {
        int n = nums.length;
        int temp[] = new int[n];
        int k = n - 1;
        int i = 0;
        int j = n - 1;

        while(i <= j) {
            if(Math.abs(nums[i]) >= Math.abs(nums[j])) {
                temp[k--] = Math.abs(nums[i]);
                i++;
            } else {
                temp[k--] = Math.abs(nums[j]);
                j--;
            }
        }

        k = 0;
        for(int elem : temp) {
            nums[k++] = elem * elem;
        }
        return nums;
    }

    public static void print(int nums[]) {
        for(int elem : nums) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = {-4, -1, 0, 3, 10};
        // squareOfSortedArrayTwoPointerApproach(nums);
        squareOfSortedArrayApproach1(nums);
        print(nums);
    }
}