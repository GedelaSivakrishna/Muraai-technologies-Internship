public class PowerFunction {

    // Time: O(b) -> There will be b function calls with constant operation in each fn call.
    //Space: O(b) -> There will be maximum b stack frames in the call stack.
    public static int p(int a, int b) {
        // base case
        if(b == 1) {
            return a;
        }
        return a * p(a, b - 1);
    }
    
    public static void main(String[] args) {
        System.out.println(p(2,5));
    }
}
