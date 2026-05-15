package Leetcode.Easy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;
public class ThreeDigitEvenNumbers {

    public static int[] threeDigitEvenNumbers(int nums[]) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            if(nums[i] == 0) {
                continue;
            }
            for(int j = 0; j < n; j++) {
                if(i == j) {
                    continue;
                }
                for(int k = 0; k < n; k++) {
                    if(k == i || k == j) {
                        continue;
                    }
                    String num = "" + nums[i] + nums[j] + nums[k];
                    int value = Integer.valueOf(num);
                    if(value % 2 == 0 && !list.contains(value)) {
                        list.add(value);
                    }
                }
            }
        }

        int result[] = new int[list.size()];
        int idx = 0;
        for(Integer value : list)
            result[idx++] = value;

        Arrays.sort(result);
        return result;
    }

    static boolean visited[];
    static Set<Integer> result = new HashSet<>();

    public static void f(int digits[], boolean visited[], String output) {
        // base case
        if (output.length() == 3 && !output.startsWith("0")) {
            int val = Integer.valueOf(output);
            if (val % 2 == 0)
                result.add(val);
            return;
        }

        for(int i = 0; i < digits.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                f(digits, visited, output + digits[i]);
                visited[i] = false;
            }
        }
    }

    public static void print(int nums[]) {
        for(int elem : nums) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
    
    /*  Time - O(k * 10^k), Space - O(m)
        Here k is the length of target even numbers to find
        m is the total even numbers
    */
    public static int[] findEvenNumbers(int[] digits) {
        // store the frequencies of digits in a map
        HashMap<Integer, Integer> digitsMap = new HashMap<>();
        for(int digit : digits)
            digitsMap.put(digit, digitsMap.getOrDefault(digit, 0) + 1);

        ArrayList<Integer> list = new ArrayList<>();

        // loop through all 3 digit numbers
        for(int i = 100; i <= 999; i += 2) {
            HashMap<Integer, Integer> numberMap = new HashMap<>();
            int temp = i;
            while(temp != 0) {
                int digit = temp % 10;
                numberMap.put(digit, numberMap.getOrDefault(digit, 0) + 1);
                temp /= 10;
            }

            boolean isValid = true;
            for(int key : numberMap.keySet()) {
                if (digitsMap.get(key) == null || digitsMap.get(key) < numberMap.get(key)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid)
                list.add(i);
        }

        int result[] = new int[list.size()];
        for(int k = 0; k < list.size(); k++)
            result[k] = list.get(k);

        return result;
    }

    public static void main(String[] args) {
        // int digits[] = {1, 2, 3};
        int digits[] = {2,2,8,8,2};
        // // ArrayList<Integer> list = threeDigitEvenNumbers(digits);
        // int list[] = threeDigitEvenNumbers(digits2);

        // for(Integer value : list)
        //     System.out.print(value + " ");

        // visited = new boolean[digits.length]; // by default, boolean array initializes with false
        // result.clear();
        // f(digits, visited, "");
        // int arr[] = new int[result.size()];
        // int idx = 0;
        // for(int val : result)
        //     arr[idx++] = val;
        // Arrays.sort(arr);

        print(findEvenNumbers(digits));
    }
}
