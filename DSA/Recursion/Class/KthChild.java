package Class;
public class KthChild {

    /*  Time - O(n)     Space - O(n) */
    public static char f(int n, int k) {
        if(n == 1 && k == 1) return 'M';

        if(k % 2 == 0) {
            // 2nd child
            return f(n - 1, k / 2) == 'M' ? 'F' : 'M';
        } else {
            // 1st child
            return f(n - 1, k / 2 + 1) == 'M' ? 'M' : 'F';
        }
    }

    /*  Time - O(n)     Space - O(n) */
    public static char f2(char root, int n, long k) {
        if(n == 1 && k == 1) return root;

        long value = (1 << n - 1) / 2;
        if(k <= value) { // move left
            return f2(root, n - 1, k);
        } else {
            // move right
            char new_root = root == 'M' ? 'F' : 'M';
            return f2(new_root, n - 1, k - value);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(f2('M', 1, 1)); // M
        System.out.println(f2('M', 2, 1)); // M
        System.out.println(f2('M', 2, 2)); // F
        System.out.println(f2('M', 4, 5)); // F
    }
}
