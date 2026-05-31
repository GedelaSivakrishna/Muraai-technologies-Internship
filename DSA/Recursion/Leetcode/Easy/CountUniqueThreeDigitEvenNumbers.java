package Leetcode.Easy;
import java.util.HashMap;
public class CountUniqueThreeDigitEvenNumbers {
    
    /*  Time - O(k * 10^k), Space - O(1)
        Here k is the length of target even numbers to find
    */
    public static int totalNumbers(int[] digits) {
        // store the frequencies of digits in a map
        HashMap<Integer, Integer> digitsMap = new HashMap<>();
        for(int digit : digits)
            digitsMap.put(digit, digitsMap.getOrDefault(digit, 0) + 1);

        int count = 0;
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
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int digits[] = {1,2,3,4};
        System.out.println(totalNumbers(digits)); // 12
    }
}
