public class FirstMissingPositive {
    // Time: O(n)
    //Space: O(1)
    public static int firstMissingPositive(int nums[]) {
        int n = nums.length;
        // Replace -ve with zero
        for(int i = 0; i < n; i++) {
            if(nums[i] < 0) {
                nums[i] = 0;
            }
        }

        // Modify the array
        for(int i = 0; i < n; i++) {
            if(nums[i] == 0) {
                continue;
            }
            
            int currVal = Math.abs(nums[i]);
            int chair = currVal - 1;

            if(chair < n) {
                if(nums[chair] == 0) {
                    nums[chair] = -currVal;
                } else {
                    if(nums[chair] > 0) {
                        nums[chair] *= -1;
                    }
                }
            }
        }

        // Find the first non zero & positive element and return (index + 1)
        for(int i = 0; i < n; i++) {
            if(nums[i] == 0 || nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }
    public static void main(String[] args) {
        int nums[] = {1, 2, 0};
        System.out.println(firstMissingPositive(nums));
    }
}
