package Class;
public class PowerSum {

    static int ways = 0;

    public static int nthRoot(int num, int n) {
        int lo = 1;
        int hi = num;
        int ans = 0;

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if(Math.pow(mid, n) > num) {
                // mid cannot be part of answer
                hi = mid - 1;
            } else {
                ans = mid;
                // find better answer
                lo = mid + 1;
            }
        }
        return ans;
    }

    /*  Time- O(2^nthRoot(X)), Space- O(nthRoot(X))  */
    public static void f(int n, int i, int x, int p, long sum) {
        // base case
        if(i > n) {
            if(sum == x) ways++;
            return;
        }

        // include
        f(n, i + 1, x, p, sum + (long)Math.pow(i, p));

        // exclude
        f(n, i + 1, x, p, sum);
    }

    /*  Time- O(2^nthRoot(X)), Space- O(nthRoot(X))  */
    public static void f1(int x, int n, int i) {
        int power = (int)Math.pow(i, n);
        // base cases
        if(x == 0) {
            ways++;
            return;
        }

        if(power > x) {
            return;
        }

        f1(x - power, n, i + 1);
        f1(x, n, i + 1);
    }
    
    public static void main(String[] args) {
        int X = 10;
        int N = 2;
        int X1 = 100;
        int N1 = 2;
        int X2 = 100;
        int N2 = 3;
        int X3 = 10;
        int N3 = 3;
        ways = 0;
        // System.out.println(nthRoot(X, N)); // 3
        // f(nthRoot(X, N), 1, X, N, 0);
        // System.out.println("Total ways = " + ways); // 1
        // f(nthRoot(X1, N1), 1, X1, N1, 0);
        // System.out.println("Total ways = " + ways); // 3
        // f(nthRoot(X2, N2), 1, X2, N2, 0);
        // System.out.println("Total ways = " + ways); // 1
        f1( X, N, 1);
        System.out.println("Total ways = " + ways); // 1
        ways = 0;
        f1( X1, N1, 1);
        System.out.println("Total ways = " + ways); // 3
        ways = 0;
        f1( X2, N2, 1);
        System.out.println("Total ways = " + ways); // 1
        ways = 0;
        f1( X3, N3, 1);
        System.out.println("Total ways = " + ways); // 0
    }
}
