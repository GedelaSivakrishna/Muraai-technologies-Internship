package Class;
public class SumOfDigits {

    /*  f(num) = calculates the sum of digits of num */
    public static long f(long num) {
        // base case
        if(num == 0) return 0;

        return (num % 10) + f(num / 10);
    }
    
    public static void main(String[] args) {
        // System.out.println(f(538)); // 16
        // System.out.println(f(210101120242L)); // 16
    }
}
