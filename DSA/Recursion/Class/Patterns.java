package Class;
public class Patterns {

    /*  Pattern - * * * * * */
    public static void pattern1(int n) {
        // base case
        if(n == 0) {
            return;
        }

        // self work
        System.out.print("* ");

        pattern1(n - 1);
    }

    /*  Pattern - * * * * *
                  * * * * *
                  * * * * *
                  * * * * *
                  * * * * *
    */
    public static void pattern2(int n, int i, int j) {
        // base case
        if(j == n) {
            System.out.println();
            pattern2(n, i + 1, 0);
            return;
        }

        if(i == n) {
            return;
        }

        // self work
        System.out.print("* ");

        pattern2(n, i, j + 1);
    }

    /*  Pattern - *
                  * *
                  * * *
                  * * * *
                  * * * * *
    */
    public static void pattern3(int n, int i, int j) {
        if(j > i) {
            System.out.println();
            pattern3(n, i + 1, 0);
            return;
        }

        if(i == n) {
            return;
        }

        // self work
        System.out.print("* ");

        pattern3(n, i, j + 1);
    }

    /*  Pattern - * * * * *
                  * * * *
                  * * *
                  * *
                  *
    */
    public static void pattern4(int n, int i, int j) {
        // base case
        if(i >= n) {
            return;
        }

        if(j >= (n - i)) {
            System.out.println();
            pattern4(n, i + 1, 0);
            return;
        }

        // self work
        System.out.print("* ");

        pattern4(n, i, j + 1);
    }
    
    public static void main(String[] args) {
        // pattern1(5);
        // pattern2(5, 0, 0);
        // pattern3(5, 0, 0);
        pattern4(5, 0, 0);
    }
}
