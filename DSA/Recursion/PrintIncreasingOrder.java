public class PrintIncreasingOrder {

    // Time: O(n)
    //Space: O(n)
    public static void f(int n) {
        //base case
        if(n == 0) {
            return;
        }

        f(n - 1); // print previous numbers, then I will print myself next
        System.out.println(n);
    }
    
    public static void main(String[] args) {
        f(5);
    }
}
