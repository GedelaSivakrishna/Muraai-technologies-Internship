public class Power {

    /*  Time  - O(exp)
        Space - O(1)
    */
    public static long powerLoopApproach(int base, int exp) {
        long result = 1;

        for(int i = 1; i <= exp; i++) {
            result *= base;
        }

        return result;
    }

    /*  Time  - O(exp)
        Space - O(exp)
    */
    public static long power(int base, int exp) {
        // base case
        if(exp == 1) {
            return base;
        }

        return base * power(base, exp - 1);
    }

    /*  Time  - O(log exp)
        Space - O(log exp)
    */
    public static long powerOptimised(int base, int exp) {
        // base case
        if(exp == 1) {
            return base;
        }

        long half = powerOptimised(base, exp / 2);

        if(exp % 2 == 0) {
            return half * half;
        } else {
            return half * half * base;
        }
    }
    
    public static void main(String[] args) {
        // System.out.println(powerLoopApproach(7, 5));
        System.out.println(power(7, 5));
    }
}
