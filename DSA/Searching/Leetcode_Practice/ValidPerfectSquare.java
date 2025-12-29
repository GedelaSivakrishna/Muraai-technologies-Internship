package Leetcode_Practice;

public class ValidPerfectSquare {

    // Time O(log n)
    //Space O(1)
    public static boolean validPerfectSquare(int num) {
        if(num < 0) {
            return false;
        }
        if(num == 1) {
            return true;
        }
        int lo = 2, hi = num - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int val = mid * mid;
            if(val == num) {
                return true;
            } else if (val > num) {
                // discard right
                hi = mid - 1;
            } else {
                // discard left
                lo = mid + 1;
            }
        }
        return false;
    }

    // linear search approach
    // Time O(sqrt(n))
    //Space O(1)
    public static boolean validPerfectSquare2(int num) {
        if(num < 0) {
            return false;
        }
        if(num == 1) {
            return true;
        }
        for(int i = 2; i < num; i++) {
            if(i * i == num) {
                return true;
            }
            if(i * i > num) {
                break;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int num = 242;
        int num2 = 256;
        // ans false
        System.out.println(validPerfectSquare(num));
        // ans true
        System.out.println(validPerfectSquare(num2));
        // ans false
        System.out.println(validPerfectSquare2(num));
        // ans true
        System.out.println(validPerfectSquare2(num2));
    }
}
