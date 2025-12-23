public class InsertionSort {

    // Time: O(n^2)
    //Space: O(1)
    public static void insertionSort(int nums[]) {
        int n = nums.length;
        // First element is sorted, we need to sort [1, n - 1] elements
        for(int i = 1; i < n; i++) {
            int element = nums[i];
            int j;
            for(j = i - 1; j >= 0; j--) {
                if(nums[j] > element) {
                    nums[j + 1] = nums[j]; // push the greater element to the right
                    continue;
                }
                break;
            }
            // place the element at it's correct position
            nums[j + 1] = element;
        }
    }
    
    public static void print(int nums[]) {
        for(int elem : nums) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = {5, 4, 3, 2, 1};
        insertionSort(nums);
        print(nums);
    }
}
