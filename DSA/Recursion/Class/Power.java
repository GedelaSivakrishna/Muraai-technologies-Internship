package Class;
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

    public static double iterativePower(double x, int n) {
        int temp = 2;
        // int n = 5; // 2 ^ 5
        double result = x;

        while(temp <= n / 2) {
            result = result * result;
            temp *= 2;
        }

        if(n % 2 == 0) {
            return result * result;
        } else {
            return result * result * x;
        }
    }
    
    public static void main(String[] args) {
        // System.out.println(powerLoopApproach(7, 5));
        // System.out.println(power(7, 5));
        // iterativePower();
    }
}
