import java.util.HashSet;
import java.util.Arrays;
import java.util.List;
import java.util.HashSet;
import java.util.Collections;
import java.util.ArrayList;
public class Triplets {

    public static List<List<Integer>> threeSum(int nums[]) {
        /*  Time: O(n^3), Space: O(n^3) -> if all triplets satisfy the condition */
        // int n = nums.length;
        // HashSet<List<Integer>> set = new HashSet<>();

        // for(int i = 0; i < n; i++) {
        //     for(int j = i + 1; j < n; j++) {
        //         for(int k = j + 1; k < n; k++) {
        //             if(nums[i] + nums[j] + nums[k] == 0) {
        //                 List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
        //                 Collections.sort(list);
        //                 set.add(list);
        //             }
        //         }
        //     }
        // }

        // return set.stream().toList();

        /* Approach 2 => Time: O(n^2), Space: O(unique triplets) */
        // int n = nums.length;
        // List<List<Integer>> ans = new ArrayList<>();
        // HashSet<List<Integer>> uniqueTriplets = new HashSet<>();
        // for(int i = 0; i < n; i++) {
        //     int target = -nums[i];
        //     HashSet<Integer> set = new HashSet<>();
        //     for(int j = i + 1; j < n; j++) {
        //         int third = target - nums[j];

        //         if(set.contains(third)) {
        //             List<Integer> triplet = Arrays.asList(nums[i], nums[j], third);
        //             Collections.sort(triplet);
        //             if(!uniqueTriplets.contains(triplet)) {
        //                 // this triplet can be part of answer
        //                 ans.add(triplet);
        //                 // add current triplet to set
        //                 uniqueTriplets.add(triplet);
        //             }
        //         }

        //         set.add(nums[j]);
        //     }
        // }

        // return ans;

        /* Approach 3 => Time: O(n^2), Space: O(unique triplets) */
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < n; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = n - 1;
            
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < 0) {
                    j++;
                } else if(sum > 0) {
                    k--;
                } else {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                    ans.add(triplet);
                    j++; k--;

                    while(j < k && nums[j] == nums[j - 1]) j++;
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> threeSumTriplets = threeSum(nums);
        System.out.println(threeSumTriplets);

    }
}