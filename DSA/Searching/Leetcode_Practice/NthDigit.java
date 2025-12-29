package Leetcode_Practice;

public class NthDigit {

    // Time: O(n)
    //Space: O(1)
    public static int nthDigit(int n) {
        int digitsPerNumber = 1;
        int countInRange = 9;

        while(n > (long) digitsPerNumber * countInRange) {
            n -= digitsPerNumber * countInRange;
            digitsPerNumber++;
            countInRange *= 10;
        }

        int number = (int)Math.pow(10, digitsPerNumber - 1) + (n - 1) / digitsPerNumber;
        int digitIndex = (n - 1) % digitsPerNumber;
        return String.valueOf(number).charAt(digitIndex) - '0';
    }
    
    public static void main(String[] args) {
        // ans 1
        // System.out.println(nthDigit(10));
        // // ans 0
        // System.out.println(nthDigit(11));
        // // ans 1
        // System.out.println(nthDigit(12));
        // // ans 1
        // System.out.println(nthDigit(13));
        // // ans 1
        // System.out.println(nthDigit(14));
        // // ans 2
        // System.out.println(nthDigit(15));
        // ans 0
        System.out.println(nthDigit(200));
    }

}
