public class PowerFunctionOptimised {

    // Time: O(log b)
    //Space: O(log b)
    public static int f(int a, int b) {
        // base case
        if(b == 1) {
            return a;
        }

        int halfValue = f(a, b / 2);
        if(b % 2 == 0) {
            return halfValue * halfValue;
        } else {
            return a * halfValue * halfValue;
        }
    }
    
    public static void main(String[] args) {
        // System.out.println(f(2, 5));
        System.out.println(f(2, 6));
    }
}
