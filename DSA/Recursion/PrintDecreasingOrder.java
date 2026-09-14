public class PrintDecreasingOrder {

    // Time: O(n)
    //Space: O(n)
    public static void f(int n) {
        // base case
        if(n == 0) {
            return;
        }
        System.out.println(n);
        // call next fn
        f(n - 1);
    }
    
    public static void main(String[] args) {
        f(5);
    }
}
