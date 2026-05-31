package Class;
public class FriendsPairing {

    /*  f(n) = f(n - 1) + (n - 1) * f(n - 2) */
    /*  Time = O(2^n), Space = O(n) */
    public static int f(int n) {
        if(n == 1 || n == 2) return n;
        return f(n - 1) + (n - 1) * f(n - 2);
    }
    
    public static void main(String[] args) {
        System.out.println(f(3)); // 4
        System.out.println(f(4)); // 10
        System.out.println(f(5)); // 26
    }
}
